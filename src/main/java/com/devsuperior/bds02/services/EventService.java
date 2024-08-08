package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.exceptions.BusinessException;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EventService {
  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private CityRepository cityRepository;

  public EventDTO update(Long id, EventDTO eventDTO){
    Event entity = eventRepository.findById(id).orElseThrow(()-> new BusinessException(3,"Event Not found", HttpStatus.NOT_FOUND));

    converterDTOForEntity(eventDTO, entity);

    return new EventDTO(eventRepository.save(entity));
  }

  private void converterDTOForEntity(EventDTO eventDTO, Event entity) {
    entity.setId(entity.getId());
    entity.setName(eventDTO.getName());
    entity.setDate(eventDTO.getDate());
    entity.setUrl(eventDTO.getUrl());
    City city = cityRepository.findById(eventDTO.getCityId()).orElseThrow(()-> new BusinessException(2, "City Not Found", HttpStatus.NOT_FOUND));
    entity.setCity(city);
  }
}
