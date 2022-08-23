package com.nttdata.bootcamp.bank.location.springwebflux.dao.inte;

import com.nttdata.bootcamp.bank.location.springdata.document.Location;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LocationDaoInte extends ReactiveMongoRepository<Location, String> {
    Mono<Location> readByCodeLocation(String codeProduct);
}
