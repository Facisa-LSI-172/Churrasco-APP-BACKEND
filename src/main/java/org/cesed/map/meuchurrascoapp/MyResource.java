package org.cesed.map.meuchurrascoapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("eventos")
public class MyResource {
	
    @GET
    @Path("/getAll")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Get it!";
    
    }
    
    @GET
    @Path("/getOne/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String retrieveSomething(@PathParam("id") String id) {
        return "got it" +id;
    }
    
         
}
