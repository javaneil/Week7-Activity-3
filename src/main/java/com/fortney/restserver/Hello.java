package com.fortney.restserver;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neil on 3/2/2017.
 */

@Path( "/hello" )
public class Hello {

    @GET
    @Path( "/{param}" )
    public Response getMessage( @PathParam( "param" ) String msg ) {
        if ( msg.equals( "html" ) ) {
            return returnHtml();
        }
        else if (msg.equals( "json" ) ) {
            return returnJson();
        }
        else {
            String output = "Unhandled Format: " + msg ;
            return Response.status(200).entity(output).build() ;
        }
    }

    @GET
    @Produces( {MediaType.TEXT_HTML} )
    public Response returnHtml() {
        String output =
                  "<html>"
                + "<title>TAB HelloWorld HTML</title>"
                + "<body>"
                + "<h1>HelloWorld HTML</h1>"
                + "</body>"
                + "</html> ";
        return Response.status(200).entity( output ).build() ;
    }

    /**
     * References:
     * http://www.mkyong.com/webservices/jax-rs/restful-java-client-with-jersey-client/
     * https://www.nabisoft.com/tutorials/java-ee/producing-and-consuming-json-or-xml-in-java-rest-services-with-jersey-and-jackson
     * http://www.mkyong.com/java/how-to-convert-java-object-to-from-json-jackson/
     * @return
     */
    @GET
    @Produces( {MediaType.APPLICATION_JSON} )
    public Response returnJson() {

        List<JsonMsgPojo> list = genJsonMsg( 3 ) ;
        String json = convertToJson( list ) ;

        return Response.status(200).entity( json ).build() ;
    }

    private List<JsonMsgPojo> genJsonMsg( int len ) {
        List<JsonMsgPojo> msgArray = new ArrayList<JsonMsgPojo>() ;

        for ( int idx = 1; idx <= len; idx++ ) {
            JsonMsgPojo msg = new JsonMsgPojo() ;
            msg.setId( idx ) ;
            msg.setFirst( "Hello" ) ;
            msg.setLast( "World" ) ;
            msgArray.add( msg ) ;
        }
        return msgArray ;
    }

    //todo convert prints to logs
    private String convertToJson( List<JsonMsgPojo> list ) {
        ObjectMapper mapper = new ObjectMapper() ;
        String json = "" ;

        // found this on-line, prettys-up the output with CR/LFs
        mapper.configure( SerializationFeature.INDENT_OUTPUT, true ) ;

        try {
            json = mapper.writeValueAsString( list ) ;
        }
        catch ( JsonGenerationException e ) {
            e.printStackTrace();
        }
        catch ( JsonMappingException e ) {
            e.printStackTrace();
        }
        catch ( IOException e ) {
            e.printStackTrace() ;
        }
        return json ;
    }

}
