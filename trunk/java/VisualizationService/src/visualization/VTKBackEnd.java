/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visualization;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import vtk.*;

/**
 *
 * @author skoulouz
 */
public class VTKBackEnd {

    static {
        System.loadLibrary("vtkCommon");
        System.loadLibrary("vtkCommonJava");

        System.loadLibrary("vtkFiltering");
        System.loadLibrary("vtkFilteringJava");

        System.loadLibrary("vtkIO");
        System.loadLibrary("vtkIOJava");

        System.loadLibrary("vtkImaging");
        System.loadLibrary("vtkImagingJava");

        System.loadLibrary("vtkGraphics");
        System.loadLibrary("vtkGraphicsJava");

        System.loadLibrary("vtkRendering");
        System.loadLibrary("vtkRenderingJava");



        System.loadLibrary("vtkzlib");
        System.loadLibrary("vtkjpeg");
        System.loadLibrary("vtktiff");
        System.loadLibrary("vtkpng");
        System.loadLibrary("vtkexpat");
        System.loadLibrary("vtkfreetype");
        System.loadLibrary("vtkftgl");

        try {
            System.loadLibrary("vtkHybrid");
            System.loadLibrary("vtkHybridJava");
            System.loadLibrary("vtkHybridJava");
        } catch (Throwable e) {
            System.out.println("cannot load vtkHybrid,   skipping...");
        }
        try {
            System.loadLibrary("vtkVolumeRendering");
            System.loadLibrary("vtkVolumeRenderingJava");
        } catch (Throwable e) {
            System.out.println("cannot load vtkVolumeRendering,skipping...");
        }
//        try {
//            System.loadLibrary("vtkParallel");
//            System.loadLibrary("vtkParallelJava");
//        } catch (Throwable e) {
//            System.out.println("cannot load vtkParallelJava,skipping...");
//        }
    }
    private String resultsDir;
    private boolean offScreenRender = true;

    private static void debug(String msg) {
        System.err.println(VTKBackEnd.class.getName() + ": " + msg);
//        Logger.getLogger(VTKBackEnd.class.getName()).log(Level.INFO, msg, msg);
    }
    private Logger loger;

    public VTKBackEnd(String resultDir) {
        this.resultsDir = resultDir;
        File f = new File(resultDir);
        f.mkdirs();
        
        loger = Logger.getLogger(VTKBackEnd.class.getName());
    }

    public String readPolyData(String fileName) {
        loger.info("step one");
        vtkPolyDataReader reader = new vtkPolyDataReader();
//        vtkDataSetReader reader = new vtkDataSetReader();
        loger.info("reader object constructed");
        reader.SetFileName(fileName);
        loger.info("file read");
        reader.Update();
        loger.info("name is set to " + fileName);


        String output = getFileNameWithOutExt(fileName);//fileName.substring(0, fileName.length() - 3);

        loger.info("output is : " + output);
        String outputPath = getResultsDir() + output + "spw";

        vtkPolyDataWriter writer = new vtkPolyDataWriter();
        loger.info("writer object constructed");
        writer.SetInputConnection(reader.GetOutputPort());
        //write file to *.pdw
        writer.SetFileName(outputPath);
        writer.Write();
        loger.info("file written");
        
        
        return outputPath;
    }

    public String readDataSet(String path) {

        loger.info("path is : " + path);

        vtkDataSetReader reader = getdataSetReader(path);

        vtkDataSetWriter writer = new vtkDataSetWriter();
//        vtkStructuredPointsWriter writer = new vtkStructuredPointsWriter();
        loger.info("writer object constructed");
        writer.SetInputConnection(reader.GetOutputPort());


        String output = getFileNameWithOutExt(path);

        loger.info("output is : " + output);
        String outputPath = getResultsDir() + output + "spw";

        writer.SetFileName(outputPath);
        writer.Write();
        return outputPath;
    }

