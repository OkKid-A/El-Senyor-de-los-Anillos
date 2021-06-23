package src.Seres;

import java.util.Random;

public class Hobbit extends Heroe{

    public Hobbit(int armadura, String nombre){
        super(armadura,200,nombre);
    }

    @Override
    public void atacar(Ser ser){
        if (ser instanceof Trasgo){
            System.out.println("\nYa que " + super.getNombre() +  " se enfrenta a un trasgo, se acobarda y obtiene -5 puntos temporales de ataque");
            Random random = new Random();
            int ataque1 = random.nextInt(super.getAtaque()-5);
            System.out.println(super.getNombre()+"Tira los dados por " + ataque1);
            int ataque2 = random.nextInt(super.getAtaque()-5);
            System.out.println(super.getNombre()+"Tira los dados de nuevo por " + ataque2);
            int ataque = (ataque1>ataque2)?ataque1:ataque2;
            System.out.println(super.getNombre() + " ataca con " + ataque+" puntos de ataque");
            ser.recibirDano(calcularDano(ataque,ser.getArmadura()));
        } else {
            super.atacar(ser);
        }
    }
}
