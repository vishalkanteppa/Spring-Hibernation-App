package com.chaitanya.service;

import java.util.List;

import com.chaitanya.model.Car;

/**
 * @author Dinesh Rajput
 *
 */
public interface CarService {
	
	public void addCar(Car car);

	public List<Car> listEmployeess();
	
	public Car getCar(int empid);
	
	public void deleteCar(Car car);
}
