package Tp3.Ejercicio1;
//es una implementación de una pila genérica en Java.
//Una pila es una estructura de datos que sigue el principio de LIFO(last in first Out)
//EL ULTIMO ELEMENTO QUE SE AGREGA A LA PILA ES EL PRIMERO QUE SE ELIMINA.
//*El parámetro ELEMENT es un tipo de parámetro que se utiliza para indicar el tipo de objeto que se va a manejar en la pila.*/
public class PilaGenerica<ELEMENT> {
	
	//Atributos
	private final static Integer defaulDimension = 10;
	private ELEMENT[] data;
	private Integer count;
	
	//Constructor por defecto
	public PilaGenerica() {
		this(PilaGenerica.defaulDimension);
	}
	
	//Constructor: 
	//Si la dimension es menor o igual a 0, lanza una excepcion
	//Inicializa el array con el tamaño especificado
	//Inicializa count a 0 indicando que la pila esta vacia
	@SuppressWarnings("unchecked")
	public PilaGenerica(Integer dimension) {
		if (dimension <= 0) {
			throw new RuntimeException("La cantidad de elementos en la pila debe ser positivo");	
		}
		this.data = (ELEMENT []) new Object[dimension];
		this.count = 0;
	}
	
	
	//Metodo para comprobar si la pila esta vacia
	public boolean empty() {
		return this.count <= 0;
	}
	
	//Metodo para ver el ultimo elemento en ingresar
	public ELEMENT peek() {
		if (this.empty()) {
			throw new RuntimeException("La pila esta vacia...");
		}
		return this.data[this.count - 1];// se utiliza para devolver el último elemento que se agregó a la pila.
	}
	
	//este método elimina y devuelve el último elemento agregado a la pila
	public ELEMENT pop() {
		if (this.empty()) {
			throw new RuntimeException("La pila esta vacia...");
		}
		--this.count;//Esta línea decrementa el valor de la variable count en 1
	//?Devuelve el elemento que se encuentra en la posición count del arreglo data. Como count se decrementó en la línea anterior, se devuelve el elemento que se encontraba en la posición superior de la pila.
		return this.data[this.count];
	}
	
	//* el método push(ELEMENT element) agrega un elemento a la pila y, si la pila está llena, redimensiona el arreglo data para permitir que la pila crezca dinámicamente. */
	//"ELEMENT" es el tipo de dato que se devuelve por este método
	public ELEMENT push(ELEMENT element) {
		//?"this.size()" es un método que devuelve el tamaño actual de la pila
		//?"this.data.length" es la capacidad máxima del arreglo "data".
		if (this.size() >= this.data.length) {
			//throw new RuntimeException("La pila esta llena...");
			@SuppressWarnings("unchecked")
			//"ELEMENT [] temp" es un arreglo de tipo "ELEMENT" llamado "temp".
			//? "(ELEMENT[]) new Object [this.data.length * 2]" crea un nuevo arreglo de objetos con el doble de capacidad que el arreglo "data" actual y lo convierte a un arreglo de tipo "ELEMENT".
			ELEMENT [] temp = (ELEMENT[]) new Object [this.data.length * 2];
			for (int i=0; i< this.data.length; ++i) {
				//"temp[i]" es el elemento en la posición "i" del arreglo "temp".
				//? "this.data[i]" es el elemento en la posición "i" del arreglo
				temp[i] = this.data[i];
			}
			//"this.data" es el arreglo "data" actual.
			//? "temp" es el arreglo "temp" que se está creando.
			//this.data es el arreglo data que se utiliza para almacenar los elementos de la pila.
			// temp es el nuevo arreglo que se acaba de crear con el doble de capacidad que el arreglo data actual.

			this.data = temp;//no copia los elementos del arreglo temp al arreglo data, sino que cambia la referencia al arreglo data para que apunte al nuevo arreglo temp.
		}
		//En otras palabras, se está accediendo al elemento que se encuentra en la posición count del arreglo data.
		//*sería equivalente a this.data[3], lo que significa que se está accediendo al elemento que se encuentra en la posición 3 del arreglo data. */
		this.data[this.count] = element;
		++this.count;// para aumentar el valor de la variable en 1.
		return element;
	}
	
	//Metodo para buscar un elemento en la pila
	//El método se llama search y devuelve un valor de tipo int. Recibe un parámetro llamado object de tipo Object, que es el elemento que se va a buscar en la pila.

	public int search(Object object) {
		// Este es un bucle for que itera sobre la pila desde la posición más alta hasta la posición más baja. La variable pos se inicializa con el valor this.count - 1, que es la posición del último elemento agregado a la pila. El bucle se repite mientras pos sea mayor o igual a 0.
		for (int pos = this.count - 1; pos >= 0; --pos) {
			//Dentro del bucle, se verifica si el elemento en la posición pos es igual al elemento que se está buscando (object). La condición se evalúa utilizando el método equals que se define en la clase del objeto.
			if (this.data[pos].equals(object)) {
				return this.count - pos;//Si se encuentra el elemento, se devuelve la posición del elemento en la pila
			}
		}
		return -1;
	}
	
	//Metodo para obtener el numero de elementos que hay en la pila
	public int size() {
		return this.count;
	}
}
