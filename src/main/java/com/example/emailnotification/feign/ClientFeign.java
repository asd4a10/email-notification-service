package com.example.emailnotification.feign;

import com.example.emailnotification.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-core-api")
public interface ClientFeign {
    @GetMapping(value="/client",consumes= MediaType.APPLICATION_JSON_VALUE)
    ClientModel getClientById(@RequestParam String clientId);
}
