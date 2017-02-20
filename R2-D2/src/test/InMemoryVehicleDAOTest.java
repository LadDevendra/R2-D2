package test;

import static org.junit.Assert.*;
import model.Vehicle;

import org.junit.Test;

import dao.InMemoryVehicleDAO;

public class InMemoryVehicleDAOTest {

	@Test
	public void test_get() {
		InMemoryVehicleDAO inMemoryVehicleDAO = new InMemoryVehicleDAO();
		Vehicle vehicle = inMemoryVehicleDAO.get(5);
		assertEquals(5, vehicle.getId());
		
		vehicle = inMemoryVehicleDAO.get(-2);
		assertEquals(null, vehicle);
	}
	
	@Test
	public void test_create(){
		InMemoryVehicleDAO inMemoryVehicleDAO = new InMemoryVehicleDAO();
		Vehicle vehicle = new Vehicle( 2000, "Z-160", "X-Wing", "Starfighter");
		int id = inMemoryVehicleDAO.create(vehicle);
		
		assertNotEquals(null, id);				
		Vehicle vehicleGet = inMemoryVehicleDAO.get(id);
		
		assertEquals(id, vehicleGet.getId());
		assertEquals(vehicle.getMake(), vehicleGet.getMake());
		assertEquals(vehicle.getModel(), vehicleGet.getModel());
		assertEquals(vehicle.getVehicle_class(),vehicleGet.getVehicle_class());
		assertEquals(vehicle.getYear(), vehicleGet.getYear());		
	}
	
	@Test
	public void test_update()
	{
		InMemoryVehicleDAO inMemoryVehicleDAO = new InMemoryVehicleDAO();
		Vehicle vehicle = new Vehicle( 5, 2000, "Z-160", "X-Wing", "Starfighter");
		inMemoryVehicleDAO.update(vehicle);
					
		Vehicle vehicleGet = inMemoryVehicleDAO.get(5);
		
		assertEquals(5, vehicleGet.getId());
		assertEquals(vehicle.getMake(), vehicleGet.getMake());
		assertEquals(vehicle.getModel(), vehicleGet.getModel());
		assertEquals(vehicle.getVehicle_class(),vehicleGet.getVehicle_class());
		assertEquals(vehicle.getYear(), vehicleGet.getYear());		
	}
	
	public void test_delete()
	{
		InMemoryVehicleDAO inMemoryVehicleDAO = new InMemoryVehicleDAO();
		Vehicle vehicle = new Vehicle( 5, 2000, "Z-160", "X-Wing", "Starfighter");
		inMemoryVehicleDAO.delete(vehicle);
					
		Vehicle vehicleGet = inMemoryVehicleDAO.get(vehicle.getId());
		
		assertEquals(null, vehicleGet);
	}

}
