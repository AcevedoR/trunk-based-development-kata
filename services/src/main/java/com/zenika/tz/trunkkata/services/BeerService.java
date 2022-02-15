package com.zenika.tz.trunkkata.services;

import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.domain.CreateBeerRequest;
import com.zenika.tz.trunkkata.domain.Rating;

import java.util.List;

public interface BeerService {

    Beer create(CreateBeerRequest beer);

    List<Beer> findAll();

    void rate(String beer, Rating rating);
}
