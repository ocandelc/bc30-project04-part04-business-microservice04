package com.nttdata.bootcamp.bank.springboot.dao.inte;

import com.nttdata.bootcamp.bank.springboot.document.Location;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LocationDaoInte extends ReactiveMongoRepository<Location, String> {
    Mono<Location> readByCodeLocation(String codeProduct);
}
