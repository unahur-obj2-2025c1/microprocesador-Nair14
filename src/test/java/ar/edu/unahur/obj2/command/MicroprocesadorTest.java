package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ar.edu.unahur.obj2.command.comandos.ADD;
import ar.edu.unahur.obj2.command.comandos.LOD;
import ar.edu.unahur.obj2.command.comandos.LODV;
import ar.edu.unahur.obj2.command.comandos.NOP;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.STR;
import ar.edu.unahur.obj2.command.comandos.SWAP;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class MicroprocesadorTest {


    @Test
    void hacerAvanzar3Veces() {
    Microcontrolador micro = new Microcontrolador();
    
    List<Operable> programa = Arrays.asList(
        new NOP(),
        new NOP(),
        new NOP()
    );
    
    assertEquals(0, micro.getProgramCounter(), "PC inicial debe ser 0");
    
	micro.run(programa);

    assertEquals(3, micro.getProgramCounter(), "PC debe ser 3 después de 3 NOPs");

    }

	

	@Test
	void sumar20y17() {
        Microcontrolador micro = new Microcontrolador();
        
        List<Operable> programa = Arrays.asList(
            new LODV(20),   
            new SWAP(),     
            new LODV(17),   
            new ADD()       
        );
        
        assertEquals(0, micro.getProgramCounter(), "PC debe empezar en 0");
        assertEquals(0, micro.getAcumuladorA(), "Acumulador A debe empezar en 0");
        assertEquals(0, micro.getAcumuladorB(), "Acumulador B debe empezar en 0");
        
        // Ejecutar programa
        micro.run(programa);
        
        // Verificaciones finales
        assertEquals(4, micro.getProgramCounter(), "PC debe estar en 4 después de 4 instrucciones");
        assertEquals(37, micro.getAcumuladorA(), "Acumulador A debe contener la suma 37");
        assertEquals(0, micro.getAcumuladorB(), "Acumulador B debe estar en 0 después de ADD");
    }
		
	
	
	@Test
	void sumar2y8y5() {
		Microcontrolador micro = new Microcontrolador();
    
		List<Operable> programa = Arrays.asList(
			new LODV(2),   
			new STR(0),      
			new LODV(8),    
			new SWAP(),      
			new LODV(5),    
			new ADD(),       
			new SWAP(),      
			new LOD(0),     
			new ADD()        
		);
		
		micro.run(programa);
		
		assertEquals(9, micro.getProgramCounter());
		assertEquals(15, micro.getAcumuladorA());
		assertEquals(0, micro.getAcumuladorB());
		assertEquals(2, micro.getAddr(0));
	}
	

}
