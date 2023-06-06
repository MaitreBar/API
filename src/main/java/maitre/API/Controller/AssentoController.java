package maitre.API.Controller;

import maitre.API.Domain.Assento;
import maitre.API.Repository.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assentos")
@CrossOrigin("http://localhost:3000/")
public class AssentoController {

    @Autowired
    private AssentoRepository assentoRepository;

    @GetMapping
    public ResponseEntity<List<Assento>> listarAssentos(){
        List<Assento> lista = assentoRepository.findAll();
        if(lista.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assento> buscarAssentoPorId(@PathVariable Integer id){
        Optional<Assento> optAssento = assentoRepository.findById(id);
        if(optAssento.isPresent()){
            return ResponseEntity.status(200).body(optAssento.get());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/estabelecimento/{id}")
    public ResponseEntity<List<Assento>> buscarAssentoPorIdDoEstabelecimento(@PathVariable Integer id){
        List<Assento> optAssento = assentoRepository.findAssentoByEstabelecimentoId(id);
        if(optAssento.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(optAssento);
    }

    @PostMapping
    public ResponseEntity<Assento> criarAssento(@RequestBody Assento a){
        Assento assento = assentoRepository.save(a);
        return ResponseEntity.status(201).body(assento);
    }

    @PutMapping
    public ResponseEntity<Assento> atualizarAssento(@RequestBody Assento a){
        Assento assento = assentoRepository.save(a);
        return ResponseEntity.status(200).body(assento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssento(@PathVariable Integer id){
        Optional<Assento> optionalAssento = assentoRepository.findById(id);
        if (optionalAssento.isPresent()) {
            assentoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
