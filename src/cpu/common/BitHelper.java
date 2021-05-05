package cpu.common;

public abstract class BitHelper {

    private BitHelper() {
        throw new UnsupportedOperationException();
    }

    public static int GetBits(int i, int mask, int position) {
        if(position < 0) {
            throw new IllegalArgumentException("position must be non negative.");
        }

        return (i & (mask << position)) >> position;
    }

    public static int SetBits(int i, int mask, int position) {
        if(position < 0) {
            throw new IllegalArgumentException("position must be non negative.");
        }

        return (i | (mask << position)) >> position;
    }

    public static int ClearBits(int i, int mask, int position) {
        if(position < 0) {
            throw new IllegalArgumentException("position must be non negative.");
        }

        return i & ~(mask << position);
    }

    public static boolean IntToBool(int i) {
        if(i == 0) {
            return false;
        } else if (i == 1) {
            return true;
        } else {
            throw new IllegalArgumentException("int must be either 0 or 1.");
        }
    }

    public static int BoolToInt(boolean b) {
        return b ? 1 : 0;
    }
}
