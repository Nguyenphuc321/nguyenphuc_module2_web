package codegym209.case_study_furama_2019.model;


import javax.persistence.*;

@Entity
@Table(name = "accomdation")
public class Accomdation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tendichvu")
    private String tendichvu;
    @Column(name = "dientich")
    private float dientich;
    @Column(name = "sotang")
    private int sotang;
    @Column(name = "songuoitoida")
    private int songuoitoida;
    @Column(name = "chiphithue")
    private int chiphithue;
    @Column(name = "trangthai")
    private String trangthai;
    @Column(name = "kieuthue")
    private String kieuthue;
    @ManyToOne
    @JoinColumn(name = "id_loaidichvu")
    private FuramaLoaiDichVu furamaLoaiDichVu;

    public Accomdation() {
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

    public float getDientich() {
        return dientich;
    }

    public void setDientich(float dientich) {
        this.dientich = dientich;
    }

    public int getSotang() {
        return sotang;
    }

    public void setSotang(int sotang) {
        this.sotang = sotang;
    }

    public int getSonguoitoida() {
        return songuoitoida;
    }

    public void setSonguoitoida(int songuoitoida) {
        this.songuoitoida = songuoitoida;
    }

    public int getChiphithue() {
        return chiphithue;
    }

    public void setChiphithue(int chiphithue) {
        this.chiphithue = chiphithue;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getKieuthue() {
        return kieuthue;
    }

    public void setKieuthue(String kieuthue) {
        this.kieuthue = kieuthue;
    }

    public FuramaLoaiDichVu getFuramaLoaiDichVu() {
        return furamaLoaiDichVu;
    }

    public void setFuramaLoaiDichVu(FuramaLoaiDichVu furamaLoaiDichVu) {
        this.furamaLoaiDichVu = furamaLoaiDichVu;
    }
}
