package maitre.API.Controller;

import maitre.API.Entidades.Estabelecimento;
import maitre.API.Entidades.Reserva;
import maitre.API.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

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

    @PostMapping
    public ResponseEntity<Estabelecimento> cadastrar(@RequestBody Estabelecimento e){
        Estabelecimento estabelecimento = estabelecimentoRepository.save(e);
        return ResponseEntity.status(201).body(estabelecimento);
    }

    @PutMapping("/{id}/reservas")
    public ResponseEntity<Void> atualizarListaReservas(@RequestBody Reserva r, @PathVariable Integer id){
        estabelecimentoRepository.findEstabelecimentoById(id).addReserva(r);
        return ResponseEntity.status(200).build();
    }

    @PatchMapping ("/{id}/checkIn/{idReserva}")
    public ResponseEntity<Void> checkIn(@PathVariable Integer id, @PathVariable Integer idReserva){
        Estabelecimento e = estabelecimentoRepository.findEstabelecimentoById(id);
        if(!e.getReservas().get(idReserva).getCheckIn()){
            e.getReservas().get(idReserva).setCheckIn(true);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }

    @PatchMapping ("/{id}/checkOut/{idReserva}")
    public ResponseEntity<Void> checkOut(@PathVariable Integer id, @PathVariable Integer idReserva){
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoById(id);
        if(estabelecimento.getReservas().get(idReserva).getCheckIn()){
            estabelecimento.getReservas().get(idReserva).setCheckOut(true);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }

}
