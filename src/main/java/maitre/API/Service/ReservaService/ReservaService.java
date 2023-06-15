package maitre.API.Service.ReservaService;


import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.Domain.Usuario;
import maitre.API.Repository.EstabelecimentoRepository;
import maitre.API.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;


    public List<Reserva> listarReservas(){
        List<Reserva> lista = reservaRepository.findAll();

        if(lista.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return lista;
    }

    public Reserva buscarReservaPorId(Integer id){
        Optional<Reserva> optReserva = reservaRepository.findById(id);
        if(optReserva.isPresent()){
            return optReserva.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Estabelecimento> buscarReservaPorUsuarioId(Integer idUsuario){
        List<Estabelecimento> listReserva = reservaRepository.findEstabelecimentoWithReservaByUsuarioId(idUsuario);
        if(listReserva.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return listReserva;
    }

    public List<Reserva> buscarReservaPorUsuarioIdLista(Integer idUsuario){
        List<Reserva> listReserva = reservaRepository.findReservaByUsuarioId(idUsuario);
        if(listReserva.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return listReserva;
    }

    public List<Usuario> buscarReservaPorEstabelecimentoId(Integer idEstabelecimento){
        List<Usuario> listReserva = reservaRepository.findUsuarioWithReservaByEstabelecimentoId(idEstabelecimento);
        if(listReserva.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return listReserva;
    }

    public Reserva criarReservar(Reserva r){
        Reserva reserva = reservaRepository.save(r);
        return reserva;
    }

    public Reserva atualizaReserva(Integer id, Reserva r){
        Optional<Reserva> reserva = reservaRepository.findById(id);
        if(reserva.isPresent()) {
            r.setId(id);
            r.setDtReserva(reserva.get().getDtReserva());
            r.setHoraReserva(reserva.get().getHoraReserva());
            r.setAssentos(reserva.get().getAssentos());
            Reserva reservaAtualizada = this.reservaRepository.save(r);
            return reservaAtualizada;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Void selecionarLugares(Usuario u, Integer idAssento, Integer idEstabelecimento){
        Optional<Estabelecimento> optEstabelecimento = estabelecimentoRepository.findById(idEstabelecimento);
        Estabelecimento estabelecimento;

        if (optEstabelecimento.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        estabelecimento = optEstabelecimento.get();

        if(estabelecimento.getAssentos().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            if (estabelecimento.getAssentos().get(idAssento).getDisponivel()){
                estabelecimento.getAssentos().get(idAssento).setDisponivel(false);
                throw new ResponseStatusException(HttpStatus.OK);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Void deletarReserva(Integer id){
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            reservaRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}

