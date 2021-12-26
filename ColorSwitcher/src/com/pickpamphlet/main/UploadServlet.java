package com.pickpamphlet.main;

import javax.imageio.ImageIO;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
//@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*10,      	// 10 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class UploadServlet extends HttpServlet {
	 private final static Logger LOGGER = 
	            Logger.getLogger(UploadServlet.class.getCanonicalName());
	
	private static final long serialVersionUID = 1L;
	
	 private BufferedImage image = null;
	 private static final String UPLOAD_DIRECTORY = "upload";
	 int oldcolor, newcolor;
	 static String req = null, requested = null;
	
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doPost(request,response);
	    }
	 
	
	 public static BufferedImage replace(BufferedImage image, int oldcolor, int newcolor) {
		    int width = image.getWidth();
		    int height = image.getHeight();
		    BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  //image.getType() //BufferedImage.TYPE_INT_ARGB
            int color;
		    float hsb[] = new float[3];
		 //   Color[][] colors = new Color[image.getWidth()][image.getHeight()];
        //    String hexColor1 = String.format("#%06X", (0xFFFFFF & oldcolor));
		   
		    float ohsb[] = new float[3];
		    int ro = new Color(oldcolor).getRed();
		    int go =new Color(oldcolor).getGreen();
		    int bo = new Color(oldcolor).getBlue();
		    ohsb = Color.RGBtoHSB(ro, go, bo, null);
		    System.out.println("oldcolor   " +"ohsb:" + ohsb[0] + ",ro:" + ro + ",go:"+ go + ",bo:" + bo);
      	   
		    float nhsb[] = new float[3];
		    int rn = new Color(newcolor).getRed();
		    int gn =new Color(newcolor).getGreen();
		    int bn = new Color(newcolor).getBlue();
		    nhsb = Color.RGBtoHSB(rn, gn, bn, null);
		    System.out.println("newcolor   " +"nhsb:" + nhsb[0] + ",rn:" + rn + ",gn:"+ gn + ",bn:" + bn);
        
		    for (int i = 0; i < width; i++) {
		        for (int j = 0; j < height; j++) {
		      // 	colors[i][j] = new Color(image.getRGB(i, j));
               // System.out.println("COLORS[i][j] " +colors[i][j]);
		        	 
		        	color = image.getRGB(i, j);
		        	// int a = (color>>24)&0xff;
		        	int r = (color >> 16) & 0xFF;
		        	int g = (color >>  8) & 0xFF;
		        	int b = (color      ) & 0xFF;
		        //	Color colorw = new Color(r,g,b);
	   
		        	hsb = Color.RGBtoHSB(r, g, b, null);
		        	 float deg = hsb[0]*360;
				     float deg1 = nhsb[0];
				     float sat = hsb[1];
				     float bri = hsb[2];
				     int rgb; 
				     
                     if(req.equals("#ff0000")) {  //red
                    	 if (hsb[1] < 0.1 && hsb[2] > 0.9) {
     		        		//nearlyWhite();
                    		 rgb = Color.HSBtoRGB(deg1, sat, bri);
     				      	 newImage.setRGB(i, j, rgb);
     		        	}
     				    else if (hsb[2] < 0.1) {
     				    	//nearlyBlack();
     				    	rgb = Color.HSBtoRGB(deg1, sat, bri);
    				      	 newImage.setRGB(i, j, rgb);
     				    }
     				    else {
				        	if(deg >= 0 && deg < 45)  { 
	     				      	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
	     				        }
				        	else {
				        		rgb = Color.HSBtoRGB(hsb[0], sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
				        } 
                     }
				        
                     else if(req.equals("#e518e3")) { //pink
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >= 310 && deg < 359) { 
    				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
    					      	 newImage.setRGB(i, j, rgb);
    				        }
     				        else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
				        } 
				        }
				        else if(req.equals("#9a18e5")) {  //purple
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >= 270 && deg < 310) { 
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				        else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
						    }
                        } 
				        else if(req.equals("#0000ff")) { //blue
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >= 220 && deg < 270) { 
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        } 
				        	else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
				       } 
				        }
				        else if(req.equals("#1fabdf")) { //turquoise
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >= 160 && deg < 180) { 
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        } 
				        	else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
						    }
				       } 
				        else if(req.equals("#7fc7ff")) { //light-blue
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >= 180 && deg < 220) { 
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
				        	else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
						    }
                       } 
				        else if(req.equals("#99ff99")) { //light-green
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >= 90 && deg < 110) { 
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
				        	else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
						    }
                       } 
				        else if(req.equals("#1ae829")) { //green
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >=  110 && deg < 160) {  
    				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
    					      	 newImage.setRGB(i, j, rgb);
    				        }
				        	else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
                       } 
				        }
				        else if(req.equals("#fde307")) { //yellow
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >=  60 && deg <  90) { 
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
				        	else {  //red();
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
                       } 
				        }
				        else if(req.equals("#ff8c00")) { //orange
				        	if (hsb[1] < 0.1 && hsb[2] > 0.9) {
				        		//nearlyWhite();	
				        		rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
				        	}
						    else if (hsb[2] < 0.1) {
						    	//nearlyBlack();
						    	rgb = Color.HSBtoRGB(deg1, sat, bri);
	     				      	 newImage.setRGB(i, j, rgb);
						    }
						    else {
				        	if (deg >=  45 && deg <  60) { 
	 				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
	 					      	 newImage.setRGB(i, j, rgb);
	 				        }
				        	else {  
     				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
						    }
                       } 
		        }		     
	          }
	    
	  
	    return newImage;
	 }	        /*	        else {
				     //   	System.out.println("This is Running!");
				        	rgb = Color.HSBtoRGB(hsb[0], sat, bri);
					      	 newImage.setRGB(i, j, rgb);
                       } 
			
				        
				     if(deg >=   0 && deg <  45)  { //red();
     				      	rgb = Color.HSBtoRGB(deg1, sat, bri);
     				      	 newImage.setRGB(i, j, rgb);
     				        }
				        else if (deg >=  45 && deg <  55) { //Orange();
 				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
 					      	 newImage.setRGB(i, j, rgb);
 				        }
     			        else if (deg >=  55 && deg <  90) { //yellow();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				        else if (deg >=  90 && deg < 110) {  //light_green();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				       else if (deg >=  110 && deg < 160) {  //green();
    				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
    					      	 newImage.setRGB(i, j, rgb);
    				        }
     				        else if (deg >= 160 && deg < 180) { //turquoise();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        } 
     				        else if (deg >= 180 && deg < 220) { //light-blue();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				        else if (deg >= 220 && deg < 270) { //blue();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				        else if (deg >= 270 && deg < 310) { //purple();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				       else if (deg >= 310 && deg < 359) { //pink();
    				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
    					      	 newImage.setRGB(i, j, rgb);
    				        }
     				        else {  //red();
     				        	rgb = Color.HSBtoRGB(deg1, sat, bri);
     					      	 newImage.setRGB(i, j, rgb);
     				        }
     				*/      
				 
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			if(request.getParameter("oldcolor")!=null && request.getParameter("newcolor")!=null) {
	        	 String o = request.getParameter("oldcolor");
	        	 String n = request.getParameter("newcolor");
	        	 String n1 = request.getParameter("newcolor1");
	        	 
	        	 req = request.getParameter("oldcolor");
	        	 requested = request.getParameter("newcolor");
	          	 oldcolor = Integer.parseInt(o.replaceFirst("^#",""), 16);
	             newcolor = Integer.parseInt(n.replaceFirst("^#",""), 16);
	             
	    	    System.out.println("oldcolor: " +oldcolor);
	        	System.out.println("newcolor: " +newcolor);
	        	System.out.println("newcolor1: " +n1);
	        	System.out.println("req: " +req);
	        	System.out.println("requested: " +requested);
	        	} else {
	        		System.out.println("Not Intialized");
	        	}
		}  catch(NumberFormatException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

	   
	 // gets absolute path of the web application
        String applicationPath = getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String path = applicationPath + File.separator + UPLOAD_DIRECTORY;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(path);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	    final Part filePart = request.getPart("file");
	    final String fileName = getFileName(filePart);

	    OutputStream out = null;
	    InputStream filecontent = null;
	   // final PrintWriter writer = response.getWriter();
	    File file = new File(path + File.separator + fileName);

	    try {
	        out = new FileOutputStream(file);
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);   
	        }
	        
	        try
            {
	          image = ImageIO.read(file);
          	  BufferedImage changedimage = replace(image, oldcolor, newcolor);
          	  File storeFile = new File(path + File.separator + "Out.jpg");
             ImageIO.write(changedimage, "jpg", storeFile);
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
	        request.setAttribute("message", fileName + " File uploaded successfully!");
	        request.setAttribute("Path", path);	
	    //    writer.println("New file " + fileName + " created at " + path);
	   //     LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",  new Object[]{fileName, path});
	    } catch (FileNotFoundException fne) {
	    //    writer.println("You either did not specify a file to upload or are "
	  //              + "trying to upload a file to a protected or nonexistent "
	   //             + "location.");
	 //       writer.println("<br/> ERROR: " + fne.getMessage());

	  //      LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
	  //              new Object[]{fne.getMessage()});
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	   //     if (writer != null) {
	    //        writer.close();
	    //    }
	    }
	  
	    request.getRequestDispatcher("/message.jsp").forward(request, response); 
        }
	

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
