package cpu.memory;

public class Ram {

    private Address[] memory;

    public Ram(int size) {
        memory = new Address[size];
        for(int i = 0; i < size; i++) {
            memory[i] = new Address(0);
        }

        System.out.println("Creating RAM");
    }

    public Ram(int[] memory) {
        this.memory = new Address[memory.length];
        for (int i = 0; i < memory.length; i++) {
            this.memory[i] = new Address(memory[i]);
        }
    }

    public int Read(int address) throws BreakpointException {
        if(memory[address].breakpoint) {
            throw new BreakpointException();
        }

        return memory[address].value;
    }

    public void Write(int address, int value) throws BreakpointException {
        if(memory[address].breakpoint) {
            throw new BreakpointException();
        }

        memory[address].value = value;
    }

    public void SetBreakpoint(int address, boolean breakpoint) {
        memory[address].breakpoint = breakpoint;
    }

    private class Address {
        private boolean breakpoint;
        private int value;

        Address(int value) {
            breakpoint = false;
            this.value = value;
        }
    }
}