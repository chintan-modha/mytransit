package com.mytransit.train.controller;

import com.mytrainst.train.Application;
import com.mytrainst.train.domain.Train;
import com.mytrainst.train.repository.ITrainRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class TrainControllerTest {

    private static final String VALID_ID = "TRAIN-123";
    private static final String VALID_TRAIN_NAME = "EAST-WEST-COAST-EXPRESS";
    private static final String VALID_TYPE = "EXPRESS-TRAIN";

    @Autowired
    private ITrainRepository repository;

    @LocalServerPort
    private int port;

    @BeforeEach
    void init() {
        val train = repository.save(new Train(VALID_ID, VALID_TRAIN_NAME, VALID_TYPE));
        assertNotNull(train);
    }

    @Test
    void shouldReturnTrainForAValidName() {

        RestAssured.registerParser("text/json", Parser.JSON);

        given().port(port)
               .accept(ContentType.JSON)
               .log().all()
               .when()
               .get("/trains/name/{name}", VALID_TRAIN_NAME)
               .then()
               .log().all()
               .statusCode(HttpStatus.OK.value())
               .body("name", equalTo(VALID_TRAIN_NAME))
               .body("id", equalTo(VALID_ID))
               .body("type", equalTo(VALID_TYPE));

    }
}
