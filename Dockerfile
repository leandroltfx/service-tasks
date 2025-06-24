# Etapas necessárias para a montagem da imagem do serviço
# O arquivo faz com que a aplicação seja executada dentro de um container
# Multistaging build do Docker

# 1ª etapa (build)
# etapa de build com o maven utilizando uma imagem do amazoncorreto com jdk e maven
FROM maven:3.9.6-amazoncorretto-21-debian AS build

# cópia da pasta src para dentro do container em "/app/src"
COPY src /app/src

# cópia do pom para a pasta app no container
COPY pom.xml /app

# alterando o diretório de trabalho para a pasta app e gerando o .jar da aplicação com o comando maven pulando os testes
WORKDIR /app
RUN mvn clean install -DskipTests

# 2ª etapa (cópia do resultado da 1ª etapa)
# usando imagem do amazoncorreto mais limpa do que a da linha 4 somente com a JRE
FROM amazoncorretto:21

# copiando o .jar
COPY --from=build /app/target/service-tasks-0.0.1-SNAPSHOT.jar /app/app.jar

# alterando o diretório de trabalho para a pasta app
WORKDIR /app

# o container irá expor a porta 8081
EXPOSE 8081

# e executando o .jar com o comando java -jar app.jar
CMD ["java", "-jar", "app.jar"]

# executar o comando no terminal para gerar a imagem:
# docker build -t service-tasks:latest .
# docker build -t service-tasks:latest (nome da imagem e versão) . (o ponto é para usar o Dockerfile dentro da pasta service-main)

# executando a imagem para subir um container com a aplicação na porta do container para a porta local:
# docker run -p 8081:8081 service-tasks:latest