
package lerarquivotexto;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author clesio
 */
public class LerArquivoTexto {

    
    public static void main(String[] args) {
       
        try { 
            String arquivo = "src/lerarquivotexto/texto.txt";    //Local do Arquivo 
            BufferedReader ler = 
                    new BufferedReader(new InputStreamReader(new FileInputStream(arquivo)));  //Buscar arquivo para buffer.

            String linha = "";
            
            do                   //While lendo linha a linha o arquivo 
            {
               linha = ler.readLine();         //Ler linha
               
                if (linha != null)                   
                { 
                    System.out.println(linha);      //Imprimr linha
                }
                else
                    break;                         //Sai do laço quando acabar as linhas do arquivo
              
            } while (true);
            
            ler.close();                     //Fechar buffer arquivo.
       } 
         catch (IOException e) {
            e.printStackTrace();
       }  
        
    }
    
}
