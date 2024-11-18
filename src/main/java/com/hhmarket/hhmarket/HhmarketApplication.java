package com.hhmarket.hhmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HhmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(HhmarketApplication.class, args);
    }

}
