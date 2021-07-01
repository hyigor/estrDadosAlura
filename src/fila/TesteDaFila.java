package fila;

import java.util.LinkedList;
import java.util.Queue;

public class TesteDaFila {

	public static void main(String[] args) {
		
		Fila fila = new Fila();
		
		fila.adiciona("Mauricio");
		fila.adiciona("Guilherme");
		
		
		System.out.println(fila);
		
		String x1 = fila.remove();
		
		System.out.println(fila);
		
		Queue<String> filaDoJava = new LinkedList<String>();
		
		filaDoJava.add("Mauricio");
		System.out.println(filaDoJava);

		String x2 = filaDoJava.poll();
		
		System.out.println(x2);
		System.out.println(filaDoJava);
		
	}
	
	
}
