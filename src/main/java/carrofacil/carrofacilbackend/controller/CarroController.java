package carrofacil.carrofacilbackend.controller;

import carrofacil.carrofacilbackend.model.CarroModel;
import carrofacil.carrofacilbackend.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarroController {

    private final CarroRepository repository;

    CarroController(CarroRepository repository) {
        this.repository = repository;
    }

    // index
    @GetMapping(path = "/api/carros")
    public Iterable<CarroModel> findAll() {
        return repository.findAll();
    }

    // findById
    @GetMapping(path = "/api/carros/{id}")
    public ResponseEntity findById(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // update
    @PutMapping(path = "/api/carros/{id}")
    public CarroModel update(@RequestBody CarroModel newCarro, @PathVariable("id") long id) {
        return repository.findById(id)
                .map(carro -> {
                    carro.setAno(newCarro.getAno());
                    carro.setDescricao(newCarro.getDescricao());
                    carro.setPreco(newCarro.getPreco());
                    carro.setModelo(newCarro.getModelo());
                    return repository.save(carro);
                })
                .orElseGet(() -> {
                    newCarro.setId(id);
                    return repository.save(newCarro);
                });
    }

    // create
    @PostMapping(path = "/api/carros/create")
    public CarroModel create(@RequestBody CarroModel carro) {
        return repository.save(carro);
    }

    // delete
    @DeleteMapping(path = "/api/carros/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

}
