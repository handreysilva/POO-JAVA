package br.com.handrey.restaurante;

import java.util.ArrayList;

public class Carrinho {

    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
        System.out.println("Item adicionado!");
    }

    public void listar() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            for (int i = 0; i < itens.size(); i++) {
                System.out.println(i + " - " + itens.get(i).getNome());
            }
        }
    }

    public void remover(int index) {
        if (index >= 0 && index < itens.size()) {
            itens.remove(index);
            System.out.println("Item removido!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void editar(int index, Item novo) {
        if (index >= 0 && index < itens.size()) {
            itens.set(index, novo);
            System.out.println("Item atualizado!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}