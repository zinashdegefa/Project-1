package org.zinash.daos;

import org.zinash.models.Car;

import java.util.List;

public interface CarDaoInterface {

    List<Car> getAllCars();

    void addCar(Car car);

    void updatePrice(int plateNo, double newPrice);

     void deletCar(int plateNo);

    public List<Car> getCarByplateNo(int plateNo);

    public List<Car> getCarBycarName(String carName);

    public List <Car> getCarByPersonName(String name);
}
