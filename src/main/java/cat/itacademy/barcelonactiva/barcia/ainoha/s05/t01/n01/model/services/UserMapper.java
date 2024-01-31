package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto.SucursalDTO;

public class UserMapper {

    public static SucursalDTO mapToSucursalDto (Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO(
                sucursal.getPk_SucursalId(),
                sucursal.getNameSucursal(),
                sucursal.getCountryName()
        );
        return sucursalDTO;
    }

    public static Sucursal mapToSucursal (SucursalDTO sucursalDTO){
        Sucursal sucursal = new Sucursal(
                sucursalDTO.getPk_SucursalID(),
                sucursalDTO.getNameSucursal(),
                sucursalDTO.getCountryName()

        );
        return sucursal;
    }
}
