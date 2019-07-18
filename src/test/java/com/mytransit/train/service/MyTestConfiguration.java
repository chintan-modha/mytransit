package com.mytransit.train.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mytransit.train.repository",
                               "com.mytransit.train.service"})
public class MyTestConfiguration {
}
