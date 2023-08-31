package entidades;

import java.util.Objects;

public class Embarcacion {
    private String matricula;
    private int eslora;
    private int annoFabricacion;

    public Embarcacion() {
    }

    public Embarcacion(String matricula, int eslora, int annoFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.annoFabricacion = annoFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public int getAnnoFabricacion() {
        return annoFabricacion;
    }

    public void setAnnoFabricacion(int annoFabricacion) {
        this.annoFabricacion = annoFabricacion;
    }

    @Override
    public String toString() {
        return "matrícula: '" + matricula + '\'' +
                ", eslora: " + eslora + "m" +
                ", fabricado en " + annoFabricacion +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Embarcacion that = (Embarcacion) o;
        return Double.compare(eslora, that.eslora) == 0 && annoFabricacion == that.annoFabricacion && Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, eslora, annoFabricacion);
    }

}
