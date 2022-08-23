package com.nttdata.bootcamp.bank.location.springwebflux.service.inte;

import com.nttdata.bootcamp.bank.location.springdata.document.Location;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationServiceInte {

    Mono<Location> create(final Location location);

    Flux<Location> readAll();

    Mono<Location> readByCodeLocation(String codeLocation);

    Mono<Location> updateById(final String id, final Location location);

    Mono<Void> deleteById(final String id);
}