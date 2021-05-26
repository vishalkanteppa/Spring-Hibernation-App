package com.chaitanya.dao;

import java.util.List;

import com.chaitanya.model.Car;

/**
 * @author Dinesh Rajput
 *
 */
public interface CarDao {
	
	public void addCar(Car car);

	public List<Car> listEmployeess();
	
	public Car getCar(int empid);
	
	public void deleteCar(Car car);
}
