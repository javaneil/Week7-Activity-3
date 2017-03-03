package com.fortney.restserver;

/**
 * Created by Neil on 3/2/2017.
 */

public class JsonMsgPojo {
    private int    id ;
    private String first ;
    private String last ;

    public int getId() {
        return id ;
    }
    public void setId( int id ) {
        this.id = id ;
    }

    public String getFirst() {
        return first ;
    }
    public void setFirst( String first) {
        this.first = first ;
    }

    public String getLast() {
        return last ;
    }
    public void setLast( String last ) {
        this.last = last ;
    }

}
