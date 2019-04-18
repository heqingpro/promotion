/**
 * FeeQuerynewdaoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xmbtn.boss.qfee.server;

public class FeeQuerynewdaoLocator extends org.apache.axis.client.Service implements FeeQuerynewdao {

    public FeeQuerynewdaoLocator() {
    }


    public FeeQuerynewdaoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FeeQuerynewdaoLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FeeQueryNewDAOImplPort
    private String FeeQueryNewDAOImplPort_address = "http://172.25.2.153:8081/bossws/service/feeQuerynewdao";

    public String getFeeQueryNewDAOImplPortAddress() {
        return FeeQueryNewDAOImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String FeeQueryNewDAOImplPortWSDDServiceName = "FeeQueryNewDAOImplPort";

    public String getFeeQueryNewDAOImplPortWSDDServiceName() {
        return FeeQueryNewDAOImplPortWSDDServiceName;
    }

    public void setFeeQueryNewDAOImplPortWSDDServiceName(String name) {
        FeeQueryNewDAOImplPortWSDDServiceName = name;
    }

    public IFeeQueryNewDAO getFeeQueryNewDAOImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FeeQueryNewDAOImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFeeQueryNewDAOImplPort(endpoint);
    }

    public IFeeQueryNewDAO getFeeQueryNewDAOImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.xmbtn.boss.qfee.server.FeeQuerynewdaoSoapBindingStub _stub = new com.xmbtn.boss.qfee.server.FeeQuerynewdaoSoapBindingStub(portAddress, this);
            _stub.setPortName(getFeeQueryNewDAOImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFeeQueryNewDAOImplPortEndpointAddress(String address) {
        FeeQueryNewDAOImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IFeeQueryNewDAO.class.isAssignableFrom(serviceEndpointInterface)) {
                com.xmbtn.boss.qfee.server.FeeQuerynewdaoSoapBindingStub _stub = new com.xmbtn.boss.qfee.server.FeeQuerynewdaoSoapBindingStub(new java.net.URL(FeeQueryNewDAOImplPort_address), this);
                _stub.setPortName(getFeeQueryNewDAOImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("FeeQueryNewDAOImplPort".equals(inputPortName)) {
            return getFeeQueryNewDAOImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "feeQuerynewdao");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://server.qfee.boss.xmbtn.com/", "FeeQueryNewDAOImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("FeeQueryNewDAOImplPort".equals(portName)) {
            setFeeQueryNewDAOImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
