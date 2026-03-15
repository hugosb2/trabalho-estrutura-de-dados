package trabalho.estrutura.de.dados;

import javax.swing.JOptionPane;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Lista<Livro> livros = new Lista<>();
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);

        // Carregar dados ao iniciar o sistema (Questao 7)
        carregarDados(livros);

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Excluir livro (remover ultima ocorrencia)");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Inserir lista de livros em uma fila ");
            System.out.println("5 - Criar PILHAS de livros do mesmo genero literario");
            System.out.println("6 - Inserir lista de livros em uma ARVORE");
            System.out.println("7 - Salvar Lista");
            System.out.println("8 - Criar indice invertido");
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
                    System.out.println("Livro removido (ultima ocorrencia)!");
                    break;

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
                        boolean adiciona = false;

                        for (Pilha p : pilhalivro) {

                            Livro primeiro = p.getObjetos().get(0);
                            if (primeiro.getGenero().equalsIgnoreCase(l.getGenero())) {
                                p.adiciona(l);
                                adiciona = true;
                                break;
                            }
                        }
                        if (!adiciona) {
                            Pilha nova = new Pilha();
                            nova.adiciona(l);
                            pilhalivro.add(nova);
                        }
                    }
                    for (Pilha p : pilhalivro) {
                        System.out.println(p.toString());
                    }
                    break;

                // ===== QUESTAO 6: Inserir lista de livros em ARVORE =====
                case 6:
                    if (livros.vazia()) {
                        System.out.println("Lista vazia!");
                        break;
                    }

                    // Criar arvore e inserir livros ordenados por numero de paginas
                    Arvore<Livro> arvore = new Arvore<>();
                    
                    // Limpa a lista de repetidos antes de inserir
                    arvore.limparRepetidos();

                    System.out.println("\n--- Inserindo livros na Arvore (ordem crescente por numero de paginas) ---");
                    for (Livro l : livros.getObjetos()) {
                        arvore.adicionar(l);
                    }

                    // Imprimir arvore em-ordem
                    System.out.println("\n--- Arvore em-ordem ---");
                    System.out.println(arvore.emOrdem(arvore.getRaiz()));

                    // Imprimir arvore em pre-ordem
                    System.out.println("\n--- Arvore em pre-ordem ---");
                    System.out.println(arvore.preOrdem(arvore.getRaiz()));

                    // Imprimir livros repetidos
                    System.out.println("\n--- Livros nao inseridos (titulos repetidos) ---");
                    if (arvore.getRepetidos().isEmpty()) {
                        System.out.println("Nenhum livro repetido!");
                    } else {
                        for (Livro l : arvore.getRepetidos()) {
                            System.out.println(l);
                        }
                    }
                    break;

                // ===== QUESTAO 7: Salvar Lista usando ObjectOutputStream =====
                case 7:
                    salvarDados(livros);
                    SalvaArquivo sa = new SalvaArquivo();
                    System.out.println("Lista salva com sucesso no arquivo: " + sa.getArquivoDados());
                    break;

                // ===== QUESTAO 8: Criar indice invertido =====
                case 8:
                    System.out.print("Digite o nome do arquivo de texto a ler: ");
                    String nomeArquivo = scanner.nextLine();
                    criarIndiceInvertido(livros, nomeArquivo);
                    break;

                case 0:
                    // Salvar automaticamente ao encerrar
                    salvarDados(livros);
                    System.out.println("Encerrando o programa... (dados salvos automaticamente)");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // ===== QUESTAO 7: Salvar lista usando SalvaArquivo =====
    private static void salvarDados(Lista<Livro> livros) {
        SalvaArquivo sa = new SalvaArquivo();
        sa.grava(livros.getObjetos());
    }

    // ===== QUESTAO 7: Carregar dados usando SalvaArquivo =====
    private static void carregarDados(Lista<Livro> livros) {
        try {
            SalvaArquivo sa = new SalvaArquivo();
            Object conteudo = sa.ler();
            if (conteudo != null) {
                LinkedList<Livro> listaCarregada = (LinkedList<Livro>) conteudo;
                for (Livro l : listaCarregada) {
                    livros.adiciona(l);
                }
                if (!livros.vazia()) {
                    System.out.println("Dados carregados do arquivo: " + livros.tamanho() + " livros carregados.");
                }
            }
        } catch (Exception e) {
            System.out.println("Nenhum arquivo de dados encontrado. Iniciando com lista vazia.");
        }
    }

    // ===== QUESTAO 8: Criar indice invertido =====
    private static void criarIndiceInvertido(Lista<Livro> livros, String nomeArquivo) {
        // Primeiro, verificar se o arquivo existe e ler os titulos
        Map<String, Integer> contagemTitulos = new HashMap<>();

        // Inicializar a contagem com todos os titulos da lista com 0
        for (Livro l : livros.getObjetos()) {
            contagemTitulos.put(l.getTitulo().toLowerCase(), 0);
        }

        // Ler o arquivo de texto e contar as ocorrencias
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Para cada titulo na lista, verificar se aparece no texto
                String linhaLower = linha.toLowerCase().trim();
                
                // Verificar cada titulo da lista na linha lida
                for (Livro l : livros.getObjetos()) {
                    String tituloLower = l.getTitulo().toLowerCase();
                    
                    // Contar ocorrencias exatas (ignorando case)
                    int count = contagemTitulos.getOrDefault(tituloLower, 0);
                    
                    // Verificar se o titulo aparece na linha
                    if (linhaLower.contains(tituloLower)) {
                        // Contar quantas vezes aparece na linha
                        int occurrences = 0;
                        String temp = linhaLower;
                        while (temp.contains(tituloLower)) {
                            occurrences++;
                            temp = temp.replaceFirst(tituloLower, "");
                        }
                        contagemTitulos.put(tituloLower, count + occurrences);
                    }
                }
            }

            // Criar lista de indice invertido e imprimir
            System.out.println("\n--- INDICE INVERTIDO ---");
            System.out.println("Titulo - Ocorrencias");
            for (Map.Entry<String, Integer> entry : contagemTitulos.entrySet()) {
                // Encontrar o titulo original (com capitalizacao correta)
                String tituloOriginal = entry.getKey();
                for (Livro l : livros.getObjetos()) {
                    if (l.getTitulo().toLowerCase().equals(entry.getKey())) {
                        tituloOriginal = l.getTitulo();
                        break;
                    }
                }
                System.out.println(tituloOriginal + " - " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
