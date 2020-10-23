package ejercicio.evaluacion;

import ejercicio.evaluacion.Model.Phone;
import ejercicio.evaluacion.Model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UsuarioServiceTest {

    @InjectMocks
    UsuarioService usuarioService;

    Usuario usuario = new Usuario();
    Phone phone = new Phone();
    List<Phone> lista = new ArrayList<>();

    @BeforeEach
    void setUp() {

        this.phone.setCityCode((long) 123);
        this.phone.setCountryCode((long) 123);
        this.phone.setNumber((long) 123);

        this.lista.add((phone));
        this.usuario.setId((long) 1D);
        this.usuario.setName("Prueba");
        this.usuario.setEmail("prueba@prueba.cl");
        this.usuario.setPassword("Pll00s");
        this.usuario.setPhones(lista);

    }

    @Test
    public void guardarUsuarioNombreVacioTest() {
        usuario.setName(null);
        usuarioService.guardarUsuario(usuario);
    }

    @Test
    public void guardarUsuarioMailVacioTest() {
        usuario.setEmail(null);
        usuarioService.guardarUsuario(usuario);
    }

    @Test
    public void guardarUsuarioMailErroneoTest() {
        usuario.setEmail("email");
        usuarioService.guardarUsuario(usuario);
    }

    @Test
    public void guardarUsuarioPasswordVacioTest() {
        usuario.setPassword(null);
        usuarioService.guardarUsuario(usuario);
    }

    @Test
    public void guardarUsuarioPasswordErroneoTest() {
        usuario.setPassword("12");
        usuarioService.guardarUsuario(usuario);
    }

    @Test
    public void guardarUsuarioPhoneVacioTest() {
        usuario.setPhones(null);
        usuarioService.guardarUsuario(usuario);
    }
}
