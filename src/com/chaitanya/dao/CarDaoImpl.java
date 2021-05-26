package com.chaitanya.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.chaitanya.model.Car;


@Repository("carDao")
public class CarDaoImpl implements CarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCar(Car car) {
		sessionFactory.getCurrentSession().saveOrUpdate(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> listEmployeess() {
		return (List<Car>) sessionFactory.getCurrentSession().createCriteria(Car.class).list();
	}

	public Car getCar(int cid) {
		return (Car) sessionFactory.getCurrentSession().get(Car.class, cid);
	}

	public void deleteCar(Car car) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Car WHERE carid = "+car.getId()).executeUpdate();
	}

}
