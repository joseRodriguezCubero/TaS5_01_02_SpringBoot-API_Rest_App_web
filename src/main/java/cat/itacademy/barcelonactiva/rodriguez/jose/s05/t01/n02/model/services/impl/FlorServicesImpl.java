package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.impl;


import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions.SucursalAlreadyExistException;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.SucursalServices;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.SucursalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


    @Service
    @AllArgsConstructor
    public class SucursalServicesImpl implements SucursalServices {

        private SucursalRepository sucursalRepository;

        @Override
        public SucursalDto createSucursal(SucursalDto sucursalDto) {
            // Convert UserDto into User JPA Entity
            Sucursal sucursal = SucursalMapper.mapToSucursal(sucursalDto);
            Sucursal savedSucursal = sucursalRepository.save(sucursal);
            // Convert User JPA entity to UserDto
            SucursalDto savedSucursalDto = SucursalMapper.mapToSucursalDto(savedSucursal);
            return savedSucursalDto;
        }

        @Override
        public SucursalDto getSucursalById(Long sucursalId) {
            Optional<Sucursal> optionalSucursal = sucursalRepository.findById(sucursalId);
            Sucursal sucursal = optionalSucursal.get();
            return SucursalMapper.mapToSucursalDto(sucursal);
        }

        @Override
        public List<SucursalDto> getAllSucursals() {
            List<Sucursal> users = sucursalRepository.findAll();
            return users.stream().map(SucursalMapper::mapToSucursalDto)
                    .collect(Collectors.toList());
        }

        @Override
        public SucursalDto updateSucursal(SucursalDto sucursal) {
            Sucursal existingUser = sucursalRepository.findById(sucursal.getPk_SucursalID()).get();
            existingUser.setNomSucursal(sucursal.getNomSucursal());
            existingUser.setCountry(sucursal.getCountry());
            Sucursal updatedSucursal = sucursalRepository.save(existingUser);
            return SucursalMapper.mapToSucursalDto(updatedSucursal);
        }


        @Override
        public void deleteSucursalById(Long id) {
            Sucursal existingSucursal = sucursalRepository.findById(id)
                    .orElseThrow(() -> new SucursalNotFoundException("Fruit Not Found with ID: " + id));
            sucursalRepository.deleteById(existingSucursal.getPk_SucursalID());
        }
    }



    /*@Service
    @AllArgsConstructor
    public class UserServiceImpl implements UserService {

        private UserRepository userRepository;



        @Override
        public UserDto getUserById(Long userId) {
            Optional<User> optionalUser = userRepository.findById(userId);
            User user = optionalUser.get();
            return UserMapper.mapToUserDto(user);
        }

        @Override
        public List<UserDto> getAllUsers() {
            List<User> users = userRepository.findAll();
            return users.stream().map(UserMapper::mapToUserDto)
                    .collect(Collectors.toList());
        }

        @Override
        public UserDto updateUser(UserDto user) {
            User existingUser = userRepository.findById(user.getId()).get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            User updatedUser = userRepository.save(existingUser);
            return UserMapper.mapToUserDto(updatedUser);
        }

        @Override
        public void deleteUser(Long userId) {
            userRepository.deleteById(userId);
        }
    }*/

