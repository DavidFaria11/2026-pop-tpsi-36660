public class BolaVoleibol extends Bola {

    public BolaVoleibol(String marca) {
        super(marca);
    }

    @Override
    public void lancar() {
        System.out.println("Bola de voleibol [" + getMarca() + "] foi lançada para o ar!");
    }

    @Override
    public void ressaltar() {
        System.out.println("Bola de voleibol [" + getMarca() + "] ressaltou na rede!");
    }
}