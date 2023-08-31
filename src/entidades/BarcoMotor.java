package entidades;

import java.util.Objects;

public class BarcoMotor extends Embarcacion {
    private int caballosDeVapor;

    public BarcoMotor() {
    }

    public BarcoMotor(String matricula, int slora, int annoFabricacion) {
        super(matricula, slora, annoFabricacion);
    }

    public BarcoMotor(int caballosDeVapor) {
        this.caballosDeVapor = caballosDeVapor;
    }

    public BarcoMotor(String matricula, int slora, int annoFabricacion, int caballosDeVapor) {
        super(matricula, slora, annoFabricacion);
        this.caballosDeVapor = caballosDeVapor;
    }

    public int getCaballosDeVapor() {
        return caballosDeVapor;
    }

    public void setCaballosDeVapor(int caballosDeVapor) {
        this.caballosDeVapor = caballosDeVapor;
    }

    @Override
    public String toString() {
        return "HP: " + caballosDeVapor +
                ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BarcoMotor that = (BarcoMotor) o;
        return caballosDeVapor == that.caballosDeVapor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caballosDeVapor);
    }
}
