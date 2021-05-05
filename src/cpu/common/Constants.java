package cpu.common;


public abstract class Constants {
    private Constants() {
        throw new UnsupportedOperationException();
    }

    // general opcode constants
    public static final int OPCODE_OFFSET = 27;
    public static final int OPCODE_MASK = 0x1f;

    // basic math opcodes

    // REG Y + number Z -> REG X
    // 0000 0xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y + REG Z -> REG X
    // 0000 0xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_ADD = 0;

    // REG Y - number Z -> REG X
    // 0000 1xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y - REG Z -> REG X
    // 0000 1xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_SUB = 1;

    // REG Y * number Z -> REG X
    // 0001 0xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y * REG Z -> REG X
    // 0001 0xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_MUL = 2;

    // REG Y / number Z -> REG X
    // 0001 1xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y / REG Z -> REG X
    // 0001 1xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_DIV = 3;

    // REG Y % number Z -> REG X
    // 0010 0xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y % REG Z -> REG X
    // 0010 0xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_MOD = 4;

    // INC REG X
    // 0010 1xxx x000 0000 0000 0000 0000 0000
    public static final int OPCODE_INC = 5;

    // DEC REG X
    // 0011 0xxx x000 0000 0000 0000 0000 0000
    public static final int OPCODE_DEC = 6;

    // bit operation opcodes

    // REG Y | number Z -> REG X
    // 0011 1xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y | REG Z -> REG X
    // 0011 1xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_OR = 7;

    // REG Y & number Z -> REG X
    // 0100 0xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y & REG Z -> REG X
    // 0100 0xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_AND = 8;

    // REG Y ^ number Z -> REG X
    // 0100 1xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y ^ REG Z -> REG X
    // 0100 1xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_XOR = 9;

    // ~REG Y -> REG X
    // 0101 0xxx xyyy y100 0000 0000 0000 0000
    public static final int OPCODE_NOT = 10;

    // REG Y << number Z -> REG X
    // 0101 1xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y << REG Z -> REG X
    // 0101 1xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_LS = 11;

    // REG Y >> number Z -> REG X
    // 0110 0xxx xyyy y1zz zzzz zzzz zzzz zzzz
    // REG Y >> REG Z -> REG X
    // 0110 0xxx xyyy y0zz zz00 0000 0000 0000
    public static final int OPCODE_RS = 12;

    // memory

    // x = dest, y = ip offset
    // 0110 1xxx xyyy yyyy yyyy yyyy yyyy yyyy
    public static final int OPCODE_LD = 13;

    // x = dest, y = reg
    // 0111 0xxx x000 yyyy 0000 0000 0000 0000
    public static final int OPCODE_LDR = 14;

    // x =dest, y = ip offset
    // 0111 1xxx xyyy yyyy yyyy yyyy yyyy yyyy
    public static final int OPCODE_LDI = 15;

    // x =dest, y = ip offset
    // 1000 0xxx xyyy yyyy yyyy yyyy yyyy yyyy
    public static final int OPCODE_LEA = 16;

    // x = src, y = ip offset
    // 1000 1xxx xyyy yyyy yyyy yyyy yyyy yyyy
    public static final int OPCODE_ST = 17;

    // x = src, y = reg
    // 1001 0xxx x000 yyyy 0000 0000 0000 0000
    public static final int OPCODE_STR = 18;

    // x = src, y = ip offset
    // 1001 1xxx xyyy yyyy yyyy yyyy yyyy yyyy
    public static final int OPCODE_STI = 19;

    // program flow

    // x = ip offset, nzp = conditions
    // 1010 0nzp xxxx xxxx xxxx xxxx xxxx xxxx
    public static final int OPCODE_JMP = 20;

    // user mode functions calls

    // call function pointer in reg x
    // 1010 1xxx x000 y000 0000 0000 0000 0000
    public static final int OPCODE_CALL = 21;

    // return
    // 1011 0000 0000 0000 0000 0000 0000 0000
    public static final int OPCODE_RET = 22;

    // kernel mode calls

    // call into trap vector
    // 1011 0000 0000 0000 xxxx xxxx xxxx xxxx
    public static final int OPCODE_SYSCALL = 23;

    // 1100 0000 0000 0000 0000 0000 0000 0000
    public static final int OPCODE_SYSEXIT = 24; // return from syscall, flip to usermode

    // set bit << yyyyy to x
    // 1100 1000 000x 0000 0000 0000 000y yyyy
    public static final int OPCODE_SETF = 25;

    // get bit << yyyyy put into reg x
    // 1101 0000 xxxx 0000 0000 0000 000y yyyy
    public static final int OPCODE_GETF = 26;

    // push reg x onto stack
    // 1101 1xxx x000 0000 0000 0000 0000 0000
    public static final int OPCODE_PUSH = 27;

    // pop into reg x from stack
    // 1110 0xxx x0000 0000 0000 0000 0000 0000
    public static final int OPCODE_POP = 28;

    // push flags onto stack
    // 1110 1000 0000 0000 0000 0000 0000 0000
    public static final int OPCODE_PUSHF = 29;

    // pop into flags from stack
    // 1111 0000 0000 0000 0000 0000 0000 0000
    public static final int OPCODE_POPF = 30;

    // hlt
    // 1111 1000 0000 0000 0000 0000 0000 0000
    public static final int OPCODE_HALT = 31;
}

