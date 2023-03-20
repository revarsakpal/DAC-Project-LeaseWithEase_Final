package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.City;

public interface CityService {

	List<City> getAllCity();

	City saveCity(City city);

	boolean deleteCity(int city_id);

}
