package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.services;


import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.entity.Flor;

public class FlorMapper {

    // Convert User JPA Entity into UserDto
    public static FlorDTO mapToFlorDTO(Flor flor){
        FlorDTO florDTO = new FlorDTO(
                flor.getPk_FlorID(),
                flor.getNomFlor(),
                flor.getPaisFlor()

        );
        return florDTO;
    }

    // Convert UserDto into User JPA Entity
    public static Flor mapToFlor(FlorDTO florDTO){
        Flor flor = new Flor(
                florDTO.getPk_FlorID(),
                florDTO.getNomFlor(),
                florDTO.getPaisFlor()
        );
        return flor;
    }
}
