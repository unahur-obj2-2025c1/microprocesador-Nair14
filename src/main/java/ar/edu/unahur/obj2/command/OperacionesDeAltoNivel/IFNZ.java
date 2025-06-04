package ar.edu.unahur.obj2.command.OperacionesDeAltoNivel;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;
import ar.edu.unahur.obj2.command.comandos.Operable;


public class IFNZ implements Operable {
    private final List<Operable> instrucciones;

    public IFNZ(List<Operable> instrucciones) {
        this.instrucciones = new ArrayList<>(instrucciones);
    }

    @Override
    public void execute(Programable micro) {
        if (micro.getAcumuladorA() != 0) {
            micro.guardarEstado();
            for (Operable op : instrucciones) {
                op.execute(micro);
            }
        }
        micro.incProgramCounter();
    }

    @Override
    public void undo(Programable micro) {
      
    }
    
}
