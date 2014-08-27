package com.comcast.addition.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.0
 * 2014-08-18T14:46:40.586-04:00
 * Generated source version: 2.7.0
 * 
 */
@WebService(targetNamespace = "http://www.comcast.com/addition/services/", name = "AdditionService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface AdditionService {

    @WebResult(name = "addResponse", targetNamespace = "http://www.comcast.com/addition/services/", partName = "parameters")
    @WebMethod(action = "http://www.comcast.com/addition/services/add")
    public AddResponse add(
        @WebParam(partName = "parameters", name = "addRequest", targetNamespace = "http://www.comcast.com/addition/services/")
        AddRequest parameters
    );
}