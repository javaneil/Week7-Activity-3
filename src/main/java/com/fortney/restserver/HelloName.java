package com.fortney.restserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by Neil on 3/1/2017.
 */

@Path( "/name" )
public class HelloName {

    @GET
    @Produces( "text/plain" )
    @Path( "/{param}" )
    public Response getMessage( @PathParam( "param" ) String msg ) {
        String output = "Hello { " + msg + " }" ;
        return Response.status(200).entity( output ).build() ;
    }

}
