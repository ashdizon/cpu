package cpu.instruction;

public abstract class ThreeOperandInstruction extends TwoOperandInstruction {
    private int operand3;

    public ThreeOperandInstruction(int operand1, int operand2, int operand3) {
        super(operand1, operand2);
        this.operand3 = operand3;
    }

    public int getOperand3() {
        return operand3;
    }
}
