package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {

    void createSucursal(SucursalDTO sucursal);

    SucursalDTO updateSucursal (SucursalDTO sucursalDTO);

    void deleteSucursalById(Long pk_SucursalID)throws SecurityException;

    SucursalDTO getSucursalById (Long pk_SucursalID);

    List<SucursalDTO> getAllSucurals();



}