    public String streamLine(String fileName, int ratio) {


        //        stream lines--------------------------------------
        vtkDataSetReader dataSetReader = getdataSetReader(fileName);

        vtkVectorNorm vectorNorm = new vtkVectorNorm();
        vectorNorm.NormalizeOn();
        vectorNorm.SetInputConnection(dataSetReader.GetOutputPort());


        vtkArrowSource source = new vtkArrowSource();

        vtkMaskPoints maskPoints = new vtkMaskPoints();
        maskPoints.SetOnRatio(ratio);
        maskPoints.RandomModeOn();
        maskPoints.SetInputConnection(vectorNorm.GetOutputPort());


        vtkGlyph3D glyph = new vtkGlyph3D();
        glyph.SetInputConnection(maskPoints.GetOutputPort());
        glyph.SetScaleFactor(10);
        glyph.SetSource(source.GetOutput());

        String output = getFileNameWithOutExt(fileName);
        String outputPath = getResultsDir() + output + "pdw";
        vtkPolyDataWriter pWriter = new vtkPolyDataWriter();
        loger.info("writer object constructed");
        pWriter.SetInputConnection(glyph.GetOutputPort());
        pWriter.SetFileName(outputPath);
        pWriter.Write();

        return outputPath;

    }

    public String readStructuredPoints(String fileName) {

        loger.info("step one");
        vtkStructuredPointsReader reader = new vtkStructuredPointsReader();
//        vtkDataSetReader reader = new vtkDataSetReader();
        loger.info("reader object constructed");

        loger.info("SetFileName: " + fileName);
        reader.SetFileName(fileName);


        loger.info("file read");
        reader.Update();

        vtkVectorNorm vect = new vtkVectorNorm();
        vect.SetInputConnection(reader.GetOutputPort());

        loger.info("name is set to " + fileName);

        String output = getFileNameWithOutExt(fileName);//fileName.substring(0, fileName.length() - 3);

        loger.info("output is : " + output);
        String outputPath = getResultsDir() + output + "spw";

        vtkStructuredPointsWriter writer = new vtkStructuredPointsWriter();
        loger.info("writer object constructed");

        writer.SetInputConnection(vect.GetOutputPort());


        writer.SetFileName(outputPath);
        writer.Write();
        loger.info("file written");

        return outputPath;
    }

    private vtkDataSetReader getdataSetReader(String path) {
        vtkDataSetReader dataSetReader = new vtkDataSetReader();
        dataSetReader.SetFileName(path);
        dataSetReader.Update();
        return dataSetReader;
    }
//    public String streamLine(String fileName, int pNumber) {
//        loger.info("step one");
//        vtkStructuredPointsReader reader = new vtkStructuredPointsReader();
//
//
//        loger.info("reader object constructed");
//        reader.SetFileName(fileName);
//        loger.info("file read");
//        reader.Update();
//        loger.info("name is set to " + fileName);
//
//        vtkPointSource seeds = new vtkPointSource();
//        seeds.SetRadius(20.0);	// 20.0
//        seeds.SetCenter(297.93, 111.98, 37.155);	// 56.478, 118.64, 312.32
//        seeds.SetNumberOfPoints(pNumber);	// 50
//
//        vtkStreamLine streamers = new vtkStreamLine();
//        streamers.SetInputConnection(reader.GetOutputPort());
//        streamers.SetSource(seeds.GetOutput());
//        streamers.SetMaximumPropagationTime(5610000);
//        streamers.SetIntegrationStepLength(0.5);
//        streamers.SetStepLength(150.0);
//        streamers.SetIntegrationDirectionToIntegrateBothDirections();
//        streamers.Update();
//
//        vtkTubeFilter tubes = new vtkTubeFilter();
//        tubes.SetInput(streamers.GetOutput());
//        tubes.SetRadius(0.5);
//        tubes.SetNumberOfSides(6);
//        tubes.Update();
//
//        String output = getFileNameWithOutExt(fileName);//fileName.substring(0, fileName.length() - 3);
//        String outputPath = getResultsDir() + output + "pdw";
//
//        vtkPolyDataWriter writer = new vtkPolyDataWriter();
//        loger.info("writer object constructed");
//        writer.SetInputConnection(tubes.GetOutputPort());
//        writer.SetFileName(outputPath);
////        writer.Update();
//        writer.Write();
//
//        loger.info("file written");
//
//        return outputPath;
//    }
    public String renderArtery(String fileName) {

        //String output = fileName.substring(0, fileName.length() - 3);
        String output = getFileNameWithOutExt(fileName);
        String outputPath = getResultsDir() + output + "jpg";

        vtkPolyDataReader arteryreader = new vtkPolyDataReader();
        arteryreader.SetFileName(fileName);
        arteryreader.Update();
        loger.info("name is set to " + fileName);

        vtkPolyDataMapper arteryMapper = new vtkPolyDataMapper();
        arteryMapper.SetInput(arteryreader.GetOutput());
        arteryMapper.ScalarVisibilityOff();

        vtkActor arteryActor = new vtkActor();
        arteryActor.SetMapper(arteryMapper);
        arteryActor.GetProperty().SetOpacity(0.4);
//        arteryActor.SetOrientation(5.0, 0, 0.0);
//        double[] or = arteryActor.GetOrientation();
//        
//        for(int i=0;i<or.length;i++){
//            loger.info("or["+i+"]: "+or[i]);
//        }

        vtkRenderer ren = new vtkRenderer();
        ren.AddActor(arteryActor);
        ren.SetBackground(0.1, 0.2, 0.2);

//        vtkRenderWindow renWin = new vtkRenderWindow();
//        vtkXOpenGLRenderWindow renWin = new vtkXOpenGLRenderWindow();
        vtkOpenGLRenderWindow renWin = new vtkOpenGLRenderWindow();


        renWin.AddRenderer(ren);
        renWin.SetSize(800, 600);
        renWin.OffScreenRenderingOn();

        vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
        iren.SetRenderWindow(renWin);

        vtkInteractorStyleTrackballCamera style = new vtkInteractorStyleTrackballCamera();

        iren.SetInteractorStyle(style);

//        if(isOffScreenRender()){
        renWin.OffScreenRenderingOn();

        renWin.SetOffScreenRendering(1);
//        }


        renWin.Render();
//  	iren.Start();

        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
        w2i.SetInput(renWin);

        vtkJPEGWriter JWriter = new vtkJPEGWriter();
        JWriter.SetInputConnection(w2i.GetOutputPort());
        JWriter.SetFileName(outputPath);
        JWriter.Write();

        return outputPath;
    }

