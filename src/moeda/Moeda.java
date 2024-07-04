package moeda;

public abstract class Moeda {
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    // Método para exibir e converter o valor da moeda para reais
    public abstract void info();
    public abstract double converter();

    public double getValor() {
        return this.valor;
    }
}
