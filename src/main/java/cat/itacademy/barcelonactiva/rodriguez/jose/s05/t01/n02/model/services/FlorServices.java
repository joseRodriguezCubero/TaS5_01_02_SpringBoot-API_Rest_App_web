package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions.SucursalNotFoundException;

import java.util.List;

public interface SucursalServices {

    void deleteSucursalById(Long id) throws SucursalNotFoundException;
    SucursalDto createSucursal(SucursalDto sucursal);

    SucursalDto getSucursalById(Long sucursalId);

    List<SucursalDto> getAllSucursals();

    SucursalDto updateSucursal(SucursalDto sucursal);


}




/*UserDto createSucursal(UserDto user);

    SucursalDto getSucursalById(Long sucursalId);

    List<SucursalDto> getAllSucursals();

    SucursalDto updateSucursal(SucursalDto sucursal);

    void deleteSucursal(Long sucursalId);*/

