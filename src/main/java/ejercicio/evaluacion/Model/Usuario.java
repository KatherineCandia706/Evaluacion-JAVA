package ejercicio.evaluacion.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name="USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NAME_USUARIO")
    private String name;

    @Column(name = "EMAIL_USUARIO")
    private String email;

    @Column(name = "PASS_USUARIO")
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_LOGIN")
    private Login login;

    public Usuario() {

    }

    public Usuario(Long id, String name, String email, String password, List<Phone> phones, Login login) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void addPhones(Phone phone){
        if (!phones.contains(phone)){
            phones.add(phone);
            phone.setUsuario(this);
        }
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
