package trabalho.estrutura.de.dados;
import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Lista <Livro> livros= new Lista<>();
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);


        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Excluir livro (remover ultima ocorrencia)");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Inserir lista de livros em uma fila ");
            System.out.println("5 - Criar PILHAS de livros do mesmo gênero literário  ");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o genero: ");
                    String genero = scanner.nextLine();

                    System.out.print("Digite o numero de paginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine();

                    Livro livro = new Livro(titulo, genero, paginas);
                    livros.adiciona(livro);

                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o titulo do livro a remover: ");
                    String remove = scanner.nextLine();
                    livros.remove(remove);

                case 3:
                    System.out.print(livros.MostraLista());
                    break;
                case 4:
                    if (livros.vazia()) {
                        System.out.println("Lista vazia!");
                    } else {
                        for (Livro l : livros.getObjetos()) {
                            fila.adiciona(l);
                        }
                        fila.imprimirFila();
                    }
                    break;
                case 5:
                    if (livros.vazia()) {
                        System.out.println("Lista vazia!");
                        break;
                    }

                    LinkedList<Pilha> pilhalivro = new LinkedList<>();

                    for (Livro l : livros.getObjetos()) {
                        boolean adiciona=false;

                        for (Pilha p : pilhalivro){

                            Livro primeiro = p.getObjetos().get(0);
                            if(primeiro.getGenero().equalsIgnoreCase(l.getGenero())){
                                p.adiciona(l);
                                adiciona=true;
                                break;
                            }
                        }
                        if(!adiciona){
                            Pilha nova= new Pilha();
                            nova.adiciona(l);
                            pilhalivro.add(nova);
                        }
                    }
                    for (Pilha p : pilhalivro) {
                        System.out.println(p.toString());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção invalida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

}
