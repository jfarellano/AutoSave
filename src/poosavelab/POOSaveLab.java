/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poosavelab;

import Lab.Ejemplo;
import Lab.Ejemplo2;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class POOSaveLab {

    static Ejemplo e = new Ejemplo(5, "juan f", "arellano");
    static Ejemplo p = new Ejemplo(6, "nicolas", "morales");
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException, InstantiationException, InvocationTargetException {
        e.save();
        p.save();
        System.out.println(e.apellido);
        e.apellido = "barbosa";
        e.save();
        System.out.println(e.apellido);
        e.apellido = "garcia";
        p.nombre = "santiago";
        e.save();
        p.save();
        System.out.println(e.apellido);
        Ejemplo z = (Ejemplo) Ejemplo.load(5);
        System.out.println(z.apellido + " appellido de z");
        System.out.println(z.nombre + " nombre de z");
        
        ArrayList<Ejemplo> a = Ejemplo.loadAll();
        
        for(Ejemplo e : a){
            System.out.println(e.apellido + " appellido de array");
            System.out.println(e.nombre + " nombre de array");
        }
        
        Ejemplo2 ej = new Ejemplo2(4, "De queso");
        ej.save();
        Ejemplo2 pi = (Ejemplo2) Ejemplo2.load(4);
        System.out.println(pi.crema);
        
    }
    
}
