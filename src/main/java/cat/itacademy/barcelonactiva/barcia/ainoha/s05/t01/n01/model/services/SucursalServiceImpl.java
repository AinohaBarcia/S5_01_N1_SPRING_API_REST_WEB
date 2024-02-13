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
    public void  createSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = UserMapper.mapToSucursal(sucursalDTO);
        Sucursal savedSucursal = iSucursalRepository.save(sucursal);
    }

    @Override
    public SucursalDTO updateSucursal (SucursalDTO sucursalDTO){
        Sucursal existingSucursal = iSucursalRepository.findById(sucursalDTO.getPk_SucursalId()).get();
        existingSucursal.setName(sucursalDTO.getName());
        existingSucursal.setCountry(sucursalDTO.getCountry());
        Sucursal updateSucursal=iSucursalRepository.save(existingSucursal);
        return UserMapper.mapToSucursalDto(updateSucursal);
    }

    @Override
    public SucursalDTO deleteSucursalById(Long pk_SucursalID) throws SucursalException   {

            return iSucursalRepository.findById(pk_SucursalID)
                    .map(sucursal -> {
                        iSucursalRepository.deleteById(pk_SucursalID);
                        System.out.println("Sucursal with id: " + pk_SucursalID + " is deleted");
                        return UserMapper.mapToSucursalDto(sucursal);
                    })
                    .orElseThrow(() -> new SucursalException("Sucursal with id: " + pk_SucursalID + " not found"));
        }


    @Override
    public SucursalDTO getSucursalById(Long pk_SucursalID) {
       return  UserMapper.mapToSucursalDto(iSucursalRepository.findById(pk_SucursalID).
               orElseThrow(()->new SucursalException("Sucursal with id: " + pk_SucursalID + " not found")));

    }

    @Override
    public List<SucursalDTO> getAllSucurals() {
        List<Sucursal> sucursalList = iSucursalRepository.findAll();
        return sucursalList.stream().map(UserMapper::mapToSucursalDto).collect(Collectors.toList());
    }


}
