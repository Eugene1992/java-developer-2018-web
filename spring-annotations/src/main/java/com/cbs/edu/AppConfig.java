package com.cbs.edu;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Performer duke() {
        return new Juggler(10);
    }
}
