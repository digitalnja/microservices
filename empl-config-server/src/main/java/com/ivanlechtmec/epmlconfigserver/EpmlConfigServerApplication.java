package com.ivanlechtmec.epmlconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EpmlConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpmlConfigServerApplication.class, args);
    }

}
