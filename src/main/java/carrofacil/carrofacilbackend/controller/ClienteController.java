package carrofacil.carrofacilbackend.controller;


import carrofacil.carrofacilbackend.model.Cliente;
import carrofacil.carrofacilbackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping(path = "/api/clientes")
    public Iterable<Cliente> findAll(){
        return repository.findAll();
    }

    @GetMapping(path = "/api/cliente/{id}")
    public ResponseEntity consultar(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/cliente/salvar")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

}
