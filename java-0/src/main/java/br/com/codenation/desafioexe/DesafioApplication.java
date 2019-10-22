package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

import br.com.codenation.TestadorFibonacci;
import br.com.codenation.annotation.Desafio;

public class DesafioApplication {

	public static void main(String[] args) {
		new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	}
	public static int fib(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
			return fib(n-1 ) + fib(n-2);
	}


	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {
		List<Integer> resp = new ArrayList();
		int valor=0;
		for(int i=0; valor<350; i++) {
			if(i!=0)
				resp.add(valor);
			valor=fib(i);
		}
		return resp;
	}

	@Desafio("isFibonacci")
	public static Boolean isFibonacci(Integer a) {
		List<Integer> lista=fibonacci();
		return lista.contains(a);
	}

}
