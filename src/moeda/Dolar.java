package moeda;

public class Dolar extends Moeda {

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Dolar - " + valor);
    }
//valor do dolar em 04/07/24
    @Override
    public double converter() {
        return this.valor * 5.50;
    }
}
