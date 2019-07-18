package com.mytransit.train.service;

import com.mytransit.train.domain.Train;
import com.mytransit.train.exception.TrainNotFoundException;
import com.mytransit.train.repository.ITrainRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MyTestConfiguration.class)
public class TrainServiceTest {

    @MockBean
    private ITrainRepository repository;

    @Autowired
    private ITrainService trainService;

    @Test
    public void findTrainByName() {
        reset(repository);
        String name = "Nort east corridor";
        String type = "Express";

        //given
        given(repository.findByName(Mockito.anyString()))
                .willReturn(new Train("123" ,name, type));
        //act
        Train train = trainService.findByName(name);

        //verify
        assertThat(train).isNotNull();
        assertThat(train.getName()).isEqualTo(name);
        assertThat(train.getType()).isEqualTo(type);
    }

    @Test
    void testShouldThrowTrainNotFoundException() {
        reset(repository);
        //given
        given(repository.findByName(Mockito.anyString()))
                .willReturn(null);
        String name = "South east corridor";
        Assertions.assertThrows(TrainNotFoundException.class,
                                () -> trainService.findByName(name),
                                "TrainNotFoundException was not thrown.");
    }
}