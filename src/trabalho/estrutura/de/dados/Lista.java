package trabalho.estrutura.de.dados;

import java.util.LinkedList;

public class Lista {


    private LinkedList<Livro> objetos;


    public Lista(){
        this.objetos=new LinkedList<Livro>();
    }

    public void adiciona(Livro t){
        this.objetos.add(t);
    }

    public void remove(String t){
        if(this.vazia())
            throw new IndexOutOfBoundsException("lista vazia");
        else

            for(int i=this.objetos.size()-1;i>=0;i--){
                if(objetos.get(i).getTitulo().equalsIgnoreCase(t)){
                    objetos.remove(i);
                    break;
                }
            }
    }

    public int tamanho(){
        return  objetos.size();
    }

    public Livro olha(){
        return this.objetos.getFirst();
    }

    public boolean vazia(){
        return (this.objetos.size() == 0);
    }

    public String MostraLista(){
        String retorno="[";

        for (int i=0;i<objetos.size();i++){
            retorno+= (i+1)+"-"+objetos.get(i)+" ";

        }
        retorno+=" ]";
        return retorno;
    }

    public LinkedList<Livro> getObjetos() {
        return objetos;
    }



    @Override
    public String toString() {
        return "Lista{" + "objetos=" + objetos + '}';
    }


}
