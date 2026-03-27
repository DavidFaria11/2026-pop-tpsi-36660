public class Main {
    public static void main(String[] args) {


        System.out.println("========== VENTOINHA ==========");
        Ventoinha v = new Ventoinha();
        System.out.println(v);
        v.ligar();
        v.setVelocidadeVentoinha(Velocidade.ALTA);
        System.out.println("\nApós ligar e definir velocidade ALTA:");
        System.out.println(v);
        v.desligar();
        System.out.println("\nApós desligar:");
        System.out.println(v);


        System.out.println("\n========== AQUECEDOR ==========");
        Aquecedor a = new Aquecedor();
        System.out.println(a);
        a.ligar();
        a.ligarAquecimento();
        a.setPotenciaResistencia(Velocidade.MEDIA);
        System.out.println("\nApós ligar ventoinha, ligar aquecimento e definir potência MEDIA:");
        System.out.println(a);
        a.desligarAquecimento();
        System.out.println("\nApós desligar aquecimento:");
        System.out.println(a);


        System.out.println("\n========== CLIMATIZADOR ==========");
        Climatizador c = new Climatizador();
        System.out.println(c);

        c.ligar();
        c.ligarAquecimento();
        c.setPotenciaResistencia(Velocidade.ALTA);
        System.out.println("\nApós ligar ventoinha e aquecimento (ALTA):");
        System.out.println(c);

        c.ligarRefrigeracao();
        c.setPotenciaRefrigerador(Velocidade.MEDIA);
        System.out.println("\nApós ligar refrigeração (desliga aquecimento automaticamente):");
        System.out.println(c);

        c.desligarRefrigeracao();
        System.out.println("\nApós desligar refrigeração:");
        System.out.println(c);
    }
}