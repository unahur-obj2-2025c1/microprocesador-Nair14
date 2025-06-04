package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LODV implements Operable {
    private Integer value;

    public LODV(Integer value) {
        this.value = value;
    }

    @Override
    public void execute(Programable micro) {
        micro.setAcumuladorA(value);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
     
    }

    
}
