import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;



public class Main {
    public static void main(String[] args) {
        int competidores;
        double mediaComp;
        double mediaClas;
        double desvioComp;
        double desvioClas;
        int numClassificados;
        int[] classificados;
        int[] notas;
        Scanner scan = new Scanner(System.in);
        competidores = scan.nextInt();
        numClassificados = scan.nextInt();
        while(numClassificados > competidores) {
        	System.out.println("O número de classificados nao pode ser maior que o de competidores");
        	numClassificados = scan.nextInt();
        }
        notas = new int[competidores];
        classificados = new int[competidores];
        for(int i=0;i<competidores;i++) {
        	notas[i] = scan.nextInt();
        	classificados[i] = -1;
        }
        Arrays.sort(notas);
        for(int i=0;i<numClassificados;i++) {
        	classificados[i] = notas[competidores-i-1];
        	if(i == numClassificados-1 && competidores-i-1 > 0 && notas[competidores-i-1] == notas[competidores-i-2]) {
        		numClassificados++;
        	}
        }
        mediaComp = getMedia(notas,competidores);
        mediaClas = getMedia(classificados,competidores);
        desvioComp = getDesvio(notas,mediaComp,competidores);
        desvioClas = getDesvio(classificados,mediaClas,competidores);
        System.out.println(numClassificados);
        System.out.println(desvioClas);
        System.out.println(mediaClas);
        System.out.println(desvioComp);
        System.out.println(mediaComp);
        scan.close();
    }
    public static double getMedia(int[] vec,int n){
    	int cont = 0;
    	double media = 0;
    	for(int i=0;i<n;i++) {
    		if(vec[i] != -1) {
    			media+= vec[i];
    			cont++;
    		}
    	}
    	media = media/cont;
    	return media;
    }
    public static double getDesvio(int[] vec,double med, int n) {
    	int cont = 0;
    	double desvio = 0;
    	for(int i=0;i<n;i++) {
    		if(vec[i] != -1) {
    			desvio= desvio + ((vec[i] - med)* (vec[i] - med));
    			cont++;
    		}
    	}
    	desvio = desvio/cont;
		desvio = Math.sqrt(desvio);
    	return desvio;
    }
}