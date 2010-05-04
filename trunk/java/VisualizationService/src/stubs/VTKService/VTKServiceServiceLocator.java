/**
 * VTKServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stubs.VTKService;

public class VTKServiceServiceLocator extends org.apache.axis.client.Service implements stubs.VTKService.VTKServiceService {

    public VTKServiceServiceLocator() {
    }


    public VTKServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public VTKServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for VTKService
    private java.lang.String VTKService_address = "http://localhost:8080/axis/services/VTKService";

    public java.lang.String getVTKServiceAddress() {
        return VTKService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String VTKServiceWSDDServiceName = "VTKService";

    public java.lang.String getVTKServiceWSDDServiceName() {
        return VTKServiceWSDDServiceName;
    }

    public void setVTKServiceWSDDServiceName(java.lang.String name) {
        VTKServiceWSDDServiceName = name;
    }

    public stubs.VTKService.VTKService getVTKService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(VTKService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getVTKService(endpoint);
    }

    public stubs.VTKService.VTKService getVTKService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            stubs.VTKService.VTKServiceSoapBindingStub _stub = new stubs.VTKService.VTKServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getVTKServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setVTKServiceEndpointAddress(java.lang.String address) {
        VTKService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (stubs.VTKService.VTKService.class.isAssignableFrom(serviceEndpointInterface)) {
                stubs.VTKService.VTKServiceSoapBindingStub _stub = new stubs.VTKService.VTKServiceSoapBindingStub(new java.net.URL(VTKService_address), this);
                _stub.setPortName(getVTKServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
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
        java.lang.String inputPortName = portName.getLocalPart();
        if ("VTKService".equals(inputPortName)) {
            return getVTKService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/services/VTKService", "VTKServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/services/VTKService", "VTKService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("VTKService".equals(portName)) {
            setVTKServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
