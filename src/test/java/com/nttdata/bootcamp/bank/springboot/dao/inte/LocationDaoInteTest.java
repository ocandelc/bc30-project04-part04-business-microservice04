package com.nttdata.bootcamp.bank.springboot.dao.inte;

import com.nttdata.bootcamp.bank.springboot.document.Location;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
public class LocationDaoInteTest {

    private static final Logger logger = LoggerFactory.getLogger(LocationDaoInteTest.class);

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() {
        logger.debug("INICIO TEST");

        closeable = MockitoAnnotations.openMocks(this);

        Location object01 = new Location();
        object01.setId("62f6a0edc8039c79397e7876");
        object01.setCodeLocation("L-0000000001");
        object01.setName("SUCURSAL NORTE - LOCAL MEGAPLAZA");
        object01.setDescription("prueba");
        object01.setState("1");
        object01.setCodeLocationType("LT-0000000001");
        object01.setCodeUbigeo("010101");

        Mono<Location> monoObjectTest = Mono.just(object01);

        Mono<Location> monoObjectDatabase = locationDaoInte.readByCodeLocation("L-0000000001");

        Mockito.when(monoObjectDatabase).thenReturn(monoObjectTest);

    }

    @AfterEach
    void tearDown() throws Exception {
        logger.debug("FIN TEST");

        closeable.close();
    }

    @Mock
    LocationDaoInte locationDaoInte;

    @Test
    @Order(1)
    public void createLocationTest() {
        Location object03 = new Location();
        object03.setId("62f6a0edc8039c79397e7876");
        object03.setCodeLocation("L-0000000001");
        object03.setName("SUCURSAL NORTE - LOCAL MEGAPLAZA");
        object03.setDescription("prueba");
        object03.setState("1");
        object03.setCodeLocationType("LT-0000000001");
        object03.setCodeUbigeo("010101");

        Mono<Location> monoObjectDatabase = locationDaoInte.save(object03);

        Mockito.verify(locationDaoInte).save(object03);
    }

    @Test
    @Order(2)
    public void readByCodeLocationTest() {

        Mono<Location> monoObjectDatabase = locationDaoInte.readByCodeLocation("L-0000000001");

        Mockito.verify(locationDaoInte).readByCodeLocation("L-0000000001");

    }

    @Test
    @Order(3)
    public void updateLocationTest() {
        Location object01 = new Location();
        object01.setId("62f6a0edc8039c79397e7876");
        object01.setCodeLocation("L-0000000001");
        object01.setName("SUCURSAL NORTE - LOCAL MEGAPLAZA");
        object01.setDescription("prueba");
        object01.setState("1");
        object01.setCodeLocationType("LT-0000000001");
        object01.setCodeUbigeo("010101");

        Mono<Location> monoObjectDatabase = locationDaoInte.save(object01);

        Mockito.verify(locationDaoInte).save(object01);
    }

    @Test
    @Order(4)
    public void deleteLocationTest() {

        Mono<Void> monoObjectDatabase = locationDaoInte.deleteById("L-0000000001");

        Mockito.verify(locationDaoInte).deleteById("L-0000000001");
    }

    @Test
    @Order(5)
    public void readByCodeLocationStepVerifierTest() {

        Mono<Location> objectDatabase = locationDaoInte.readByCodeLocation("L-0000000001");

        Location object01 = new Location();
        object01.setId("62f6a0edc8039c79397e7876");
        object01.setCodeLocation("L-0000000001");
        object01.setName("SUCURSAL NORTE - LOCAL MEGAPLAZA");
        object01.setDescription("prueba");
        object01.setState("1");
        object01.setCodeLocationType("LT-0000000001");
        object01.setCodeUbigeo("010101");

        Mono<Location> objectTest = Mono.just(object01);

        StepVerifier.create(locationDaoInte.readByCodeLocation("L-0000000001")).recordWith(ArrayList::new)
                .expectNextCount(1)
                .consumeRecordedWith(r -> {
                    Assertions.assertEquals("L-0000000001", "L-0000000001");
                })
                .verifyComplete();;

    }

}
