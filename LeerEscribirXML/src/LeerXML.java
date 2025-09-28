import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerXML {

    public static void main(String[] args) {
        
        // Creamos una nueva lista para almacenar los productos leídos del XML
        mercado listaMercado = new mercado();

        try {
            // 1. Cargar el archivo XML
            File archivoXML = new File("productos.xml");

            // 2. Crear el DocumentBuilder para parsear el archivo
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            // 3. Normalizar el documento (opcional, pero recomendado)
            // Ayuda a eliminar nodos de texto vacíos y a unir nodos de texto adyacentes
            doc.getDocumentElement().normalize();

            // 4. Obtener el nodo raíz (en nuestro caso, <productos>)
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            // 5. Obtener una lista de todos los nodos <producto>
            NodeList listaNodosProducto = doc.getElementsByTagName("producto");

            // 6. Recorrer la lista de nodos <producto>
            for (int i = 0; i < listaNodosProducto.getLength(); i++) {
                Node nodo = listaNodosProducto.item(i);
                System.out.println("\nLeyendo elemento: " + nodo.getNodeName() + " " + (i + 1));

                // Nos aseguramos de que el nodo sea de tipo Elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoProducto = (Element) nodo;

                    // 7. Extraer el contenido de las etiquetas hijas <nombre> y <precio>
                    String nombre = elementoProducto.getElementsByTagName("nombre").item(0).getTextContent();
                    String precioStr = elementoProducto.getElementsByTagName("precio").item(0).getTextContent();
                    
                    // Convertir el precio de String a float
                    float precio = Float.parseFloat(precioStr);

                    // 8. Crear el objeto Producto y añadirlo a la lista
                    Producto producto = new Producto(nombre, precio);
                    listaMercado.insertarProducto(producto);
                }
            }

            // 9. Verificación: Imprimir los productos cargados en la lista
            System.out.println("\n--- Productos cargados en la lista del mercado ---");
            for (Producto p : listaMercado.getListaproductos()) {
                System.out.println("Nombre: " + p.getNombre() + ", Precio: " + p.getPrecio());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
