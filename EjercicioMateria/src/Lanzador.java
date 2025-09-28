import java.io.File;

public class Lanzador {
    public void LanzarArea(Double altura, Double radio, String fichResultado) {
        ProcessBuilder pb;
        try {
            
            pb = new ProcessBuilder(
                "java","-cp", "bin", "Cilindro",
                altura.toString(), 
                radio.toString());
            pb.redirectError(new File("error.txt"));
            pb.redirectOutput(new File(fichResultado));
            pb.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void compararArea(String fichresult, String fichcomparaciones) {
        ProcessBuilder pb;
        try {
            
            pb = new ProcessBuilder(
                "java","-cp", "bin", "comparar",
                fichresult,
                fichcomparaciones
            );
            pb.redirectError(new File("error.txt"));
            pb.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Lanzador lanzador = new Lanzador();
        lanzador.LanzarArea(6.0, 3.0, "resultado.txt");
        lanzador.compararArea("resultado.txt", "comparaciones.txt");
    }
}
