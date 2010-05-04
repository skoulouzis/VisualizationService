/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualization;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.rpc.ServiceException;
import nl.uva.vlet.vfs.VFile;
import nl.uva.vlet.vrl.VRL;
import nl.uva.vlet.vrs.VNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import proxyWS.clients.ProxyClient;
import proxyWS.stubs.ProxyService.ProxyService;
import stubs.VTKService.VTKService;
import stubs.VTKService.VTKServiceServiceLocator;
import static org.junit.Assert.*;

/**
 *
 * @author skoulouz
 */
public class VTKServiceTest {

    private static File dataFolder;
    private static String dataLocation;
    private static String outputDir;
    private Logger loger;

    public VTKServiceTest() {
        dataFolder = new File("/tmp/testData/");
        dataLocation = dataFolder.getAbsolutePath();
        File outPutDir = new File("testData/output/");
        outputDir = outPutDir.getAbsolutePath();

        loger = Logger.getLogger(VTKServiceTest.class.getName());

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRenderNewArtery() {
//        try {
//            System.out.println("renderArtery");
////        String url = dataLocation + "/uvadata/carotid-bifurcation_7800.vtk";
////        String url = dataLocation + "/artery-smooth.vtk";
//            URI uri = new URI("file://"+dataLocation + "/newArtery.vtk");
////            URI uri = new URI("sftp://alogo@localhost/"+dataLocation + "/newArtery.vtk");
//
////            URI uri = new URI("gsiftp://skoulouz@elab.science.uva.nl/tmp/testData/newArtery.vtk");
//
//            loger.info("uri: " + uri);
//
//            stubs.VTKService.VTKServiceServiceLocator sl = new VTKServiceServiceLocator();
//            String host = "http://localhost:8080/axis/services/VTKService";
//            VTKService instance = sl.getVTKService(new URL(host));
//
//            String readResult = instance.readDataset(uri.toString());
//            loger.info("Result is: " + readResult);
//
//            String uploadLoc = instance.uploadData(readResult, "gsiftp://elab.science.uva.nl/tmp/testData/");
//
//            loger.info("Upload in: " + uploadLoc);
//
//            String renderResult = instance.renderArtery(uploadLoc);
//
//
//        } catch (Exception ex) {
//            Logger.getLogger(VTKServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Test
    public void testRenderBoth() {
//        try {
//            System.out.println("testRenderBoth");
//
//            URI uri1 = new URI("gsiftp://elab.science.uva.nl/tmp/testData/newArtery.vtk");
////            URI uri1 = new URI("file://" + dataLocation + "/newArtery.vtk");
//
//            stubs.VTKService.VTKServiceServiceLocator sl = new VTKServiceServiceLocator();
////            String host = "http://localhost:8080/axis/services/VTKService";
////            String host = "http://node204.das3.science.uva.nl:8080/axis/services/VTKService";
//            String readHost1 = "http://owf-01.science.uva.nl:8080/axis/services/VTKService";
//            VTKService dataReadService1 = sl.getVTKService(new URL(readHost1));
//
//            String readResult = dataReadService1.readDataset(uri1.toString());
//            loger.info("    service read result is @: " + readResult);
//            String arteryReadLoc = dataReadService1.uploadData(readResult, "gsiftp://elab.science.uva.nl/tmp/testData/output");
//            loger.info("    read artery is @: " + arteryReadLoc);
////
////
//            URI uri2 = new URI("gsiftp://elab.science.uva.nl/tmp/testData/cutted.vtk");
//            String readHost2 = "http://owf-02.science.uva.nl:8080/axis/services/VTKService";
//            VTKService dataReadService2 = sl.getVTKService(new URL(readHost2));
//            readResult = dataReadService2.readDataset(uri2.toString());
//            String flowReadLoc = dataReadService2.uploadData(readResult, "gsiftp://elab.science.uva.nl/tmp/testData/output");
//            loger.info("    read flow is @: " + flowReadLoc);
////            
////            
//            String streamHost = "http://owf-03.science.uva.nl:8080/axis/services/VTKService";
//            VTKService streamService = sl.getVTKService(new URL(streamHost));
//            String streamResoult = streamService.addStream(flowReadLoc, 300);
//            String streamLoc = streamService.uploadData(streamResoult, "gsiftp://elab.science.uva.nl/tmp/testData/output");
//            loger.info("    added streams is @: " + streamLoc);
////
//
//            String renderHost = "http://owf-04.science.uva.nl:8080/axis/services/VTKService";
//            VTKService renderService = sl.getVTKService(new URL(renderHost));
//            String renderResult = renderService.renderArteryAndFlow(arteryReadLoc, streamLoc);
//            loger.info("    rener is @: " + renderResult);
//
//            String jpgLoc = renderService.uploadData(renderResult, "gsiftp://elab.science.uva.nl/tmp/testData/output");
//            loger.info("    jpg is @: " + jpgLoc);
//
//
//            proxyWS.transport.DataTransportContext.init(false, null);
//            VFile image = (VFile) proxyWS.transport.DataTransportContext.getVnode(jpgLoc);
//            VRL outVRL = new VRL("file://" + outputDir);
//            image.copyToDir(outVRL);
//
//        } catch (Exception ex) {
//            Logger.getLogger(VTKServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

//    @Test
//    public void testRenderBothProxy() {
//
//        try {
//            System.out.println("testRenderBoth");
//
//            URI uri1 = new URI("gsiftp://elab.science.uva.nl/tmp/testData/newArtery.vtk");
//
//            //two ws locators 
//            stubs.VTKService.VTKServiceServiceLocator vtkSl = new VTKServiceServiceLocator();
//            proxyWS.stubs.ProxyService.ProxyServiceServiceLocator proxySl = new proxyWS.stubs.ProxyService.ProxyServiceServiceLocator();
//
//            //read first dataset
//            String readHost1 = "http://owf-01.science.uva.nl:8080/axis/services/VTKService";
//            VTKService dataReadService1 = vtkSl.getVTKService(new URL(readHost1));
//            String readArteryResult = dataReadService1.readDataset(uri1.toString());
//            loger.info("    service read result is @: " + readArteryResult);
//            //get local path as uri
//            String proxyReadHost1 = "http://owf-01.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService proxyReadService1 = proxySl.getProxyService(new URL(proxyReadHost1));
//            String httpReadArterryLoc = proxyReadService1.getFileURI(readArteryResult);
//            loger.info("    service read uri is: " + httpReadArterryLoc);
//
//
//            //read 2nd dataset
//            URI uri2 = new URI("gsiftp://elab.science.uva.nl/tmp/testData/cutted.vtk");
//            String readHost2 = "http://owf-02.science.uva.nl:8080/axis/services/VTKService";
//            VTKService dataReadService2 = vtkSl.getVTKService(new URL(readHost2));
//            String readFlowResult = dataReadService2.readDataset(uri2.toString());
//            //get local path as uri
//            String proxyReadHost2 = "http://owf-02.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService proxyReadService2 = proxySl.getProxyService(new URL(proxyReadHost2));
//            String httpReadFlowLoc = proxyReadService2.getFileURI(readFlowResult);
//            loger.info("    service read uri is: " + httpReadFlowLoc);
//
//
//            //add the streams to the flow. This has to be proxy. The tagret WS only knows GFTP
//            String streamHost = "http://owf-03.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService streamService = proxySl.getProxyService(new URL(streamHost));
//            
//            URI refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpReadFlowLoc, "");
//            Object[] args = {refData.toString(), new Integer(300)};
//            String streamResoult = (String) streamService.callServiceReturnObject("VTKService", "addStream", args);
//            String httpStreamLoc = streamService.getFileURI(streamResoult);
//            loger.info("    service stream uri is: " + httpStreamLoc);
//
//            //render has to be proxy. agin target only GFTP            
//            String renderHost = "http://owf-04.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService renderService = proxySl.getProxyService(new URL(renderHost));
//            
//            URI arteryReadLoc = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpReadArterryLoc, "");
//            URI streamLoc = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpStreamLoc, "");
//            
//            Object[] paths = {arteryReadLoc.toString(),streamLoc.toString()};
//            String renderResult = (String) renderService.callServiceReturnObject("VTKService", "renderArteryAndFlow", paths);
//            String jpgLoc = renderService.getFileURI(renderResult);
//            loger.info("    jpg is @: " + jpgLoc);
//            
//                       
//            proxyWS.clients.ProxyClient cl = new proxyWS.clients.ProxyClient();
//            File JpgFile = cl.getFile(jpgLoc, outputDir+"/togetherHttp.jpg");
//
//
//        } catch (Exception ex) {
//            Logger.getLogger(VTKServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @Test
    public void testRenderBothAllProxy() {

//        try {
//            System.out.println("testRenderBothAllProxy");
//            proxyWS.stubs.ProxyService.ProxyServiceServiceLocator proxySl = new proxyWS.stubs.ProxyService.ProxyServiceServiceLocator();
//            
//            URI uri1 = new URI("gsiftp://elab.science.uva.nl/tmp/testData/newArtery.vtk");
//            
//
//            //read first dataset
//            String readHost1 = "http://owf-01.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService dataReadService1 = proxySl.getProxyService(new URL(readHost1));
//            URI refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", uri1.toString(), "");
//            Object[] arg = {refData.toString()};
//            String readArteryResult = (String) dataReadService1.callServiceReturnObject("VTKService", "readDataset", arg);
//            loger.info("    service read result is @: " + readArteryResult);
//            //get local path as uri
//            String httpReadArterryLoc = dataReadService1.getFileURI(readArteryResult);
//            loger.info("    service read uri is: " + httpReadArterryLoc);
//
//
//            //read 2nd dataset
//            URI uri2 = new URI("gsiftp://elab.science.uva.nl/tmp/testData/cutted.vtk");
//            String readHost2 = "http://owf-02.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService dataReadService2 = proxySl.getProxyService(new URL(readHost2));
//            refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", uri2.toString(), "");
//            Object[] arg2 = {refData.toString()};
//            String readFlowResult = (String) dataReadService2.callServiceReturnObject("VTKService", "readDataset", arg2);
//            //get local path as uri
//            String httpReadFlowLoc = dataReadService2.getFileURI(readFlowResult);
//            loger.info("    service read uri is: " + httpReadFlowLoc);
//
//
//            //add the streams to the flow. This has to be proxy. The tagret WS only knows GFTP
//            String streamHost = "http://owf-03.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService streamService = proxySl.getProxyService(new URL(streamHost));
//            
//            refData = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpReadFlowLoc, "");
//            Object[] args = {refData.toString(), new Integer(300)};
//            String streamResoult = (String) streamService.callServiceReturnObject("VTKService", "addStream", args);
//            String httpStreamLoc = streamService.getFileURI(streamResoult);
//            loger.info("    service stream uri is: " + httpStreamLoc);
//
//            //render has to be proxy. agin target only GFTP            
//            String renderHost = "http://owf-04.science.uva.nl:8080/axis/services/ProxyService";
//            ProxyService renderService = proxySl.getProxyService(new URL(renderHost));
//
//            URI arteryReadLoc = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpReadArterryLoc, "");
//            URI streamLoc = new URI("wsdt", proxyWS.utils.Constants.IN_REF_FILE, "/dummypath", httpStreamLoc, "");
//
//            Object[] paths = {arteryReadLoc.toString(), streamLoc.toString()};
//            String renderResult = (String) renderService.callServiceReturnObject("VTKService", "renderArteryAndFlow", paths);
//            String jpgLoc = renderService.getFileURI(renderResult);
//            loger.info("    jpg is @: " + jpgLoc);
//
//
//            proxyWS.clients.ProxyClient cl = new proxyWS.clients.ProxyClient();
//            File JpgFile = cl.getFile(jpgLoc, outputDir + "/togetherHttp.jpg");
//
//
//        } catch (Exception ex) {
//            Logger.getLogger(VTKServiceTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void debug(String msg) {
        System.out.println(this.getClass().getName() + ": " + msg);
    }
}