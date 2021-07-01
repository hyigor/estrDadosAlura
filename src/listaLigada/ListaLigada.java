package listaLigada;

public class ListaLigada {

	
	private Celula primeira = null;
	private Celula ultimo = null;
	private int totalDeElementos = 0;
	
	public void adicionaNoComeco(Object elemento) {
//		Celula nova = new Celula(elemento, primeira);
//		this.primeira = nova;
//
//		
//		
//		if(this.totalDeElementos == 0) {
//			this.ultimo = this.primeira;
//			
//			System.out.println(this.ultimo.getElemento());
//		}
		
		if(this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultimo = nova;
		} else {
			Celula nova = new Celula(elemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		
		
		
		this.totalDeElementos++;
		
	}
	
	@Override
	public String toString() {

		if(this.totalDeElementos == 0) {
			return "[]";
		}
		
		Celula atual = primeira;
		StringBuilder builder = new StringBuilder("[");
		
		for(int i = 0; i < totalDeElementos; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			
			atual = atual.getProximo();

		
		}
		
		builder.append("]");
		
		return builder.toString();
	}
	
	public void adiciona(Object elemento) {
		
		if(this.totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
//			Celula nova = new Celula(elemento, null);
//			this.ultimo.setProximo(nova);
//			this.ultimo = nova;
			
			Celula nova = new Celula(elemento);
			this.ultimo.setProximo(nova);
			nova.setAnterior(this.ultimo);
			this.ultimo = nova;
			this.totalDeElementos++;
		}
		
	}
	
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	
	
	private Celula pegaCelula(int posicao) {
		
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("posicao inexistente");
		}
		
		Celula atual = primeira;
		for(int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
	}
	
	
	public void adiciona(int posicao, Object elemento) {
		
		if(posicao == 0) {
			adicionaNoComeco(elemento);
		} else if(posicao == this.totalDeElementos) {
			adiciona(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula proxima = anterior.getProximo();
			Celula nova = new Celula(elemento, anterior.getProximo());
			
			
			nova.setAnterior(anterior);
			anterior.setProximo(nova);
			proxima.setAnterior(nova);
			
			this.totalDeElementos++;
		}
		
		
	}

	
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
		}
	
	
	public void removeDoComeco() {
		if(this.totalDeElementos == 0) {
			throw new IllegalArgumentException("Lista vazia!");
		}
		
		this.primeira = this.primeira.getProximo();
		
		this.totalDeElementos--;
		
		if(totalDeElementos == 0) {
			this.ultimo = null;
		}
	}
	
	public void remove(int posicao) {
		if(posicao == 0) {
			this.removeDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula atual = anterior.getProximo();
			Celula proximo = atual.getProximo();
			
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			
			this.totalDeElementos--;
		}
	}
	
	public int tamanho() {
		return this.totalDeElementos;
	
	}
	
	
	public boolean contem(Object elemento) {
		Celula atual = this.primeira;
		
		while(atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			}
			
			atual = atual.getProximo();
			
		}
		
		return false;

	
	
	}
	
	public void removeDoFim() {
		if(this.totalDeElementos == 1) {
			this.removeDoComeco();
		} else {
			Celula penultimo = this.ultimo.getAnterior();
			penultimo.setProximo(null);
			this.ultimo = penultimo;
			this.totalDeElementos--;
		}
	
		
	}
	
	
}
