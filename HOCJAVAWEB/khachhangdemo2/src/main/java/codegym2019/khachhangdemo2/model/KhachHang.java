package codegym2019.khachhangdemo2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "makhachhang")
    @NotNull(message = "khong dc trong")
    private String makhachhang;

    @Column(name = "loaikhachhang")
    @NotNull(message = "khong dc trong")
    private String loaikhachhang;

    @Column(name = "hoten")
    @NotNull(message = "khong dc trong")
    private String hoten;

    @Column(name = "ngaysinh")
    private Date ngaysinh;

    @Column(name = "gioitinh")
    @NotBlank(message = "Please Choose Your Sez")
    private String gioitinh;

    @Column(name = "sodienthoai")
    @NotNull(message = "khong dc de trong")
    private String sodienthoai;

    @Column(name = "sochungminhnhandan")
    @NotNull(message = "khong dc de trong")
    private String sochungminhnhandan;

    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9]{1,}[@][A-Za-z0-9]{3,}[.][A-Za-z0-9]{2,}$")
    private String email;

    @Column(name = "diachi")
    @NotNull(message = "khong dc trong")
    private String diachi;


    public KhachHang() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
}
