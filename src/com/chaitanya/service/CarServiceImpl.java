package com.chaitanya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chaitanya.dao.CarDao;
import com.chaitanya.model.Car;


@Service("CarService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCar(Car car) {
		carDao.addCar(car);
	}
	
	public List<Car> listEmployeess() {
		return carDao.listEmployeess();
	}

	public Car getCar(int cid) {
		return carDao.getCar(cid);
	}
	
	public void deleteCar(Car car) {
		carDao.deleteCar(car);
	}

}
