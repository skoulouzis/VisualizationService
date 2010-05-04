/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clients;

/**
 *
 * @author alogo
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import org.globus.util.GlobusURL;
//import org.globus.io.urlcopy.*;
//import org.globus.ftp.*;
//import org.globus.ftp.exception.*;
//
//import org.aws.wsrf.preader.PreaderClient;
//import org.aws.wsrf.sreader.SreaderClient;
//import org.aws.wsrf.stream.StreamerClient;
//import org.aws.wsrf.renderer.RendererClient;


public class GUIClient extends javax.swing.JFrame {
    
    private static final String FTPSERVER = "ftp://owf-04.science.uva.nl:40000/";
    private static final String PREADER   = "http://146.50.1.190:8080/wsrf/services/vtkPolyDataReaderService";
    private static final String SREADER   = "http://146.50.1.190:8080/wsrf/services/vtkStructuredPointsReaderService";
    private static final String STREAMER  = "http://146.50.1.190:8080/wsrf/services/vtkStreamService";
    private static final String RENDERER  = "http://146.50.1.190:8080/wsrf/services/vtkRenderingService";
            
    private static String ARTERY = "";
    private static String FLOW   = "";
    
    private static String IMAGE = "";
    
    private int nLines;
    
    /**
     * Creates new form ContactEditor
     */
    public GUIClient() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        jLabel1.setText("Datasets:");

        jLabel2.setText("Services:");

        jCheckBox3.setText("Preader");
        jCheckBox3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jCheckBox4.setText("Sreader");
        jCheckBox4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox4.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jCheckBox5.setText("Streamer");
        jCheckBox5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox5.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jCheckBox6.setText("Renderer");
        jCheckBox6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox6.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel3.setText("artery");

        jLabel4.setText("flow");

        jTextField1.setText("your input");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setText("your input");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("your input");

        jTextField4.setText("your input");

        jTextField5.setText("your input");

        jLabel5.setText("X");

        jLabel6.setText("Y");

        jLabel7.setText("Z");

        jLabel8.setText("Streamlines");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "6", "9", "12" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(47, 47, 47)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel4Layout.createSequentialGroup()
                                        .add(jLabel1)
                                        .add(45, 45, 45)
                                        .add(jLabel3)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jPanel4Layout.createSequentialGroup()
                                        .add(113, 113, 113)
                                        .add(jCheckBox3)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel4Layout.createSequentialGroup()
                                        .add(jLabel4)
                                        .add(4, 4, 4)
                                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jCheckBox5)
                                    .add(jPanel4Layout.createSequentialGroup()
                                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jPanel4Layout.createSequentialGroup()
                                                .add(jCheckBox4)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jLabel5)
                                                .add(3, 3, 3)
                                                .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .add(jLabel8)
                                                .add(21, 21, 21)))
                                        .add(jLabel6)
                                        .add(1, 1, 1)
                                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(jComboBox1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(jTextField4))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jLabel7)
                                        .add(3, 3, 3)
                                        .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(214, 214, 214)
                        .add(jCheckBox6)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel3)
                    .add(jLabel4)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(63, 63, 63)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jCheckBox3)
                    .add(jCheckBox4)
                    .add(jLabel5)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jTextField5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel2)
                        .add(22, 22, 22)
                        .add(jCheckBox5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 46, Short.MAX_VALUE)
                        .add(jCheckBox6)
                        .add(34, 34, 34))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel8)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jButton5.setText("Check");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Run");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("View Result");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(60, 60, 60)
                .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(108, 108, 108)
                .add(jButton6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 116, Short.MAX_VALUE)
                .add(jButton7)
                .add(75, 75, 75))
            .add(layout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton5)
                    .add(jButton6)
                    .add(jButton7))
                .add(34, 34, 34))
        );
        pack();
    }// </editor-fold>                        

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
// TODO add your handling code here:
        nLines = Integer.parseInt((String)jComboBox1.getSelectedItem());
    }                                          

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
// TODO add your handling code here:
        FLOW = jTextField2.getText();
    }                                           

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
// TODO add your handling code here:
        ARTERY = jTextField1.getText();
    }                                           

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        new Viewer(IMAGE);
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
//        RunClient rc = new RunClient();
//        String result = rc.run();
//        IMAGE = result.substring(result.lastIndexOf("/") +1, result.length());
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        check();
    }                                        
    
    
//    class Ftp{
//    //put/get data to/from the gridftp server
//
//        public void transfer(String file, String f)
//        {
//	String flag = f;
//	GlobusURL from = null;
//	GlobusURL to = null;
//	String url = (FTPSERVER + file);
//
//	try {
//		if(flag.equals("get"))
//		{
//		    from = new GlobusURL(url);
//		    to = new GlobusURL("file:///" + file);
//		}
//		else if(flag.equals("put"))
//		{
//		    from = new GlobusURL("file:///" + file);
//		    to = new GlobusURL(url);
//		}
//		else
//		{
//		    System.err.println("Error, specify get or put");
//		}
//		//System.out.println("============ Transferring file =====================");
//	        //System.out.println("From:\n"+ from.toString());
//        	//System.out.println("----------------------------------------------------");
//        	//System.out.println("To:\n" + to.toString());
//            
//            	UrlCopy uc = new UrlCopy();
//
//		uc.setSourceUrl(from);
//		uc.setDestinationUrl(to);
//		uc.setUseThirdPartyCopy(false);
//		uc.copy();
//		//System.out.println("============== Transfer done =======================\n\n");
//	}
//	catch (Exception e) {
//		e.printStackTrace();
//        }
//        }
//    }
    
    

