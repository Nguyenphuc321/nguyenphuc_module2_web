package codegym2019.casestudy_2019.controller;


import codegym2019.casestudy_2019.entity.FuramaHopDong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryBookingController {
    @GetMapping("/history")
    public ModelAndView getHistorypage(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("history");
        Cookie[] cookies = request.getCookies();
        List<FuramaHopDong>listhopdong = new ArrayList<>();
        for (int i = 0; i <cookies.length ; i++) {
            if (cookies[i].getName().contains("hopdong")){
                FuramaHopDong hopDong = new FuramaHopDong();
                String[] cookiaValue = cookies[i].getValue().split("\\_");
                hopDong.setId(Long.parseLong(cookiaValue[0]));
                hopDong.setIddichvu(Long.parseLong(cookiaValue[1]));
                hopDong.setNgaylamhopdong(Date.valueOf(cookiaValue[2]));
                hopDong.setNgayketthuc(Date.valueOf(cookiaValue[3]));
                listhopdong.add(hopDong);
            }
        }
        modelAndView.addObject("historyHopdong",listhopdong);
        return modelAndView;
    }
}
