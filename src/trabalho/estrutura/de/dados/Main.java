package trabalho.estrutura.de.dados;
import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {
        
        
        //Main para testar classe livro
        
        String nome = JOptionPane.showInputDialog("Digite o título do livro");
        String genero = JOptionPane.showInputDialog("Digite o gênero do livro");
        int numpagina = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas"));
        
        Livro l1 = new Livro(nome, genero, numpagina);
        
        
        
        
        JOptionPane.showMessageDialog(null, l1.toString());
        
    }
    
}
