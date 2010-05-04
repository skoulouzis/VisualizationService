/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualization;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vtk.vtkPointSource;
import static org.junit.Assert.*;

/**
 *
 * @author skoulouz
 */
public class VTKLocalTest {

    private static final File dataLocation = new File("testData");
    private String outputDir = dataLocation.getAbsolutePath() + "/output/";

    public VTKLocalTest() {
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
//        File f = new File(outputDir);
//        for (int i = 0; i < f.list().length; i++) {
//            f.listFiles()[i].delete();
//        }
    }

//    @Test
//    public void testRenderNewArteryOnScreen() {
//        System.out.println("renderArtery");
////        String url = dataLocation + "/uvadata/carotid-bifurcation_7800.vtk";
////        String url = dataLocation + "/artery-smooth.vtk"; 
//        String url = dataLocation + "/newArtery.vtk";
//        VTKBackEnd instance = new VTKBackEnd(outputDir);
//
//        String result = instance.readPolyData(url);
//
//        File f = new File(result);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + result + " is empty!");
//        }
//
//        url = result;
//        result = instance.renderArtery(url);
//
//        System.err.println("result: " + result);
//
//        f = new File(result);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + result + " is empty!");
//        }
//    }

    @Test
    public void testRenderSmoothArteryOnScreen() {
        System.out.println("renderArtery");
//        String url = dataLocation + "/uvadata/carotid-bifurcation_7800.vtk";
        String url = dataLocation + "/artery-smooth.vtk";
//        String url = dataLocation + "/newArtery.vtk";
        VTKBackEnd instance = new VTKBackEnd(outputDir);

        String result = instance.readPolyData(url);

        File f = new File(result);
        assertTrue(f.exists());
        if (f.length() <= 0) {
            fail("File " + result + " is empty!");
        }

        url = result;
        result = instance.renderArtery(url);

        System.err.println("result: " + result);

        f = new File(result);
        assertTrue(f.exists());
        if (f.length() <= 0) {
            fail("File " + result + " is empty!");
        }
    }
//    
//       @Test
//    public void testRenderNewArtery() {
//        System.out.println("renderArtery");
////        String url = dataLocation + "/uvadata/carotid-bifurcation_7800.vtk";
////        String url = dataLocation + "/artery-smooth.vtk"; 
//        String url = dataLocation + "/newArtery.vtk";
//        VTKService instance = new VTKService();
//        instance.setOutputDir(outputDir);
//
//
//        String result = instance.readPolyData(url);
//
//        File f = new File(result);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + result + " is empty!");
//        }
//
//        url = result;
//        result = instance.renderArtery(url);
//
//        System.err.println("result: " + result);
//
//        f = new File(result);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + result + " is empty!");
//        }
//    }

//    @Test
//    public void testRenderSmoothArtery() {
//        System.out.println("renderArtery");
////        String url = dataLocation + "/uvadata/carotid-bifurcation_7800.vtk";
//        String url = dataLocation + "/artery-smooth.vtk";
////        String url = dataLocation + "/newArtery.vtk";
//        VTKService instance = new VTKService();
//        instance.setOutputDir(outputDir);
//
//
//        String result = instance.readPolyData(url);
//
//        File f = new File(result);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + result + " is empty!");
//        }
//
//        url = result;
//        result = instance.renderArtery(url);
//
//        System.err.println("result: " + result);
//
//        f = new File(result);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + result + " is empty!");
//        }
//    }
    @Test
    public void testRenderFlowVel1OffScreen() {
//        System.out.println("renderFlow");
////        Flow:   	vel1new.vtk(856K)	cutted.vtk(31M)		velocity.vtk(67M)
//        String url = dataLocation + "/vel1.vtk";
////        String url = dataLocation  + "/velocity.vtk";
////        String url = dataLocation + "/vel1new.vtk";
////        String url = dataLocation + "/uvadata/carotid-bifurcation.7800.vtk";
////        String url = dataLocation + "/cutted.vtk";
//
//        VTKBackEnd instance = new VTKBackEnd(outputDir);
//        
//        String readResult = instance.readDataSet(url);
//        
//        System.out.println("readResult: "+readResult);
//
//        File f = new File(readResult);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + readResult + " is empty!");
//        }
//
//        String streamRes = instance.streamLine(readResult, 100);
//        f = new File(streamRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + streamRes + " is empty!");
//        }
//
//        String renderRes = instance.renderFlow(streamRes);
//        f = new File(renderRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + renderRes + " is empty!");
//        }
    }

//    @Test
//    public void testRenderFlowVel1() {
//        System.out.println("renderFlow");
////        Flow:   	vel1new.vtk(856K)	cutted.vtk(31M)		velocity.vtk(67M)
//        String url = dataLocation + "/vel1.vtk";
////        String url = dataLocation  + "/velocity.vtk";
////        String url = dataLocation + "/vel1new.vtk";
////        String url = dataLocation + "/uvadata/carotid-bifurcation.7800.vtk";
////        String url = dataLocation + "/cutted.vtk";
//
//        VTKService instance = new VTKService();
//        instance.setOutputDir(outputDir);
//        String readResult = instance.readDataset(url);
//
//        File f = new File(readResult);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + readResult + " is empty!");
//        }
//
//        String streamRes = instance.addStream(readResult, 100);
//        f = new File(streamRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + streamRes + " is empty!");
//        }
//
//        String renderRes = instance.renderFlow(streamRes);
//        f = new File(renderRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + renderRes + " is empty!");
//        }
//    }
//
//    @Test
//    public void testRenderFlowvelocity() {
//        System.out.println("renderFlow");
////        Flow:   	vel1new.vtk(856K)	cutted.vtk(31M)		velocity.vtk(67M)
////        String url = dataLocation  + "/vel1.vtk";
//        String url = dataLocation + "/velocity.vtk";
////        String url = dataLocation + "/vel1new.vtk";
////        String url = dataLocation + "/uvadata/carotid-bifurcation.7800.vtk";
////        String url = dataLocation + "/cutted.vtk";
//
//        VTKService instance = new VTKService(outputDir);
//        String readResult = instance.readDataset(url);
//
//        File f = new File(readResult);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + readResult + " is empty!");
//        }
//
//        String streamRes = instance.addStream(readResult, 100);
//        f = new File(streamRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + streamRes + " is empty!");
//        }
//
//        String renderRes = instance.renderFlow(streamRes);
//        f = new File(renderRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + renderRes + " is empty!");
//        }
//    }
//
//    @Test
//    public void testRenderFlowvel1new() {
//        System.out.println("renderFlow");
////        Flow:   	vel1new.vtk(856K)	cutted.vtk(31M)		velocity.vtk(67M)
////        String url = dataLocation  + "/vel1.vtk";
////        String url = dataLocation  + "/velocity.vtk";
//        String url = dataLocation + "/vel1new.vtk";
////        String url = dataLocation + "/uvadata/carotid-bifurcation.7800.vtk";
////        String url = dataLocation + "/cutted.vtk";
//
//        VTKService instance = new VTKService(outputDir);
//        String readResult = instance.readDataset(url);
//
//        File f = new File(readResult);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + readResult + " is empty!");
//        }
//
//        String streamRes = instance.addStream(readResult, 100);
//        f = new File(streamRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + streamRes + " is empty!");
//        }
//
//        String renderRes = instance.renderFlow(streamRes);
//        f = new File(renderRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + renderRes + " is empty!");
//        }
//    }
//
//    @Test
//    public void testRenderFlowcarotid() {
//        System.out.println("renderFlow");
////        Flow:   	vel1new.vtk(856K)	cutted.vtk(31M)		velocity.vtk(67M)
////        String url = dataLocation  + "/vel1.vtk";
////        String url = dataLocation  + "/velocity.vtk";
////        String url = dataLocation + "/vel1new.vtk";
//        String url = dataLocation + "/uvadata/carotid-bifurcation.7800.vtk";
////        String url = dataLocation + "/cutted.vtk";
//
//        VTKService instance = new VTKService(outputDir);
//        String readResult = instance.readDataset(url);
//
//        File f = new File(readResult);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + readResult + " is empty!");
//        }
//
//        String streamRes = instance.addStream(readResult, 100);
//        f = new File(streamRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + streamRes + " is empty!");
//        }
//
//        String renderRes = instance.renderFlow(streamRes);
//        f = new File(renderRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + renderRes + " is empty!");
//        }
//    }
//
//    @Test
//    public void testRenderFlowcutted() {
//        System.out.println("renderFlow");
////        Flow:   	vel1new.vtk(856K)	cutted.vtk(31M)		velocity.vtk(67M)
////        String url = dataLocation  + "/vel1.vtk";
////        String url = dataLocation  + "/velocity.vtk";
////        String url = dataLocation + "/vel1new.vtk";
////        String url = dataLocation + "/uvadata/carotid-bifurcation.7800.vtk";
//        String url = dataLocation + "/cutted.vtk";
//
//        VTKService instance = new VTKService(outputDir);
//        String readResult = instance.readDataset(url);
//
//        File f = new File(readResult);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + readResult + " is empty!");
//        }
//
//        String streamRes = instance.addStream(readResult, 100);
//        f = new File(streamRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + streamRes + " is empty!");
//        }
//
//        String renderRes = instance.renderFlow(streamRes);
//        f = new File(renderRes);
//        assertTrue(f.exists());
//        if (f.length() <= 0) {
//            fail("File " + renderRes + " is empty!");
//        }
//    }
    @Test
    public void testRenderArteryAndFlow1() {
//        System.out.println("renderArteryAndFlow");
//        String arrteryDataLoc = dataLocation + "/newArtery.vtk";
//        String flowDataLoc = dataLocation + "/vel1new.vtk";
//
//
//        VTKBackEnd instance = new VTKBackEnd(outputDir);
//        String arrteryReadResult = instance.readDataSet(arrteryDataLoc);
//
//
//        String flowReadResult = instance.readDataSet(flowDataLoc);
//        String streamResault = instance.streamLine(flowReadResult, 10);
//
//        System.out.println("---------streamResault-------------- " + streamResault);
//        System.out.println("---------arrteryReadResult---- " + arrteryReadResult);
//
//
//        instance.renderArteryAndFlow(arrteryReadResult, streamResault);
    }

    @Test
    public void testRenderArteryAndFlow2() {
//        System.out.println("renderArteryAndFlow");
//        String arrteryDataLoc = dataLocation + "/artery-smooth.vtk";
//        String flowDataLoc = dataLocation + "/velocity.vtk";
//
//
//        VTKBackEnd instance = new VTKBackEnd(outputDir);
//        String arrteryReadResult = instance.readDataSet(arrteryDataLoc);
//
//
//        String flowReadResult = instance.readDataSet(flowDataLoc);
//        String streamResault = instance.streamLine(flowReadResult, 300);
//
//        System.out.println("---------streamResault-------------- " + streamResault);
//        System.out.println("---------arrteryReadResult---- " + arrteryReadResult);
//
//
//        instance.renderArteryAndFlow(arrteryReadResult, streamResault);
    }
}
