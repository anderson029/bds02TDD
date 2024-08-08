package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

  @Autowired
  private CityService cityService;

  @GetMapping
  public ResponseEntity<List<CityDTO>> findAllCities(){
    List<CityDTO> resultLIst = cityService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(resultLIst);
  }

  @PostMapping
  public ResponseEntity<CityDTO>insert(@RequestBody CityDTO city){
    CityDTO result = cityService.createCity(city);
    return ResponseEntity.status(HttpStatus.CREATED).body(result);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity delete(@PathVariable Long id){
    cityService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
