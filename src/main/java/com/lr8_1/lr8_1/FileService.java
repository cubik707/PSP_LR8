package com.lr8_1.lr8_1;

import java.util.*;
import java.io.*;
import jakarta.servlet.ServletContext;

public class FileService {
  private ServletContext context;

  public FileService(ServletContext context) {
    this.context = context;
  }

  public List<TextFile> getFilesByCategory(String category) throws IOException {
    List<TextFile> files = new ArrayList<>();
    String path = "/WEB-INF/files/" + category;
    File directory = new File(context.getRealPath(path));

    if (directory.exists() && directory.isDirectory()) {
      for (File file : directory.listFiles()) {
        if (file.isFile()) {
          String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
          files.add(new TextFile(file.getName(), category, content));
        }
      }
    }
    return files;
  }

  public TextFile getFile(String category, String fileName) throws IOException {
    String path = "/WEB-INF/files/" + category + "/" + fileName;
    File file = new File(context.getRealPath(path));

    if (file.exists()) {
      String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));
      return new TextFile(fileName, category, content);
    }
    return null;
  }
}

