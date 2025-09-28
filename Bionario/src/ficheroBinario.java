import java.io.*;
public class ficheroBinario {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Producto uno = new Producto("galletas", 10);
        Producto dos = new Producto("leche", 2);
        //Escritura de fichero Binario
        ObjectOutputStream serializador = null;
        serializador = new ObjectOutputStream(new FileOutputStream("archivo.dat"));
        serializador.writeObject(uno);
        serializador.writeObject(dos);
        serializador.close();
        //Leer de fichero Binario
        FileInputStream filein = new FileInputStream(new File("archivo.dat"));
        ObjectInputStream deserializador = new ObjectInputStream(filein);
        Producto p1 = null;
        Producto p2 = null;
        p1 = (Producto)deserializador.readObject();
        p2 = (Producto)deserializador.readObject();
        System.out.println("Producto: "+p1.getNombre());
        System.out.println("Precio: "+p2.getPrecio());

    }
}