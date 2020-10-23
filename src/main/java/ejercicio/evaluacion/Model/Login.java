package ejercicio.evaluacion.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name="LOGIN")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_LOGIN")
    private Long idLogin;

    @Column(name = "CREATED")
    private Date created;

    @Column(name = "MODIFIED")
    private Date modified;

    @Column(name = "LAST_LOGIN")
    private Date last_login;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToOne(mappedBy = "login", fetch = FetchType.LAZY)
    private Usuario usuario;

    public Login() {

    }

    public Login(Long idLogin, Date created, Date modified, Date last_login, String token, Boolean isActive, Usuario usuario) {
        this.idLogin = idLogin;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.isActive = isActive;
        this.usuario = usuario;
    }

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
