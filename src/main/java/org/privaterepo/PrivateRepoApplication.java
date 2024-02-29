package org.privaterepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PrivateRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrivateRepoApplication.class, args);
    }

}
