package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table (name="sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_SucursalId;

    @Column (name = "Sucursal_name",nullable = false,length = 50)
    private String nameSucursal;

    @Column(name = "Country name",nullable = false, length = 50)
    private String countryName;



    public Sucursal(){
    }

    public Sucursal(Long pk_SucursalId, String nameSucursal, String countryName) {
        this.pk_SucursalId = pk_SucursalId;
        this.nameSucursal = nameSucursal;
        this.countryName = countryName;
    }

    public Sucursal(String nameSucursal, String countryName) {
        this.nameSucursal = nameSucursal;
        this.countryName = countryName;
    }

    public Long getPk_SucursalId() {
        return pk_SucursalId;
    }

    public void setPk_SucursalId(Long pk_SucursalId) {
        this.pk_SucursalId = pk_SucursalId;
    }

    public String getNameSucursal() {
        return nameSucursal;
    }

    public void setNameSucursal(String nameSucursal) {
        this.nameSucursal = nameSucursal;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
