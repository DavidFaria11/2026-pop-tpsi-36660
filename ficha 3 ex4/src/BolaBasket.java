public class BolaBasket extends Bola {

    public BolaBasket(String marca) {
        super(marca);
    }

    @Override
    public void lancar() {
        System.out.println("Bola de basket [" + getMarca() + "] foi lançada para o cesto!");
    }

    @Override
    public void ressaltar() {
        System.out.println("Bola de basket [" + getMarca() + "] ressaltou no chão!");
    }
}