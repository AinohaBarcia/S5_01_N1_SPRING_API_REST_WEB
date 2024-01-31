package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {

    SucursalDTO createSucursal(SucursalDTO sucursal);

    SucursalDTO updateSucursal (Long pk_SucursalID, SucursalDTO sucursal);


    void deleteSucursalById(Long pk_SucursalID)throws SecurityException;

    SucursalDTO getSucursalById (Long pk_SucursalID);

    List<SucursalDTO> getAllSucurals();


}

