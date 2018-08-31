package com.lwstudy.javaweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: LiuWang
 * @Created: 2018/8/31 17:55
 */
public class ChanceServlet extends HttpServlet {

    private int chanceNumber;

    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        chanceNumber = Integer.parseInt(config.getInitParameter("chanceNumber"));
        context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<html>")
                .append("<head>")
                .append("<meta charset=\"UTF-8\">")
                .append("</head>")
                .append("<body>");
        String value = req.getParameter("name");

        Integer number = (Integer) context.getAttribute(value);
        if (number == null) {
            // 等于 null, 就给 value 赋值成 number
            number = chanceNumber;
            context.setAttribute(value, number);
        }
        if (number > 0) {
            number -= 1;
            context.setAttribute(value, number);
            writer.append("<h1>")
                    .append("剩余").append(String.valueOf(number)).append("次机会")
                    .append("</h1>");
        } else {
            writer.append("<h1>").append("没机会了...").append("</h1>");
        }
        writer.append("</body>").append("</html>");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy...");
    }
}
