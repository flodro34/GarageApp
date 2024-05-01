package com.flo.garageapp.service;

import com.flo.garageapp.model.Car;
import com.flo.garageapp.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;
//    static private ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(
//        new Car(1,"Clio", "Renault", 2016, Car.Color.BLUE),
//        new Car(2,"2008", "Peugeot", 2016, Car.Color.RED),
//        new Car(3,"Astra", "Opel", 2000, Car.Color.YELLOW),
//        new Car(4,"C4", "Citroen", 2003, Car.Color.GREEN),
//        new Car(5,"M3", "BMW", 2020, Car.Color.BLUE)
//    ));

    public List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        garageRepository.findAll().forEach(car -> {
            cars.add(car);
        });
        return cars;
    }

    public Car getCar(long id){
        //return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
        return garageRepository.findById(id).orElse(null);
    }

    public void deleteCar(long id) {
        //cars.removeIf(car -> car.getId() == id);
        garageRepository.deleteById(id);
    }

    public void addCar(Car car) {
        //cars.add(car);
        garageRepository.save(car);
    }

    public void updateCar(Car car, long id) {
//        cars.forEach(car1 -> {
//            if (car1.getId() == id){
//                cars.set(cars.indexOf(car1), car);
//            }
//        });
        garageRepository.save(car);
    }
}
