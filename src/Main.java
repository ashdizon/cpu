import cpu.Cpu;
import cpu.Registers;
import cpu.memory.Ram;

public class Main {
    public static void main(String[] args) {
        Ram testRam = new Ram(512);
        Registers testReg = new Registers();
        Cpu cpu = new Cpu(testRam, testReg);


        // REG Y + number Z -> REG X
        // 0000 0xxx xyyy y1zz zzzz zzzz zzzz zzzz
        // 0000 0000 1000 0100 0000 0000 0000 0001
        // Reg Y (0) + 1 -> store into Reg 1
        testRam.Write(0, 0b00000000100001000000000000000010); // write add instruction
        // should expect register 1 to have the value 2

        System.out.println("value in register 1: " + testReg.getGpr(1));
        System.out.println("begin test\n\n");
        cpu.Step();
        System.out.println("\n\nend test\n\n");
        System.out.println("value in register 1: " + testReg.getGpr(1));




        testRam = new Ram(512);
        testReg = new Registers();
        cpu = new Cpu(testRam, testReg);

        // REG Y + REG Z -> REG X
        // 0000 0xxx xyyy y0zz zz00 0000 0000 0000
        // 0000 0000 1000 0000 1000 0000 0000 0000
        // reg 0 + reg 2 -> store into reg 1
        testRam.Write(0, 0b00000000100000001000000000000000);
        testReg.setGpr(0, 5, true); // reg 0 = 5, the true flag does not matter for this test
        testReg.setGpr(2, 2, true); // reg 2 = 2

        // should expect register 1 to equal 7
        // register 0 and 2 should remain the same

        System.out.println("value in register 0: " + testReg.getGpr(0));
        System.out.println("value in register 1: " + testReg.getGpr(1));
        System.out.println("value in register 2: " + testReg.getGpr(2));
        System.out.println("begin test\n\n");

        cpu.Step();

        System.out.println("\n\nend test\n\n");
        System.out.println("value in register 0: " + testReg.getGpr(0));
        System.out.println("value in register 1: " + testReg.getGpr(1));
        System.out.println("value in register 2: " + testReg.getGpr(2));
    }
}
