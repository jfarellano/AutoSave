AutoSave:

AutoSave es una libreria de java diseñada para guardar objetos y ademas cargarlos de una manera facil. La libreria permite el guarado de Enteros (int) y Cadenas (String).

Requerimientos:
	1. Agregar AutoSave al proyecto en el que lo quiere utilizar.
	2. Extender AutoSave a todas las clases en las que se quieran guardar sus objetos.
	3. Los atributos de las clases deben ser publicos.
	4. Estas clases deben tener un constructor de primero con todos los atributos y en el mismo orden de declaracion.
	5. Al cargar una instancia en particular se necesita castear al tipo correcto.
	6. TODAS las clases deben contar con un id numerico unico por objeto.
	7. Se debe pasar en el super del constructor la clase que desea utilizar. Ej clase Ejemplo -> super(Ejemplo.class)

Metodos y uso:

save()
	El metodo save esta diseñado para guardar una instancia en especifico.
		Este se usa de la siguiente manera:
			Ejemplo e = new Ejemplo(5, "ejemplo");
			e.save();
		De esta manera ya estara guardada una instancia en un archivo unico para esa clase.
			- Si se guarda un objeto con la misma id este sera actualizado en el archivo.

load(id)
	El metodo load esta diseñando para retornar una instancia perviamente guardada con base en su id unico
		Este se usa de la siguiente manera:
			Ejemplo e = new Ejemplo(6, "ejemplo");
			e.save();
			Ejemplo cargado = Ejemplo.load(6);
		De esta manera el objeto cargado va a tener la misma informacion que el objeto e.

loadAll()
	El metodo loadAll esta diseñado para retornar un ArrayList con todas las instancias guardadas de la clase.
		Este se usa de la siguiente manera:
			Ejemplo e = new Ejemplo(6, "ejemplo");
			e.save();
			e.id = 7;
			e.texto = "ejemplo 2";
			e.save();
			ArrayList<Ejemplo> a = Ejemplo.loadAll();
		De esta manera el arraylist contendra dos instancias con id 6 y id 7.

Notas:

	- Para importar la libreria solamente se debe tener la clase AutoSave en el proyecto.
	- Las clases Ejemplo y POOSaveLab son clases de prueba con ejemplos de la utilizacion de todas las funcionalidades.
	- Se le recomienda al usuario antes de implementar la libreria experimente primero en el proyecto.
	- En siguientes versiones se implementaran mas tipos de variables en los atributos y estados de proteccion.

