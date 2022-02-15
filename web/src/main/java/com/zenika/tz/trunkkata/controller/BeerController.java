package com.zenika.tz.trunkkata.controller;

import com.zenika.tz.trunkkata.dto.CreateBeerDTO;
import com.zenika.tz.trunkkata.dto.ResponseBeerDTO;
import com.zenika.tz.trunkkata.mapper.BeerMapper;
import com.zenika.tz.trunkkata.services.BeerService;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    private final BeerService beerService;
    private final BeerMapper beerMapper = Mappers.getMapper(BeerMapper.class);

    public BeerController(final BeerService beerService) {
        this.beerService = beerService;
    }

    @ResponseStatus (HttpStatus.CREATED)
    @PostMapping
    public ResponseBeerDTO create(@RequestBody CreateBeerDTO createBeerDTO) {
        return beerMapper.toResponseBeerDTO(
                beerService.create(
                    beerMapper.toModel(createBeerDTO)
            )
        );
    }

    @GetMapping
    public List<ResponseBeerDTO> findAll() {
        return beerService.findAll().stream()
                .map(beerMapper::toResponseBeerDTO)
                .toList();
    }
}
