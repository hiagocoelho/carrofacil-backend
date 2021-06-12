package carrofacil.carrofacilbackend.repository;

import carrofacil.carrofacilbackend.model.ModeloModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModeloRepository extends CrudRepository<ModeloModel, Long> {

    List<ModeloModel> findByMarcaId(Long marca_id);

}
