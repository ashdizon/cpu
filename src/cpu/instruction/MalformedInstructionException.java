package cpu.instruction;

public class MalformedInstructionException extends IllegalArgumentException{

    private static final long serialVersionUID = 1L;
    public MalformedInstructionException(String message) {
        super(message);
    }
}
