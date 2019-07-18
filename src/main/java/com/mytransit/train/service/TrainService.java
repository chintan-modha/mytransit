package com.mytransit.train.service;

import com.mytransit.train.domain.Train;
import com.mytransit.train.exception.TrainNotFoundException;
import com.mytransit.train.repository.ITrainRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TrainService implements ITrainService {

    private ITrainRepository repository;

    @Override
    public Train findByName(String name) {
        return Optional.ofNullable(repository.findByName(name))
                       .orElseThrow(() -> new TrainNotFoundException("Train not found for given name : "+name));
    }
}
