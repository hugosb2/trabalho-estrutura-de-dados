package trabalho.estrutura.de.dados;

public class Arvore<TIPO extends Comparable> {
    
    private Elemento<TIPO> raiz;   
    private java.util.List<TIPO> repetidos; // Lista para armazenar elementos repetidos
    
    public Arvore(){
        this.raiz = null;
        this.repetidos = new java.util.ArrayList<>();
    }
    
    public Elemento<TIPO> getRaiz() {
        return raiz;
    }
    public void setRaiz(Elemento<TIPO> r) {
         raiz = r;
    }
    
    public java.util.List<TIPO> getRepetidos() {
        return repetidos;
    }
    
    // Método para verificar se o título já existe na árvore
    public boolean tituloJaExiste(String titulo) {
        return tituloJaExiste(raiz, titulo);
    }
    
    private boolean tituloJaExiste(Elemento<TIPO> atual, String titulo) {
        if (atual == null) {
            return false;
        }
        
        TIPO valor = atual.getValor();
        if (valor instanceof Livro) {
            if (((Livro) valor).getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        
        return tituloJaExiste(atual.getEsquerda(), titulo) || 
               tituloJaExiste(atual.getDireita(), titulo);
    }
    
    public void adicionar(TIPO valor){
        // Se for Livro, verifica título duplicado
        if (valor instanceof Livro) {
            String titulo = ((Livro) valor).getTitulo();
            if (tituloJaExiste(titulo)) {
                System.out.println("Livro com título repetido não será inserido: " + titulo);
                repetidos.add(valor);
                return;
            }
        }
        
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor); 
        
        if (raiz == null){    // Caso arvore vazia
            this.raiz = novoElemento;
        }
        else{
            Elemento<TIPO> atual = this.raiz;   // inicia raiz com atual
            
            while(true){ //roda constante entrado nos nivies da arvore - Para com break 
                // ------------- Novo elementno MENOR
                if (novoElemento.getValor().compareTo(atual.getValor()) == -1){   
                    if (atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    }else{
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                }
                //-------- Novo elemento MAIOR 
                else if (novoElemento.getValor().compareTo(atual.getValor()) == 1){                        
                    if (atual.getDireita() != null){
                        atual = atual.getDireita();
                    }else{
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
                else  // ---- Elemento igual => não insere
                    break;
            
            }
        }
    }
    
    // Limpa a lista de repetidos
    public void limparRepetidos() {
        repetidos.clear();
    }

  
    
    public String emOrdem(Elemento<TIPO> atual){
        
        if (atual != null){
            return emOrdem(atual.getEsquerda()) + 
                   atual.getValor() + ", " + 
                   emOrdem(atual.getDireita());
        }
        else
            return "";         
    }
    
    public String preOrdem(Elemento<TIPO> atual){
        if (atual != null){
            return atual.getValor()+ ", " + 
                   preOrdem(atual.getEsquerda()) + 
                   preOrdem(atual.getDireita());
        } 
        else
            return "";
    }
}
