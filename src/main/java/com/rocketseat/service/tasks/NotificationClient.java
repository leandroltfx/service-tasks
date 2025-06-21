package com.rocketseat.service.tasks;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Essa interface representa um cliente feign, portanto irá
// disparar uma requisição HTTP usando o Feign
// O parâmetro "name" indica o microsserviço a ser chamado, sem utilizar a sua URL
// pois isso será resolvido pelo Service Discovery do Eureka
@FeignClient(name = "service-notification")
public interface NotificationClient {

    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);

}
