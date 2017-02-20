package dao;

import service.IVehicleService;

//this is just a dummy class to show how new DAO could be added without interfering 
//with existing code.
public class SQLDAOFactory extends DAOFactory {

	// method to create SQL connections
	
//	public static final String DRIVER="SQL_driver";
//	public static final String DBURL= "Database connection url";
	
//	public static Connection createConnection() {
//	}
		  
	@Override
	public IVehicleService getVehicleDAO() {
	//	return new SQLVehicleDAO();
		return null;
	}
	
//	similarly other entities could be added here
	
//	@Override
//	public EmployeeService getEmployeeDAO() {
//		// InMemoryEmployeeDAO implements EmployeeService
//		return new SQLEmployeeDAO();
//	}

}
