package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.SucursalException;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.services.ISucursalService;
import ch.qos.logback.core.model.Model;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SucursalController {
    @Autowired
    private ISucursalService iSucursalService;


    @PostMapping("/createSucursal")
    public ResponseEntity<SucursalDTO> createSucursal(@RequestBody SucursalDTO sucursal) {
        SucursalDTO sucursalObj = iSucursalService.createSucursal(sucursal);
        return new ResponseEntity<>(sucursalObj, HttpStatus.CREATED);
    }

    @PutMapping("/updateSucursalById/{pk_SucursalID}")
    public ResponseEntity<SucursalDTO> updateSucursalById(@PathVariable(value = "id") Long pk_SucursalID, @RequestBody SucursalDTO sucursalDTO) {
        return ResponseEntity.ok().body(iSucursalService.updateSucursal(pk_SucursalID,sucursalDTO));
    }

    @DeleteMapping("/deleteSucursalById/{pk_SucursalID}")
    public ResponseEntity<HttpStatus> deleteSucursalById(@PathVariable Long pk_SucursalID) {
        iSucursalService.deleteSucursalById(pk_SucursalID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getSucursalById/{pk_SucursalID}")
    public ResponseEntity<SucursalDTO> getSucursalById(@PathVariable("pk_SucursalID") Long pk_SucursalID) {
        try {
            SucursalDTO sucursal = iSucursalService.getSucursalById(pk_SucursalID);
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } catch (SucursalException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllSucursals")
    public ResponseEntity<List<SucursalDTO>> getAllSucursals() {

       try {
            List<SucursalDTO> sucursalList = iSucursalService.getAllSucurals();
            if (sucursalList.isEmpty()) {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {

                return ResponseEntity.ok().body(iSucursalService.getAllSucurals());
            }
        }catch(Exception ex){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }





