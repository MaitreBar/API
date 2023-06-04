package maitre.API.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import maitre.API.Domain.Entidades.Estabelecimento;
import maitre.API.Domain.Entidades.Reserva;
import jakarta.validation.Valid;
import maitre.API.Domain.Entidades.Estabelecimento;
import maitre.API.Domain.Entidades.Reserva;
import maitre.API.Domain.Entidades.Usuario;
import maitre.API.ListaObj.ListaObj;
import maitre.API.Repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Tag(name = "Estabelecimento", description = "Endpoints Estabelecimento")

@RestController
@RequestMapping("/estabelecimentos")
@CrossOrigin("http://localhost:3000/")
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

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<Estabelecimento> login(@PathVariable String email, @PathVariable String senha) {
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();
        for (Estabelecimento e : estabelecimentos){
            if (e.getEmail().equals(email) && e.getSenha().equals(senha)){
                System.out.printf("O Estabelecimento %s Logado com sucesso" , e.getNome());
                return ResponseEntity.status(200).body(e);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estabelecimento> atualizaUser(@PathVariable Integer id, @RequestBody @Valid Estabelecimento e){
        e.setId(id);
        if (this.estabelecimentoRepository.existsById(id)){
            Estabelecimento estabelecimentoAtualizado = this.estabelecimentoRepository.save(e);
            return ResponseEntity.status(200).body(estabelecimentoAtualizado);
        }
        return ResponseEntity.status(404).build();
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

    @PostMapping("/test")
    public ResponseEntity<Void> adiciona(@RequestBody Estabelecimento estabelecimento){
        ListaObj<Estabelecimento> listaEstabelecimento = new ListaObj(5);
        listaEstabelecimento.adiciona(estabelecimento);
        listaEstabelecimento.exibe();
        gravarArquivoCsv(listaEstabelecimento, "Estabelecimento");
        System.out.println();
        if (listaEstabelecimento.getTamanho() == 0){
            return ResponseEntity.status(204).build();
        }else {
            leArquivoCsv("Estabelecimento");
        }
        return ResponseEntity.status(200).build();
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
                saida.format("%d;%s;%s;%s;%S;%S;%S;%S;\n",
                        estabelecimento.getId(),estabelecimento.getNome(),estabelecimento.getLogradouro(),
                        estabelecimento.getNumero(),estabelecimento.getCep(),estabelecimento.getCnpj(),
                        estabelecimento.getTags(),estabelecimento.getReservas());
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
                erroBoolean = true;
            }
//            if (erroBoolean) {
//                System.exit(1);
//            }
        }
    }

    public static void leArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%4S %-15S %-9S %4S %S %S %S %S %S %S %S %S\n",
                    "id", "nome", "logadouro", "numero", "cep", "cnpj", "qtAreas", "assentos", "tipoComida", "tipoBebida", "tipoMusica", "reservas");
            while (entrada.hasNext()) {
                System.out.println(entrada.toString() );
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
                System.out.printf("%4d %-15s %-9s %9s %9s %6d %1d %10s %10s %10s %10s \n",
                        id, nome, logradouro, numero, cep, cnpj, qtAreas, assentos, tipoComida, tipoBebida, tipoMusica, reservas);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Elemento solicitado no exssite");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
//            if (deuRuim) {
//                System.exit(1);
//            }
        }
    }
}
