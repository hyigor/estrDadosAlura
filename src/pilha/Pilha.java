package pilha;

import java.util.LinkedList;
import java.util.List;

public class Pilha {

	private List<String> nomes = new LinkedList<String>();
	
	
	public void push(String nome) { //m�todo insere
		nomes.add(nome);
	}
	
	
	public String pop() { //m�todo remove
		
		
		
		return nomes.remove(nomes.size() - 1);
	}
	
	public boolean vazia() {
		return nomes.isEmpty();
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomes.toString();
	}
	
	
}
