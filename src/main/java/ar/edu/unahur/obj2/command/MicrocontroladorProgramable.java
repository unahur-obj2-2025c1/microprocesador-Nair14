package ar.edu.unahur.obj2.command;

public class MicrocontroladorProgramable {
    private final Integer acumuladorA;
    private final Integer acumuladorB;
    private final Integer programCounter;
    private final Integer[] memoriaDatos;

    public MicrocontroladorProgramable(Integer acumuladorA, Integer acumuladorB, Integer programCounter, Integer[] memoriaDatos) {
        this.acumuladorA = acumuladorA;
        this.acumuladorB = acumuladorB;
        this.programCounter = programCounter;
        this.memoriaDatos = new Integer[1024];
        System.arraycopy(memoriaDatos, 0, this.memoriaDatos, 0, 1024);
    }

    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    public Integer getProgramCounter() {
        return programCounter;
    }

    public Integer[] getMemoriaDatos() {
        return memoriaDatos;
    }



}
