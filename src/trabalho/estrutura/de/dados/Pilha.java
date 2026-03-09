package trabalho.estrutura.de.dados;

import java.util.*;
import java.util.LinkedList;

public class Pilha {

    private List<Livro> objetos;

    public Pilha(){
        this.objetos= new LinkedList<Livro>();
    }

    public void adiciona(Livro l){
        this.objetos.add(l);
    }

    public void remove(){
        this.objetos.remove(this.objetos.size()-1);
    }

    public boolean vazia(){
        return this.objetos.size()==0;
    }

    public List<Livro> getObjetos(){
        return objetos;
    }

    @Override
    public String toString() {
        return "Pilha[" + "livros=" + objetos + ']';
    }
}
