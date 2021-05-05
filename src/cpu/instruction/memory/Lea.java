package cpu.instruction.memory;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.TwoOperandInstruction;

public class Lea extends TwoOperandInstruction {

    public Lea(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        int offset = registers.getIp() + getOperand2();
        registers.setGpr(getOperand1(), offset, true);
    }

}
