package clients;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.rpc.ServiceException;
import nl.uva.vlet.exception.VlException;
import nl.uva.vlet.vfs.VFile;
import nl.uva.vlet.vrl.VRL;
import proxyWS.impl.ProxyService;
import stubs.VTKService.VTKService;
import stubs.VTKService.VTKServiceServiceLocator;

/**
 *
 * @author skoulouz
 */
public class VTKClient {

    private static long readTime = -1;
    private static long processTime = -1;
    private static long renderTime = -1;
    private static long postStageTime = -1;
    private static long totalTime = -1;

    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        if (args[0].equals("vtk_GFTP")) {
            //gftp server, readWS1,readWS2,streamWS,renderWS

            visulizeGFTP(args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], Integer.parseInt(args[9]));


        }

//        for(int i=0;i<args.length;i++){
//            System.out.println("args["+i+"]"+args[i]);
//        }
//            

        if (args[0].equals("vtk_PROXY")) {
            //gftp server, readWS1,readWS2,streamWS,renderWS,
            //arteryLocation,flowLocation,readWS1,readWS2, streamWS,renderWS, localRes, ratio
            visulizePROXY(args[1], args[2], args[3], args[4], args[5], args[6], args[7], Integer.parseInt(args[8]));
        }

        if (args[0].equals("async_vtk_GFTP")) {
            //gftp server, readWS1,readWS2,streamWS,renderWS
            asyncVisulizeGFTP(args[1], args[2], args[3], args[4], args[5]);
        }



        if (args[0].equals("vtk_GFTP_pipline1")) {
            //gftp server, readWS1,readWS2,streamWS,renderWS
            
            
            String arteryLoc=args[1];//"gsiftp://elab.science.uva.nl/tmp/testData/artery-smooth.vtk";
            String saveLoc = args[2];//"gsiftp://elab.science.uva.nl/tmp/testData/output";
            String reader =args[3];//"http://ow140.science.uva.nl:8080/axis/services/VTKService";
            String renderer = args[4];//"http://ow143.science.uva.nl:8080/axis/services/VTKService";
            String localPath = args[5];//"/home/skoulouz/workspace/netbeans/VisualizationService/testData/output/";
                

            
            visulizeGFTPPipeline1(arteryLoc, saveLoc, reader, renderer, localPath);


        }

        totalTime = System.currentTimeMillis() - start;


        System.out.println(readTime + "\t" + processTime + "\t" + renderTime + "\t" + postStageTime + "\t" + totalTime);
        //bug!!!!
        System.exit(0);
    }

    private static void visulizeGFTP(String arteryLocation, String flowLocation, String ouputURI, String readWS1, String readWS2, String streamWS, String renderWS, String localRes, int ratio) {
        try {
            long startRead = System.currentTimeMillis();
            URI arteryURI = new URI(arteryLocation);
            VTKServiceServiceLocator sl = new VTKServiceServiceLocator();

            //read 1st dataset
            VTKService dataReadService1 = sl.getVTKService(new URL(readWS1));
            String readResult = dataReadService1.readDataset(arteryURI.toString());
            //upload result 
            String arteryReadLoc = dataReadService1.uploadData(readResult, ouputURI);


            //read 2nd dataset
            URI flowURI = new URI(flowLocation);
            VTKService dataReadService2 = sl.getVTKService(new URL(readWS2));
            readResult = dataReadService2.readDataset(flowURI.toString());
            //upload result 
            String flowReadLoc = dataReadService2.uploadData(readResult, ouputURI);

            readTime = System.currentTimeMillis() - startRead;


            long startProcess = System.currentTimeMillis();
            //add streams
            VTKService streamService = sl.getVTKService(new URL(streamWS));
            String streamResoult = streamService.addStream(flowReadLoc, ratio);
            String streamLoc = streamService.uploadData(streamResoult, ouputURI);

            processTime = System.currentTimeMillis() - startProcess;


            long startRender = System.currentTimeMillis();
            //render
            VTKService renderService = sl.getVTKService(new URL(renderWS));
            String renderResult = renderService.renderArteryAndFlow(arteryReadLoc, streamLoc);
            //upload result 
            String jpgLoc = renderService.uploadData(renderResult, ouputURI);

            renderTime = System.currentTimeMillis() - startRender;


            long startPostStage = System.currentTimeMillis();
            //get result
            proxyWS.transport.DataTransportContext.init(false, null);
            VFile image = (VFile) proxyWS.transport.DataTransportContext.getVnode(jpgLoc);
            VRL outVRL = new VRL("file://" + localRes);
            image.copyToDir(outVRL);

            postStageTime = System.currentTimeMillis() - startPostStage;

        } catch (RemoteException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (VlException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void visulizeGFTPPipeline1(String arteryLocation, String ouputURI, String readWS1, String renderWS, String localRes) {
          try {
            long startRead = System.currentTimeMillis();
            URI arteryURI = new URI(arteryLocation);
            VTKServiceServiceLocator sl = new VTKServiceServiceLocator();

            //read 1st dataset
            VTKService dataReadService1 = sl.getVTKService(new URL(readWS1));
            String readResult = dataReadService1.readDataset(arteryURI.toString());
            //upload result 
            String arteryReadLoc = dataReadService1.uploadData(readResult, ouputURI);
            
            readTime = System.currentTimeMillis() - startRead;


            long startProcess = System.currentTimeMillis();


            processTime = System.currentTimeMillis() - startProcess;


            long startRender = System.currentTimeMillis();
            //render
            VTKService renderService = sl.getVTKService(new URL(renderWS));
            String renderResult = renderService.renderArtery(arteryReadLoc);
            //upload result 
            String jpgLoc = renderService.uploadData(renderResult, ouputURI);

            renderTime = System.currentTimeMillis() - startRender;


            long startPostStage = System.currentTimeMillis();
            //get result
            proxyWS.transport.DataTransportContext.init(false, null);
            VFile image = (VFile) proxyWS.transport.DataTransportContext.getVnode(jpgLoc);
            VRL outVRL = new VRL("file://" + localRes);
            image.copyToDir(outVRL);

            postStageTime = System.currentTimeMillis() - startPostStage;

        } catch (RemoteException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (VlException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void visulizePROXY(String arteryLocation, String flowLocation, String readWS1, String readWS2, String streamWS, String renderWS, String localRes, int ratio) {
        try {
            long startRead = System.currentTimeMillis();
            //ws locators
            proxyWS.stubs.ProxyService.ProxyServiceServiceLocator proxySl = new proxyWS.stubs.ProxyService.ProxyServiceServiceLocator();

            //read first dataset
            proxyWS.stubs.ProxyService.ProxyService dataReadService1 = proxySl.getProxyService(new URL(readWS1));

            URI refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", arteryLocation, "");
            Object[] arg = {refData.toString()};
            String readArteryResult = (String) dataReadService1.callServiceReturnObject("VTKService", "readDataset", arg);
            //get local path as uri
            String httpReadArterryLoc = dataReadService1.getFileURI(readArteryResult);


            //read 2nd dataset            
            proxyWS.stubs.ProxyService.ProxyService dataReadService2 = proxySl.getProxyService(new URL(readWS2));
            refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", flowLocation, "");
            Object[] arg2 = {refData.toString()};
            String readFlowResult = (String) dataReadService2.callServiceReturnObject("VTKService", "readDataset", arg2);
            //get local path as uri            
            String httpReadFlowLoc = dataReadService2.getFileURI(readFlowResult);
            readTime = System.currentTimeMillis() - startRead;


            long startProcess = System.currentTimeMillis();
            //add the streams to the flow. This has to be proxy. The tagret WS only knows GFTP
            proxyWS.stubs.ProxyService.ProxyService streamService = proxySl.getProxyService(new URL(streamWS));

            refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpReadFlowLoc, "");
            Object[] args = {refData.toString(), new Integer(ratio)};
            String streamResoult = (String) streamService.callServiceReturnObject("VTKService", "addStream", args);
            String httpStreamLoc = streamService.getFileURI(streamResoult);
            processTime = System.currentTimeMillis() - startProcess;


            long startRender = System.currentTimeMillis();
            //render has to be proxy. agin target only GFTP
            proxyWS.stubs.ProxyService.ProxyService renderService = proxySl.getProxyService(new URL(renderWS));

            URI arteryReadLoc = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpReadArterryLoc, "");
            URI streamLoc = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpStreamLoc, "");

            Object[] paths = {arteryReadLoc.toString(), streamLoc.toString()};
            String renderResult = (String) renderService.callServiceReturnObject("VTKService", "renderArteryAndFlow", paths);
            String jpgLoc = renderService.getFileURI(renderResult);
            renderTime = System.currentTimeMillis() - startRender;

            long startPostStage = System.currentTimeMillis();
            proxyWS.clients.ProxyClient cl = new proxyWS.clients.ProxyClient();
            File JpgFile = cl.getFile(jpgLoc, localRes + "/togetherHttp.jpg");
            postStageTime = System.currentTimeMillis() - startPostStage;

        } catch (RemoteException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKClient.class.getName()).log(Level.SEVERE, null, ex);
        }






    }

    private static void asyncVisulizeGFTP(String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
