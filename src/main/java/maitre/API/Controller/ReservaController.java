package maitre.API.Controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.Domain.Usuario;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;
import maitre.API.Service.ReservaService.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Reserva", description = "Endpoints reserva")

@RestController
@RequestMapping("/reservas")
@CrossOrigin("http://localhost:3000")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas(){
        List<Reserva> lista = reservaService.listarReservas();
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Integer id){
        Reserva optReserva = reservaService.buscarReservaPorId(id);
            return ResponseEntity.status(200).body(optReserva);
    }

    @GetMapping("/busca-por-usuario/{idUsuario}")
    public ResponseEntity<List<Estabelecimento>> buscarReservaPorUsuarioId(@PathVariable Integer idUsuario){
        List<Estabelecimento> listReserva = reservaService.buscarReservaPorUsuarioId(idUsuario);
        return ResponseEntity.status(200).body(listReserva);
    }

    @GetMapping("/busca-por-estabelecimento/{idEstabelecimento}")
    public ResponseEntity<List<Usuario>> buscarReservaPorEstabelecimentoId(@PathVariable Integer idEstabelecimento){
        List<Usuario> listReserva = reservaService.buscarReservaPorEstabelecimentoId(idEstabelecimento);
        return ResponseEntity.status(200).body(listReserva);
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReservar(@RequestBody Reserva r){
        Reserva reserva = reservaService.criarReservar(r);
        return ResponseEntity.status(201).body(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizaReserva(@PathVariable Integer id, @RequestBody @Valid Reserva r){
        Reserva reserva = reservaService.atualizaReserva(id, r);
            return ResponseEntity.status(200).body(reserva);
    }

    @PostMapping("/{idEstabelecimento}/selecionarLugar/{idAssento}")
    public ResponseEntity<Void> selecionarLugares(@RequestBody Usuario u, @PathVariable Integer idAssento, @PathVariable Integer idEstabelecimento){
        reservaService.selecionarLugares(u, idAssento, idEstabelecimento);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Integer id){
        reservaService.deletarReserva(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/posicaoReserva/{idUsuario}")
    public ResponseEntity<Integer> buscarPosicaoUsuarioFilaPorId(@PathVariable Integer idUsuario){

//        return ResponseEntity.ok(buscarPosicaoUsuarioFilaPorId(idUsuario).getBody());

        List<Reserva> listReserva = reservaService.buscarReservaPorUsuarioIdLista(idUsuario);
        if (listReserva.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Reserva reserva = listReserva.get(0);
        Usuario usuario = reserva.getUsuario();

        return ResponseEntity.ok(idUsuario);

    }

}
