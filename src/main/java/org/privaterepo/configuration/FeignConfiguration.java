package org.privaterepo.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableFeignClients(basePackages = {"org.privaterepo.external"})
public class FeignConfiguration {

    @Bean
    Logger.Level feignClientLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> template.header("Content-Type", "application/json");
    }
}
