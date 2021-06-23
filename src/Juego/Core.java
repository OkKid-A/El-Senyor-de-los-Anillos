package src.Juego;

import src.Seres.*;

import java.util.Random;

public class Core {

    public static final String[] NOMBRES_BESTIAS = new String[]{"Lifdaugh", "Drozru", "Cruldeth", "Kuzigh", "Logdi", "Uzzedh", "Augzor", "Odbith", "Auzraf", "Aurzo"};
    public static final String[] NOMBRES_HEROES = new String[]{"Arod", "Banazir", "Bilbo", "Pin", "Legolas", "Gimli", "Eomer", "Faramir", "Celeborn", "Theoden"};
    private Bestia[] ejercitoBestias;
    private Heroe[] ejercitoHeroes;
    private Random random;
    private int contadorBestias;
    private int contadorHeroes;

    public Core() {
        random = new Random();
        ejercitoBestias = new Bestia[10];
        ejercitoHeroes = new Heroe[10];
        run();
    }

    private void createEjercitos() {
        contadorBestias = 0;
        contadorHeroes = 0;
        for (int k = 0; k < 10; k++) {
            ejercitoBestias[k] = escogerBestia();
            ejercitoHeroes[k] = escogerHeroe();
        }
    }

    private void run() {
        createEjercitos();
        System.out.println("La batalla ha comenzado...");
        while (contadorHeroes > 0 && contadorBestias > 0) {
            mostrarEncuentros();
            int cont = (contadorBestias > contadorHeroes) ? contadorBestias : contadorHeroes;
            for (int k = 0; k < cont; k++) {
                if (!(ejercitoBestias[k].isMuerto()) && !(ejercitoHeroes[k].isMuerto())) {
                    ejercitoHeroes[k].atacar(ejercitoBestias[k]);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!(ejercitoBestias[k].isMuerto())) {
                        ejercitoBestias[k].atacar(ejercitoHeroes[k]);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            contarCaidos();
        }
        String ganadores = ((contadorBestias > contadorHeroes) ? "Bestias" : "Heroes");
        System.out.println("\n\n            La batalla ha terminado\n!!!!!!!!!!!El ejercito de " + ganadores + " ha ganado!!!!!!!!!!!!!");
    }

    public void mostrarEncuentros() {
        System.out.println("\nInicio de Ronda\n");
        int cont = (contadorBestias < contadorHeroes) ? contadorBestias : contadorHeroes;
        for (int k = 0; k < cont; k++) {
            System.out.println(ejercitoHeroes[k].getNombre() + " ( Vida = " + ejercitoHeroes[k].getHp() + ") Vs " + ejercitoBestias[k].getNombre() + " ( Vida = " + ejercitoBestias[k].getHp() + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Bestia escogerBestia() {
        int ran = random.nextInt(1);
        switch (ran) {
            case 0:
                contadorBestias++;
                return new Orcos((random.nextInt(21) + 30), NOMBRES_BESTIAS[contadorBestias - 1]);
            case 1:
                contadorBestias++;
                return new Trasgo((random.nextInt(21) + 30), NOMBRES_BESTIAS[contadorBestias - 1]);
            default:
                return null;
        }
    }

    private void contarCaidos() {
        for (int k = 0; k < contadorHeroes; k++) {
            if (ejercitoHeroes[k].isMuerto()) {
                contadorHeroes--;
                for (int i = 0; i < contadorHeroes; i++) {
                    for (int j = i+1;j < contadorHeroes;j++) {
                        if (ejercitoHeroes[j-1].isMuerto()&&!(ejercitoHeroes[j].isMuerto())) {
                            Heroe temp = ejercitoHeroes[j];
                            ejercitoHeroes[j] = ejercitoHeroes[j - 1];
                            ejercitoHeroes[j - 1] = temp;
                        }
                    }
                }
            }
        }
        for (int j = 0; j < contadorBestias; j++) {
            if (ejercitoBestias[j].isMuerto()) {
                contadorBestias--;
                for (int i = 0; i < contadorBestias; i++) {
                    for (int k = i + 1; k < contadorBestias; k++) {
                        if (!(ejercitoBestias[k].isMuerto())&&ejercitoBestias[k-1].isMuerto()) {
                            Bestia temp = ejercitoBestias[k];
                            ejercitoBestias[k] = ejercitoBestias[k - 1];
                            ejercitoBestias[k - 1] = temp;
                        }
                    }
                }
            }
        }

    }

    private Heroe escogerHeroe() {
        int ran = random.nextInt(2);
        contadorHeroes++;
        switch (ran) {
            case 0:
                return new Elfo((random.nextInt(21) + 50), NOMBRES_HEROES[contadorHeroes - 1]);
            case 1:
                return new Humanos((random.nextInt(21) + 50), NOMBRES_HEROES[contadorHeroes - 1]);
            case 2:
                return new Hobbit((random.nextInt(21) + 50), NOMBRES_HEROES[contadorHeroes - 1]);
            default:
                return null;
        }
    }
}
