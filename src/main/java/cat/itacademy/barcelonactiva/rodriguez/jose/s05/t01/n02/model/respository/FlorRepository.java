package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.respository;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.entity.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlorRepository extends JpaRepository<Flor, Long> {
    Optional<Flor> findByNomFlorIgnoreCase (String name);
}