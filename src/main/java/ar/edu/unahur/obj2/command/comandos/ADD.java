package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class ADD implements Operable {
    
    @Override
    public void execute(Programable micro) {
        Integer suma = micro.getAcumuladorA() + micro.getAcumuladorB();
        micro.setAcumuladorA(suma);
        micro.setAcumuladorB(0);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {

    }
    
}
