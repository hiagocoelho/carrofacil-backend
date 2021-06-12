package carrofacil.carrofacilbackend.controller;

import carrofacil.carrofacilbackend.model.ModeloModel;
import carrofacil.carrofacilbackend.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModeloController {

    @Autowired
    public ModeloRepository repository;

    // index
    @GetMapping(path = "/api/modelos")
    public Iterable<ModeloModel> findAll(){
        return repository.findAll();
    }

    // findByMarca
    @GetMapping(path = "/api/modelos/por_marca/{marca_id}")
    public List<ModeloModel> filtrarPorMarca(@PathVariable("marca_id") long marca_id) {
        return repository.findByMarcaId(marca_id);
    }

    // create
    @PostMapping(path = "/api/modelos/create")
    public ModeloModel create(@RequestBody ModeloModel modelo) {
        return repository.save(modelo);
    }

}
