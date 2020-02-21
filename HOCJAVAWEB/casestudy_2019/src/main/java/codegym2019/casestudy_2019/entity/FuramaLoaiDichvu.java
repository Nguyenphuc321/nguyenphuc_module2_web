package codegym2019.casestudy_2019.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaidichvu")
public class FuramaLoaiDichvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenloaidichvu")
    private String tenloaidichvu;

    @OneToMany(targetEntity = FuramaDichVu.class)
    private List<FuramaDichVu> furamaDichVus;

    public FuramaLoaiDichvu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenloaidichvu() {
        return tenloaidichvu;
    }

    public void setTenloaidichvu(String tenloaidichvu) {
        this.tenloaidichvu = tenloaidichvu;
    }

    public List<FuramaDichVu> getFuramaDichVus() {
        return furamaDichVus;
    }

    public void setFuramaDichVus(List<FuramaDichVu> furamaDichVus) {
        this.furamaDichVus = furamaDichVus;
    }
}
