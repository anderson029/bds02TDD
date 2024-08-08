package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.exceptions.BusinessException;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;

  public List<CityDTO> findAll(){
   List<City> city = cityRepository.findAll(Sort.by("name"));
   return city.stream().map(ci -> new CityDTO(ci)).collect(Collectors.toList());
  }

  public CityDTO createCity(CityDTO cityDTO){
    City entity = new City();
    converterDtoForEntity(cityDTO, entity);
    City resultCity = cityRepository.save(entity);
    return new CityDTO(resultCity);
  }

  public void delete(Long id){
    try {
      cityRepository.findById(id).orElseThrow(() -> new BusinessException(2, "City Not Found", HttpStatus.NOT_FOUND));
      cityRepository.deleteById(id);
    }catch(DataIntegrityViolationException e){
      throw new BusinessException(1, "Integrity violation", HttpStatus.BAD_REQUEST);
    }
  }

  private void converterDtoForEntity(CityDTO cityDTO, City city) {
    city.setId(null);
    city.setName(cityDTO.getName());
  }
}
