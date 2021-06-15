package carrofacil.carrofacilbackend.controller;

import carrofacil.carrofacilbackend.model.CarroModel;
import carrofacil.carrofacilbackend.model.VisitaModel;
import carrofacil.carrofacilbackend.repository.VisitaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisitaController {

    private final VisitaRepository repository;

    VisitaController(VisitaRepository repository) {
        this.repository = repository;
    }

    // index
    @GetMapping(path = "/api/visitas")
    public Iterable<VisitaModel> findAll() {
        return repository.findAll();
    }

    // findById
    @GetMapping(path = "/api/visitas/{id}")
    public ResponseEntity findById(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // update
    @PutMapping(path = "/api/visitas/{id}")
    public VisitaModel update(@RequestBody VisitaModel newVisita, @PathVariable("id") long id) {
        return repository.findById(id)
                .map(visita -> {
                    visita.setNome(newVisita.getNome());
                    visita.setCpf(newVisita.getCpf());
                    visita.setEmail(newVisita.getEmail());
                    visita.setData(newVisita.getData());
                    visita.setCarro(newVisita.getCarro());
                    return repository.save(visita);
                })
                .orElseGet(() -> {
                    newVisita.setId(id);
                    return repository.save(newVisita);
                });
    }

    // create
    @PostMapping(path = "/api/visitas/create")
    public VisitaModel create(@RequestBody VisitaModel visita) {
        return repository.save(visita);
    }

    // delete
    @DeleteMapping(path = "/api/visitas/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        repository.deleteById(id);
    }

}
