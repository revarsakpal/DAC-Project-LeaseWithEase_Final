package com.LeaseWithEaseBackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Model.City;
import com.LeaseWithEaseBackend.Service.CityService;


@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CityController {
	@Autowired
	CityService cityService;

	@GetMapping("city")
	public ResponseEntity<List<City>> getAllCity(){
		List<City> cityList=cityService.getAllCity();
		return ResponseEntity.ok(cityList);
	}
	@PostMapping("city/addCity")
	public String addNewCity(@RequestParam String city_name) {
		City city=new City();
		city.setCity_name(city_name);
		if(cityService.saveCity(city)!=null)
			return "New City Added Successfully!!";
		else
			return "Error while adding new city!!";
	}
	@DeleteMapping("city/delete/{city_id}")
	public String deleteCity(@PathVariable int city_id) {
		if(cityService.deleteCity(city_id))	{
			return "Selected City deleted successfully!!";
		}
		return "Error in deletion of city!!";
	}

}
