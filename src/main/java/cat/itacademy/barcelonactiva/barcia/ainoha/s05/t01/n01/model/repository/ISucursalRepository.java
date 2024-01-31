package cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.barcia.ainoha.s05.t01.n01.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal,Long> {

//    List<Sucursal> findAllById();
}