    public String renderOffScreenArtery(String fileName) {

        //String output = fileName.substring(0, fileName.length() - 3);
        String output = getFileNameWithOutExt(fileName);
        String outputPath = getResultsDir() + output + "jpg";

        vtkGraphicsFactory gf = new vtkGraphicsFactory();

        gf.SetUseMesaClasses(1);
        gf.SetOffScreenOnlyMode(1);

        vtkImagingFactory imf = new vtkImagingFactory();
        imf.SetUseMesaClasses(1);

        vtkPolyDataReader arteryreader = new vtkPolyDataReader();
        arteryreader.SetFileName(fileName);
        arteryreader.Update();
        loger.info("name is set to " + fileName);

        vtkMesaPolyDataMapper arteryMapper = new vtkMesaPolyDataMapper();
        arteryMapper.SetInput(arteryreader.GetOutput());
        arteryMapper.ScalarVisibilityOff();

        vtkMesaActor arteryActor = new vtkMesaActor();
        arteryActor.SetMapper(arteryMapper);
        arteryActor.GetProperty().SetOpacity(0.4);

        vtkMesaRenderer ren = new vtkMesaRenderer();
        ren.AddActor(arteryActor);
        ren.SetBackground(0.1, 0.2, 0.2);

        vtkXMesaRenderWindow renWin = new vtkXMesaRenderWindow();
        renWin.OffScreenRenderingOn();
        renWin.AddRenderer(ren);
        renWin.SetSize(800, 600);


//	vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
//	iren.SetRenderWindow(renWin);

//	vtkInteractorStyleTrackballCamera  style = new vtkInteractorStyleTrackballCamera();
//	iren.SetInteractorStyle(style);

        renWin.Render();
//  	iren.Start();

        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
        w2i.SetInput(renWin);

        vtkJPEGWriter JWriter = new vtkJPEGWriter();
        JWriter.SetInputConnection(w2i.GetOutputPort());
        JWriter.SetFileName(outputPath);
        JWriter.Write();

        return outputPath;
    }

