package com.zenika.tz.trunkkata.mapper;

import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.domain.request.CreateBeerRequest;
import com.zenika.tz.trunkkata.dto.CreateBeerDTO;
import com.zenika.tz.trunkkata.dto.ResponseBeerDTO;

import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    ResponseBeerDTO toResponseBeerDTO(Beer beer);

    CreateBeerRequest toModel(CreateBeerDTO createBeerDTO);
}
