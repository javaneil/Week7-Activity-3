package com.fortney.restserver;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application; // Ensure this is the Rest Services (.rs.) class from org.glassfish.jersey.containers
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Neil on 3/1/2017.
 */

//Defines the base URI for all resource URIs.
@ApplicationPath("/")

//The java class declares root resource and provider classes
public class HelloApplication extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>() ;
        h.add( HelloWorld.class ) ;
        h.add( HelloName.class ) ;
        h.add( Hello.class ) ;
        return h ;
    }

}
