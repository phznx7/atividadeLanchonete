package atividade1;

public class Item {
    String descricao;
    double valor;
    String imagem;

    public Item(String descricao, double valor, String imagem) {
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return String.format("%-20s R$ %6.2f | Imagem: %s", descricao, valor, imagem);
    }
}
