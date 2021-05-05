package cpu.instruction;

public abstract class OneOperandInstruction implements Instruction {
    private int operand1;

    public OneOperandInstruction(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand1() {
        return operand1;
    }
}
