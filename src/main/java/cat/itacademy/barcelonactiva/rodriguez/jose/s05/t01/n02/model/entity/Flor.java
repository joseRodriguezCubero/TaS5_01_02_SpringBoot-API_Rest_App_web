package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;


@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_SucursalID;
    @NotBlank(message = "El campo no puede estar vacío")
    @Column(name = "nom_sucursal")
    private String nomSucursal;

    public Long getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Long pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne
    @JoinColumn (name="countries_id")
    private Country country;

    public Sucursal(String nomSucursal, Country paisSucursal) {
        this.nomSucursal=nomSucursal;
        this.country=paisSucursal;
    }

    public Sucursal() {
    }

    public Sucursal(Long pkSucursalID, String nomSucursal, Country paisSucursal) {
        this.pk_SucursalID=pkSucursalID;
        this.nomSucursal=nomSucursal;
        this.country=paisSucursal;
    }



    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + country.getCountryName() + '\'' +
                '}';
    }
}
