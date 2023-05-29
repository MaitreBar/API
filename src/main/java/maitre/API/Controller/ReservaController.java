package maitre.API.Controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import maitre.API.Domain.Entidades.Estabelecimento;
import maitre.API.Domain.Entidades.Reserva;
import maitre.API.Domain.Entidades.Usuario;
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
@CrossOrigin("http://localhost:3000/")
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

    @GetMapping("/busca-por-usuario/{idUsuario}")
    public ResponseEntity<List<Reserva>> buscarReservaPorUsuarioId(@PathVariable Integer idUsuario){
        List<Reserva> listReserva = reservaRepository.findReservaByUsuarioId(idUsuario);
        if(listReserva.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listReserva);
    }

    @GetMapping("/busca-por-estabelecimento/{idUsuario}")
    public ResponseEntity<List<Reserva>> buscarReservaPorEstabelecimentoId(@PathVariable Integer idEstabelecimento){
        List<Reserva> listReserva = reservaRepository.findReservaByEstabelecimentoId(idEstabelecimento);
        if(listReserva.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listReserva);
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReservar(@RequestBody Reserva r){
        Reserva reserva = reservaRepository.save(r);
        return ResponseEntity.status(201).body(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizaReserva(@PathVariable Integer id, @RequestBody @Valid Reserva r){
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if(reserva.isPresent()) {
            r.setId(id);
            r.setDtReserva(reserva.get().getDtReserva());
            r.setHoraReserva(reserva.get().getHoraReserva());
            r.setAssentos(reserva.get().getAssentos());
            Reserva reservaAtualizada = this.reservaRepository.save(r);
            return ResponseEntity.status(200).body(reservaAtualizada);
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{idEstabelecimento}/selecionarLugar/{idAssento}")
    public ResponseEntity<Void> selecionarLugares(@RequestBody Usuario u, @PathVariable Integer idAssento, @PathVariable Integer idEstabelecimento){
        Optional<Estabelecimento> optEstabelecimento = estabelecimentoRepository.findById(idEstabelecimento);
        Estabelecimento estabelecimento = new Estabelecimento();

        if (optEstabelecimento.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        estabelecimento = optEstabelecimento.get();

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
