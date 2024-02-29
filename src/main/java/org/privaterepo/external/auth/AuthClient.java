package org.privaterepo.external.auth;

import feign.Response;
import org.privaterepo.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "authClient", url = "https://mapi.oliveyoung.co.kr/auth/api", configuration = FeignConfiguration.class)
public interface AuthClient {

    @GetMapping(value = "/acquire/token")
    Response getToken(@RequestParam("memberNumber") String memberNumber);
}
