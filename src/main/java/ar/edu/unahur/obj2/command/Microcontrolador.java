package ar.edu.unahur.obj2.command;


import java.util.List;
import java.util.Stack;

import ar.edu.unahur.obj2.command.comandos.Operable;


public class Microcontrolador implements Programable {
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private Integer[] memoriaDatos;
    private Stack<MicrocontroladorProgramable> estadosAnteriores;


    public Microcontrolador() {
        reset();
    }


    @Override
    public void run(List<Operable> operaciones) {
        // Iniciamos en PC = 0
        for (programCounter = 0; programCounter < operaciones.size(); ) { 
            guardarEstado();
            try {
                operaciones.get(programCounter).execute(this); 
            } catch (Exception e) {
                deshacer();
            }
        }
    }


    @Override
    public void incProgramCounter() {
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

   @Override
    public void setAddr(Integer addr, Integer value) {
        if (addr < 0 || addr >= 1024) {
            throw new IllegalArgumentException("Dirección de memoria inválida: " + addr);
        }
        memoriaDatos[addr] = value;
    }


    @Override
    public Integer getAddr(Integer addr) {
        if (addr < 0 || addr >= 1024) {
            throw new IllegalArgumentException("Dirección de memoria inválida: " + addr);
        }
        return memoriaDatos[addr];
    }

    @Override
    public void reset() {
        this.acumuladorA = 0;
        this.acumuladorB = 0;
        this.programCounter = 0;
        this.memoriaDatos = new Integer[1024];
        this.estadosAnteriores = new Stack<>();
        
        for (int i = 0; i < 1024; i++) {
            memoriaDatos[i] = 0;
        }
    }

    @Override
    public void guardarEstado() {
        estadosAnteriores.push(crearPrograma());
    }

    @Override
    public void deshacer() {
        if (!estadosAnteriores.isEmpty()) {
            restaurarMicro(estadosAnteriores.pop());
        }
    }

    @Override
    public MicrocontroladorProgramable crearPrograma() {
        return new MicrocontroladorProgramable(acumuladorA, acumuladorB, programCounter, memoriaDatos);
    }

    @Override
    public void restaurarMicro(MicrocontroladorProgramable micro) {
        this.acumuladorA = micro.getAcumuladorA();
        this.acumuladorB = micro.getAcumuladorB();
        this.programCounter = micro.getProgramCounter();
        System.arraycopy(micro.getMemoriaDatos(), 0, this.memoriaDatos, 0, 1024);
    }

    @Override
    public void copyFrom(Programable programable) {
     
    }

    @Override
    public Programable copy() {
            return null;
   
    }

 
}





