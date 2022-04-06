package com.zenika.tz.trunkkata.services;


import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.domain.request.CreateBeerRequest;
import com.zenika.tz.trunkkata.domain.Rating;
import com.zenika.tz.trunkkata.spi.IBeerRepository;
import com.zenika.tz.trunkkata.spi.IRatingRepository;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;


@Service
public class BeerServiceImpl implements BeerService {

    private final IBeerRepository beerRepository;
    private final IRatingRepository ratingRepository;
    private final IPARule ipaRule;

    public BeerServiceImpl(final IRatingRepository ratingRepository, final IBeerRepository beerRepository, final IPARule ipaRule) {
        this.beerRepository = beerRepository;
        this.ratingRepository = ratingRepository;
        this.ipaRule = ipaRule;
    }
// dd
    @Override
    public Beer create(final CreateBeerRequest createBeerRequest) {
        // TODO kata, Branch by abstraction: rework IPA type rule
        String ipaType = ipaRule.determineIPAType(createBeerRequest.alcool(), createBeerRequest.ibu());
        Beer beer = new Beer(null, createBeerRequest.name(), createBeerRequest.brewery(), ipaType);
        return beer.create(beerRepository);
    }

    @Override
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    // TODO kata, Dark launching: expose POST /beers/rate
    @Override
    public void rate(String beer, Rating rating) {
        Consumer<Rating> persistFunction = ratingRepository::save;
        rating.create(persistFunction);
    }
}
