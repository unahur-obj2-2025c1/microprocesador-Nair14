package ar.edu.unahur.obj2.command;

import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public interface Programable {

    void run(List<Operable> operaciones);

    void incProgramCounter();

    Integer getProgramCounter();

    void setAcumuladorA(Integer value);

    Integer getAcumuladorA();

    void setAcumuladorB(Integer value);

    Integer getAcumuladorB();

    void copyFrom(Programable programable);

    Programable copy();

    void reset();

    void setAddr(Integer addr, Integer value);

    Integer getAddr(Integer addr);

    void guardarEstado();
    
    void deshacer();

    MicrocontroladorProgramable crearPrograma();

    void restaurarMicro(MicrocontroladorProgramable micro);

}
