package com.chaitanya.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dinesh Rajput
 *
 */
@Entity
@Table(name="car")
public class Car implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "carid")
	private Integer cid;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="model")
	private String model;
	
	@Column(name="price")
	private Long price;
	
	@Column(name="power")
	private Integer power;

	public Integer getId() {
		return cid;
	}

	public void setId(Integer cid) {
		this.cid = cid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

}
