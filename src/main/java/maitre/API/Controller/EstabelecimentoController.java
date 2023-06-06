package maitre.API.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import jakarta.validation.Valid;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Tag(name = "Estabelecimento", description = "Endpoints Estabelecimento")

@RestController
@RequestMapping("/estabelecimentos")
@CrossOrigin("http://localhost:3000/")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @GetMapping
    @Operation(summary = "Lista todos os estabelecimentos disponíveis")
    public ResponseEntity<List<Estabelecimento>> listar(){
        List<Estabelecimento> lista = estabelecimentoService.listar();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<Estabelecimento> login(@PathVariable String email, @PathVariable String senha) {
        Estabelecimento estabelecimento = estabelecimentoService.login(email, senha);
        return ResponseEntity.ok(estabelecimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estabelecimento> atualizaUser(@PathVariable Integer id, @RequestBody @Valid Estabelecimento e){
        Estabelecimento estabelecimentoAtualizado = estabelecimentoService.atualizaUser(id, e);
        return ResponseEntity.ok(estabelecimentoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> buscarPorId(@PathVariable Integer id){
        Estabelecimento estabelecimento = estabelecimentoService.buscarPorId(id);
        return ResponseEntity.ok(estabelecimento);
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> cadastrar(@RequestBody Estabelecimento e){
        Estabelecimento estabelecimento = estabelecimentoService.cadastrar(e);
        return ResponseEntity.status(201).body(estabelecimento);
    }

    @PostMapping("/test")
    public ResponseEntity<Void> adiciona(@RequestBody Estabelecimento estabelecimento){
        return ResponseEntity.ok(estabelecimentoService.adiciona(estabelecimento));
    }

    @PutMapping("/{id}/reservas")
    public ResponseEntity<Void> atualizarListaReservas(@RequestBody Reserva r, @PathVariable Integer id){
        Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoService.atualizarListaReservas(r, id);
        return optionalEstabelecimento.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PatchMapping ("/{id}/checkIn/{idReserva}")
    public ResponseEntity<Void> checkIn(@PathVariable Integer id, @PathVariable Integer idReserva){
        return ResponseEntity.ok(estabelecimentoService.checkIn(id, idReserva));
    }

    @PatchMapping ("/{id}/checkOut/{idReserva}")
    public ResponseEntity<Void> checkOut(@PathVariable Integer id, @PathVariable Integer idReserva){
        return ResponseEntity.ok(estabelecimentoService.checkOut(id, idReserva));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        return ResponseEntity.ok(estabelecimentoService.deletar(id));
    }

}
