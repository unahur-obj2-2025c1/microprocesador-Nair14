package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;



public class ProgramBuilder {
    private final List<Operable> instrucciones = new ArrayList<>();

    public ProgramBuilder nop() {
        instrucciones.add(new NOP());
        return this;
    }

    public ProgramBuilder add() {
        instrucciones.add(new ADD());
        return this;
    }

    public ProgramBuilder swap() {
        instrucciones.add(new SWAP());
        return this;
    }

    public ProgramBuilder lod(Integer addr) {
        instrucciones.add(new LOD(addr));
        return this;
    }

    public ProgramBuilder str(Integer addr) {
        instrucciones.add(new STR(addr));
        return this;
    }

    public ProgramBuilder lodv(Integer valor) {
        instrucciones.add(new LODV(valor));
        return this;
    }

    public List<Operable> build() {
        return new ArrayList<>(instrucciones); 
    }


}