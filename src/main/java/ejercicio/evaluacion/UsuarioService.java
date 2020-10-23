package ejercicio.evaluacion;

import ejercicio.evaluacion.Model.Login;
import ejercicio.evaluacion.Model.Mensaje;
import ejercicio.evaluacion.Model.Usuario;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
public class UsuarioService implements UsuarioServices{

    private static final Logger logger = LogManager.getLogger(UsuarioService.class);

    private static EntityManager manager;
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Persistencia");;

    /**
     * Este método valida si el Json tiene un error, la cual o
     * devuelve el objeto Mensaje o el objeto Login.
     * @param usuario
     * @return Object (Mensaje o Login)
     */
    public Object guardarUsuario(Usuario usuario) {
        logger.info("Se ingresó al método guardarUsuario");

        String mensajeError = validarUsuario(usuario);

        if ("".equals(mensajeError)) {
            logger.info("Se creará el nuevo usuario");
            return crearUsuario(usuario);
        } else {
            logger.error(mensajeError);
            return new Mensaje(mensajeError);
        }
    }


    public String validarUsuario(Usuario usuario) {
        String mensaje = "";
        try{
            mensaje = validaCampos(usuario);
        } catch(Exception e) {
            logger.error("Ocurrió un error en el sistema: "+ e.toString());
            mensaje = e.toString();
        }
        return mensaje;
    }

    /**
     * Este método valida si los campos del Json están vacíos.
     * @param usuario
     * @return mensajeError
     */
    public String validaCampos(Usuario usuario) {
        logger.info("Se validará los campos correspondientes");
        String mensajeError = "";

        // Patrón para validar el email
        Pattern patternMail = Pattern
                .compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");

        // Patrón para validar el password
        Pattern patternPass = Pattern
                .compile("^(?=(?:\\w*\\d){2})(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,}$");

        if (usuario.getName() == null || usuario.getName().isEmpty())
            mensajeError = "El nombre del usuario está vacío";

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            mensajeError = "El email del usuario está vacío";
        } else {
            Matcher mather = patternMail.matcher(usuario.getEmail());

            if (!mather.find())
                mensajeError = "El email del usuario no tiene el formato correcto";

            if (validaEmail(usuario.getEmail().trim()))
                mensajeError = "El correo ya registrado";
        }

        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            mensajeError = "El password del usuario está vacío";
        } else {
            Matcher validaPassword = patternPass.matcher(usuario.getPassword());

            if (!validaPassword.find())
                mensajeError = "El password del usuario no tiene el formato correcto, debe tener: "
                        + "Una mayúscula, letras minúsculas y dos números";
        }

        if (usuario.getPhones() == null || usuario.getPhones().size() < 1){
            mensajeError = "El teléfono del usuario está vacío";
        }

        return mensajeError;
    }

    /**
     * Este método si el email ya se encuentra guardado en la
     * base de datos.
     * @param email
     * @return retorno
     */
    @SuppressWarnings("unchecked")
    public Boolean validaEmail(String email) {
        Boolean retorno = false;
            logger.info("Se validará si el email se encuentra en la base de datos");

            manager = emf.createEntityManager();

            List<Usuario> user = (List<Usuario>) manager.createQuery(
                    "FROM Usuario WHERE email = '" + email + "'").getResultList();
            user.size();
            manager.close();
            if (user.size() > 0 ) {
                    retorno = true;
                }

            return retorno;
    }

    /**
     * Este método guarda el usuario
     * @param usuario
     * @return Object (Mensaje o Login)
     */
    @SuppressWarnings("unchecked")
    public Object crearUsuario(Usuario usuario) {
        manager = emf.createEntityManager();

        try {
            Date date = new Date();
            UUID token = UUID.randomUUID();
            Login login = new Login();

            login.setCreated(date);
            login.setModified(date);
            login.setLast_login(date);
            login.setToken(token.toString());
            login.setIsActive(true);
            login.setUsuario(usuario);

            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.persist(login);

            manager.getTransaction().commit();
            manager.close();

            logger.info("Se creó el usuario exitosamente..");
            return login;
        } catch (Exception e) {
            String error = "Ocurrió un error al guardar el usuario: " + e.toString();
            logger.error(error);
            return new Mensaje(error);
        }
    }
}
