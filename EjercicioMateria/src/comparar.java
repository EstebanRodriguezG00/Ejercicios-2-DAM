import java.io.*;

public class comparar {
    public static void main(String[] args) {
        try {
            FileReader LeerTXT = new FileReader("resultado.txt");
            BufferedReader LeerLinea = new BufferedReader(LeerTXT);
            String linea = LeerLinea.readLine();
            LeerLinea.close();

            double area = Double.parseDouble(linea);

            FileWriter Escribir = new FileWriter("comparaciones.txt",true);
            if (area < 200) {
                Escribir.write("El area entra: " + area);
            } else {
                Escribir.write("El area es demasiado grande: " + area);
            }
            Escribir.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
