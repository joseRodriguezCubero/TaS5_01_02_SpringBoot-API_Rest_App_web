package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;


@Getter
@Entity
@Table(name = "flowers")
public class Flor implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Flower Id", example = "123")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_FlorID;

    @Setter
    @Schema(description = "Flower's name", example = "Rosa")
    @Column(name = "nom_flor")
    private String nomFlor;

    @Setter
    @Schema(description = "Flower's country", example = "France")
    @Column(name = "pais_flor")
    private String paisFlor;


    public Flor() {
    }

    public Flor(Long pkSucursalID, String nomSucursal, String paisFlor) {
        this.pk_FlorID=pkSucursalID;
        this.nomFlor=nomSucursal;
        this.paisFlor=paisFlor;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + pk_FlorID +
                ", name='" + nomFlor + '\'' +
                ", country='" + paisFlor + '\'' +
                '}';
    }
}
