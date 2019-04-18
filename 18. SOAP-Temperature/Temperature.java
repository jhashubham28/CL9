package com.temp;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author prachirishi
 */
@WebService(serviceName = "Temperature")
@Stateless()
public class Temperature {
  
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "degreeCelcius")
    public double degreeCelcius(@WebParam(name="far")double fahrenheit){
       double celcius=(fahrenheit-32)/1.8;
        return celcius;
    }
}
