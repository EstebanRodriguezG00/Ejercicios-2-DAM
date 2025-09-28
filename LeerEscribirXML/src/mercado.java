import java.util.LinkedList;

public class mercado {
    private LinkedList<Producto> listaproductos = new LinkedList<>();

    public mercado() {
    }

    public LinkedList<Producto> getListaproductos() {
        return listaproductos;
    }

    public void insertarProducto(Producto p){
        listaproductos.add(p);
    }

}