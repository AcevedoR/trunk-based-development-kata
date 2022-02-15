package com.zenika.tz.trunkkata.dao;

import com.zenika.tz.trunkkata.BeerEntityMapper;
import com.zenika.tz.trunkkata.spi.IBeerRepository;
import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.entity.BeerEntity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class SimpleInMemoryBeerRepository implements IBeerRepository {
    private final List<BeerEntity> database = new ArrayList<>();
    private final BeerEntityMapper beerEntityMapper = Mappers.getMapper(BeerEntityMapper.class);
    private long idSequence = 0L;

    @Override
    public Beer save(final Beer beer) {
        BeerEntity entity = beerEntityMapper.toEntity(beer);
        idSequence++;
        entity.setId(idSequence);
        database.add(
                entity
        );
        return beer;
    }

    @Override
    public List<Beer> findAll() {
        return database.stream().map(beerEntityMapper::toModel).toList();
    }

    @Override
    public Beer get(final long id) {
        return beerEntityMapper.toModel(database.stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("beer not found for id: " + id))
        );
    }
    @PostConstruct
    private void postConstruct() {
        this.save(new Beer(null, "beer1", "vocation", "DIPA"));
        this.save(new Beer(null, "beer2", "vocation", "TIPA"));
    }
}
