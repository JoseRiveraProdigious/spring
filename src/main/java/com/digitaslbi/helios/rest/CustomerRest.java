package com.digitaslbi.helios.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import javax.ws.rs.QueryParam;

@Named
@Path("/")
@Controller
public class CustomerRest {

	private static List<Customer> customers = new ArrayList<Customer>();

	static {
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setNome("Customer 1");
		customer1.setEmail("customer1@gmail.com");
		customers.add(customer1);
	}

	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@QueryParam("id") long id) throws Exception {
		Customer cli = null;
		for (Customer c : customers) {
			if (c.getId() == id)
				cli = c;
		}

		if (cli == null) {
			System.out.println("sssss");
			throw new NotFoundException("prueba");
		}

		return Response.ok(cli).build();
	}
}
