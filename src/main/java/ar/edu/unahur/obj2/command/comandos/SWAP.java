package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable {

    @Override
    public void execute(Programable micro) {
        Integer temp = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(temp);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
     
    }

    
}