    public String renderFlow(String fileName) {

        //String output = fileName.substring(0, fileName.length() - 3);
        String output = getFileNameWithOutExt(fileName);
        String outputPath = getResultsDir() + output + "jpg";

        vtkLookupTable lut = new vtkLookupTable();
        lut.SetTableRange(0, 2000);
        lut.SetHueRange(0.667, 0); 	//This creates a blue to red lut.
        lut.SetSaturationRange(1, 1);
        lut.SetValueRange(1, 1);
        lut.Build();

        vtkPolyDataReader flowreader = new vtkPolyDataReader();
        flowreader.SetFileName(fileName);
        flowreader.Update();
        loger.info("name is set to " + fileName);

        vtkPolyDataMapper flowMapper = new vtkPolyDataMapper();
        flowMapper.SetInput(flowreader.GetOutput());
        flowMapper.SetLookupTable(lut);
        flowMapper.SetColorModeToMapScalars();
        flowMapper.ScalarVisibilityOn();
        flowMapper.SetScalarRange(flowreader.GetOutput().GetScalarRange()); // I am not sure with scalar range needed.

        //flow actor
        vtkActor flowActor = new vtkActor();
        flowActor.SetMapper(flowMapper);

        //rendering stuff
        vtkRenderer ren = new vtkRenderer();
        ren.AddActor(flowActor);
        ren.SetBackground(0.1, 0.2, 0.2);

        vtkRenderWindow renWin = new vtkRenderWindow();
        renWin.AddRenderer(ren);
        renWin.SetSize(800, 600);

        vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
        iren.SetRenderWindow(renWin);

        vtkInteractorStyleTrackballCamera style = new vtkInteractorStyleTrackballCamera();
        iren.SetInteractorStyle(style);

        if (isOffScreenRender()) {
            renWin.OffScreenRenderingOn();
        }

        //rendering 
        renWin.Render();

        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
        w2i.SetInput(renWin);

        vtkJPEGWriter JWriter = new vtkJPEGWriter();
        JWriter.SetInputConnection(w2i.GetOutputPort());
        JWriter.SetFileName(outputPath);
        JWriter.Write();


        return outputPath;
    }

