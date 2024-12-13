package com.lr8_1.lr8_1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/files")
public class FileServlet extends HttpServlet {
  private FileService fileService;

  @Override
  public void init() throws ServletException {
    fileService = new FileService(getServletContext());
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String category = request.getParameter("category");

    if (category == null || category.isEmpty()) {
      request.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(request, response);
    } else {
      List<TextFile> files = fileService.getFilesByCategory(category);
      request.setAttribute("files", files);
      request.setAttribute("category", category);
      request.getRequestDispatcher("/WEB-INF/views/files.jsp").forward(request, response);
    }
  }
}

