package com.techrevolution.msscbrewery.service;

import com.techrevolution.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().uuid(beerId) //UUID.randomUUID()
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveBeerDto(BeerDto beerDto) {
        return BeerDto.builder()
                .uuid(beerDto.getUuid())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteBeer(UUID beerId) {
      log.debug("deleting a beer with uuid :-- {}" , beerId);
    }
}
