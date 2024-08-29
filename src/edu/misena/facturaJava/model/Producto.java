package edu.misena.facturaJava.model;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;


    private static int ultimoCodigo = 0;

    public Producto(){

        this.codigo = generarCodigoUnico();
        this.nombre = nombre;
        this.precio = precio;
    }



    private String generarCodigoUnico(){

        ultimoCodigo++;

        return String.format("P%05d", ultimoCodigo);
    }



    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo +
                "\t" + nombre +
                "\t" + precio;
    }

}
