package com.kissan.brewery.service.v1;

import com.kissan.brewery.web.model.v1.BeerDTO;

import java.util.UUID;

public interface BeerService {

    public BeerDTO getBeerById(UUID beerId);

    public BeerDTO addBeer(BeerDTO beerDTO);

    public BeerDTO updateBeer(UUID id, BeerDTO beerDTO);

    void deleteBeer(UUID beerId);
}
