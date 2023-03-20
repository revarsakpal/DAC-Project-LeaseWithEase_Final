package com.LeaseWithEaseBackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.City;
import com.LeaseWithEaseBackend.Repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{
@Autowired
CityRepository cityRepository;

@Override
public List<City> getAllCity() {
	return cityRepository.findAll();
}

@Override
public City saveCity(City city) {
return cityRepository.save(city);	
}

@Override
public boolean deleteCity(int city_id) {
	 cityRepository.deleteById(city_id);
	return true;
}
}
