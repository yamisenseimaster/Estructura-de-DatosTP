package Tp4.Ejercicio2Rolo;

/*Implementar una clase “ColaCircular” que utilice un array para gestionar una cola de tamaño fijo de manera
circular que priorice velocidad.
Insertar números enteros en la cola. Verificar que la cola maneje correctamente las inserciones y
eliminaciones en caso de cola llena y cola vacía.*/
public class ColaCircular<T>  {
	private final static Integer defaulDimension = 4;
    private T [] data;
    private int head;
    private int tail;
    
    public ColaCircular() {
        this(ColaCircular.defaulDimension);
    }

	@SuppressWarnings("unchecked")
	public ColaCircular(int dimension) {
        this.data = (T[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
    }
    
	private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    
    public boolean add(T element) {
    	 
        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }
 
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        
        return true;
    }
    
    public T peek() {
        if (this.isEmpty()) {
            return null;
        }
 
        return this.data[this.head];
    }
    
    public T remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cola vacía ...");
        }
 
        T result = this.data[this.head];
        this.head = this.next(this.head);
        
        return result;
    }
    
    public boolean isFull() {
    	return this.next(this.tail) == this.head;
    }
    
    public boolean isEmpty() {
    	return head == tail;
    }
    
    public int size() {
        if (this.tail >= this.head) {
            return this.tail - this.head;
        } else {
            return this.data.length - this.head + this.tail;
        }
    }
 
}