package com.mytransit.train.service;

import com.mytransit.train.domain.Train;

public interface ITrainService {
    Train findByName(String name);
}
