package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter

public class FlorDTO implements Serializable {

    private Long pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String typeFlor;
    private final ArrayList<String> euroCountries = new ArrayList<>(List.of("Alemania", "Austria", "Bélgica", "Chipre", "Croacia", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Países Bajos", "Portugal"));

    public FlorDTO(Long pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.typeFlor = createTypeFlor(paisFlor);
    }

    public FlorDTO() {
    }

    public String createTypeFlor(String paisFlor) {
        if (paisFlor != null) {
            if (this.euroCountries.contains(paisFlor)) {
                return "EURO";
            }
        }
        return "NO EURO";
    }
}
