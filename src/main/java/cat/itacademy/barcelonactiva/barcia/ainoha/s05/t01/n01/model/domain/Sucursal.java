package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table (name="sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_SucursalId;

    @Column (name = "Name",nullable = false,length = 50)
    private String name;

    @Column(name = "Country",nullable = false, length = 50)
    private String country;



    public Sucursal(){
    }

    public Sucursal(Long pk_SucursalId, String name, String country) {
        this.pk_SucursalId = pk_SucursalId;
        this.name = name;
        this.country = country;
    }

    public Sucursal(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Long getPk_SucursalId() {
        return pk_SucursalId;
    }

    public void setPk_SucursalId(Long pk_SucursalId) {
        this.pk_SucursalId = pk_SucursalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
