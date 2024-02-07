package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.exceptions.FlorNotFoundException;

import java.util.List;

public interface FlorServices {

    void deleteFlorById(Long id) throws FlorNotFoundException;
    FlorDTO createFlor(FlorDTO florDTO);

    FlorDTO getFlorById(Long florId);

    List<FlorDTO> getAllFlowers();

    FlorDTO updateFlor(FlorDTO florDTO, Long id);

}



