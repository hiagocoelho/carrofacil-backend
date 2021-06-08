package carrofacil.carrofacilbackend.repository;

import carrofacil.carrofacilbackend.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
