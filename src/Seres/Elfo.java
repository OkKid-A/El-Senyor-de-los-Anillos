package src.Seres;

import java.util.Random;

public class Elfo extends Heroe{

    public Elfo(int armadura, String nombre){
        super(armadura,250,nombre);
    }

    @Override
    public void atacar(Ser ser){
        if (ser instanceof Orcos){
            System.out.println("\nYa que " + super.getNombre() +  " se enfrenta a un orco obtiene 10 puntos extra de ataque");
            Random random = new Random();
            int ataque1 = random.nextInt(super.getAtaque()+10);
            System.out.println(super.getNombre()+" Tira los dados por " + ataque1);
            int ataque2 = random.nextInt(super.getAtaque()+10);
            System.out.println(super.getNombre()+" Tira los dados de nuevo por " + ataque2);
            int ataque = (ataque1>ataque2)?ataque1:ataque2;
            System.out.println(super.getNombre() + " ataca con " + ataque+" puntos de ataque");
            ser.recibirDano(calcularDano(ataque,ser.getArmadura()));
        } else {
            super.atacar(ser);
        }
    }
}
