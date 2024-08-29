package edu.misena.facturaJava.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceActual = 0;

    public static final int MAX_ITEMS = 100;
    private static int ultimoFolio = 0;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fecha = new Date();
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio = ultimoFolio++;

    }

    public void addItemFactura(ItemFactura item) {
        if (indiceActual < MAX_ITEMS) {
            items[indiceActual] = item;
            indiceActual++;
        } else {
            System.out.println("No se pueden añadir más ítems. Se ha alcanzado el límite máximo.");
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\tCant.\t$\tTotal\n");

        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(String.format("%.2f", calcularTotal()));

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }



}
