package com.mytrainst.train.service;

import com.mytrainst.train.domain.Train;

public interface ITrainService {
    Train findByName(String name);
}
