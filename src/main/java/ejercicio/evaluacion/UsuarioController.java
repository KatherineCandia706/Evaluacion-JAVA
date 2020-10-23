package ejercicio.evaluacion;

import ejercicio.evaluacion.Model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioService;

    /**
     * Toma el Json para validar y guardar el usuario
     * en la base de datos.
     * @param usuario
     * @return Object (Mensaje o Login)
     */
    @RequestMapping(value="/guardarUsuario", method = RequestMethod.POST)
    public Object guardarUsuario(@RequestBody Usuario usuario) {
       return usuarioService.guardarUsuario(usuario);
    }
}
