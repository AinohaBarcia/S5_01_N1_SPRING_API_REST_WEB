package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class SucursalDTO {

    private Long pk_SucursalId;
    private String name;
    private String country;
    private String type;
    private final ArrayList<String> isEuropean=new ArrayList<>(Arrays.asList("Albania", "Andorra", "Armenia", "Austria", "Azerbaijan", "Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Georgia", "Germany", "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Kosovo", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United Kingdom", "Vatican City"));

    public SucursalDTO(){

    }
    public SucursalDTO(Long pk_SucursalId, String name, String country) {
        this.pk_SucursalId = pk_SucursalId;
        this.name = name;
        this.country = country;
        this.type = isEuropean(country);

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String isEuropean (String country){

        if (country != null){
            if (isEuropean.contains(country)){
                type = "European";
            }else{
                type = "Not european";
            }
        }else{
           System.out.println("You don't type a country");
        }
        return type;
    }

}
