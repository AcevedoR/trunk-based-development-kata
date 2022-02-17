package com.zenika.tz.trunkkata.services;

import com.zenika.tz.trunkkata.domain.Beer;
import com.zenika.tz.trunkkata.domain.request.CreateBeerRequest;
import com.zenika.tz.trunkkata.spi.IBeerRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith (MockitoExtension.class)
class BeerServiceImplTest {

    @InjectMocks
    private BeerServiceImpl beerService;

    @Mock
    private IPARule ipaRule;

    @Mock
    private IBeerRepository beerRepository;

    @Test
    void shouldDetermineIPA() {
        when(ipaRule.determineIPAType(10.0, 12)).thenReturn("IPA");
        when(beerRepository.save(any())).thenAnswer(i -> i.getArgument(0));
        CreateBeerRequest createBeerRequest = new CreateBeerRequest("myBeer", "myBrewery", 10.0, 12);
        Beer res = beerService.create(createBeerRequest);
        Assertions.assertThat(res.type()).isEqualTo("IPA");
    }
}