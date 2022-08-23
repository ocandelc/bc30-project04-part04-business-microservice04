package com.nttdata.bootcamp.bank.location.springflux.controller;

import com.nttdata.bootcamp.bank.location.springdata.document.Location;
import com.nttdata.bootcamp.bank.location.springwebflux.service.inte.LocationServiceInte;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;

@SpringBootTest
public class LocationRestControllerTest {

    @MockBean
    private LocationServiceInte locationServiceInte;

    @Test
    void readAllTest() {

        Flux<Location> fluxLocation = locationServiceInte.readAll();

        Mockito.verify(locationServiceInte).readAll();

     }

}
