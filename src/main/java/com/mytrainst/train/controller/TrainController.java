package com.mytrainst.train.controller;

import com.mytrainst.train.domain.Train;
import com.mytrainst.train.service.ITrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Component
public class TrainController implements ITrainController {

    @Autowired
    private ITrainService trainService;

    @Override
    public Train findByName(@PathVariable final String name) {
        log.info(":: Request received: {} ", name);
        return trainService.findByName(name);
    }
}
