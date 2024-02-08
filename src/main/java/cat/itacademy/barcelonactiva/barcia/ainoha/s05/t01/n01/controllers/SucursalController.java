package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.controllers;


import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.SucursalException;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.services.ISucursalService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class SucursalController {
    @Autowired
    private ISucursalService iSucursalService;


    @GetMapping("/createSucursal")
    public String createSucursalForm(Model model) {
        SucursalDTO sucursalObj = new SucursalDTO();
        model.addAttribute("sucursalDto",sucursalObj);
        return "createSucursal";
    }
    @PostMapping("/add")
    public String saveSucursal (@ModelAttribute("sucursalDto")SucursalDTO sucursalDto){
        iSucursalService.createSucursal(sucursalDto);
        return "redirect:/api/v1/";
    }

    @GetMapping("/updateForm/{pk_SucursalId}")
    public String updateForm(@PathVariable (value = "pk_SucursalId") Long pk_SucursalId, Model model){
        model.addAttribute("sucursalDTO", iSucursalService.getSucursalById(pk_SucursalId));
        return "updateSucursal";
    }
    @PostMapping("/updateSucursalById/{pk_SucursalId}")
    public String updateSucursalById(@PathVariable(value = "pk_SucursalId") Long pk_SucursalId,
                                     @ModelAttribute("sucursalDTO") SucursalDTO sucursalDTO, Model model) {
        iSucursalService.updateSucursal(sucursalDTO);
        return "/updateSucursal";
    }
    @GetMapping("/deleteSucursalById/{pk_SucursalId}")
    public String deleteSucursalById(@PathVariable Long pk_SucursalId) {
        iSucursalService.deleteSucursalById(pk_SucursalId);
        return  "redirect:/api/v1/";
    }
    @GetMapping("/getOne/{pk_SucursalId}")
    public String getOne(@PathVariable (value = "pk_SucursalId") Long pk_SucursalId, Model model){
        SucursalDTO sucursalDTO=iSucursalService.getSucursalById(pk_SucursalId);
        List<SucursalDTO>sucursalsDTO = new ArrayList<>();
        sucursalsDTO.add(sucursalDTO);
        model.addAttribute("sucursalsDto", sucursalsDTO);
        return "sucursals";

    }

    @GetMapping("/")
    public String getAllSucursals(Model model) {
       List<SucursalDTO>sucursalsDto = iSucursalService.getAllSucurals();
        model.addAttribute("sucursalsDto",sucursalsDto);
        return "sucursals";
        }


    }





