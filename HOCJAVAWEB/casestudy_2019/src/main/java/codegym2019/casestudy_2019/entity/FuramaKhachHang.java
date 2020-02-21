package codegym2019.casestudy_2019.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Entity
@Table(name = "khachhang")
public class FuramaKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_loaikhach")
    private Long id_loaikhach;


    @NotEmpty(message = "khong duoc de trong")
    @Column(name = "hoten")
    private String hoten;

    @NotNull(message = "vui long chon ngay sinh")
    @Column(name = "ngaysinh")
    private Date ngaysinh;

    @NotEmpty(message = "vui long dien thong tin")
    @Column(name = "soCMNN")
    private String soCMND;

    @NotEmpty(message = "vui long nhap sdt")
    @Column(name = "sdt")
    private String sdt;

    @NotEmpty(message = "khong duoc de trong")
    @Pattern(regexp = "^[A-Za-z0-9]{1,}[@][A-Za-z0-9]{3,}[.][A-Za-z0-9]{2,}$",message = "emai ban nhap chua dung dinh dang")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "khong duoc de trong")
    @Column(name = "diachi")
    private String diachi;

    public FuramaKhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_loaikhach() {
        return id_loaikhach;
    }

    public void setId_loaikhach(Long id_loaikhach) {
        this.id_loaikhach = id_loaikhach;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
}
