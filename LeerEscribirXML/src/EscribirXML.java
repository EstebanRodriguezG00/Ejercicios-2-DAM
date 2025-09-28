import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class EscribirXML {
    public static void main(String[] args) throws Exception {

        // 1. Incorporo productos a lista de productos java
        Producto uno = new Producto("leche", 1.50f);
        Producto dos = new Producto("galletas", 5.25f);

        mercado listaProductos = new mercado();
        listaProductos.insertarProducto(uno);
        listaProductos.insertarProducto(dos);

        // 2. Creación del Documento XML en Memoria
        // Se crea una instancia de DocumentBuilderFactory para poder crear un DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Se crea un DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Se crea un Document en blanco
        Document documento = builder.newDocument();

        // 3. Construcción del Árbol DOM (La parte que ya tenías)
        Element raiz = documento.createElement("productos");
        documento.appendChild(raiz); // Se añade el elemento raíz al documento

        for (Producto producto : listaProductos.getListaproductos()) {
            // Elemento <producto>
            Element nodoProducto = documento.createElement("producto");
            raiz.appendChild(nodoProducto);

            // Elemento <nombre>
            Element nodoDatosNombre = documento.createElement("nombre");
            nodoProducto.appendChild(nodoDatosNombre);
            Text textoNombre = documento.createTextNode(producto.getNombre());
            nodoDatosNombre.appendChild(textoNombre);

            // Elemento <precio>
            Element nodoDatosPrecio = documento.createElement("precio");
            nodoProducto.appendChild(nodoDatosPrecio);
            // Convertimos el float a String para el nodo de texto
            Text textoPrecio = documento.createTextNode(String.valueOf(producto.getPrecio()));
            nodoDatosPrecio.appendChild(textoPrecio);
        }

        // 4. Escritura del Documento a un Archivo Físico
        // Se crea una instancia de TransformerFactory
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // Se crea un Transformer a partir de la fábrica
        Transformer transformer = transformerFactory.newTransformer();
        
        // Se configura el Transformer para que el XML de salida esté formateado (indentado)
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Se especifica el origen de los datos (nuestro documento DOM)
        DOMSource source = new DOMSource(documento);
        // Se especifica el destino de los datos (un archivo llamado "productos.xml")
        StreamResult result = new StreamResult(new File("productos.xml"));

        // Se realiza la transformación
        transformer.transform(source, result);

        System.out.println("Archivo XML 'productos.xml' creado correctamente.");
    }
}