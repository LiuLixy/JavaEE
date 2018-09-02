package com.lwstudy.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * @Author: LiuWang
 * @Created: 2018/8/31 20:47
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取上传请求的文件
        Part part = req.getPart("filename");
        InputStream is = part.getInputStream();
        String appUploadPath = req.getServletContext().getRealPath("/upload");

        // xxx.jpg
        String filename = part.getSubmittedFileName();

        // --> upload/xxx.jpg
        File file = new File(appUploadPath, filename);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        OutputStream os = new FileOutputStream(file);
        byte[] buff = new byte[1024];
        int len;
        while ((len = is.read(buff)) != -1) {
            os.write(buff, 0, len);
        }
        os.close();
        is.close();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset='UTF-8'>")
                .append("<title>File</title>")
                .append("</head>")
                .append("<body>")
                .append("<a href='")
                .append("/upload/").append(part.getSubmittedFileName())
                .append("'>")
                .append("<img src='")
                .append("/upload/").append(part.getSubmittedFileName())
                .append("'>")
                .append("上传的文件")
                .append("</a>")
                .append("</body>")
                .append("</html>");
    }
}
