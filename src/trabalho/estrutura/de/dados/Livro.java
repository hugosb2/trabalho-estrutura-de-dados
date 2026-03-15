package trabalho.estrutura.de.dados;

import java.io.Serializable;

public class Livro implements Comparable<Livro>, Serializable {
    private String titulo;
    private String genero;
    private int numPagina;

    public Livro(String titulo, String genero, int numPagina) {
        this.titulo = titulo;
        this.genero = genero;
        this.numPagina = numPagina;
    }

    @Override
    public int compareTo(Livro outro) {
        // Compara pelo numero de paginas (ordem crescente)
        return Integer.compare(this.numPagina, outro.numPagina);
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    @Override
    public String toString() {
        return this.titulo + " - " + this.genero + " - "+ this.numPagina;
    }



}
