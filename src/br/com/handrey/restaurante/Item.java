package br.com.handrey.restaurante;

public class Item {

    private String nome;

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void exibir() {
        System.out.println("Item: " + nome);
    }
}