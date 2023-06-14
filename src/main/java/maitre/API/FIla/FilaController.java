//package maitre.API.FIla;
//
//import maitre.API.Controller.ReservaController;
//import maitre.API.Repository.UsuarioRepository;
//import maitre.API.FIla.ListReserva;
//import maitre.API.Service.UsuarioService.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/fila")
//@CrossOrigin("http://localhost:3000/")
//public class FilaController {
//
//    @Autowired
//    private ReservaController reservaController;
//
//    private UsuarioRepository usuarioRepository;
//
//    private FilaObj fila = new FilaObj(100);
//
//    public FilaObj<ListReserva> listarReservas() {
//        return fila;
//    }
//
//    @GetMapping("/posicao")
//    public ResponseEntity<FilaObj> ReservarFila() {
//
//
//}
