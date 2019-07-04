package com.mytrainst.train.service;

import com.mytrainst.train.domain.Train;
import com.mytrainst.train.exception.TrainNotFoundException;
import com.mytrainst.train.repository.ITrainRepository;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

@RunWith(SpringRunner.class)
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

    @Test(expected = TrainNotFoundException.class)
    public void testShouldThrowTrainNotFoundException() {
        reset(repository);
        //given
        given(repository.findByName(Mockito.anyString()))
                .willReturn(null);
        String name = "South east corridor";
        trainService.findByName(name);
    }
}