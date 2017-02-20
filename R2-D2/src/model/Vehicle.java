package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Vehicle {
	
	@NotNull
	private int id;
	
	@NotNull
	@Min(1950)
	@Max(2050)
	private int year;
	
	@NotNull
	private String make;
	@NotNull
	private String model;
	@NotNull
	private String vehicle_class;
	
	//for initial population
	public Vehicle(int id, int year, String make, String model, String vehicle_class) {
		this.setId(id);
		this.setYear(year);
		this.setMake(make);
		this.setModel(model);
		this.setVehicle_class(vehicle_class);
	}
	//for create operation
	public Vehicle(int year, String make, String model, String vehicle_class) {
		this.setYear(year);
		this.setMake(make);
		this.setModel(model);
		this.setVehicle_class(vehicle_class);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVehicle_class() {
		return vehicle_class;
	}
	public void setVehicle_class(String vehicle_class) {
		this.vehicle_class = vehicle_class;
	}	
}
