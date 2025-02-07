package atividade1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Mostrar Cardápio");
            System.out.println("2 - Calcular Preço Total");
            System.out.println("3 - Cadastrar Novo Produto");
            System.out.println("4 - Sair");
            System.out.print("Digite sua opção: ");
            
            try {
                escolha = entrada.nextInt();
                entrada.nextLine();

                switch (escolha) {
                    case 1:
                        CardapioService.exibirCardapio();
                        break;
                    case 2:
                        calcularPrecoTotal();
                        break;
                    case 3:
                        cadastrarNovoProduto();
                        break;
                    case 4:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido.");
                entrada.nextLine();
                escolha = 0; 
            }
        } while (escolha != 4);
    }

    private static void calcularPrecoTotal() {
        try {
            System.out.print("Digite o código do item: ");
            int id = entrada.nextInt();

            Item itemSelecionado = CardapioService.buscarItem(id);
            if (itemSelecionado == null) {
                System.out.println("Item não encontrado! Veja o cardápio abaixo:");
                CardapioService.exibirCardapio();
                return;
            }

            System.out.print("Digite a quantidade: ");
            int qtd = entrada.nextInt();

            if (qtd <= 0) {
                System.out.println("Erro: Quantidade deve ser maior que zero.");
                return;
            }

            double total = itemSelecionado.valor * qtd;
            System.out.printf("Total: R$ %.2f%n", total);
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Digite um número.");
            entrada.nextLine();
        }
    }

    private static void cadastrarNovoProduto() {
        System.out.print("Digite o nome do produto: ");
        String descricao = entrada.nextLine();
        
        double valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Digite o preço do produto: ");
                valor = entrada.nextDouble();
                entrada.nextLine(); 
                if (valor <= 0) {
                    System.out.println("Erro: O preço deve ser maior que zero.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um valor numérico válido.");
                entrada.nextLine(); 
            }
        }

        System.out.print("Digite o nome do arquivo da imagem (deve estar em C:/Users/budamentality/Pictures/): ");
        String imagem = "C:/Users/budamentality/Pictures/" + entrada.nextLine();

        CardapioService.adicionarItem(descricao, valor, imagem);
    }
}
