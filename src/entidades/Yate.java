package entidades;

import java.util.Objects;

public class Yate extends BarcoMotor {
    private int cantidadCamarotes;

    public Yate() {
    }

    public Yate(String matricula, int slora, int annoFabricacion) {
        super(matricula, slora, annoFabricacion);
    }

    public Yate(int caballosDeVapor) {
        super(caballosDeVapor);
    }

    public Yate(String matricula, int slora, int annoFabricacion, int caballosDeVapor) {
        super(matricula, slora, annoFabricacion, caballosDeVapor);
    }

    public Yate(int caballosDeVapor, int cantidadCamarotes) {
        super(caballosDeVapor);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    public Yate(String matricula, int slora, int annoFabricacion, int caballosDeVapor, int cantidadCamarotes) {
        super(matricula, slora, annoFabricacion, caballosDeVapor);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    public int getCantidadCamarotes() {
        return cantidadCamarotes;
    }

    public void setCantidadCamarotes(int cantidadCamarotes) {
        this.cantidadCamarotes = cantidadCamarotes;
    }

    @Override
    public String toString() {
        return "nro de camarotes: " + cantidadCamarotes +
                ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Yate yate = (Yate) o;
        return cantidadCamarotes == yate.cantidadCamarotes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cantidadCamarotes);
    }
}
