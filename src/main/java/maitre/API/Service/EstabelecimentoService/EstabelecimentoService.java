package maitre.API.Service.EstabelecimentoService;

import maitre.API.Domain.Estabelecimento;
import maitre.API.Domain.FilaObj;
import maitre.API.Domain.PilhaObj;
import maitre.API.Domain.Reserva;
import maitre.API.ListaObj.ListaObj;
import maitre.API.Repository.EstabelecimentoRepository;
import maitre.API.Service.EstabelecimentoService.dto.AtualizacaoEstabelecimentoDTO;
import maitre.API.Service.EstabelecimentoService.dto.EstabelecimentoMapper;
import maitre.API.Service.EstabelecimentoService.dto.PerfilEstabelecimentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class EstabelecimentoService {
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public List<Estabelecimento> listar() {
        List<Estabelecimento> lista = estabelecimentoRepository.findAll();
        FilaObj<Estabelecimento> estabelecimentoFilaObj = new FilaObj<>(100);

        for (int i = 0; i < lista.size(); i++) {
            estabelecimentoFilaObj.insert(lista.get(i));
        }

        PilhaObj<Estabelecimento> estabelecimentoPilhaObj = new PilhaObj<>(100);
        List<Estabelecimento> listaEmpilhada = new ArrayList<>(100);

        for (int i = 0; i < estabelecimentoFilaObj.getTamanho(); i++) {
            estabelecimentoPilhaObj.push(estabelecimentoFilaObj.get(i));
//            estabelecimentoPilhaObj.pop();
        }
        for (int i = 0; i < estabelecimentoPilhaObj.getTopo() + 1; i++) {
            listaEmpilhada.add(estabelecimentoPilhaObj.buscaPorPosicao(i));
        }

        return listaEmpilhada;
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
        e.setIdEstabelecimento(id);
        if (this.estabelecimentoRepository.existsById(id)) {
            AtualizacaoEstabelecimentoDTO estabelecimentoAtualizadoDto = EstabelecimentoMapper.MapAtualizacaoDTO(e);
            Estabelecimento estabelecimento = EstabelecimentoMapper.of(estabelecimentoAtualizadoDto);
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
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoByIdEstabelecimento(id);
        if (!estabelecimento.getReservas().get(idReserva).getCheckIn()) {
            estabelecimento.getReservas().get(idReserva).setDtHoraCheckOut(LocalDateTime.now());
            estabelecimento.getReservas().get(idReserva).setCheckIn(true);
            throw new ResponseStatusException(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public Void checkOut(Integer id, Integer idReserva) {
        Estabelecimento estabelecimento = estabelecimentoRepository.findEstabelecimentoByIdEstabelecimento(id);
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
        }

        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Estabelecimento estabelecimento = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%S;%S;%S;%S;\n", estabelecimento.getIdEstabelecimento(), estabelecimento.getNome(), estabelecimento.getLogradouro(), estabelecimento.getNumero(), estabelecimento.getCep(), estabelecimento.getCnpj(), estabelecimento.getTags(), estabelecimento.getReservas());
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

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // Bloco try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao abrir o arquivo!");

        }

        // Bloco try-catch para gravar e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao gravar o arquivo!");
        }
    }

    public String leArquivoTxtEstabelecimento(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, rua, numero, bairro, cnpj, email, telefoneContato;
        int contaRegDadosLidos = 0;
        int qtdRegDadosGravados;

        List<Estabelecimento> listaLida = new ArrayList<>();

        // try-catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq + ".txt"));
        } catch (IOException erro) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Houve um erro ao realizar a leitura do arquivo txt (estabalecimentoService.leArquivoTxt: )");
        }

        // try-catch para ler e fechar o arquivo
        try {
            // le o 1o registro do arquivo
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2, 17));
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(17, 36));
                    System.out.println("Versão do layout: " + registro.substring(36, 38));
                } else if (tipoRegistro.equals("04")) {
                    System.out.println("É um registro de trailer");
                    qtdRegDadosGravados = Integer.parseInt(registro.substring(2, 7));

                    if (qtdRegDadosGravados == contaRegDadosLidos) {
                        System.out.println("Quantidade de registros de dados gravados compatível com quantidade de registros de dados lidos");
                    } else {
                        System.out.println("Quantidade de registros de dados gravados incompatível com quantidade de registros de dados lidos");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("É um registro de dados ou  (Estabelecimento Parte 1)");
                    nome = registro.substring(2, 102).trim();
                    rua = registro.substring(102, 202).trim();
                    numero = registro.substring(202, 207).trim();
                    bairro = registro.substring(207, 252).trim();
                    cnpj = registro.substring(252, 266).trim();
                    email = registro.substring(266, 366).trim();
                    telefoneContato = registro.substring(366, 391).trim();

                    Estabelecimento estabelecimento = new Estabelecimento(nome, rua, numero, bairro, cnpj, email, telefoneContato);
                    contaRegDadosLidos++;

                    // Para importar essa informação ao banco de dados:
                    // repository.save(a);

                    // No nosso caso, como não estamos conectados a banco de dados
                    // vamos adicionar esse aluno a uma lista
                    listaLida.add(estabelecimento);
                } else {
                    System.out.println("Tipo de registro inválido!");
                }
                // le o próximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
        }

        String retorno = "";
        // Exibe a lista lida
        System.out.println("\nLista contendo os dados lidos do arquivo:");
        for (Estabelecimento e : listaLida) {
            retorno += String.format("%d Registro: %s\n", listaLida.indexOf(e)+1, e);
            System.out.println(e);
        }

        return retorno;

        // Se quiser importar a lista toda de uma vez para o banco:
        // repository.saveAll(listaLida);
    }


    public String exportArquivoTxt(String nomeArq) {
        int contaRegDadosGravados = 0;
        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.findAll();
//        List<EnderecoTxtDTO> enderecos = enderecoService.findAll().stream().map(EnderecoMapper::mapToTxt).toList();

        // Monta o registro de header
        String header = "00Estabelecimento";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        nomeArq += ".txt";

        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de dados ou registros de corpo
        String corpo;
        for (int i = 0; i < estabelecimentos.size(); i++) {
            Estabelecimento e = estabelecimentos.get(i);
            corpo = "02";
            corpo += String.format("%-100.100s", e.getNome());
            corpo += String.format("%-100.100s", e.getLogradouro());
            corpo += String.format("%-50.50s", e.getNumero());
//            corpo += String.format("%-45.45s", e.getBairro());
            corpo += String.format("%14.14s", e.getCnpj());
            corpo += String.format("%100.100s", e.getEmail());
            corpo += String.format("%25.25s", e.getTelefoneContato() == null? "(11) 95125401215654213456": e.getTelefoneContato());
            gravaRegistro(corpo, nomeArq);
            contaRegDadosGravados++;
        }

        // Monta e grava o registro de trailer
        String trailer = "04";
        trailer += String.format("%05d", contaRegDadosGravados);
        gravaRegistro(trailer, nomeArq);
        return "Arquivo gerado com sucesso!!";
    }

}
