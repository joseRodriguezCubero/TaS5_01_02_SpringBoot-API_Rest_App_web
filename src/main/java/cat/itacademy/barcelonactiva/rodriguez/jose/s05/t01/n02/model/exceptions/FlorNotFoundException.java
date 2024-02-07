package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions;

public class SucursalNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public SucursalNotFoundException(String msg) {
        super(msg);
    }
}

