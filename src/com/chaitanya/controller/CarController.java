package com.chaitanya.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chaitanya.bean.CarBean;
import com.chaitanya.model.Car;
import com.chaitanya.service.CarService;


@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") CarBean carbea, 
			BindingResult result) {
		Car car = prepareModel(carbea);
		carService.addCar(car);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(carService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  CarBean carbea,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(carService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  CarBean carbea,
			BindingResult result) {
		carService.deleteCar(prepareModel(carbea));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("car", null);
		model.put("employees",  prepareListofBean(carService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  CarBean carbea,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("car", prepareEmployeeBean(carService.getCar(carbea.getId())));
		model.put("employees",  prepareListofBean(carService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	private Car prepareModel(CarBean carbea){
		Car car = new Car();
		car.setModel(carbea.getModel());
		car.setPower(carbea.getPower());
		car.setBrand(carbea.getBrand());
		car.setPrice(carbea.getPrice());
		car.setId(carbea.getId());
		carbea.setId(null);
		return car;
	}
	
	private List<CarBean> prepareListofBean(List<Car> employees){
		List<CarBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<CarBean>();
			CarBean bean = null;
			for(Car car : employees){
				bean = new CarBean();
				bean.setBrand(car.getBrand());
				bean.setId(car.getId());
				bean.setModel(car.getModel());
				bean.setPrice(car.getPrice());
				bean.setPower(car.getPower());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private CarBean prepareEmployeeBean(Car car){
		CarBean bean = new CarBean();
		bean.setModel(car.getModel());
		bean.setPower(car.getPower());
		bean.setBrand(car.getBrand());
		bean.setPrice(car.getPrice());
		bean.setId(car.getId());
		return bean;
	}
}
