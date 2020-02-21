package codegym2019.ungdungtutao.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "renter")
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_renter")
    private String namerenter;

    @Column(name = "id_card")
    private String idcard;

    @Column(name = "ngay_thue")
    private Date ngaythue;

    @Column(name = "ngay_ket_thuc")
    private Date ngayketthuc;
    @ManyToOne
    @JoinColumn(name = "id_khachsan")
    private Hotel hotel;
    @Column(name = "hotel")

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


    public Renter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamerenter() {
        return namerenter;
    }

    public void setNamerenter(String namerenter) {
        this.namerenter = namerenter;
    }

    public Date getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(Date ngaythue) {
        this.ngaythue = ngaythue;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
