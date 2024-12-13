package com.lr8_1.lr8_1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/file")
public class FileContentServlet extends HttpServlet {
  private FileService fileService;

  @Override
  public void init() throws ServletException {
    fileService = new FileService(getServletContext());
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    String category = request.getParameter("category");
    String fileName = request.getParameter("fileName");

    try {
      if (category != null && fileName != null) {
        TextFile file = fileService.getFile(category, fileName);
        if (file != null) {
          request.setAttribute("file", file);
          request.getRequestDispatcher("/WEB-INF/views/fileContent.jsp").forward(request, response);
          return;
        }
      }
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
    } catch (IOException e) {
      throw new ServletException("Error reading file", e);
    }
  }
}
