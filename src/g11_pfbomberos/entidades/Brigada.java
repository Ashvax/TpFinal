
package g11_pfbomberos.entidades;

public class Brigada {
    private int codBrigada;
    private String brigadaName;
    private String especialidad;
    private boolean libre;
    private int nroCuartel;
    private Boolean disponibilidad;
    private String nombre_cuartel;

    public Brigada() {
    }

    public Brigada(String brigadaName, String especialidad, boolean libre, int nroCuartel, Boolean disponibilidad,String nombre_cuartel) {
        this.brigadaName = brigadaName;
        this.especialidad = especialidad;
        this.libre = libre;
        this.nroCuartel = nroCuartel;
        this.disponibilidad = disponibilidad;
        this.nombre_cuartel = nombre_cuartel;
    }

    public Brigada(int codBrigada, String brigadaName, String especialidad, boolean libre, int nroCuartel, Boolean disponibilidad,String nombre_cuartel) {
        this.codBrigada = codBrigada;
        this.brigadaName = brigadaName;
        this.especialidad = especialidad;
        this.libre = libre;
        this.nroCuartel = nroCuartel;
        this.disponibilidad = disponibilidad;
        this.nombre_cuartel = nombre_cuartel;
    }

    public int getCodBrigada() {
        return codBrigada;
    }

    public void setCodBrigada(int codBrigada) {
        this.codBrigada = codBrigada;
    }

    public String getNombreBr() {
        return brigadaName;
    }

    public void setNombreBr(String nombreBr) {
        this.brigadaName = brigadaName;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getNroCuartel() {
        return nroCuartel;
    }

    public void setNroCuartel(int nroCuartel) {
        this.nroCuartel = nroCuartel;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNombre_cuartel() {
        return nombre_cuartel;
    }

    public void setNombre_cuartel(String nombre_cuartel) {
        this.nombre_cuartel = nombre_cuartel;
    }
   
    @Override
    public String toString() {
        return "Brigada{" + "codBrigada=" + codBrigada + ", nombreBr=" + brigadaName + ", especialidad=" + especialidad + ", libre=" + libre + ", nroCuartel=" + nroCuartel + '}';
    }   
}
