package com.lwstudy.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据查询
 *
 * @Author: LiuWang
 * @Created: 2018/8/31 20:04
 */
public class QueryServlet extends HttpServlet {

    private Map<String, List<String>> scenicSpot = new HashMap<>();

    private Map<String, String> cityMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();

        List<String> xian = new ArrayList<>();
        xian.add("华清池");
        xian.add("兵马俑");
        xian.add("大雁塔");
        scenicSpot.put("xian", xian);
        cityMap.put("xian", "西安");

        List<String> baoji = new ArrayList<>();
        baoji.add("太白山");
        baoji.add("法门寺");
        baoji.add("关山牧场");
        scenicSpot.put("baoji", baoji);
        cityMap.put("baoji", "宝鸡");

        List<String> xianyang = new ArrayList<>();
        xianyang.add("乾陵");
        scenicSpot.put("xianyang", xianyang);
        cityMap.put("xianyang", "咸阳");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理参数
        String city = req.getParameter("city");
        // 准备数据
        List<ScenicsDto> scenicsDtoArrayList = new ArrayList<>();
        if (city == null || city.length() <= 0) {
            // 全部信息
            for (Map.Entry<String, List<String>> entry : scenicSpot.entrySet()) {
                String cityKey = entry.getKey();
                List<String> scenics = entry.getValue();
                for (String item : scenics) {
                    ScenicsDto scenicsDto = new ScenicsDto();
                    scenicsDto.setCity(cityMap.get(cityKey));
                    scenicsDto.setName(item);
                    scenicsDtoArrayList.add(scenicsDto);
                }
            }
        } else {
            // 指定信息, 单个城市
            List<String> scenics = scenicSpot.get(city);
            // 如果没找到, 就 new 一个空的页面
            if (scenics == null) {
                scenics = new ArrayList<>();
            }
            for (String item : scenics) {
                ScenicsDto scenicsDto = new ScenicsDto();
                scenicsDto.setCity(cityMap.get(city));
                scenicsDto.setName(item);
                scenicsDtoArrayList.add(scenicsDto);
            }
        }
        // 响应数据
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>景点</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table>\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <td>编号</td>\n" +
                "        <td>所在城市</td>\n" +
                "        <td>景点名称</td>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>");
        int id = 1;
        for (ScenicsDto dto : scenicsDtoArrayList) {
            writer.append("<tr>")
                    .append("<td>").append(String.valueOf(id)).append("</td>")
                    .append("<td>").append(dto.city).append("</td>")
                    .append("<td>").append(dto.name).append("</td>")
                    .append("</tr>");
            id++;
        }
        writer.append("    </tbody>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }

    public static class ScenicsDto {
        private String city;
        private String name;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
