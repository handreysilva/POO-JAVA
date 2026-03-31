package br.com.handrey.restaurante;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Usuario usuario = new Usuario("admin", "123");
        Carrinho carrinho = new Carrinho();

        boolean logado = false;

        // LOGIN
        while (!logado) {
            System.out.println("=== LOGIN ===");
            System.out.print("Usuário: ");
            String user = sc.nextLine();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (usuario.autenticar(user, senha)) {
                logado = true;
                System.out.println("Login realizado!");
            } else {
                System.out.println("Credenciais inválidas!");
            }
        }

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Incluir item");
            System.out.println("2 - Consultar carrinho");
            System.out.println("3 - Editar item");
            System.out.println("4 - Excluir item");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Cardápio:");
                    System.out.println("1 - Cachorro-Quente");
                    System.out.println("2 - Sushi");
                    System.out.println("3 - Pizza");
                    System.out.println("4 - Baguncinha");

                    int escolha = sc.nextInt();
                    sc.nextLine();

                    String nomeItem = "";

                    switch (escolha) {
                        case 1: nomeItem = "Cachorro-Quente"; break;
                        case 2: nomeItem = "Sushi"; break;
                        case 3: nomeItem = "Pizza"; break;
                        case 4: nomeItem = "Baguncinha"; break;
                        default: System.out.println("Opção inválida!");
                    }

                    if (!nomeItem.isEmpty()) {
                        carrinho.adicionar(new Item(nomeItem));
                    }
                    break;

                case 2:
                    carrinho.listar();
                    break;

                case 3:
                    carrinho.listar();
                    System.out.print("Digite o índice para editar: ");
                    int idxEdit = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo item: ");
                    String novo = sc.nextLine();

                    carrinho.editar(idxEdit, new Item(novo));
                    break;

                case 4:
                    carrinho.listar();
                    System.out.print("Digite o índice para remover: ");
                    int idxRem = sc.nextInt();
                    sc.nextLine();

                    carrinho.remover(idxRem);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}