package cpu.instruction;

public abstract class TwoOperandInstruction extends OneOperandInstruction {
    private int operand2;

    public TwoOperandInstruction(int operand1, int operand2) {
        super(operand1);
        this.operand2 = operand2;
    }

    public int getOperand2() {
        return operand2;
    }
}