    public String renderOffScreenFlow(String fileName) {

        String output = getFileNameWithOutExt(fileName);
        String outputPath = getResultsDir() + output + "jpg";

        vtkGraphicsFactory gf = new vtkGraphicsFactory();
        gf.SetUseMesaClasses(1);
        gf.SetOffScreenOnlyMode(1);

        vtkImagingFactory imf = new vtkImagingFactory();
        imf.SetUseMesaClasses(1);

        vtkLookupTable lut = new vtkLookupTable();
        lut.SetTableRange(0, 2000);
        lut.SetHueRange(0.667, 0); 	//This creates a blue to red lut.
        lut.SetSaturationRange(1, 1);
        lut.SetValueRange(1, 1);
        lut.Build();

        vtkPolyDataReader flowreader = new vtkPolyDataReader();
        flowreader.SetFileName(fileName);
        flowreader.Update();
        loger.info("name is set to " + fileName);

        vtkMesaPolyDataMapper flowMapper = new vtkMesaPolyDataMapper();
        flowMapper.SetInput(flowreader.GetOutput());
        flowMapper.SetLookupTable(lut);
        flowMapper.SetColorModeToMapScalars();
        flowMapper.ScalarVisibilityOn();
        flowMapper.SetScalarRange(flowreader.GetOutput().GetScalarRange()); // I am not sure with scalar range needed.

        //flow actor
        vtkMesaActor flowActor = new vtkMesaActor();
        flowActor.SetMapper(flowMapper);

        //rendering stuff
        vtkMesaRenderer ren = new vtkMesaRenderer();
        ren.AddActor(flowActor);
        ren.SetBackground(0.1, 0.2, 0.2);

        vtkXMesaRenderWindow renWin = new vtkXMesaRenderWindow();
        renWin.OffScreenRenderingOn();
        renWin.AddRenderer(ren);
        renWin.SetSize(800, 600);

//	vtkRenderWindowInteractor iren= new vtkRenderWindowInteractor();
//	iren.SetRenderWindow(renWin);

//	vtkInteractorStyleTrackballCamera style= new vtkInteractorStyleTrackballCamera();
//	iren.SetInteractorStyle(style);

        //rendering 
        renWin.Render();

        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
        w2i.SetInput(renWin);

        vtkJPEGWriter JWriter = new vtkJPEGWriter();
        JWriter.SetInputConnection(w2i.GetOutputPort());
        JWriter.SetFileName(outputPath);
        JWriter.Write();

        return outputPath;
    }

//    public String renderpFlow(String fileName) {
//
//        vtkLookupTable lut = new vtkLookupTable();
//        lut.SetTableRange(0, 2000);
//        lut.SetHueRange(0.667, 0); 	//This creates a blue to red lut.
//        lut.SetSaturationRange(1, 1);
//        lut.SetValueRange(1, 1);
//        lut.Build();
//
//        vtkPolyDataReader flowreader = new vtkPolyDataReader();
//        flowreader.SetFileName(fileName);
//        flowreader.Update();
//        loger.info("name is set to " + fileName);
//
//        vtkPolyDataMapper flowMapper = new vtkPolyDataMapper();
//        flowMapper.SetInput(flowreader.GetOutput());
//        flowMapper.SetLookupTable(lut);
//        flowMapper.SetColorModeToMapScalars();
//        flowMapper.ScalarVisibilityOn();
//        flowMapper.SetScalarRange(flowreader.GetOutput().GetScalarRange()); // I am not sure with scalar range needed.
//
//        //flow actor
//        vtkActor flowActor = new vtkActor();
//        flowActor.SetMapper(flowMapper);
//
//        //rendering stuff
//        vtkRenderer ren = new vtkRenderer();
//        ren.AddActor(flowActor);
//        ren.SetBackground(0.1, 0.2, 0.2);
//
//        vtkRenderWindow renWin = new vtkRenderWindow();
//        renWin.AddRenderer(ren);
//        renWin.SetSize(800, 600);
//
//        vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
//        iren.SetRenderWindow(renWin);
//
//        vtkInteractorStyleTrackballCamera style = new vtkInteractorStyleTrackballCamera();
//        iren.SetInteractorStyle(style);
//
//        if (isOffScreenRender()) {
//            renWin.OffScreenRenderingOn();
//        }
//
//        //rendering 
//        renWin.Render();
////  	iren.Start();	//uncomment this to enable the render window to stay
//
//        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
//        w2i.SetInput(renWin);
//
//
//        String output = getFileNameWithOutExt(fileName);
//        String outputPath = getResultsDir() + output + "jpg";
//
//        vtkJPEGWriter JWriter = new vtkJPEGWriter();
//        JWriter.SetInputConnection(w2i.GetOutputPort());
//        JWriter.SetFileName(outputPath);
//        JWriter.Write();
//
//
//        return outputPath;
//    }
    
    
    public String renderArteryAndFlow(String arteryData, String flowData) {
        vtkPolyDataReader arteryreader = new vtkPolyDataReader();
        arteryreader.SetFileName(arteryData);
        arteryreader.Update();
        loger.info("name is set to " + arteryData);

        vtkPolyDataMapper arteryMapper = new vtkPolyDataMapper();
        arteryMapper.SetInput(arteryreader.GetOutput());
        arteryMapper.ScalarVisibilityOff();

        vtkActor arteryActor = new vtkActor();
        arteryActor.SetMapper(arteryMapper);
        arteryActor.GetProperty().SetOpacity(0.4);
//        arteryActor.SetPosition(0, 0, 90);
//        arteryActor.SetOrientation(0, 90, 0);
//        arteryActor.SetOrigin(0.0, 0.0, 50);
        

        vtkLookupTable lut = new vtkLookupTable();
        lut.SetTableRange(0, 2000);
        lut.SetHueRange(0.667, 0); 	//This creates a blue to red lut.
        lut.SetSaturationRange(1, 1);
        lut.SetValueRange(1, 1);
        lut.Build();

        vtkPolyDataReader flowreader = new vtkPolyDataReader();
        flowreader.SetFileName(flowData);
        flowreader.Update();
        loger.info("name is set to " + flowData);

        vtkPolyDataMapper flowMapper = new vtkPolyDataMapper();
        flowMapper.SetInput(flowreader.GetOutput());
        flowMapper.SetLookupTable(lut);
        flowMapper.SetColorModeToMapScalars();
        flowMapper.ScalarVisibilityOn();
        flowMapper.SetScalarRange(flowreader.GetOutput().GetScalarRange());

        //flow actor
        vtkActor flowActor = new vtkActor();
        flowActor.SetMapper(flowMapper);

        vtkRenderer ren = new vtkRenderer();
        ren.AddActor(arteryActor);
        ren.AddActor(flowActor);
        ren.SetBackground(0.1, 0.2, 0.2);

        vtkRenderWindow renWin = new vtkRenderWindow();
        renWin.AddRenderer(ren);
        renWin.SetSize(800, 600);
        renWin.OffScreenRenderingOn();


        vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
        iren.SetRenderWindow(renWin);

        vtkInteractorStyleTrackballCamera style = new vtkInteractorStyleTrackballCamera();
        iren.SetInteractorStyle(style);

        if (isOffScreenRender()) {
            renWin.OffScreenRenderingOn();
        }

        renWin.Render();
//  	iren.Start();

        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
        w2i.SetInput(renWin);

        String outputPath = getResultsDir() + "together.jpg";

        vtkJPEGWriter JWriter = new vtkJPEGWriter();
        JWriter.SetInputConnection(w2i.GetOutputPort());
        JWriter.SetFileName(outputPath);
        JWriter.Write();

        return outputPath;
    }

