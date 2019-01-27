package apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apirest.entity.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

}
