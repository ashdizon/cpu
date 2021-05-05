package cpu.instruction;


import cpu.common.BitHelper;
import cpu.common.Constants;
import cpu.instruction.math.AddImm;
import cpu.instruction.math.AddReg;

public abstract class InstructionFactory {

    private InstructionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Instruction Create(int instruction) throws MalformedInstructionException {
        int opcode = BitHelper.GetBits(instruction, Constants.OPCODE_MASK, Constants.OPCODE_OFFSET);

        System.out.println("opcode decoded: " + opcode);

        switch(opcode) {
            case Constants.OPCODE_ADD: return createAdd(instruction);
            case Constants.OPCODE_SUB: return createSub(instruction);
            case Constants.OPCODE_MUL: return createMul(instruction);
            case Constants.OPCODE_DIV: return createDiv(instruction);
            case Constants.OPCODE_MOD: return createMod(instruction);
            case Constants.OPCODE_INC: return createInc(instruction);
            case Constants.OPCODE_DEC: return createDec(instruction);
            case Constants.OPCODE_OR: return createOr(instruction);
            case Constants.OPCODE_AND: return createAnd(instruction);
            case Constants.OPCODE_XOR: return createXor(instruction);
            case Constants.OPCODE_NOT: return createNot(instruction);
            case Constants.OPCODE_LS: return createLs(instruction);
            case Constants.OPCODE_RS: return createRs(instruction);
            case Constants.OPCODE_LD: return createLd(instruction);
            case Constants.OPCODE_LDR: return createLdr(instruction);
            case Constants.OPCODE_LDI: return createLdi(instruction);
            case Constants.OPCODE_LEA: return createLea(instruction);
            case Constants.OPCODE_ST: return createSt(instruction);
            case Constants.OPCODE_STR: return createStr(instruction);
            case Constants.OPCODE_STI: return createSti(instruction);
            case Constants.OPCODE_JMP: return createJmp(instruction);
            case Constants.OPCODE_CALL: return createCall(instruction);
            case Constants.OPCODE_RET: return createRet(instruction);
            case Constants.OPCODE_SYSCALL: return createSyscall(instruction);
            case Constants.OPCODE_SYSEXIT: return createSysexit(instruction);
            case Constants.OPCODE_SETF: return createSetf(instruction);
            case Constants.OPCODE_GETF: return createGetf(instruction);
            case Constants.OPCODE_PUSH: return createPush(instruction);
            case Constants.OPCODE_POP: return createPop(instruction);
            case Constants.OPCODE_PUSHF: return createPushf(instruction);
            case Constants.OPCODE_POPF: return createPopf(instruction);
            case Constants.OPCODE_HALT: return createHalt(instruction);
            default: throw new IllegalArgumentException();
        }
    }

    private static Instruction createAdd(int instruction) {

        int regX = BitHelper.GetBits(instruction, 0xF, 23);
        int regY = BitHelper.GetBits(instruction, 0xF, 19);
        boolean isImmAdd = BitHelper.IntToBool(BitHelper.GetBits(instruction, 1, 18));

        System.out.println("instruction: " + instruction);
        System.out.println("regX: " + regX);
        System.out.println("regY: " + regY);
        System.out.println("isImmAdd: " + isImmAdd);

        if(isImmAdd) {
            int number = BitHelper.GetBits(instruction, 0x3FFFF, 0);
            System.out.println("number: " + number);
            return new AddImm(regX, regY, number);
        }else{
            int regZ = BitHelper.GetBits(instruction, 0xFF, 14);
            System.out.println("regZ: " + regZ);
            return new AddReg(regX, regY, regZ);
        }
    }

    private static Instruction createSub(int instruction) {
        return null;
    }

    private static Instruction createMul(int instruction) {
        return null;
    }

    private static Instruction createDiv(int instruction) {
        return null;
    }

    private static Instruction createMod(int instruction) {
        return null;
    }

    private static Instruction createInc(int instruction) {
        return null;
    }

    private static Instruction createDec(int instruction) {
        return null;
    }

    private static Instruction createOr(int instruction) {
        return null;
    }

    private static Instruction createAnd(int instruction) {
        return null;
    }

    private static Instruction createXor(int instruction) {
        return null;
    }

    private static Instruction createNot(int instruction) {
        return null;
    }

    private static Instruction createLs(int instruction) {
        return null;
    }

    private static Instruction createRs(int instruction) {
        return null;
    }

    private static Instruction createLd(int instruction) {
        return null;
    }

    private static Instruction createLdr(int instruction) {
        return null;
    }

    private static Instruction createLdi(int instruction) {
        return null;
    }

    private static Instruction createLea(int instruction) {
        return null;
    }

    private static Instruction createSt(int instruction) {
        return null;
    }

    private static Instruction createStr(int instruction) {
        return null;
    }

    private static Instruction createSti(int instruction) {
        return null;
    }

    private static Instruction createJmp(int instruction) {
        return null;
    }

    private static Instruction createCall(int instruction) {
        return null;
    }

    private static Instruction createRet(int instruction) {
        return null;
    }

    private static Instruction createSyscall(int instruction) {
        return null;
    }

    private static Instruction createSysexit(int instruction) {
        return null;
    }

    private static Instruction createSetf(int instruction) {
        return null;
    }

    private static Instruction createGetf(int instruction) {
        return null;
    }

    private static Instruction createPush(int instruction) {
        return null;
    }

    private static Instruction createPop(int instruction) {
        return null;
    }

    private static Instruction createPushf(int instruction) {
        return null;
    }

    private static Instruction createPopf(int instruction) {
        return null;
    }

    private static Instruction createHalt(int instruction) {
        return null;
    }
}

