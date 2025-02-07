package atividade1;

import java.util.HashMap;
import java.util.Map;

public class CardapioService {
    private static Map<Integer, Item> cardapio = new HashMap<>();

    static {
        cardapio.put(1, new Item("Cachorro Quente", 4.00, "C:/Users/budamentality/Pictures/cachorro_quente.jpg"));
        cardapio.put(2, new Item("X-Salada", 4.50, "C:/Users/budamentality/Pictures/x_salada.jpg"));
        cardapio.put(3, new Item("X-Bacon", 5.00, "C:/Users/budamentality/Pictures/x_bacon.jpg"));
        cardapio.put(4, new Item("Torrada Simples", 2.00, "C:/Users/budamentality/Pictures/torrada.jpg"));
        cardapio.put(5, new Item("Refrigerante", 1.50, "C:/Users/budamentality/Pictures/refrigerante.jpg"));
    }

    public static void exibirCardapio() {
        System.out.println("\nCardápio:");
        for (Map.Entry<Integer, Item> entry : cardapio.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static Item buscarItem(int id) {
        return cardapio.get(id);
    }

    public static void adicionarItem(String descricao, double valor, String imagem) {
        int novoId = cardapio.size() + 1;
        cardapio.put(novoId, new Item(descricao, valor, imagem));
        System.out.println("Produto cadastrado com sucesso! ID: " + novoId);
    }
}
