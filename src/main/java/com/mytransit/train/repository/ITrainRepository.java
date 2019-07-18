package com.mytransit.train.repository;

import com.mytransit.train.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainRepository extends JpaRepository<Train, String> {
    Train findByName(String name);
}
