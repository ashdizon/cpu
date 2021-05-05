package cpu.instruction.math;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.OneOperandInstruction;

public class Dec extends OneOperandInstruction {

    public Dec(int operand1) {
        super(operand1);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        int src = registers.getGpr(getOperand1());
        registers.setGpr(getOperand1(), src - 1, true);
    }

}
