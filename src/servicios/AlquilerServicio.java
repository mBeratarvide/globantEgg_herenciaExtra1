package servicios;

import entidades.*;
import enumerados.Amarre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlquilerServicio {
    private ArrayList<Alquiler<Embarcacion>> alquileres = new ArrayList<>();
    private EmbarcacionServicio es = new EmbarcacionServicio();

    public void menuPrincipal() {
        int opcion = 0;

        System.out.println("=== Alquil-a-boat systems presenta (?) ===");
        do {
            System.out.println("Menú de opciones");
            System.out.println("1 - Nuevo alquiler");
            System.out.println("5 - Finalizar alquiler");
            System.out.println("9 - Ver alquileres");
            System.out.println("0 - Salir");

            opcion = Lector.leer().nextInt();
            Lector.leer().nextLine();

            switch(opcion) {
                case 1:
                    nuevoAlquiler();
                    break;
                case 5:
                    finalizarAlquiler();
                    break;
                case 9:
                    verAlquileres();
                    break;
                case 0:
                    salir();
                    break;
                default:
                    System.out.println("¿O_ô?");
            }

        } while(opcion != 0);
    }

    private void salir() {
        System.out.println("Chau~");
    }

    private void nuevoAlquiler() {
        Alquiler<Embarcacion> a = llenarFormulario();
        if(a != null) {
            a.setAmarre(elegirEmbarcacion(a));
            alquileres.add(a);
        }
    }

    private void finalizarAlquiler() {
        if(alquileres.isEmpty()) {
            System.out.println("No hay alquileres todavía :(");
        } else {
            System.out.print("Documento? ");
            Alquiler<Embarcacion> a = encontrarAlquilerPorDocumento(Lector.leer().nextInt());
            Lector.leer().nextLine();

            if (a != null) {
                if(a.getFechaDevolucion() == null) {
                    a.setFechaDevolucion(LocalDate.now());
                    if (totalDiasDeAlquiler(a) < 1) {
                        System.out.println("Hay un problema con su registro, llame a sistemas (cuak)");
                    } else {
                        System.out.println("Debe abonar $" + calcularAlquiler(a));
                    }
                } else {
                    System.out.println("Este alquiler ya está finalizado :B");
                }
            }
        }
    }

    private void verAlquileres() {
        if(alquileres.isEmpty()) {
            System.out.println("No hay alquileres todavía :(");
        } else {
            System.out.println(alquileres);
        }
    }

    private Alquiler<Embarcacion> llenarFormulario() {
        Alquiler<Embarcacion> a = new Alquiler<>();

        System.out.print("Nro documento: ");
        a.setDu(Lector.leer().nextInt());
        Lector.leer().nextLine();

        Alquiler<Embarcacion> b = encontrarAlquilerPorDocumento(a.getDu());
        if(b != null && b.getFechaDevolucion() != null) {
            System.out.println("Este documento tiene un alquiler pendiente de finalización :B");
            return null;
        }

        System.out.print("Nombre: ");
        a.setNombre(Lector.leer().nextLine());

        System.out.println("Fecha del alquiler (YYYY-MM-DD): ");
        a.setFechaAlquiler(LocalDate.parse(Lector.leer().nextLine()));

        return a;
    }

    private Amarre elegirEmbarcacion(Alquiler<Embarcacion> a) {
        System.out.println("Elija el tipo de embarcación:\n1-Barquito\n2-Velero\n3-Barco a motor\n4-Yate");
        int opcion = 0;
        do {
            opcion = Lector.leer().nextInt();
            Lector.leer().nextLine();
        } while(opcion < 1 || opcion > 4);

        ArrayList<Amarre> amarresDisponibles = new ArrayList<>();
        Collections.addAll(amarresDisponibles, Amarre.values());
        Random rnd = new Random();
        Amarre[] amarres = new Amarre[3];
        for(int i = 0; i < amarres.length; i++) {
            int indice = rnd.nextInt(amarresDisponibles.size());
            amarres[i] = amarresDisponibles.get(indice);
            amarresDisponibles.remove(indice);
        }

        ArrayList<Embarcacion> barquitos = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            switch(opcion) {
                case 1:
                    barquitos.add(es.generarUnBarcoAleatorio());
                    break;
                case 2:
                    barquitos.add(es.generarUnVeleroAleatorio());
                    break;
                case 3:
                    barquitos.add(es.generarUnBarcoMotorAleatorio());
                    break;
                case 4:
                    barquitos.add(es.generarUnYateAleatorio());
                    break;
            }
        }

        // mostrar disponibles
        System.out.println("Estas son las embarcaciones disponibles:");
        for(int i = 0; i < amarres.length; i++) {
            System.out.print((i+1) + ") " + barquitos.get(i).getClass().getSimpleName() + " en el amarre " + amarres[i] + ", ");
            System.out.println(barquitos.get(i));
        }

        // elegir el barquito
        System.out.println("Cuál vas a querer?");
        opcion = 0;
        do {
            opcion = Lector.leer().nextInt();
            Lector.leer().nextLine();
        } while(opcion < 1 || opcion > 3);

        a.setEmbarcacion(barquitos.get(opcion - 1));

        return amarres[opcion - 1];
    }

    private double calcularAlquiler(Alquiler<Embarcacion> a) {
        System.out.println("=== Detalle ===");
        // cálculo básico
        long dias = totalDiasDeAlquiler(a);
        System.out.print(dias + " días de alquiler por ");
        double eslora = a.getEmbarcacion().getEslora();
        System.out.println(a.getEmbarcacion());
        double total = eslora * dias;

        // cálculo especial
        if(a.getEmbarcacion() instanceof Yate) {
            total = total + ((Yate) a.getEmbarcacion()).getCaballosDeVapor() + ((Yate) a.getEmbarcacion()).getCantidadCamarotes();
        } else if(a.getEmbarcacion() instanceof BarcoMotor) {
            total = total + ((BarcoMotor) a.getEmbarcacion()).getCaballosDeVapor();
        } else if(a.getEmbarcacion() instanceof Velero) {
            total = total + ((Velero) a.getEmbarcacion()).getCantidadMastiles();
        }

        return total;
    }

    private long totalDiasDeAlquiler(Alquiler<Embarcacion> a) {
        return ChronoUnit.DAYS.between(a.getFechaAlquiler(), a.getFechaDevolucion());
    }

    private Alquiler<Embarcacion> encontrarAlquilerPorDocumento(int du) {
        for(Alquiler<Embarcacion> a : alquileres) {
            if(a.getDu() == du) {
                return a;
            }
        }
        System.out.println("Tipeaste bien? :S");
        return null;
    }

}
