package org.cesed.map.meuchurrascoapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("eventos")
public class MyResource {
	
    @GET
    @Path("/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Get it!";
    
    }
    
    @GET
    @Path("/getone/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String retrieveSomething(@PathParam("id") String id) {
        return "got it" +id;
    }
         
}
