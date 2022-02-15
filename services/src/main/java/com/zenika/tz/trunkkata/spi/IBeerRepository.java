package com.zenika.tz.trunkkata.spi;

import com.zenika.tz.trunkkata.domain.Beer;

import java.util.List;

public interface IBeerRepository {
    Beer save(Beer beer);
    List<Beer> findAll();
    Beer get(long id);
}
