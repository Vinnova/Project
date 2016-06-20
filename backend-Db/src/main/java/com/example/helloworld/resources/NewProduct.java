package com.example.helloworld.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.database.Product;
import com.example.helloworld.database.ProductDAO;

@Path("/Product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NewProduct {
	private ProductDAO productDAO;
	
	public NewProduct(ProductDAO dao) {
		productDAO = dao;
	}
	
	@GET
	@Path("/{id}")
	@Timed
	public Product getUser(@PathParam("id") Integer id) {
		Product u = productDAO.findById(id);
		
		if (u != null) {
			return u;
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
	}
	
	@GET
	@Timed
	public List<Product> listProducts() {
		return productDAO.getAll();
	}
	
	@POST
	@Timed
	public void save(Product product) {
		if (product != null) {
			productDAO.insert(product);
			throw new WebApplicationException(Response.Status.OK);
		} else {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
	}
	
	@PUT
	@Path("/{id}")
	public void update(@PathParam("id") int id, Product product) {
		if (product != null) {
			productDAO.update(product, id);
			throw new WebApplicationException(Response.Status.OK);
		} else {
			throw new WebApplicationException(Status.BAD_REQUEST);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Timed
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	public void deleteProduct(@PathParam("id") Integer id) {
		if (productDAO.findById(id) != null) {
			productDAO.deleteById(id);
			throw new WebApplicationException(Response.Status.OK);
		} else {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
	

}
