import edu.misena.facturaJava.model.ItemFactura;
import edu.misena.facturaJava.model.Factura;
import edu.misena.facturaJava.model.Producto;
import edu.misena.facturaJava.model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("88889-9");
        cliente.setNombre("Luis");

        Scanner s = new Scanner(System.in);

        System.out.print("Ingrese una descripción de la factura: ");
        String descripcion = s.nextLine();
        Factura factura = new Factura(descripcion, cliente);

        System.out.println();

        Producto producto;

        System.out.println();

        for(int i = 0; i<2; i++){
            producto = new Producto();
            System.out.print("Ingrese producto nº " + producto.getCodigo() +(i + 1) + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            int cantidad = s.nextInt();

            factura.addItemFactura(new ItemFactura(producto, cantidad));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
    }
}