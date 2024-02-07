package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.services.impl;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.entity.Flor;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.exceptions.FlorAlreadyExistException;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.respository.FlorRepository;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.services.FlorMapper;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.services.FlorServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FlorServicesImpl implements FlorServices {

    private final FlorRepository florRepository;

    @Override
    public FlorDTO createFlor(FlorDTO florDTO) {
        // Convert UserDto into User JPA Entity
        Flor flor = FlorMapper.mapToFlor(florDTO);
        florRepository.findByNomFlorIgnoreCase(flor.getNomFlor())
                .ifPresent(flower -> {
                    throw new FlorAlreadyExistException("Already exist flower with given name:" + flor.getNomFlor());
                });
        Flor savedFlor = florRepository.save(flor);
        // Convert User JPA entity to UserDto
        return FlorMapper.mapToFlorDTO(savedFlor);
    }


    @Override
    public FlorDTO getFlorById(Long florId) {
        Flor flor = florRepository.findById(florId).orElseThrow(() -> new FlorNotFoundException("Flor Not Found with ID: " + florId));
        return FlorMapper.mapToFlorDTO(flor);
    }

    @Override
    public List<FlorDTO> getAllFlowers() {
        List<Flor> flowers = florRepository.findAll();
        return flowers.stream().map(FlorMapper::mapToFlorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlorDTO updateFlor(FlorDTO florDTO, Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Flor ID cannot be null");
        }
        Flor existingFlor = florRepository.findById(id)
                .orElseThrow(() -> new FlorNotFoundException("Flower Not Found with ID: " + id));
        existingFlor.setNomFlor(florDTO.getNomFlor());
        existingFlor.setPaisFlor(florDTO.getPaisFlor());
        Flor updatedFlor = florRepository.save(existingFlor);
        return FlorMapper.mapToFlorDTO(updatedFlor);
    }


    @Override
    public void deleteFlorById(Long id) {
        Flor existingFlor = florRepository.findById(id)
                .orElseThrow(() -> new FlorNotFoundException("Flower Not Found with ID: " + id));
        florRepository.deleteById(existingFlor.getPk_FlorID());
    }
}