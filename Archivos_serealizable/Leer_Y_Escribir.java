package Archivos_serealizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Leer_Y_Escribir {

    public void escribir_srchivo(String ruta, Persona persona) {
        try {
            ObjectOutputStream ejemplo = new ObjectOutputStream(new FileOutputStream(ruta));
            ejemplo.writeObject(persona);
            ejemplo.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public static void main(String[] args) {
        Leer_Y_Escribir objeto = new Leer_Y_Escribir();
        Persona objeto1 = new Persona("JOSE", "AVILA", 20, new Mascota("Firulais", 4));
//        objeto.escribir_srchivo("C:\\Users\\SATBOY-DJ\\Desktop\\name.txt", objeto1);
//        objeto.leer_archivo("C:\\Users\\SATBOY-DJ\\Desktop\\name.txt");
        Persona objeto2 = new Persona("JOSE", "AVILA", 20, new Mascota("Firulais", 4));
        Persona objeto3 = new Persona("Santos", "Daniel", 20, new Mascota("Firulais", 4));
        Persona objeto4 = new Persona("Jon", "Jose", 20, new Mascota("Juan", 4));

        List<Persona> lista = new ArrayList<>();
        lista.add(objeto1);
        lista.add(objeto2);
        lista.add(objeto3);
        lista.add(objeto4);
        objeto.escribirLista("C:\\Users\\SATBOY-DJ\\Desktop\\name.txt", lista);
        objeto.leer_archivo("C:\\Users\\SATBOY-DJ\\Desktop\\name.txt");
        List<Persona> lista1 = objeto.lista("C:\\Users\\SATBOY-DJ\\Desktop\\name.txt");
    }

    public void leer_archivo(String ruta) {
        try {
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream(ruta));
            Object auxiliar = leer.readObject();

//          System.out.println(persona.getMascota());
            Persona persona = (Persona) auxiliar;
            System.out.println(auxiliar);
            while (auxiliar != null) {
                System.out.println(persona.getNombre());
                auxiliar = leer.readObject();
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public void escribirLista(String direccion_archivo, List<Persona> listapersona) {
        try {
            ObjectOutputStream ejemplo1 = new ObjectOutputStream(new FileOutputStream(direccion_archivo));
            for (Persona listapersona1 : listapersona) {
                ejemplo1.writeObject(listapersona1);

            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

    }

    public List<Persona> lista(String direccion) {

        List<Persona> lista1 = new ArrayList<Persona>();

        try {
            ObjectInputStream leer = new ObjectInputStream(new FileInputStream(direccion));
            Object auxiliar = leer.readObject();
   
               
                while (auxiliar != null) {
                    Persona persona = (Persona) auxiliar;
                    System.out.println(persona.getNombre());
                    auxiliar =leer.readObject();
                }
            
        } catch (Exception e) {
            System.out.println("error" +e);

        }
        return null;

    }
}
