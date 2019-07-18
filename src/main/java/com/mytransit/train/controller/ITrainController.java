package com.mytransit.train.controller;

import com.mytransit.train.domain.Train;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trains", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface ITrainController {

    @GetMapping("/name/{name}")
    Train findByName(@PathVariable final String name);
}
