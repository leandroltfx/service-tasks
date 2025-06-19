package com.rocketseat.service_one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // Recuperando a propriedade definida em service-one.properties do config-server
    // que é clonado pelo servidor principal que roda na porta 8888
    @Value("${message:Mensagem Default}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message;
    }

}
