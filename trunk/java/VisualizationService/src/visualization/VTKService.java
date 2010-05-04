/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualization;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.uva.vlet.exception.VlException;
import nl.uva.vlet.exception.VlURISyntaxException;
import nl.uva.vlet.vfs.VFile;
import nl.uva.vlet.vfs.localfs.LFile;
import nl.uva.vlet.vrl.VRL;

/**
 *
 * @author skoulouz
 */
public class VTKService {

    private String outputDir = null;
    private Logger loger;

    public VTKService() {
        
        System.gc();
        
        proxyWS.transport.DataTransportContext.init(true, null);

        loger = Logger.getLogger(VTKService.class.getName());
        loger.info("proxy: " + proxyWS.transport.DataTransportContext.getVrsContext().getGridProxy().getProxyFilename());

//        loger.info("proxy is valid: " + proxyWS.transport.DataTransportContext.getVrsContext().getGridProxy().isValid());

        if (!proxyWS.transport.DataTransportContext.getVrsContext().getGridProxy().isValid()) {
            try {
                proxyWS.transport.DataTransportContext.getVrsContext().setProxyFromString(System.getProperty("user.home") + "/proxy");
            } catch (VlException ex) {
                Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

//    public VTKService(String outPutDir) {
//        setOutputDir(outPutDir);
//    }
    public String getOutputDir() {
        if (outputDir == null) {
            outputDir = System.getProperty("java.io.tmpdir") + "/visServiceOutPut/";
        }

        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        return outputDir;
    }

    public void setOutputDir(String aOutputDir) {
        outputDir = aOutputDir;
    }

    private String downloadData(String uri) {

        loger.info("will download: " + uri);
        String path;

        VRL fileVRL = null;



        try {
            fileVRL = new VRL(uri);
            
            String scheme =  fileVRL.getScheme();
            loger.info("Got scheme: " + scheme);
            if(scheme == null){
                return uri;
            }
            if(scheme.equals("file") || scheme.equals("")  ){
                return uri;
            }
            VFile node = (VFile) proxyWS.transport.DataTransportContext.getVnode(fileVRL);
            loger.info("Got node: " + node.getVRL().toString());

            VRL vOutputDir = new VRL("file://" + getOutputDir());
            VFile theFile;
            //if not local bring here
            if (!(node instanceof nl.uva.vlet.vfs.localfs.LFile)) {

                theFile = node.copyToDir(vOutputDir);

                loger.info("VRL result: " + theFile.getVRL());

                path = theFile.getPath();
                loger.info("Was remote. Set path to: " + path);
            } else {
                path = node.getPath();
                loger.info("Was Local. Set path to: " + path);
            }
            loger.info("Returning: " + node.getPath());
            return path;
        } catch (VlException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return uri;
    }

    public String uploadData(String sourceUri, String destUri) {
        LFile localFile = null;
        VRL remoteVRL = null;
        VFile remoteFile = null;
        if (sourceUri != null || !sourceUri.equals("")) {
            try {
                localFile = (LFile) proxyWS.transport.DataTransportContext.getVnode(sourceUri);
                remoteVRL = new VRL(destUri);
                remoteFile = localFile.copyToDir(remoteVRL);
            } catch (VlException ex) {
                Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return remoteFile.getVRL().toString();
    }

    public String readPolyData(String url) {
        String result = "";
        try {
            String data = downloadData(url);


            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.readPolyData(data);

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "error";
    }

    public String readDataset(String url) {
        try {
            String result = "";
            String data = downloadData(url);

            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.readDataSet(data);

            return new URI("file://" + result).toString();

        } catch (Exception ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "error";
    }

    public String readStructuredPoints(String url) {
        try {
            String data = downloadData(url);
            String result = "";

            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.readStructuredPoints(data);

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }

    public String readSPoints(String url) {
        try {

            String data = downloadData(url);
            loger.info("data is: " + data);
            String result = "";


            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.readStructuredPoints(data);

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "error";
    }

    public String addStream(String url, int ratio) {
        try {
            String data = downloadData(url);
            String result = "";

            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.streamLine(data, ratio);

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "error";
    }

    public String renderArtery(String url) {
        try {

            String data = downloadData(url);
            String result = "";

            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
//        result = imp.renderArtery(data);
            result = imp.renderOffScreenArtery(data);
            
            
            

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "error";
    }

    public String renderFlow(String url) {
        try {

            String data = downloadData(url);
            String result = "";

            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.renderFlow(data);

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "error";
    }

    public String renderpFlow(String url) {
        try {
            String server = url.substring(0, url.lastIndexOf("/"));
            System.out.println(server);
            String data = downloadData(url);
            String result = "";


            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
            result = imp.renderFlow(url);
            result = imp.renderOffScreenFlow(url);

            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return "error";
    }

    public String renderArteryAndFlow(String arteryURL, String flowURL) {
        try {

            String arteryData = downloadData(arteryURL);
            String flowData = downloadData(flowURL);
            String result = "";

            VTKBackEnd imp = new VTKBackEnd(getOutputDir());
//        result = imp.renderArteryAndFlow(arteryData, flowData);
            result = imp.renderOffScreenArteryAndFlow(arteryData, flowData);              
            return new URI("file://" + result).toString();
        } catch (URISyntaxException ex) {
            Logger.getLogger(VTKService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        return "error";
    }

    private void debug(String msg) {
        System.err.println(this.getClass().getName() + ": " + msg);
    }
}

