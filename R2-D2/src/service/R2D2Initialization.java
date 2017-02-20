package service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import controller.VehicleController;
import dao.DAOFactory;

public class R2D2Initialization implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub	
	}

	//Servlet startup context listener
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		//context Root-> initialize everything here.
		
		//dependency injection
		DAOFactory inMemoryDAOFactory = DAOFactory.getDAOFactory(DAOFactory.INMEMORY);
		//DAOFactory inSQLDAOFactory = DAOFactory.getDAOFactory(DAOFactory.SQL);
		
		IVehicleService vehicleDAO = inMemoryDAOFactory.getVehicleDAO();
		//IVehicleService vehicleDAO = inSQLDAOFactory.getVehicleDAO();
		
		//context for the configured IVehicleService is passed to the VehicleController		
		VehicleController.vehicleService = vehicleDAO;
	}

	
}
