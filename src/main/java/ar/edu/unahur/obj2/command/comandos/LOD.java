package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD implements Operable {
    private Integer addr;

    public LOD(Integer addr) {
        this.addr = addr;
    }

    @Override
    public void execute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(addr));
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
    
    }
    
}

