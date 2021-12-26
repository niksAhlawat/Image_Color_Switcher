package com.pickpamphlet.unused;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteImage
 */
@WebServlet("/DeleteImage")
public class DeleteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIRECTORY = "upload";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
         String filePath = getServletContext().getRealPath("")
 	            + File.separator + UPLOAD_DIRECTORY;
 	    
		  File file = new File(filePath);
	        boolean fileDelete = file.delete();

	            if (fileDelete) 
	            { 
	                  
	                    request.setAttribute("message", "successfully deleted!");
	            } else {
	              
	                request.setAttribute("message", "cant delete a file!");
	            } 
	            getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}

}