//    class RunClient{
// 
//        private String remsg  = "";
//        private String remsg1 = "";
//        private String remsg2 = "";
// 
//        public String run(){
//
//        if (ARTERY != ""){ 
//            Ftp ftp = new Ftp();
//            ftp.transfer(ARTERY,"put");
//     
//            PreaderClient pclient = new PreaderClient();
//            remsg=pclient.run(FTPSERVER + ARTERY, PREADER);
//         
//            RendererClient rclient = new RendererClient();
//            remsg=rclient.runArtery(FTPSERVER + remsg, RENDERER);     
//            
//            ftp.transfer(remsg,"get");
//        }
// 
//        if (FLOW != "") {           //to be added with argument of nLines 
// 
//            Ftp ftp = new Ftp();
//            ftp.transfer(FLOW,"put");
//     
//            SreaderClient sclient = new SreaderClient();
//            remsg=sclient.run(FTPSERVER + FLOW, SREADER);
//         
//            StreamerClient strclient = new StreamerClient();
//            remsg=strclient.run(FTPSERVER + remsg, STREAMER, nLines);
//            
//            RendererClient rclient = new RendererClient();           
//            remsg=rclient.runFlow(FTPSERVER + remsg, RENDERER);    
//            
//            ftp.transfer(remsg,"get");
//        }
//        if (ARTERY != "" && FLOW != ""){
//        
//            Ftp ftp = new Ftp();
//            ftp.transfer(ARTERY,"put");
//            ftp.transfer(FLOW,"put");    
//            
//            PreaderClient pclient = new PreaderClient();
//            remsg1=pclient.run(FTPSERVER + ARTERY, PREADER);
//         
//            SreaderClient sclient = new SreaderClient();
//            remsg2=sclient.run(FTPSERVER + FLOW, SREADER);
//         
//            StreamerClient strclient = new StreamerClient();
//            remsg2=strclient.run(FTPSERVER + remsg2, STREAMER, nLines);
//            
//            RendererClient rclient = new RendererClient();           
//            remsg=rclient.runBoth(FTPSERVER + remsg1, FTPSERVER + remsg2, RENDERER);
//            
//            ftp.transfer(remsg,"get");
//        }
//        return remsg;
//    }
// }
       
    
/*    
    public String GetClient(String service){
       
        if(service == PREADER){
            PreaderClient client = new PreaderClient();
        }
        
        if(service == SREADER){
            SreaderClient client = new SreaderClient();
        }
        
        if(service == STREAMER){
            StreamerClient client = new StreamerClient();
        }

        if(service == RENDERER){
            RendererClient client = new RendererClient();
        }
    }
 */   
    
    
    class Viewer extends JFrame{
        private Image image;
        
    	public Viewer(String fileName) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            image = toolkit.getImage(fileName);
            MediaTracker mediaTracker = new MediaTracker(this);
            mediaTracker.addImage(image, 0);
            try
            {
		mediaTracker.waitForID(0);
            }
            catch (InterruptedException ie)
            {
                System.err.println(ie);
            }
            addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
        	setVisible(false);
            }
            });
            setSize(image.getWidth(null), image.getHeight(null));
            setTitle(fileName);
            setVisible(true);
            }
        }
    
    
    class CheckDialog extends JDialog{
        CheckDialog(Frame f,String msg) {
            //make modal dialog
            JDialog dia = new JDialog(f, true);
            //add label
            JLabel lab = new JLabel(msg);
            dia.getContentPane().add(BorderLayout.NORTH, lab);
            //show modal dialog
            dia.setLocation(20, 20);
            dia.setSize(200, 100);
            dia.setVisible(true);
        }
    }
        
    public CheckDialog check(){
    
        if(jCheckBox3.isSelected()==true && jCheckBox6.isSelected()==true && jCheckBox4.isSelected()==false && jCheckBox5.isSelected()==false ){return new CheckDialog(this,"good to go");}
    
        if(jCheckBox3.isSelected()==false && jCheckBox6.isSelected()==true && jCheckBox4.isSelected()==true && jCheckBox5.isSelected()==true ){return new CheckDialog(this,"good to go");}

        if(jCheckBox3.isSelected()==true && jCheckBox6.isSelected()==true && jCheckBox4.isSelected()==true && jCheckBox5.isSelected()==true ){return new CheckDialog(this,"good to go");}
                    
        return new CheckDialog(this,"error");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIClient().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration                   
    
}

