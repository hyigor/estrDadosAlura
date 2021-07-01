package vetores;

public class VetorTeste {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("Joao");
		Aluno a2 = new Aluno("José");
		
		
		Vetor lista = new Vetor();
		
		System.out.println(lista.tamanho());
		lista.adiciona(a1);
		System.out.println(lista.tamanho());
		lista.adiciona(a2);
		System.out.println(lista.tamanho());
		
		System.out.println(lista);
		
		
		Aluno a3 = new Aluno("Maria");
		System.out.println(lista.contem(a3));
		
		Aluno a4 = new Aluno("sad");
		Aluno a5 = new Aluno("Masaria");
		Aluno a6 = new Aluno("Marasdia");
		Aluno a7 = new Aluno("Marasia");
		Aluno a8 = new Aluno("Marddia");

		lista.adiciona(a4);
		lista.adiciona(a5);
		lista.adiciona(a6);
		lista.adiciona(a7);
		lista.adiciona(a8);

		
		
		
//		Aluno x = lista.pega(150);
//		System.out.println(x);
		
		lista.adiciona(1, a3);
		System.out.println(lista);
		
		lista.remove(1);
		System.out.println(lista);
		
		
		for(int i = 0; i < 300; i++) {
			Aluno y = new Aluno("Joao" + i);
			lista.adiciona(y);
		}
		
		System.out.println(lista);
	}
	
}
