package entidades;

import java.util.Objects;

public class Velero extends Embarcacion {
    private int cantidadMastiles;

    public Velero() {
    }

    public Velero(String matricula, int slora, int annoFabricacion) {
        super(matricula, slora, annoFabricacion);
    }

    public Velero(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }

    public Velero(String matricula, int slora, int annoFabricacion, int cantidadMastiles) {
        super(matricula, slora, annoFabricacion);
        this.cantidadMastiles = cantidadMastiles;
    }

    public int getCantidadMastiles() {
        return cantidadMastiles;
    }

    public void setCantidadMastiles(int cantidadMastiles) {
        this.cantidadMastiles = cantidadMastiles;
    }

    @Override
    public String toString() {
        return "nro de mástiles: " + cantidadMastiles +
                ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Velero velero = (Velero) o;
        return cantidadMastiles == velero.cantidadMastiles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cantidadMastiles);
    }
}
