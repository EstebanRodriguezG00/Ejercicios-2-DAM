import java.io.*;

public class random {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        File f = new File("fichero_aleatorio.dat");
        f.createNewFile();
        //el modo rw si no existe el fichero lo crea (modo lectura/escritura)
        RandomAccessFile raf = new RandomAccessFile(f, "rw");

        String Nombre1="Luis";
        int edad1 = 40;
        double altura1 = 1.87;
        StringBuffer sb = null;

        sb= new StringBuffer(Nombre1);
        sb.setLength(10);
        raf.writeChars(sb.toString());
        raf.writeUTF(Nombre1);
        raf.writeInt(edad1);
        raf.writeDouble(altura1);

        String Nombre2="Angel";
        int edad2 = 20;
        double altura2 = 1.99;

        sb= new StringBuffer(Nombre2);
        sb.setLength(10);
        raf.writeChars(sb.toString());
        raf.writeInt(edad2);
        raf.writeDouble(altura2);

        raf.seek(32);
        sb= new StringBuffer("XXXXX");
        sb.setLength(10);
        raf.writeChars(sb.toString());
        raf.writeInt(99);
        raf.writeDouble(0.00);

        int pos =0;
        int edad;
        char[] cnombre = new char [10];
        String nombre;
        char aux;
        double altura;
        do {
            //Nos situamos en un lugar determinado del fichero para empezar a leer desde allí
            raf.seek(pos);
            for(int i=0;i<10;i++) {
                aux=raf.readChar();
                cnombre[i]=aux;
            }
            nombre = new String(cnombre);
            edad=raf.readInt();
            altura = raf.readDouble();

            System.out.println("Edad: "+edad+" Nombre: "+nombre+" Altura: "+altura);
            pos += 32;
        }while(raf.getFilePointer()!=raf.length());
        raf.close();
    }
}