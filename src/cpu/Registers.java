package cpu;

import cpu.common.BitHelper;

public class Registers {

    private static final int P_BIT = 0;
    private static final int Z_BIT = 1;
    private static final int N_BIT = 2;
    private static final int NZP_BIT_MASK = 0b111;
    private static final int INT_BIT = 3;

    private int[] gpr;
    private int ip, flags;

    public Registers() {
        gpr = new int[16];
        ip = flags = 0;
        System.out.println("Creating CPU Registers");
    }

    public boolean getInterrupt() {
        return BitHelper.IntToBool(BitHelper.GetBits(flags, 1, INT_BIT));
    }

    public void setInterrupt(boolean isInterrupted) {
        flags = BitHelper.SetBits(flags, BitHelper.BoolToInt(isInterrupted), INT_BIT);
    }

    private void clearNZP() {
        flags = BitHelper.ClearBits(flags, NZP_BIT_MASK, 0);
    }

    public boolean getN() {
        return BitHelper.IntToBool(BitHelper.GetBits(flags, 1, N_BIT));
    }

    public void setN() {
        clearNZP();
        flags = BitHelper.SetBits(flags, 1, N_BIT);
    }

    public boolean getZ() {
        return BitHelper.IntToBool(BitHelper.GetBits(flags, 1, Z_BIT));
    }

    public void setZ() {
        clearNZP();
        flags = BitHelper.SetBits(flags, 1, Z_BIT);
    }

    public boolean getP() {
        return BitHelper.IntToBool(BitHelper.GetBits(flags, 1, P_BIT));
    }

    public void setP() {
        clearNZP();
        flags = BitHelper.SetBits(flags, 1, P_BIT);
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getGpr(int reg) {
        return gpr[reg];
    }

    public void setGpr(int reg, int value, boolean updateNZP) {
        gpr[reg] = value;

        if(updateNZP) {
            if(value < 0) {
                setN();
            } else if (value > 0) {
                setP();
            } else {
                setZ();
            }
        }
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }
}
