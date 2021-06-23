package src.Seres;

import java.util.Random;

public class Heroe extends Ser{

    public Heroe(int armadura, int hp, String nombre){
        super(armadura,hp,nombre,100);
    }

    @Override
    public void atacar(Ser ser){
        Random random = new Random();
        int ataque1 = random.nextInt(super.getAtaque());
        System.out.println("\n"+super.getNombre()+" Tira los dados por " + ataque1);
        int ataque2 = random.nextInt(super.getAtaque());
        System.out.println(super.getNombre()+" Tira los dados de nuevo por " + ataque2);
        int ataque = (ataque1>ataque2)?ataque1:ataque2;
        System.out.println(super.getNombre() + " ataca con " + ataque+" puntos de ataque");
        ser.recibirDano(calcularDano(ataque,ser.getArmadura()));
    }
}
