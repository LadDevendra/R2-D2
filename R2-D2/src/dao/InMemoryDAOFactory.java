package dao;

import service.IVehicleService;

public class InMemoryDAOFactory extends DAOFactory {

	//we can do the connection and configuration here, so no need to do
	//for every entity that will request use of InMomoryDAO
	
	@Override
	public IVehicleService getVehicleDAO() {
		// InMemoryVehicleDAO implements IVehicleService
		return new InMemoryVehicleDAO();
	}
	
//	similarly other entities could be added here
	
//	@Override
//	public EmployeeService getEmployeeDAO() {
//		// InMemoryEmployeeDAO implements EmployeeService
//		return new InMemoryEmployeeDAO();
//	}
	
}
