package trabalho.estrutura.de.dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.LinkedList;

public class SalvaArquivo {
    
    private static final String ARQUIVO_DADOS = "src/trabalho/estrutura/de/dados/livros.txt";
    
    public String getArquivoDados() {
        return ARQUIVO_DADOS;
    }
    
    public void grava(Object ob) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_DADOS))) {
            LinkedList<Livro> livros = (LinkedList<Livro>) ob;
            for (Livro livro : livros) {
                writer.println(livro.getTitulo() + ";" + livro.getGenero() + ";" + livro.getPaginas());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Object ler() {
        LinkedList<Livro> retorno = new LinkedList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_DADOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String titulo = partes[0];
                    String genero = partes[1];
                    int paginas = Integer.parseInt(partes[2]);
                    retorno.add(new Livro(titulo, genero, paginas));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return retorno;
    }
}
