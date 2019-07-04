package com.mytrainst.train.service;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
public class SimpleService {
    private String text;

    public SimpleService(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
