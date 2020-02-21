package codegym2019.nguyenphuc_thiketthucmodel2.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "thanhpho")
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "ban khong duoc de trong")
    @Column(name = "tenthanhpho")
    private String tenthanhpho;

    @NotNull(message = "khong dc de trong")
    @Column(name = "quocgia")
    private String quocgia;

    @NotNull(message = "khong dc de trong")
    @Column(name = "dientich")
    private double dientich;

    @NotNull(message = "khong dc de trong")
    @Column(name = "danso")
    private int danso;


    @NotNull(message = "khong dc trong")
    @Column(name = "gdp")
    private int GDP;
    @Column(name = "mota")
    private String mota;

    public ThanhPho() {
    }

    public String getTenthanhpho() {
        return tenthanhpho;
    }

    public void setTenthanhpho(String tenthanhpho) {
        this.tenthanhpho = tenthanhpho;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public double getDientich() {
        return dientich;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    public int getDanso() {
        return danso;
    }

    public void setDanso(int danso) {
        this.danso = danso;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
