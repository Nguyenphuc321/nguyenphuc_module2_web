package codegym2019.casestudy_2019.controller;

import codegym2019.casestudy_2019.entity.FuramaDichVu;
import codegym2019.casestudy_2019.entity.FuramaHopDong;
import codegym2019.casestudy_2019.service.DichVuService;
import codegym2019.casestudy_2019.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
public class BookingController {
    @Autowired
    DichVuService dichVuService;
    @Autowired
    HopDongService hopDongService;
    @GetMapping("/bookings/{id}")
    public ModelAndView getBookingPage(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("booking");
        FuramaDichVu furamaDichVu = dichVuService.getDichvu(id);
        modelAndView.addObject("dichvu",furamaDichVu);
        return modelAndView;
    }
    @PostMapping("/booking")
    public ModelAndView saveBooking(@RequestParam(value = "id")Long id, @RequestParam(value = "ngaybatdau")Date ngaybatdau
            , @RequestParam(value = "ngayketthuc") Date ngayketthuc, HttpServletRequest request, HttpServletResponse response){

        FuramaHopDong furamaHopDong = new FuramaHopDong();
        furamaHopDong.setIddichvu(id);
        furamaHopDong.setNgaylamhopdong(ngaybatdau);
        furamaHopDong.setNgayketthuc(ngayketthuc);
        furamaHopDong.setIdkhachhang((long)1);
        furamaHopDong.setIdnhanvien((long)1);
        hopDongService.saveHopdong(furamaHopDong);
        Iterable<FuramaHopDong> listhopdong = hopDongService.findAllByIdKhachHang((long)1);
        for (FuramaHopDong hopDong:listhopdong){
            String cookiValue = hopDong.getId()+"_"+hopDong.getIddichvu()+"_"+hopDong.getNgaylamhopdong()+"_"
                    + hopDong.getNgayketthuc();
            Cookie cookie = new Cookie("hopdong"+hopDong.getId(),cookiValue);
            cookie.setMaxAge(60*60);
            cookie.setPath("/history");
            response.addCookie(cookie);
        }

        ModelAndView modelAndView = new ModelAndView("bookingSuccees");
        return modelAndView;
    }
}
