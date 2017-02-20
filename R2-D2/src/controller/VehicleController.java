package controller;

import java.util.ArrayList;

import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import service.IVehicleService;
import model.Vehicle;

@Path("/vehicle")
public class VehicleController {
	
	//vehicleService will be set from R2D2Initialization on project startup
	public static IVehicleService vehicleService;

	@GET
	@Path("/getVehicle/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicle getVehicle(@PathParam("id") int id)
	{
		if(vehicleService != null)
		{
			Vehicle vehicle = vehicleService.get(id);
			if(vehicle == null)
			{
				throw new WebApplicationException(Response.status(404).entity("Sorry,"
						+ " Vehicle not found for ID = " + id)
						.type("text/plain")
						.build());
			}
			else {
				return vehicle;
			}
		}
		throw new WebApplicationException(Response.status(500).entity("Something went wrong. Contact xxx-xxx-xxxx").build());
	}
	
	@GET
	@Path("/getVehicles")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vehicle> getVehicles()
	{
		if(vehicleService != null)
		{
			ArrayList<Vehicle> vehicles = vehicleService.get();
			if(vehicles.isEmpty())
			{
				throw new WebApplicationException(Response.status(404).entity("Sorry,"
						+ " No Vehicles in repository yet.")
						.type("text/plain")
						.build());
			}
			else {
				return vehicles;
			}
		}
		throw new WebApplicationException(Response.status(500).entity("Something went wrong. Contact xxx-xxx-xxxx").build());
	}
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String createVehicle(
					@Valid
					@Min(value = 1950, message = "Year can't be before than 1950")
					@Max(value = 2050, message = "Year can't be after 2050 ")
					@FormParam("year") int year,
					@Valid
					@NotNull
					@FormParam("make") String make,
					@FormParam("model") String model,
					@FormParam("class") String vehicle_class) throws ValidationException
	{
		if(vehicleService != null)
		{
			if(year != 0 && make != null && model != null && vehicle_class != null)
			{
				Vehicle vehicle = new Vehicle(year, make, model, vehicle_class);
				int id = vehicleService.create(vehicle);
				return "Vehicle created with ID = " + id;
			}	
			return "Not a valid data for Vehicle";
		}
		throw new WebApplicationException(Response.status(500).entity("Something went wrong. Contact xxx-xxx-xxxx").build());
	}
	
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteVehicle(@FormParam("id") int id)
	{
		if(vehicleService != null)
		{
			Vehicle vehicle = vehicleService.get(id);
			if(vehicle == null)
			{
				throw new WebApplicationException(Response.status(404).entity("Sorry,"
						+ " Vehicle not found for ID = " + id)
						.type("text/plain")
						.build());
			}
			else {
				vehicleService.delete(vehicle);
				return "deleted Vehicle with ID = " + id;
			}
		}
		throw new WebApplicationException(Response.status(500).entity("Something went wrong. Contact xxx-xxx-xxxx").build());
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateVehicle(
						@FormParam("id") int id,
						@Valid
						@Min(value = 1950, message = "Year can't be before than 1950")
						@Max(value = 2050, message = "Year can't be after 2050 ")
						@FormParam("year") int year,
						@FormParam("make") String make,
						@FormParam("model") String model,
						@FormParam("class") String vehicle_class)
	{
		if(vehicleService != null)
		{
			if(year != 0 && make != null && model != null && vehicle_class != null)
			{
					if(!vehicleService.ifExist(id))
					{
						throw new WebApplicationException(Response.status(404).entity("Sorry,"
								+ " Vehicle not found for ID = " + id)
								.type("text/plain")
								.build());
					}
					else
					{
						Vehicle vehicle = new Vehicle(id, year, make, model, vehicle_class);
						vehicleService.update(vehicle);
						return "Vehicle with ID = " + id + " Succesfully updated";
					}
			}	
			return "Not a valid data for Vehicle";
		}
		throw new WebApplicationException(Response.status(500).entity("Something went wrong. Contact xxx-xxx-xxxx").build());
	}
}
