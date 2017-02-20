package dao;

import service.IVehicleService;

public abstract class DAOFactory {
	
	//List of DAO types supported
	public static final int INMEMORY = 1;
	public static final int SQL = 2;
	
	public static DAOFactory getDAOFactory(int DAOType)
	{
		switch(DAOType)
		{
		case INMEMORY: 
			return new InMemoryDAOFactory();
		case SQL:
			return new SQLDAOFactory();
		default:
			return null;
		}
	}
	
	public abstract IVehicleService getVehicleDAO();
	//public abstract IemployeeService getEmployeeDAO();
}
