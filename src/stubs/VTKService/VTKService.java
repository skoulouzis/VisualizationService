/**
 * VTKService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stubs.VTKService;

public interface VTKService extends java.rmi.Remote {
    public java.lang.String getOutputDir() throws java.rmi.RemoteException;
    public void setOutputDir(java.lang.String aOutputDir) throws java.rmi.RemoteException;
    public java.lang.String uploadData(java.lang.String sourceUri, java.lang.String destUri) throws java.rmi.RemoteException, nl.uva.vlet.exception.VlException;
    public java.lang.String readPolyData(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String readDataset(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String readStructuredPoints(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String readSPoints(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String addStream(java.lang.String url, int ratio) throws java.rmi.RemoteException;
    public java.lang.String renderArtery(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String renderFlow(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String renderpFlow(java.lang.String url) throws java.rmi.RemoteException;
    public java.lang.String renderArteryAndFlow(java.lang.String arteryURL, java.lang.String flowURL) throws java.rmi.RemoteException;
}
