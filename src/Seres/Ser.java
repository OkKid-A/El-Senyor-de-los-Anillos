package src.Seres;

import java.util.Random;

public class Ser{

    private int armadura;
    private int hp;
    private String nombre;
    private int ataque;
    private boolean muerto;

    public Ser(int armadura, int hp, String nombre, int ataque){
        this.armadura = armadura;
        this.hp = hp;
        this.nombre = nombre;
        this.ataque = ataque;
        muerto = false;
    }

    public void atacar(Ser ser){
        Random random = new Random();
        int ataque = random.nextInt(this.ataque);
        System.out.println("\n"+this.nombre + " ataca con " + ataque+" puntos de ataque");
        ser.recibirDano(calcularDano(ataque,ser.getArmadura()));
    }

    public int getArmadura() {
        return armadura;
    }

    public int calcularDano(int ataque, int armadura){
        int dano = ataque - armadura;
        if (dano > 0) {
            this.hp -= dano;
            System.out.println("Ante "+armadura +" puntos de armadura se han hecho " + dano + " puntos de daño");
            return dano;
        } else {
            System.out.println("Ante " + armadura + " puntos de armadura no se ha podido hacer daño");
            return 0;
        }
    }

    public void recibirDano(int dano){
        this.hp-=dano;
        if (hp<=0){
            System.out.println(this.nombre+" ha muerto en combate\n");
            this.hp = 0;
            this.muerto = true;
        } else {
            System.out.println(this.nombre + " ha quedado con " + hp + " de vida\n");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getHp() {
        return hp;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
