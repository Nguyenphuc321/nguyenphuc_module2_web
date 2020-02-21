package codegym2019.thiketthuc_model2_nguyenvanphuc.formatter;

import codegym2019.thiketthuc_model2_nguyenvanphuc.model.NhanVien;
import codegym2019.thiketthuc_model2_nguyenvanphuc.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class NhanVienFormatter implements Formatter<NhanVien> {

    private NhanVienService nhanVienService;

    @Autowired
    public NhanVienFormatter(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @Override
    public NhanVien parse(String text, Locale locale) throws ParseException {
        return nhanVienService.findById(Long.parseLong(text));
    }

    @Override
    public String print(NhanVien object, Locale locale) {

        return "[" + object.getId() + ", " + object.getTennhanvien() + "]";

    }
}
