package com.mytrainst.train.repository;

import com.mytrainst.train.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainRepository extends JpaRepository<Train, String> {
    Train findByName(String name);
}
