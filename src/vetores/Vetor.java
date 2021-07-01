package vetores;
import java.util.Arrays;

public class Vetor {

	private Aluno [] alunos = new Aluno[100];
	private int totalDeAlunos = 0;
	
	public void adiciona(Aluno aluno) {
//		for(int i = 0; i < alunos.length; i++) { tempo O[N]
//			if(alunos[i] == null) {
//				alunos[i] = aluno;
//				break;
//			}
//		}
		
		this.garanteEspaco();
		this.alunos[totalDeAlunos] = aluno; //tempo constante
		totalDeAlunos++;
				
	}
	
	
	public void adiciona(int posicao, Aluno aluno) { //destrinchar lógica do método
		
		this.garanteEspaco();
		
		for(int i = totalDeAlunos - 1; i >= posicao; i-=1) { //tempo de execução O[N]
			alunos[i+1] = alunos[i];
		}
		
		alunos[posicao] = aluno;
		totalDeAlunos++;
	}
	
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalDeAlunos;
	}
	
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalDeAlunos;
	}
	
	
	
	private void garanteEspaco() {
		if(totalDeAlunos == alunos.length) {
			Aluno[] novoArray = new Aluno[alunos.length*2];
			for(int i = 0; i < alunos.length; i++) {
				novoArray[i] = alunos[i];
			}
			this.alunos = novoArray;

		}
	}
	
	public Aluno pega(int posicao) {
		
		if(!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inválida!");
		}
		
		
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição Inválida!");
		}
		
		
		return alunos[posicao];
	}

	
//	int cont = 0;
	public void remove(int posicao) {
//		
//		for(int i = posicao; i < this.totalDeAlunos; i++) {
//			System.out.println(cont++);
//			this.alunos[i] = this.alunos[i + 1];
//		}
//		
//		totalDeAlunos--;
		
		for(int i = posicao; i < this.totalDeAlunos - 1; i++) {
			this.alunos[i] = this.alunos[i + 1];
		} 
		
		totalDeAlunos--;
		this.alunos[totalDeAlunos] = null;
		
	}
	
	public boolean contem(Aluno aluno) {
		
		for(int i = 0; i < totalDeAlunos; i++) { //tempo O[N]
			if(aluno.equals(alunos[i])) {
				return true;
			}
		}
		
		
		
		return false;
	}
	
	
	public int tamanho() {
		return totalDeAlunos;
	}
	
	
	
	public String toString() {
		return Arrays.toString(alunos);
	}
}