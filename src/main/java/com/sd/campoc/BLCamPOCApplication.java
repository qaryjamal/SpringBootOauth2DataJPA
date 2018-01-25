package com.sd.campoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class BLCamPOCApplication {

    public static void main(String[] args) {
        SpringApplication.run(BLCamPOCApplication.class, args);
    }
}
