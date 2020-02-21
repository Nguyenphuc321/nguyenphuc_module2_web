package codegym209.case_study_furama_2019.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loaidichvu")
public class FuramaLoaiDichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tenloaidichvu")
    private String tenloaidichvu;
    @OneToMany(targetEntity = Accomdation.class)
    private List<Accomdation> furamaDichVus;

    public FuramaLoaiDichVu() {
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

    public List<Accomdation> getFuramaDichVus() {
        return furamaDichVus;
    }

    public void setFuramaDichVus(List<Accomdation> furamaDichVus) {
        this.furamaDichVus = furamaDichVus;
    }
}
