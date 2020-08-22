package com.kissan.brewery.service.v2;

import com.kissan.brewery.web.model.v2.BeerDTO;

import java.util.UUID;

public interface BeerServiceV2 {

    public BeerDTO getBeerById(UUID beerId);

    public BeerDTO addBeer(BeerDTO beerDTO);

    public BeerDTO updateBeer(UUID id, BeerDTO beerDTO);

    void deleteBeer(UUID beerId);
}
