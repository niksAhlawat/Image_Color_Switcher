package com.pickpamphlet.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String UPLOAD_DIRECTORY = "upload";
	 String req = null;
	 
	  String path = null;
	  String filename = "Out.jpg";

	 /**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(request, response);
		}
		
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 req = request.getParameter("req");
		 System.out.println(req);
		
		 
		 String applicationPath = getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file
	     path = applicationPath + File.separator + UPLOAD_DIRECTORY;
	     // creates the save directory if it does not exists
	        File fileSaveDir = new File(path);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        
		 if(request.getParameter("req").equals("open")) {
			 System.out.println("OPEN YES");
			 response.setContentType("image/jpeg");  
			    ServletOutputStream out;  
			    out = response.getOutputStream();  
			    FileInputStream fin = new FileInputStream(path + File.separator + filename);  
			      
			    BufferedInputStream bin = new BufferedInputStream(fin);  
			    BufferedOutputStream bout = new BufferedOutputStream(out);  
			    int ch =0; ;  
			    while((ch=bin.read())!=-1)  
			    {  
			    bout.write(ch);  
			    }  
			      
			    bin.close();  
			    fin.close();  
			    bout.close();  
			    out.close();  
		 } 
		 if (request.getParameter("req").equals("download")){
			 System.out.println("DOWNLOAD YES");
			// downloadImage(request, response);
			    response.setContentType("text/html");
				PrintWriter out = response.getWriter();
		
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setHeader("Content-Disposition", "attachment; filename=\""
						+ filename + "\"");
		 
				FileInputStream fileInputStream = new FileInputStream(path + File.separator + filename);
		 
				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				out.close();
		 }	
		 
		 if(request.getParameter("req").equals("reuse")) {
			 String imagepath = path + File.separator + filename;
			 request.setAttribute("ProcessedImage", imagepath);

			//forward the request to Servlet2
			 RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
			 rd.forward(request, response);
		 }
		 
        if(request.getParameter("req").equals("back")) {
        	String url = request.getHeader("referer");
        	 System.out.println(url);
        	 RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
             rd.forward(request, response);
		 }
		}
}
