package com.zenika.tz.trunkkata.services;


import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.domain.CreateBeerRequest;
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

    @Override
    public Beer create(final CreateBeerRequest createBeerRequest) {
        String ipaType = ipaRule.determineIPAType(createBeerRequest.alcool(), createBeerRequest.ibu());
        Beer beer = new Beer(null, createBeerRequest.name(), createBeerRequest.brewery(), ipaType);
        return beerRepository.save(beer);
    }

    @Override
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    @Override
    public void rate(String beer, Rating rating) {
        Consumer<Rating> saveRatingFunction = ratingRepository::save;
        rating.create(saveRatingFunction);
    }
}
