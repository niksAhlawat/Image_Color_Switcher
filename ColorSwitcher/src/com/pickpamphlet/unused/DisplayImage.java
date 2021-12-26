package com.pickpamphlet.unused;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Servlet implementation class DisplayImage
 */
//@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final String UPLOAD_DIRECTORY = "upload";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// constructs the directory path to store upload file
        String uploadPath = getServletContext().getRealPath("")
            + File.separator + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
		String fileName = (String)request.getAttribute("fileName");
		String filePath = uploadPath + File.separator + fileName;
		 File f = new File(filePath);

         FileInputStream fin = new FileInputStream(f);
         ServletOutputStream outStream = response.getOutputStream();
         response.setContentType("image/jpeg");
         int i = 0;
         while (i != -1) {
             i = fin.read();
             outStream.write(i);
         }
         fin.close();
	}

}
