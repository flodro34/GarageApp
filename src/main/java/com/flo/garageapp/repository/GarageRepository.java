package com.flo.garageapp.repository;

import com.flo.garageapp.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface GarageRepository extends CrudRepository<Car, Long> {
}
