package com.nttdata.bootcamp.bank.location.springwebflux.controller;

import com.nttdata.bootcamp.bank.location.springdata.document.Location;
import com.nttdata.bootcamp.bank.location.springwebflux.service.inte.LocationServiceInte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/business-microservice04-location/location")
public class LocationRestController {

    private static final Logger log = LoggerFactory.getLogger(LocationServiceInte.class);

    @Autowired
    private LocationServiceInte locationServiceInte;

    @PostMapping
    public Mono<Location> create(@RequestBody final Location location) {
        log.debug("Begin RestController create Location");
        return locationServiceInte.create(location);
    }

    @GetMapping
    public Flux<Location> readAll() {
        log.debug("Begin RestController readAll Location");
        return locationServiceInte.readAll();
    }

    @GetMapping("/readByCodeLocation/{codeLocation}")
    public Mono<Location> readByCodeLocation(@PathVariable String codeLocation) {
        log.debug("Begin RestController readByCodeLocation Location");
        return locationServiceInte.readByCodeLocation(codeLocation);
    }

    @PutMapping("/{id}")
    public Mono<Location> updateById(@RequestBody final Location location, @PathVariable("id") final String id) {
        log.debug("Begin RestController updateById Location");
        return locationServiceInte.updateById(id, location);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable final String id) {
        log.debug("Begin RestController deleteById Location");
        return locationServiceInte.deleteById(id);
    }

}