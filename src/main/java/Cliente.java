class Cliente extends Persona {
    private String origenCliente;
    private String destinoCliente;

    public Cliente(String nombre, String apellido, String identificacion, String origenCliente, String destinoCliente) {
        super(nombre, apellido, identificacion);
        this.origenCliente = origenCliente;
        this.destinoCliente = destinoCliente;
    }

    public String getOrigenCliente() {
        return origenCliente;
    }

    public String getDestinoCliente() {
        return destinoCliente;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " " + apellido + " - Identificacion: " + identificacion
                + " - Origen: " + origenCliente + " - Destino: " + destinoCliente);
    }
}