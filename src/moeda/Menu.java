package moeda;

import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private Cofrinho cofrinho;

    public Menu() {
        sc = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    // Método que exibe o menu principal
    public void mostrarMenuPrincipal() {
        System.out.println("COFRINHO:");
        System.out.println("1- Adicionar moeda:");
        System.out.println("2- Remover moeda");
        System.out.println("3- Listar moedas");
        System.out.println("4- Calcular valor total convertido para real");
        System.out.println("0- Encerrar");

        String opcaoSelec = sc.next();

        switch (opcaoSelec) {
            case "0":
                System.out.println("Sistema encerrado!");
                break;

            case "1":
                exibirMenuAddMoedas();
                mostrarMenuPrincipal();
                break;

            case "2":
                exibirRemoveMoedas();
                mostrarMenuPrincipal();
                break;

            case "3":
                cofrinho.listagemMoedas();
                mostrarMenuPrincipal();
                break;

            case "4":
                double valorTotalConvertido = cofrinho.totalConvertido();
                System.out.println("Valor total convertido para real: " + valorTotalConvertido);
                mostrarMenuPrincipal();
                break;

            default:
                System.out.println("Opção inválida.");
                mostrarMenuPrincipal();
                break;
        }
    }

    // Método que exibe o menu para adicionar moedas
    private void exibirMenuAddMoedas() {
        System.out.println("Escolha a moeda:");
        System.out.println("1- Real");
        System.out.println("2- Dólar");
        System.out.println("3- Euro");

        int tipoMoeda = sc.nextInt();

        System.out.println("Digite o valor:");

        String valorMoeda = sc.next();
        valorMoeda = valorMoeda.replace(",", ".");
        double valorMoedaFinal = Double.parseDouble(valorMoeda);

        Moeda moeda = null;

        if (tipoMoeda == 1) {
            moeda = new Real(valorMoedaFinal);
        } else if (tipoMoeda == 2) {
            moeda = new Dolar(valorMoedaFinal);
        } else if (tipoMoeda == 3) {
            moeda = new Euro(valorMoedaFinal);
        } else {
            System.out.println("Digite uma opção válida");
            mostrarMenuPrincipal();
        }

        cofrinho.adicionar(moeda);
        System.out.println("Moeda adicionada!");
    }

    // Método que exibe o menu para remover moedas
    private void exibirRemoveMoedas() {
        System.out.println("Escolha a moeda:");
        System.out.println("1- Real");
        System.out.println("2- Dólar");
        System.out.println("3- Euro");

        int tipoMoeda = sc.nextInt();

        System.out.println("Digite o valor a ser removido:");

        String valorMoeda = sc.next();
        valorMoeda = valorMoeda.replace(",", ".");
        double valorMoedaFinal = Double.parseDouble(valorMoeda);

        Moeda moeda = null;

        if (tipoMoeda == 1) {
            moeda = new Real(valorMoedaFinal);
        } else if (tipoMoeda == 2) {
            moeda = new Dolar(valorMoedaFinal);
        } else if (tipoMoeda == 3) {
            moeda = new Euro(valorMoedaFinal);
        } else {
            System.out.println("Digite uma opção válida");
            mostrarMenuPrincipal();
        }

        cofrinho.remove(moeda, valorMoedaFinal);
    }
}
