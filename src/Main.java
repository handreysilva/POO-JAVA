import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 2));
        pets.add(new Pet("Luna", 4));
        pets.add(new Pet("Thor", 1));
        pets.add(new Pet("Mel", 3));
        pets.add(new Pet("Bob", 5));
        pets.add(new Pet("Nick", 6));
        pets.add(new Pet("Bolt", 2));
        boolean sair = false;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("\n=======================");
            System.out.println("1 - Cadastrar Pet");
            System.out.println("2 - Exibir Pets");
            System.out.println("3 - Sair");
            System.out.println("4 - Remover Pet");
            System.out.println("5 - Buscar Pet");
            System.out.println("6 - Editar Pet");
            System.out.println("7 - Ordenar por idade");
            System.out.println("8 - Pet mais velho");
            System.out.println("=======================");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {

                case 1:
                    cadastrarPet(pets, sc);
                    break;

                case 2:
                    exibirPets(pets);
                    break;

                case 3:
                    sair = true;
                    break;

                case 4:
                    removerPet(pets, sc);
                    break;

                case 5:
                    buscarPet(pets, sc);
                    break;

                case 6:
                    editarPet(pets, sc);
                    break;

                case 7:
                    ordenarPorIdade(pets);
                    break;

                case 8:
                    petMaisVelho(pets);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (!sair);

        sc.close();
    }

    public static void cadastrarPet(List<Pet> pets, Scanner sc) {

        System.out.print("Nome do pet: ");
        String nome = sc.nextLine();

        System.out.print("Idade do pet: ");
        int idade = sc.nextInt();
        sc.nextLine();

        pets.add(new Pet(nome, idade));
        pets.add(new Pet("Rex", 2));
        pets.add(new Pet("Luna", 4));
        pets.add(new Pet("Thor", 1));
        pets.add(new Pet("Mel", 3));
        pets.add(new Pet("Bob", 5));
        pets.add(new Pet("Nick", 6));
        pets.add(new Pet("Bolt", 2));

        System.out.println("Pet cadastrado!");
    }

    public static void exibirPets(List<Pet> pets) {

        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }

        int contador = 1;

        for (Pet pet : pets) {

            System.out.println("Pet #" + contador);
            System.out.println("Nome: " + pet.getNome());
            System.out.println("Idade: " + pet.getIdade());
            System.out.println("------------------");

            contador++;
        }
    }

    public static void removerPet(List<Pet> pets, Scanner sc) {

        System.out.print("Nome do pet para remover: ");
        String nome = sc.nextLine();

        for (Pet pet : pets) {

            if (pet.getNome().equalsIgnoreCase(nome)) {

                pets.remove(pet);
                System.out.println("Pet removido!");
                return;
            }
        }

        System.out.println("Pet não encontrado.");
    }

    public static void buscarPet(List<Pet> pets, Scanner sc) {

        System.out.print("Nome do pet: ");
        String nome = sc.nextLine();

        for (Pet pet : pets) {

            if (pet.getNome().equalsIgnoreCase(nome)) {

                System.out.println("Nome: " + pet.getNome());
                System.out.println("Idade: " + pet.getIdade());
                return;
            }
        }

        System.out.println("Pet não encontrado.");
    }

    public static void editarPet(List<Pet> pets, Scanner sc) {

        System.out.print("Nome do pet que deseja editar: ");
        String nome = sc.nextLine();

        for (Pet pet : pets) {

            if (pet.getNome().equalsIgnoreCase(nome)) {

                System.out.print("Novo nome: ");
                String novoNome = sc.nextLine();

                System.out.print("Nova idade: ");
                int novaIdade = sc.nextInt();
                sc.nextLine();

                pet.setNome(novoNome);
                pet.setIdade(novaIdade);

                System.out.println("Pet atualizado!");
                return;
            }
        }

        System.out.println("Pet não encontrado.");
    }

    // 🚀 ORDENAR PETS POR IDADE
    public static void ordenarPorIdade(List<Pet> pets) {

        pets.sort(Comparator.comparingInt(Pet::getIdade));

        System.out.println("Pets ordenados por idade!");
    }

    // 🚀 MOSTRAR PET MAIS VELHO
    public static void petMaisVelho(List<Pet> pets) {

        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }

        Pet maisVelho = pets.get(0);

        for (Pet pet : pets) {

            if (pet.getIdade() > maisVelho.getIdade()) {
                maisVelho = pet;
            }
        }

        System.out.println("Pet mais velho:");
        System.out.println("Nome: " + maisVelho.getNome());
        System.out.println("Idade: " + maisVelho.getIdade());
    }
}