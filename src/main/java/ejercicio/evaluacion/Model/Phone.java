package ejercicio.evaluacion.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="PHONE")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_PHONE")
    private Long id;

    @Column(name = "NUMBER")
    private Long number;

    @Column(name = "CITY_CODE")
    private Long cityCode;

    @Column(name = "COUNTRY_CODE")
    private Long countryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    public Phone() {

    }

    public Phone(Long id, Long number, Long cityCode, Long countryCode, Usuario usuario) {
        this.id = id;
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long number) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
