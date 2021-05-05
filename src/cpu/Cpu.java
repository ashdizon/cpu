package cpu;

import cpu.instruction.Instruction;
import cpu.instruction.InstructionFactory;
import cpu.instruction.MalformedInstructionException;
import cpu.memory.BreakpointException;
import cpu.memory.Ram;

public class Cpu {

    private Ram ram;
    private Registers registers;

    public Cpu(Ram ram, Registers registers) {
        this.ram = ram;
        this.registers = registers;
        System.out.println("Creating CPU");
    }

    public void Step() throws BreakpointException {
        Execute(Decode(Fetch()));
    }

    private int Fetch() throws BreakpointException {
        int value = ram.Read(registers.getIp());
        System.out.println("read from ram: " + value);
        return value;
    }

    private Instruction Decode(int instruction) throws MalformedInstructionException {
        return InstructionFactory.Create(instruction);
    }

    private void Execute(Instruction instruction) {
        instruction.Execute(this);
    }

    public Registers getRegisters() {
        return registers;
    }

    public Ram getRam() {
        return ram;
    }
}
