package ar.edu.unahur.obj2.command.OperacionesDeAltoNivel;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.command.Programable;
import ar.edu.unahur.obj2.command.comandos.Operable;



public class WHNZ implements Operable {
    private final List<Operable> instrucciones;

    public WHNZ(List<Operable> instrucciones) {
        this.instrucciones = new ArrayList<>(instrucciones);
    }


    @Override
    public void execute(Programable micro) {
        while (debeContinuarEjecucion(micro)) {
            micro.guardarEstado();
            ejecutarBloqueInstrucciones(micro);
        }
        micro.incProgramCounter();
    }


    private boolean debeContinuarEjecucion(Programable micro) {
        return micro.getAcumuladorA() != 0;
    }


    private void ejecutarBloqueInstrucciones(Programable micro) {
        int i = 0;
        while (i < instrucciones.size() && debeContinuarEjecucion(micro)) {
            instrucciones.get(i).execute(micro);
            i++;
        }
    }


    @Override
    public void undo(Programable micro) {
        
    }

    
}