public class Main {
    public static void main(String[] args) {


        System.out.println("=== Pedra ===");
        Pedra pedra = new Pedra();
        pedra.lancar();


        System.out.println("\n=== Bola de Basket ===");
        BolaBasket basket = new BolaBasket("Spalding");
        basket.lancar();
        basket.ressaltar();


        System.out.println("\n=== Bola de Voleibol ===");
        BolaVoleibol voleibol = new BolaVoleibol("Mikasa");
        voleibol.lancar();
        voleibol.ressaltar();


        System.out.println("\n=== Polimorfismo com Lancavel ===");
        Lancavel[] lancaveis = { new Pedra(), new BolaBasket("Nike"), new BolaVoleibol("Mikasa") };
        for (Lancavel l : lancaveis) {
            l.lancar();
        }


        System.out.println("\n=== Polimorfismo com Bola ===");
        Bola[] bolas = { new BolaBasket("Spalding"), new BolaVoleibol("Mikasa") };
        for (Bola b : bolas) {
            System.out.println("Marca: " + b.getMarca());
            b.lancar();
            b.ressaltar();
            System.out.println();
        }
    }
}