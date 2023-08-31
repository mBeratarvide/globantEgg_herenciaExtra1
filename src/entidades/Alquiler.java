package entidades;

import enumerados.Amarre;

import java.time.LocalDate;
import java.util.Objects;

public class Alquiler<T extends Embarcacion> {
    private int du;
    private String nombre;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevolucion;
    private Amarre amarre;
    private T embarcacion;

    public Alquiler() { }

    public Alquiler(int du, String nombre, LocalDate fechaAlquiler, LocalDate fechaDevolucion, Amarre amarre, T embarcacion) {
        this.du = du;
        this.nombre = nombre;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.amarre = amarre;
        this.embarcacion = embarcacion;
    }

    public int getDu() {
        return du;
    }

    public void setDu(int du) {
        this.du = du;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Amarre getAmarre() {
        return amarre;
    }

    public void setAmarre(Amarre amarre) {
        this.amarre = amarre;
    }

    public T getEmbarcacion() {
        return embarcacion;
    }

    public void setEmbarcacion(T embarcacion) {
        this.embarcacion = embarcacion;
    }

    @Override
    public String toString() {
        return "\n\tD.U.: " + du +
               "\n\tnombre: " + nombre +
               "\n\tfechaAlquiler: " + fechaAlquiler +
               "\n\tfechaDevolucion: " + fechaDevolucion +
               "\n\tamarre: " + amarre +
               "\n\t" + embarcacion.getClass().getSimpleName() + ": " + embarcacion +
               "\n---";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alquiler alquiler = (Alquiler) o;
        return du == alquiler.du && Objects.equals(nombre, alquiler.nombre) && Objects.equals(fechaAlquiler, alquiler.fechaAlquiler) && Objects.equals(fechaDevolucion, alquiler.fechaDevolucion) && Objects.equals(amarre, alquiler.amarre) && Objects.equals(embarcacion, alquiler.embarcacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(du, nombre, fechaAlquiler, fechaDevolucion, amarre, embarcacion);
    }

}
