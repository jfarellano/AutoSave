package Lab;

import static Lab.AutoSave.klass;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.U;

public class AutoSave {
    
    static Class klass;

    public AutoSave(Class klass) {
        this.klass = klass;
    }
    
    

    public void save() throws IllegalArgumentException, IllegalAccessException, IOException {
        Field[] attributes = this.getClass().getDeclaredFields();
        String[] objeto = new String[attributes.length];
        for (int i = 0; i < attributes.length; i++) {
            objeto[i] = espaciosEntrada(asString(attributes[i].get(this)));
        }
        escribirArchivo(objeto, this.getClass().getName() + ".txt");
    }

    public static Object  load(int id) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor[] c = klass.getConstructors();
        Parameter[] p = c[0].getParameters();
        Object[] datos = new Object[p.length];
        String[] s = loadFileAsString(id, klass.getName() + ".txt");
        if (s != null) {
            for (int i = 0; i < p.length; i++) {
                try {
                    int n = Integer.parseInt(s[i]);
                    datos[i] = n;
                } catch (Exception e) {
                    try {
                        datos[i] = s[i];
                    } catch (Exception e1) {    
                    }
                }
            }
            return c[0].newInstance(datos);
        } else {
            System.out.println("id invalido usuario no existente");
            return null;
        }
    }
    
    public static ArrayList loadAll() throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException{
        ArrayList a = new ArrayList();
        boolean sw = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(klass.getName() + ".txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] clt = line.split("\\s+");
                a.add(load(Integer.parseInt(clt[0])));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return a;
    }
    
    public static String[] loadFileAsString(int id, String path) {
        StringBuilder builder = new StringBuilder();
        boolean sw = true;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] clt = line.split("\\s+");
                if(clt[0].equals(String.valueOf(id))){
                    sw = false;
                    return clt;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    


    public static void escribirArchivo(String[] lista, String ruta) throws IOException {
        File File = new File(ruta);
        File aux = new File("ayuda.txt");
        boolean sw = true;
        if (!File.exists()) {
            File.createNewFile();
            aux.createNewFile();
        }
        PrintWriter Bw = new PrintWriter(aux);
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String line;
        while ((line = br.readLine()) != null) {
            String s = line;
            String[] clt = s.split("\\s+");
            if (clt[0].equals(lista[0])) {
                for (int i = 0; i < lista.length; i++) {
                    Bw.print(lista[i] + " ");
                    sw = false;
                }
                Bw.println("");
            } else {
                Bw.println(s);
            }

        }
        if(sw){
            for (int i = 0; i < lista.length; i++) {
                Bw.print(lista[i] + " ");
            }
        }
        br.close();
        Bw.close();
        File.delete();
        aux.renameTo(new File(ruta));
        aux.delete();
    }

    public static String asString(Object x) {
        return String.valueOf(x);
    }

    public static String espaciosSalida(String s) {
        return s.replace("_", " ");
    }

    public static String espaciosEntrada(String s) {
        return s.replace(" ", "_");
    }

}
