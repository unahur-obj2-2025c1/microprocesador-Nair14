package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class STR implements Operable {
    private Integer addr;

    public STR(Integer addr) {
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        micro.getAddr(addr);
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
       
    }
    
}
