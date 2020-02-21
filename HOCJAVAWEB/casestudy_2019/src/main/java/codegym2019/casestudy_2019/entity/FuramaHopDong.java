package codegym2019.casestudy_2019.entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "hopdong")
public class FuramaHopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ngaylamhopdong")
    private Date ngaylamhopdong;

    @Column(name = "ngayketthuc")
    private Date ngayketthuc;

    @Column(name = "tiendatcoc")
    private int tiendatcoc;

    @Column(name = "tongtien")
    private int tongtien;

    @Column(name = "id_nhanvien")
    private Long idnhanvien;

    @Column(name = "id_khachhang")
    private Long idkhachhang;

    @Column(name = "id_dichvu")
    private Long iddichvu;

    public FuramaHopDong() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgaylamhopdong() {
        return ngaylamhopdong;
    }

    public void setNgaylamhopdong(Date ngaylamhopdong) {
        this.ngaylamhopdong = ngaylamhopdong;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public int getTiendatcoc() {
        return tiendatcoc;
    }

    public void setTiendatcoc(int tiendatcoc) {
        this.tiendatcoc = tiendatcoc;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public Long getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(Long idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public Long getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(Long idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public Long getIddichvu() {
        return iddichvu;
    }

    public void setIddichvu(Long iddichvu) {
        this.iddichvu = iddichvu;
    }
}
