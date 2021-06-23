package src.Seres;

import java.util.Random;

public class Orcos extends Bestia{

    public Orcos(int armadura, String nombre){
        super(armadura,300,nombre);
    }

    @Override
    public void atacar(Ser ser){
        System.out.println("\nDebido a su fuerza desmesurada este orco obtiene un %10 de penetracion de armadura");
        Random random = new Random();
        int ataque = random.nextInt(super.getAtaque());
        System.out.println(super.getNombre() + " ataca con " + ataque+" puntos de ataque");
        ser.recibirDano(calcularDano(ataque,(int)(0.9*ser.getArmadura())));
    }
}
