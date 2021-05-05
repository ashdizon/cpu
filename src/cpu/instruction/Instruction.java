package cpu.instruction;

import cpu.Cpu;

public interface Instruction {
    public void Execute(Cpu cpu);
}
