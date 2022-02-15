package com.zenika.tz.trunkkata;

import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.entity.BeerEntity;

import org.mapstruct.Mapper;

@Mapper
public interface BeerEntityMapper {

    Beer toModel(BeerEntity beer);
    BeerEntity toEntity(Beer beer);
}
