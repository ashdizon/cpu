package cpu.instruction.memory;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.TwoOperandInstruction;
import cpu.memory.Ram;

public class Ldr extends TwoOperandInstruction {

    public Ldr(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        Ram ram = cpu.getRam();
        int src = registers.getGpr(getOperand2());
        registers.setGpr(getOperand1(), ram.Read(src), true);
    }

}
