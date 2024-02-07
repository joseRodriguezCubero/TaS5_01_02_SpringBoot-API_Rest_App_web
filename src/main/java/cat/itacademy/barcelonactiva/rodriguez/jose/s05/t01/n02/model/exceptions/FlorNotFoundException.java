package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.exceptions;

public class FlorNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public FlorNotFoundException(String msg) {
        super(msg);
    }
}

