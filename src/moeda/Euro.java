package moeda;

public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Euro - " + valor);
    }
    //valor do euro em 04/07/24
    @Override
    public double converter() {
        return this.valor * 5.93;
    }
}
