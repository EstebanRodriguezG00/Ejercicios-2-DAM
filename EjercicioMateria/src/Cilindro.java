

public class Cilindro {
    public static double CalcularArea(double radio, double altura) {
        return 2 * Math.PI * radio * (radio + altura);
    }
    public static void main(String[] args) {
        try {
            double altura = Double.parseDouble(args[0]);
            double radio = Double.parseDouble(args[1]);
            double area = CalcularArea(radio, altura);
            System.out.println("El area del cilindro es: " + area);

        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
