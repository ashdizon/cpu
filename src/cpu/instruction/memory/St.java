package cpu.instruction.memory;

import cpu.Cpu;
import cpu.Registers;
import cpu.instruction.TwoOperandInstruction;
import cpu.memory.Ram;

public class St extends TwoOperandInstruction {

    public St(int operand1, int operand2) {
        super(operand1, operand2);
    }

    @Override
    public void Execute(Cpu cpu) {
        Registers registers = cpu.getRegisters();
        Ram ram = cpu.getRam();
        int adr = registers.getIp() + getOperand2();
        ram.Write(adr, registers.getGpr(getOperand1()));
    }

}
