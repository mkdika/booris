package com.mkdika.booris.ui.web.component;

import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

/**
 *
 * @author maikel
 */
public class Popmsg {
    
    private String message;
    
    public Popmsg() {
        
    }
    
    @Init
    public void init(@ExecutionArgParam("message") String msg,
            @ExecutionArgParam("price") Integer price) {
        setMessage(msg + " " + price.toString());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }        
}
