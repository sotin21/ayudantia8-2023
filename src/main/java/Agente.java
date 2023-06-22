class Agente extends Persona {
    public Agente(String nombre, String apellido, String identificacion) {
        super(nombre, apellido, identificacion);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Agente: " + nombre + " " + apellido + " - Identificacion: " + identificacion);
    }
}