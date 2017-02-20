package service;

import java.util.ArrayList;
import model.Vehicle;

//Interface that binds both High and low level modules and provides contract
public interface IVehicleService {
	
	ArrayList<Vehicle> get();
	Vehicle get(int id);
	int create(Vehicle vehicle);
	void update(Vehicle vehicle);
	boolean delete(Vehicle vehicle);
	boolean ifExist(int id);
	
}
