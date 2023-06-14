package maitre.API.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.Reserva;
import jakarta.validation.Valid;
import maitre.API.ListaObj.ListaObj;
import maitre.API.Service.EstabelecimentoService.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    @GetMapping("/{email}/{senha}")
    public ResponseEntity<Estabelecimento> login(@PathVariable String email, @PathVariable String senha) {
        Estabelecimento estabelecimento = estabelecimentoService.login(email, senha);
        ListaObj<Estabelecimento> listaEstabelecimento = new ListaObj<>(5);
        listaEstabelecimento.adiciona(estabelecimento);

        listaEstabelecimento.exibe();
        gravarArquivoCsv(listaEstabelecimento, "Estabelecimento");
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
//        return ResponseEntity.ok(estabelecimentoService.adiciona(estabelecimento));
        ListaObj<Estabelecimento> listaEstabelecimento = new ListaObj<>(5);
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

    public static void gravarArquivoCsv(ListaObj<Estabelecimento> lista, String nomeArquivo) {
        FileWriter arquivo = null;
        Formatter saida = null;
        Boolean erroB = false;

        nomeArquivo += ".csv";

        try {
            arquivo = new FileWriter(nomeArquivo);
            saida = new Formatter(arquivo);
        } catch (IOException erro) {
            System.out.println("Ocorreu um erro ao abrir");
            System.exit(1);
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Estabelecimento estabelecimento = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%S;%S;%S;%S;%S;%S;%S;%S\n",
                        estabelecimento.getIdEstabelecimento(),estabelecimento.getNome(),estabelecimento.getLogradouro(),
                        estabelecimento.getNumero(),estabelecimento.getCep(),estabelecimento.getCnpj(),
                        estabelecimento.getAssentos(),estabelecimento.getTags(),estabelecimento.getReservas());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erroB = true;
        } finally {
            saida.close();
            try {
                arquivo.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                erroB = true;
            }
            if (erroB) {
                System.exit(1);
            }
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