    public String renderOffScreenArteryAndFlow(String arteryData, String flowData) {
        vtkGraphicsFactory gf = new vtkGraphicsFactory();
        gf.SetUseMesaClasses(1);
        gf.SetOffScreenOnlyMode(1);

        vtkImagingFactory imf = new vtkImagingFactory();
        imf.SetUseMesaClasses(1);

        vtkPolyDataReader arteryreader = new vtkPolyDataReader();
        arteryreader.SetFileName(arteryData);
        arteryreader.Update();
        loger.info("name is set to " + arteryData);

        vtkMesaPolyDataMapper arteryMapper = new vtkMesaPolyDataMapper();
        arteryMapper.SetInput(arteryreader.GetOutput());
        arteryMapper.ScalarVisibilityOff();

        vtkMesaActor arteryActor = new vtkMesaActor();
        arteryActor.SetMapper(arteryMapper);
        arteryActor.GetProperty().SetOpacity(0.4);

        vtkLookupTable lut = new vtkLookupTable();
        lut.SetTableRange(0, 2000);
        lut.SetHueRange(0.667, 0); 	//This creates a blue to red lut.
        lut.SetSaturationRange(1, 1);
        lut.SetValueRange(1, 1);
        lut.Build();

        vtkPolyDataReader flowreader = new vtkPolyDataReader();
        flowreader.SetFileName(flowData);
        flowreader.Update();
        loger.info("name is set to " + flowData);

        vtkMesaPolyDataMapper flowMapper = new vtkMesaPolyDataMapper();
        flowMapper.SetInput(flowreader.GetOutput());
        flowMapper.SetLookupTable(lut);
        flowMapper.SetColorModeToMapScalars();
        flowMapper.ScalarVisibilityOn();
        flowMapper.SetScalarRange(flowreader.GetOutput().GetScalarRange());

        //flow actor
        vtkMesaActor flowActor = new vtkMesaActor();
        flowActor.SetMapper(flowMapper);

        vtkMesaRenderer ren = new vtkMesaRenderer();
        ren.AddActor(arteryActor);
        ren.AddActor(flowActor);
        ren.SetBackground(0.1, 0.2, 0.2);

        vtkXMesaRenderWindow renWin = new vtkXMesaRenderWindow();
        renWin.OffScreenRenderingOn();
        renWin.AddRenderer(ren);
        renWin.SetSize(800, 600);

//	vtkRenderWindowInteractor iren = new vtkRenderWindowInteractor();
//	iren.SetRenderWindow(renWin);

//	vtkInteractorStyleTrackballCamera  style = new vtkInteractorStyleTrackballCamera();
//	iren.SetInteractorStyle(style);

        renWin.Render();
//  	iren.Start();

        vtkWindowToImageFilter w2i = new vtkWindowToImageFilter();
        w2i.SetInput(renWin);

        vtkJPEGWriter JWriter = new vtkJPEGWriter();
        JWriter.SetInputConnection(w2i.GetOutputPort());

        String outputPath = getResultsDir() + "together.jpg";
        JWriter.SetFileName(outputPath);
        JWriter.Write();

        return outputPath;
    }

    public String getResultsDir() {
        return resultsDir + "/";
    }

    public void setResultsDir(String resultsDir) {
        this.resultsDir = resultsDir;
    }

    private String getFileNameWithOutExt(String name) {
        String[] path = name.split(File.separator);
        String fileName = path[path.length - 1].substring(0, path[path.length - 1].length() - 3);
        return fileName;
    }

    public boolean isOffScreenRender() {
        return offScreenRender;
    }

    public void setOffScreenRender(boolean offScreenRender) {
        this.offScreenRender = offScreenRender;
    }
}
