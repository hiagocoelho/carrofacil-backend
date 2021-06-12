package carrofacil.carrofacilbackend.controller;

import carrofacil.carrofacilbackend.model.MarcaModel;
import carrofacil.carrofacilbackend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcaController {

    @Autowired
    private MarcaRepository repository;

    // index
    @GetMapping(path = "/api/marcas")
    public Iterable<MarcaModel> findAll(){
        return repository.findAll();
    }

    // create
    @PostMapping(path = "/api/marcas/create")
    public MarcaModel create(@RequestBody MarcaModel marca) {
        return repository.save(marca);
    }

}
