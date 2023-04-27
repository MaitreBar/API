package maitre.API.Controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import maitre.API.Entidades.Estabelecimento;
import maitre.API.Entidades.Reserva;
import maitre.API.Entidades.Usuario;
import maitre.API.Repository.AssentoRepository;
import maitre.API.Repository.EstabelecimentoRepository;
import maitre.API.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Reserva", description = "Endpoints reserva")

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AssentoRepository assentoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas(){
        List<Reserva> lista = reservaRepository.findAll();

        if(lista.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Integer id){
        Optional<Reserva> optReserva = reservaRepository.findById(id);
        if(optReserva.isPresent()){
            return ResponseEntity.status(200).body(optReserva.get());
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReservar(@RequestBody Reserva r){
        Reserva reserva = reservaRepository.save(r);
        return ResponseEntity.status(201).body(reserva);
    }

    @PutMapping
    public ResponseEntity<Reserva> atualizarReserva(@RequestBody Reserva r){
        Reserva reserva = reservaRepository.save(r);
        return ResponseEntity.status(200).body(reserva);
    }

    @PostMapping("/{idEstabelecimento}/selecionarLugar/{idAssento}")
    public ResponseEntity<Void> selecionarLugares(@RequestBody Usuario u, @PathVariable Integer idAssento, @PathVariable Integer idEstabelecimento){
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoById(idEstabelecimento);
        if(estabelecimento.getAssentos().isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            if (estabelecimento.getAssentos().get(idAssento).getDisponivel()){
                estabelecimento.getAssentos().get(idAssento).setDisponivel(false);
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.status(403).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Integer id){
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            reservaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
