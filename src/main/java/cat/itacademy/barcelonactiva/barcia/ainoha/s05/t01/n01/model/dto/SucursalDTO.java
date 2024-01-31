package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

    private Long pk_SucursalID;
    private String nameSucursal;
    private String countryName;
    private String typeSucursal;
    private final ArrayList<String> isEuropean;

    public SucursalDTO(Long pk_SucursalID, String nameSucursal, String countryName) {
        this.pk_SucursalID = pk_SucursalID;
        this.nameSucursal = nameSucursal;
        this.countryName = countryName;
        this.typeSucursal = isEuropean(countryName);
        this.isEuropean = (ArrayList<String>) Arrays.asList("Albania", "Alemania", "Andorra", "Armenia", "Austria", "Azerbaiyán", "Bélgica", "Bielorrusia", "Bosnia y Herzegovina", "Bulgaria", "Chipre", "Ciudad del Vaticano", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Georgia", "Grecia", "Hungría", "Irlanda", "Islandia", "Italia", "Kazajistán", "Kosovo", "Letonia", "Liechtenstein", "Lituania", "Luxemburgo", "Malta", "Moldavia", "Mónaco", "Montenegro", "Noruega", "Países Bajos (Holanda)", "Polonia", "Portugal", "Reino Unido (Inglaterra, Escocia, Gales e Irlanda del Norte)", "República Checa", "Rumania", "Rusia", "San Marino", "Serbia", "Suecia", "Suiza", "Turquía", "Ucrania"
        );
    }


    public Long getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Long pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
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

    public String getTypeSucursal() {
        return typeSucursal;
    }

    public void setTypeSucursal(String typeSucursal) {
        this.typeSucursal = typeSucursal;
    }

    public String isEuropean (String countryName){
        String typeSucursal="";
        if (countryName != null){
            if (isEuropean.contains(countryName)){
                typeSucursal = "European";
            }else{
                typeSucursal = "Not europan";
            }
        }else{
           // System.out.println("The country name isn't corrrect");
        }
        return typeSucursal;
    }

}
