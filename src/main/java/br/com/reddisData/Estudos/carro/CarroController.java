package br.com.reddisData.Estudos.carro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
    private final CarroRepository repository;


    public CarroController(CarroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCarro(@RequestBody @Valid CarroRequest request) {
        Carro carro = request.paraCarro();
        repository.save(carro);
        return ResponseEntity.created(URI.create("http://localhost:8080/api/v1/carros/" + carro.getId())).build();
    }

    @GetMapping
    public ResponseEntity<?> listarCarros(@RequestParam(defaultValue = "") String id) {
        if (id.isEmpty()) {
            final List<Carro> all = (List<Carro>) repository.findAll();
            return ResponseEntity.ok(all.stream().map(CarroResponse::new).collect(Collectors.toList()));
        }
        final Optional<Carro> carro = repository.findById(id);
        return carro.map(c -> ResponseEntity.ok(new CarroResponse(c))).get();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalharCarro(@PathVariable String id) {
        final Optional<Carro> carro = repository.findById(id);
        if (!carro.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return carro.map(c -> ResponseEntity.ok(new CarroResponse(c))).get();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> RemoverCarro(@PathVariable String id) {
        final Optional<Carro> carro = repository.findById(id);
        if (!carro.isPresent()){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
