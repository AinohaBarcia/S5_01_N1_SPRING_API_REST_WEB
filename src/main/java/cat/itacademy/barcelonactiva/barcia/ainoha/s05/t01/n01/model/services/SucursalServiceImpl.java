package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.SucursalException;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.repository.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements ISucursalService{

    @Autowired
    private ISucursalRepository iSucursalRepository;

    @Override
    public SucursalDTO createSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = UserMapper.mapToSucursal(sucursalDTO);

        Sucursal savedSucursal = iSucursalRepository.save(sucursal);
        SucursalDTO savedSucursalDTO = UserMapper.mapToSucursalDto(savedSucursal);

        return savedSucursalDTO;
    }

    @Override
    public SucursalDTO updateSucursal(Long pk_SucursalID, SucursalDTO sucursal) {
       /* try {
            sucursal.setPk_SucursalID(pk_SucursalID);
            SucursalDTO updatedSucursal = iSucursalService.updateSucursal(sucursal);
            return new ResponseEntity<>(updatedSucursal, HttpStatus.OK);
        } catch (SucursalException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        if(pk_SucursalID == null){
            throw new SucursalException("Sucursal ID can't be null");
        }
        Sucursal existSucursal = iSucursalRepository.findById(pk_SucursalID)
                .orElseThrow(() ->
                     new SucursalException("Sucursal with id " + pk_SucursalID + " not found"));

                existSucursal.setNameSucursal(sucursal.getNameSucursal());
                existSucursal.setCountryName(sucursal.getCountryName());

        return UserMapper.mapToSucursalDto(iSucursalRepository.save(existSucursal));
    }

    @Override
    public void deleteSucursalById(Long pk_SucursalID)  {
        iSucursalRepository.deleteById(pk_SucursalID);
        System.out.println("Sucursal with id: " + pk_SucursalID + " is deleted");
    }

    @Override
    public SucursalDTO getSucursalById(Long pk_SucursalID) {
       Optional<Sucursal> optionalSucursal = iSucursalRepository.findById(pk_SucursalID);
       Sucursal sucursal =optionalSucursal.get();
        return UserMapper.mapToSucursalDto(sucursal);
    }

    @Override
    public List<SucursalDTO> getAllSucurals() {
        List<Sucursal> sucursalList = iSucursalRepository.findAll();

        return sucursalList.stream().map(UserMapper::mapToSucursalDto).collect(Collectors.toList());
    }


}
