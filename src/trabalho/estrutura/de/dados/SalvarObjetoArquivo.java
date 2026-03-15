
package salvarobjetoarquivo;

import java.util.LinkedList;


public class SalvarObjetoArquivo {

    
    public static void main(String[] args) {
       
        LinkedList<Aluno> lista  = new LinkedList<Aluno>();
        
        
        lista.add(new Aluno("Bernardo", 6));
        lista.add(new Aluno ("Rafael",2));
        lista.add(new Aluno ("Lucas",18));
        System.out.println("Lista Inicial - " + lista);
       
        SalvaArquivo sa = new SalvaArquivo();
        sa.grava(lista);  // Garva objeto lista 
        
        LinkedList<Aluno> listaRecupera;
       
        Object conteudo = sa.ler();                     // ler arquivo
        listaRecupera  = (LinkedList<Aluno>) conteudo;  // transforma de LinkedList
        System.out.println("\nLista Recupedata - " + listaRecupera);
        
        listaRecupera.add(new Aluno("Carol",22));
        System.out.println("\nLista Final - " +listaRecupera);
 
    }
    
}
