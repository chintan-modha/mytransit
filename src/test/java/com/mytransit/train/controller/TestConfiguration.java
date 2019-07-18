package com.mytransit.train.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mytransit.train.controller",
                               "com.mytransit.train.service"})

@EnableJpaRepositories("com.mytransit.train.repository")
@EntityScan("com.mytransit.train.domain")
@Configuration
public class TestConfiguration {
}
