package codegym2019.ungdungtutao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tenkhachsan")
    private String tenkhachsan;

    @Column(name = "diachi")
    private String diachi;

    @OneToMany(targetEntity = Renter.class)
    private List<Renter> renters;


    public Hotel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Renter> getRenters() {
        return renters;
    }

    public void setRenters(List<Renter> renters) {
        this.renters = renters;
    }

    public String getTenkhachsan() {
        return tenkhachsan;
    }

    public void setTenkhachsan(String tenkhachsan) {
        this.tenkhachsan = tenkhachsan;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
