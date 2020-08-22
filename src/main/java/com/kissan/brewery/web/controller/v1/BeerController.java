package com.kissan.brewery.web.controller.v1;

import com.kissan.brewery.service.v1.BeerService;
import com.kissan.brewery.web.model.v1.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
        BeerDTO beerDTO = beerService.getBeerById(beerId);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/beer/"+beerDTO.getId());

        return new ResponseEntity<>(beerDTO, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> addBeer(@RequestBody BeerDTO beerDTO){
        BeerDTO addedBeerDTO = beerService.addBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/beer/"+addedBeerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO){
        BeerDTO updatedBeerDTO = beerService.updateBeer(beerId, beerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/beer/"+updatedBeerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping({"/{beerId}"})
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);

        return new ResponseEntity (HttpStatus.OK);
    }
}
