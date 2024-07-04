package moeda;

import java.util.ArrayList;

public class Cofrinho {

    private ArrayList<Moeda> listaMoedas; //lista para armazenar moedas no cofre

    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
    }

    public void remove(Moeda moeda, double valorParaRemover) {
        boolean moedaEncontrada = false;

        for (Moeda m : listaMoedas) {
            if (m.getClass().equals(moeda.getClass()) && m.valor >= valorParaRemover) {
                m.valor -= valorParaRemover;
                moedaEncontrada = true;
                if (m.valor == 0) {
                    listaMoedas.remove(m);
                }
                System.out.println("Valor removido: " + valorParaRemover + " de " + moeda.getClass().getSimpleName());
                break;
            }
        }

        if (!moedaEncontrada) {
            System.out.println("Moeda não encontrada ou valor insuficiente: " + moeda.getClass().getSimpleName() + " - " + valorParaRemover);
        }
    }

    // Método para listar todas as moedas no cofrinho
    public void listagemMoedas() {
        if (this.listaMoedas.isEmpty()) {
            System.out.println("Cofrinho vazio");
            return;
        }
        for (Moeda moeda : this.listaMoedas) {
            moeda.info();
        }
    }

    public double totalConvertido() {
        if (this.listaMoedas.isEmpty()) {
            return 0;
        }
        double valorAcumulado = 0;
        for (Moeda moeda : this.listaMoedas) {
            valorAcumulado += moeda.converter();
        }
        return valorAcumulado; //valor total convertido em R$
    }
}
