package codeym2109.thimodel2.model;

import javax.persistence.*;

@Entity
@Table(name = "thanhpho")
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tenthanhpho")
    private String tenthanhpho;

    @Column(name = "quocgia")
    private String quocgia;

    @Column(name = "dientich")
    private double dientich;

    @Column(name = "danso")
    private int danso;


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
