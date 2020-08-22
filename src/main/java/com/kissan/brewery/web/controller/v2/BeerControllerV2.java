package com.kissan.brewery.web.controller.v2;

import com.kissan.brewery.service.v2.BeerServiceV2;
import com.kissan.brewery.web.model.v2.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
        BeerDTO beerDTO = beerServiceV2.getBeerById(beerId);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v2/beer/"+beerDTO.getId());

        return new ResponseEntity<>(beerDTO, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> addBeer(@RequestBody BeerDTO beerDTO){
        BeerDTO addedBeerDTO = beerServiceV2.addBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v2/beer/"+addedBeerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO){
        BeerDTO updatedBeerDTO = beerServiceV2.updateBeer(beerId, beerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v2/beer/"+updatedBeerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping({"/{beerId}"})
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeer(beerId);

        return new ResponseEntity (HttpStatus.OK);
    }
}
