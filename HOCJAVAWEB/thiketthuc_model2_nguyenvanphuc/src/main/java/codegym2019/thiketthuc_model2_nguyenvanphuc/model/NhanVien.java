package codegym2019.thiketthuc_model2_nguyenvanphuc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tennhanvien")
    private String tennhanvien;

    @OneToMany(targetEntity = KhachHang.class)
    private List<KhachHang> khachHangs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public List<KhachHang> getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(List<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }
}
