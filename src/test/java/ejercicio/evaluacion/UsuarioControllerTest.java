package ejercicio.evaluacion;

import ejercicio.evaluacion.Model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioControllerTest {

    @InjectMocks
    UsuarioController usuarioController;

    @Mock
    UsuarioServices usuarioService;

    Usuario usuario = new Usuario();

    @BeforeEach
    void setUp() {
        this.usuario.setId((long) 1D);
        this.usuario.setName("Prueba");
        this.usuario.setEmail("prueba@prueba.cl");
        this.usuario.setPassword("Pll00s");
    }

    @Test
    public void guardarUsuarioTest() {
        Mockito.when(usuarioService.guardarUsuario(usuario)).thenReturn(Mockito.any(Object.class));
        Mockito.when(usuarioController.guardarUsuario(usuario)).thenReturn(Mockito.any(Object.class));
        usuarioController.guardarUsuario(usuario);

    }
}
