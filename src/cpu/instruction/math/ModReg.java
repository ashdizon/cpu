package cpu.instruction.math;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.ThreeOperandInstruction;

public class ModReg extends ThreeOperandInstruction {

    public ModReg(int operand1, int operand2, int operand3) {
        super(operand1, operand2, operand3);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        int src1 = registers.getGpr(getOperand2());
        int src2 = registers.getGpr(getOperand3());
        registers.setGpr(getOperand1(), src1 % src2, true);
    }

}
