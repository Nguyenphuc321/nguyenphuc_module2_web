package codegym2019.thiketthuc_model2_nguyenvanphuc.model;

import javax.persistence.*;

@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "makhachhang")
    private String makhachhang;

    @Column(name = "loaikhachhang")
    private String loaikhachhang;

    @Column(name = "hoten")
    private String hoten;

    @Column(name = "ngaysinh")
    private String ngaysinh;

    @Column(name = "gioitinh")
    private String gioitinh;

    @Column(name = "sodienthoai")
    private String sodienthoai;

    @Column(name = "sochungminhnhandan")
    private String sochungminhnhandan;

    @ManyToOne
    @JoinColumn(name = "id_nhanvien")
    private NhanVien nhanVien;

    public KhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getLoaikhachhang() {
        return loaikhachhang;
    }

    public void setLoaikhachhang(String loaikhachhang) {
        this.loaikhachhang = loaikhachhang;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getSochungminhnhandan() {
        return sochungminhnhandan;
    }

    public void setSochungminhnhandan(String sochungminhnhandan) {
        this.sochungminhnhandan = sochungminhnhandan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
