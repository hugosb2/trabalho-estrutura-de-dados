package trabalho.estrutura.de.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SalvaArquivo {
    
    private static final String ARQUIVO_DADOS = "src/trabalho/estrutura/de/dados/livros.dat";
    
    public void grava(Object ob) {
        try { 
            File arquivo = new File(ARQUIVO_DADOS);  //local arquivo
            
            //Vincula objeto de gravacao arquivo
            ObjectOutputStream grava = new ObjectOutputStream(new FileOutputStream(arquivo));  
            
            grava.writeObject(ob);       //Efetua gravacao arquivo
            
            grava.close();               //Fecha objeto de gravacao
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Object ler() {
        Object retorno = null;
        
        try {
            File arquivo = new File(ARQUIVO_DADOS);  //local arquivo
            
            //Vincula objeto de leitura arquivo
            ObjectInputStream ler = new ObjectInputStream(new FileInputStream(arquivo));  
            
            Object obj = (Object) ler.readObject();  //Efetua leitura arquivo
            if (obj != null)
                retorno = obj;         //Seta retorno

            ler.close();           //Fecha objeto leitura
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        
        return retorno;
    }
}
