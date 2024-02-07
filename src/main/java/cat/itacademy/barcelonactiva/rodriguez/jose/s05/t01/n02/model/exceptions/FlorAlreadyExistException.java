package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.exceptions;

public class FlorAlreadyExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public FlorAlreadyExistException(String msg) {
        super(msg);
    }
}