package cpu.instruction.bit;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.TwoOperandInstruction;

public class Not extends TwoOperandInstruction {

    public Not(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        int src = registers.getGpr(getOperand2());
        registers.setGpr(getOperand1(), ~src, true);
    }

}
