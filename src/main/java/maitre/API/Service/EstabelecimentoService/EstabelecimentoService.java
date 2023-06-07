package maitre.API.Service.EstabelecimentoService;

import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import maitre.API.ListaObj.ListaObj;
import maitre.API.Repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class EstabelecimentoService {
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public List<Estabelecimento> listar() {
        List<Estabelecimento> lista = estabelecimentoRepository.findAll();
        return lista;
    }

    public Estabelecimento login(String email, String senha) {
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();
        for (Estabelecimento e : estabelecimentos) {
            if (e.getEmail().equals(email) && e.getSenha().equals(senha)) {
                System.out.printf("O Estabelecimento %s Logado com sucesso", e.getNome());
                return e;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Estabelecimento atualizaUser(Integer id, Estabelecimento e) {
        e.setId(id);
        if (this.estabelecimentoRepository.existsById(id)) {
            Estabelecimento estabelecimentoAtualizado = this.estabelecimentoRepository.save(e);
            return estabelecimentoAtualizado;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Estabelecimento buscarPorId(Integer id) {
        Optional<Estabelecimento> optEstabelecimento = estabelecimentoRepository.findById(id);
        if (optEstabelecimento.isPresent()) {
            return optEstabelecimento.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Estabelecimento cadastrar(Estabelecimento e) {
        Estabelecimento estabelecimento = estabelecimentoRepository.save(e);
        return estabelecimento;
    }

    public Void adiciona(Estabelecimento estabelecimento) {
        ListaObj<Estabelecimento> listaEstabelecimento = new ListaObj(5);
        listaEstabelecimento.adiciona(estabelecimento);
        listaEstabelecimento.exibe();
        gravarArquivoCsv(listaEstabelecimento, "Estabelecimento");
        System.out.println();
        if (listaEstabelecimento.getTamanho() == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            leArquivoCsv("Estabelecimento");
        }
        throw new ResponseStatusException(HttpStatus.OK);
    }

    public Optional<Estabelecimento> atualizarListaReservas(Reserva r, Integer id) {
        Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository.findById(id);
        if (optionalEstabelecimento.isPresent()) {
            optionalEstabelecimento.get().addReserva(r);
            estabelecimentoRepository.save(optionalEstabelecimento.get());
            return optionalEstabelecimento;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Void checkIn(Integer id, Integer idReserva) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoById(id);
        if (!estabelecimento.getReservas().get(idReserva).getCheckIn()) {
            estabelecimento.getReservas().get(idReserva).setDtHoraCheckOut(LocalDateTime.now());
            estabelecimento.getReservas().get(idReserva).setCheckIn(true);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public Void checkOut(Integer id, Integer idReserva) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoById(id);
        if (estabelecimento.getReservas().get(idReserva).getCheckIn()) {
            estabelecimento.getReservas().get(idReserva).setDtHoraCheckOut(LocalDateTime.now());
            estabelecimento.getReservas().get(idReserva).setCheckOut(true);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public Void deletar(Integer id) {
        Optional<Estabelecimento> optionalEstabelecimento = estabelecimentoRepository.findById(id);
        if (optionalEstabelecimento.isPresent()) {
            estabelecimentoRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public static void gravarArquivoCsv(ListaObj<Estabelecimento> lista, String nomeArquivo) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean erroBoolean = false;

        nomeArquivo += ".csv";

        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Ocorreu um erro ao abrir");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Estabelecimento estabelecimento = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%S;%S;%S;%S;\n", estabelecimento.getId(), estabelecimento.getNome(), estabelecimento.getLogradouro(), estabelecimento.getNumero(), estabelecimento.getCep(), estabelecimento.getCnpj(), estabelecimento.getTags(), estabelecimento.getReservas());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erroBoolean = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
            }
        }
    }

    public static void leArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%4S %-15S %-9S %4S %S %S %S %S %S %S %S %S\n", "id", "nome", "logadouro", "numero", "cep", "cnpj", "qtAreas", "assentos", "tipoComida", "tipoBebida", "tipoMusica", "reservas");
            while (entrada.hasNext()) {
                System.out.println(entrada.toString());
                int id = entrada.nextInt();
                String nome = entrada.next();
                String logradouro = entrada.next();
                String numero = entrada.next();
                String cep = entrada.next();
                int cnpj = entrada.nextInt();
                int qtAreas = entrada.nextInt();
                String assentos = entrada.next();
                String tipoComida = entrada.next();
                String tipoBebida = entrada.next();
                String tipoMusica = entrada.next();
                String reservas = entrada.next();
                System.out.printf("%4d %-15s %-9s %9s %9s %6d %1d %10s %10s %10s %10s \n", id, nome, logradouro, numero, cep, cnpj, qtAreas, assentos, tipoComida, tipoBebida, tipoMusica, reservas);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Elemento solicitado no existe");
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
            }
        }
    }
}
