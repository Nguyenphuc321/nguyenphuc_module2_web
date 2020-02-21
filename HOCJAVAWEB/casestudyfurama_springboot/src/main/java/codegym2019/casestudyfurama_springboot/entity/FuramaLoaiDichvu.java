package codegym2019.casestudyfurama_springboot.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaidichvu")
public class FuramaLoaiDichvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tendichvu")
    private String tendichvu;
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

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public List<FuramaDichVu> getFuramaDichVus() {
        return furamaDichVus;
    }

    public void setFuramaDichVus(List<FuramaDichVu> furamaDichVus) {
        this.furamaDichVus = furamaDichVus;
    }
}
