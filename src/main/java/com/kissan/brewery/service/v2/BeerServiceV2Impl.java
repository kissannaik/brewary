package com.kissan.brewery.service.v2;

import com.kissan.brewery.web.model.v2.BeerDTO;
import com.kissan.brewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        log.debug("Getting Beer by Id");

        return BeerDTO.builder().id(beerId)
                .beerName("Galaxy Malt")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTO addBeer(BeerDTO beerDTO) {
        log.debug("Adding Beer");

        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .build();
    }

    @Override
    public BeerDTO updateBeer(UUID id, BeerDTO beerDTO) {
        log.debug("Updating Beer by Id");

        return BeerDTO.builder()
                .id(id)
                .build();
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting Beer by Id");

        //Todo Delete Beer by Id
    }


}
