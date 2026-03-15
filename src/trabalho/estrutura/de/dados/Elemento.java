
package trabalho.estrutura.de.dados;

public class Elemento<TIPO> {
    
    private TIPO valor;    // Objeto guardado
    private Elemento<TIPO> esquerda;  // Filho da esquerda
    private Elemento<TIPO> direita;   // Filho da direita
    
    public Elemento(TIPO novoValor){
        this.valor = novoValor;
        
        this.esquerda = null;
        this.direita = null;
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public Elemento<TIPO> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento<TIPO> esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento<TIPO> getDireita() {
        return direita;
    }

    public void setDireita(Elemento<TIPO> direita) {
        this.direita = direita;
    }
    
    @Override
    public String toString(){
        return valor.toString();
    }
}
