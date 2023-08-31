package servicios;

import entidades.BarcoMotor;
import entidades.Embarcacion;
import entidades.Velero;
import entidades.Yate;

import java.util.Random;

public class EmbarcacionServicio {
    private Random rnd = new Random();

    public Embarcacion generarUnBarcoAleatorio() {
        return new Embarcacion(generadorDeMatriculas(), rnd.nextInt(40)+10, rnd.nextInt(223)+1800);
    }

    public Velero generarUnVeleroAleatorio() {
        return new Velero(generadorDeMatriculas(), rnd.nextInt(60)+10, rnd.nextInt(223)+1800, rnd.nextInt(3)+1);
    }

    public BarcoMotor generarUnBarcoMotorAleatorio() {
        return new BarcoMotor(generadorDeMatriculas(), rnd.nextInt(80)+10, rnd.nextInt(223)+1800, rnd.nextInt(800)+200);
    }

    public Yate generarUnYateAleatorio() {
        return new Yate(generadorDeMatriculas(), rnd.nextInt(100)+10, rnd.nextInt(23)+2000, rnd.nextInt(800)+200, rnd.nextInt(5)+1);
    }

    private String generadorDeMatriculas() {
        // AZ-1-123-12
        char primeraLetra = (char) (rnd.nextInt(26)+'A');
        char segundaLetra = (char) (rnd.nextInt(26)+'A');
        return "" + primeraLetra + segundaLetra + "-" + rnd.nextInt(10) + "-" + rnd.nextInt(1000) + "-" + rnd.nextInt(100);
    }
}
