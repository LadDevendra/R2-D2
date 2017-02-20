package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import service.IVehicleService;
import model.Vehicle;

public class InMemoryVehicleDAO implements IVehicleService {
	
	public HashMap<Integer, Vehicle> vehicleMap;
	
	public InMemoryVehicleDAO()
	{
		//initial data population
		vehicleMap = getDefaultedList();
	}

	private HashMap<Integer, Vehicle> getDefaultedList() {
		HashMap<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();
		
		vehicleMap.put(0, new Vehicle(0, 1960, "T-65B", "X-wing", "Starfighter"));
		vehicleMap.put(1, new Vehicle(1, 1965, "T-65C-A2", "X-wing", "Starfighter"));
		vehicleMap.put(2, new Vehicle(2, 1990, "T-70", "X-wing", "Starfighter"));
		vehicleMap.put(3, new Vehicle(3, 1991, "T-85", "X-wing", "Starfighter"));
		vehicleMap.put(4, new Vehicle(4, 1930, "S-22B", "TIE fighter", "Starfighter"));
		vehicleMap.put(5, new Vehicle(5, 1957, "S-34B", "TIE fighter", "Starfighter"));
		vehicleMap.put(6, new Vehicle(6, 1947, "S-67B", "TIE fighter", "Starfighter"));
		vehicleMap.put(7, new Vehicle(7, 2015, "S-56B", "TIE fighter", "Starfighter"));
		
		return vehicleMap;
	}

	@Override
	public ArrayList<Vehicle> get() {
		Collection<Vehicle> values = vehicleMap.values();
		return new ArrayList<Vehicle>(values);
	}

	@Override
	public Vehicle get(int id) {
		return vehicleMap.get(id);
	}

	@Override
	public int create(Vehicle vehicle) {
		vehicle.setId(vehicleMap.size());
		vehicleMap.put(vehicle.getId(), vehicle);
		return vehicle.getId();
	}

	@Override
	public void update(Vehicle vehicle) {
		if(vehicleMap.containsKey(vehicle.getId()))
		{
			vehicleMap.put(vehicle.getId(), vehicle);
		}
	}

	@Override
	public boolean delete(Vehicle vehicle) {
		if(vehicleMap.containsKey(vehicle.getId()))
		{
			vehicleMap.remove(vehicle.getId());
			return true;
		}
		return false;
	}

	@Override
	public boolean ifExist(int id) {
		if(vehicleMap.containsKey(id))
			return true;
		else
			return false;
	}
}
