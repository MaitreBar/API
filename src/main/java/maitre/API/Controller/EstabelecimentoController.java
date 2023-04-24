package maitre.API.Controller;

import maitre.API.Entidades.Assento;
import maitre.API.Entidades.Estabelecimento;
import maitre.API.Entidades.Reserva;
import maitre.API.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> listar(){
        List<Estabelecimento> lista = estabelecimentoRepository.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> buscarPorId(@PathVariable Integer id){
        Optional<Estabelecimento> optEstabelecimento = estabelecimentoRepository.findById(id);
        if (optEstabelecimento.isPresent()){
            return ResponseEntity.status(200).body(optEstabelecimento.get());
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Estabelecimento> cadastrar(@RequestBody Estabelecimento e){
        Estabelecimento estabelecimento = estabelecimentoRepository.save(e);
        return ResponseEntity.status(201).body(estabelecimento);
    }

    @PutMapping("/{id}/reservas")
    public ResponseEntity<Void> atualizarListaReservas(@RequestBody Reserva r, @PathVariable Integer id){
        Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository.findById(id);
        if(optionalEstabelecimento.isPresent()) {
            optionalEstabelecimento.get().addReserva(r);
            estabelecimentoRepository.save(optionalEstabelecimento.get());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping ("/{id}/checkIn/{idReserva}")
    public ResponseEntity<Void> checkIn(@PathVariable Integer id, @PathVariable Integer idReserva){
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoById(id);
        if(!estabelecimento.getReservas().get(idReserva).getCheckIn()){
            estabelecimento.getReservas().get(idReserva).setDtHoraCheckOut(LocalDateTime.now());
            estabelecimento.getReservas().get(idReserva).setCheckIn(true);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }

    @PatchMapping ("/{id}/checkOut/{idReserva}")
    public ResponseEntity<Void> checkOut(@PathVariable Integer id, @PathVariable Integer idReserva){
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoById(id);
        if(estabelecimento.getReservas().get(idReserva).getCheckIn()){
            estabelecimento.getReservas().get(idReserva).setDtHoraCheckOut(LocalDateTime.now());
            estabelecimento.getReservas().get(idReserva).setCheckOut(true);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository.findById(id);
        if (optionalEstabelecimento.isPresent()) {
            estabelecimentoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
