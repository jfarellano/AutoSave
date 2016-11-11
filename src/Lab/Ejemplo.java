package Lab;


import Lab.AutoSave;

public class Ejemplo extends AutoSave {
    public int id;
    public String nombre;
    public String apellido;

    public Ejemplo(int id, String nombre, String apellido){
        super(Ejemplo.class);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    

}