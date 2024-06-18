package com.lms.soapProducer;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + LMSFault.NAMESPACE_URI + "}" + "customFaultCode",
        faultStringOrReason = "")
public class LMSFault extends Exception {
    public static final String NAMESPACE_URI = "http://lms.soap.com";

    public LMSFault(String message) {
        super(message);
    }
}