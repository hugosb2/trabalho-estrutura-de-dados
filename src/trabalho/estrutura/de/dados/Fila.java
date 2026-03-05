package trabalho.estrutura.de.dados;

import java.util.LinkedList;

public class Fila {
    private LinkedList<Livro> objetos;

    public Fila(){
        this.objetos=new LinkedList<Livro>();
    }

    public void adiciona(Livro t){
        if (objetos.isEmpty()) {
            objetos.add(t);
            return;
        }

        for (int i = 0; i < objetos.size(); i++) {

            if (t.getNumPagina() < objetos.get(i).getNumPagina()) {
                objetos.add(i, t);
                return;
            }
        }

        objetos.addLast(t);

    }
    public void imprimirFila() {
        System.out.println("\n--- FILA (Menor nº páginas primeiro) ---");
        for (Livro l : objetos) {
            System.out.println(l);
        }
    }


    public String toString(){
        String retorno="[";

        for (int i=0;i<objetos.size();i++){
            retorno+= (i+1)+"-"+objetos.get(i)+" ";

        }
        retorno+=" ]";
        return retorno;
    }
}
