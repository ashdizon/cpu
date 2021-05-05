package cpu.instruction.math;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.ThreeOperandInstruction;

public class SubImm extends ThreeOperandInstruction {

    public SubImm(int operand1, int operand2, int operand3) {
        super(operand1, operand2, operand3);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        int src = registers.getGpr(getOperand2());
        registers.setGpr(getOperand1(), src - getOperand3(), true);
    }

}
