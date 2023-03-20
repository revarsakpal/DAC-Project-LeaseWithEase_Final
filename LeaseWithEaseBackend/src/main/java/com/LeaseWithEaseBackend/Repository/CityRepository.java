package com.LeaseWithEaseBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LeaseWithEaseBackend.Model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
