package com.mytrainst.train.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mytrainst.train.repository",
                               "com.mytrainst.train.service"})
public class MyTestConfiguration {
}
