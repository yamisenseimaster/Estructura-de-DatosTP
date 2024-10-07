package Tp4.Ejercicio2;



public class ColaCircularGenerica <T>{
	 private final static Integer defaulDimension = 4;

	    //endregion

	    //region Attributes

	    private T [] data;
	    private int head;
	    private int tail;
	    
	    public ColaCircularGenerica() {
	        this(ColaCircularGenerica.defaulDimension);
	    }
	    @SuppressWarnings("unchecked")
		public ColaCircularGenerica(int dimension) {
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
	    
	    
	    //AGREGA UN ELEMENTO A LA COLA DEVOLVIENDO UNA EXCEPCION SI ESTA LLENA,
	    //solo se pueden guardar (n-1) elementos donde n es el tamaño del arreglo, por eso desperdicia siempre un espacio
	    public boolean add(T element) {

	        if (head==next(tail)){//Aqui se pregunta si la posicion siguiente a donde quiero
	        	//guardar el elemento no es el head si el siguiente no es head lo guarda sino no lo guarda.
	            throw new IllegalStateException("Cola llena ...");
	        }

	        this.data[this.tail] = element;
	        this.tail = this.next(this.tail);
	        return true;
	    }
	    
	    //DEVUELVE EL ELEMENTO PROXIMO A SALIR DE LA COLA SI LA COLA ESTA VACIA DEVUELVE UNA EXCEPCION
	    public T element() {

	        if (head==tail) {
	            throw new IllegalStateException("Cola vacía ...");
	        }

	        return this.data[this.head];
	    }
	    
	    //AGREGA UN ELEMENTO A LA COLA ,RETORNA FALSE SI ESTA LLENA
	    public boolean offer(T element) {

	        if (head==next(tail)) {
	            return false;
	        }

	        this.data[this.tail] = element;
	        this.tail = this.next(this.tail);

	        return true;
	    }
	    
	  //DEVUELVE EL ELEMENTO PROXIMO A SALIR,DEVUELVE NULL SI ESTA VACIA LA COLA
	    public T peek() {
	        if (head==tail) {
	            return null;
	        }

	        return this.data[this.head];
	    }

	  //DEVUELVE Y ELIMINA EL ELEMENTO PROXIMO A SALIR EN LA COLA ,LUEGO HEAD AVANZA EN UNO Y MERMA EN UNO LOS 
	    //ELEMENTOS CARGADOS,SI LA COLA ESTA VACIA DEVUELVE NULL.
	    public T pool() {
	        if (head==tail) {
	            return null;
	        }

	        T result = this.data[this.head];
	        this.head = this.next(this.head);

	        return result;
	    }

	  //DEVUELVE Y ELIMINA EL ELEMENTO PROXIMO A SALIR EN LA COLA ,LUEGO HEAD AVANZA EN UNO Y MERMA EN UNO LOS 
	    //ELEMENTOS CARGADOS,SI LA COLA ESTA VACIA DEVUELVE UNA EXCEPCION.
	    public T remove() {
	        if (head==tail) {
	            throw new IllegalStateException("Cola vacía ...");
	        }

	        T result = this.data[this.head];
	        this.head = this.next(this.head);

	        return result;
	    }
	    

	    
	  //DEVUELVE TRUE SI LA COLA ESTA VACIA Y FALSE EN CASO CONTRARIO
	    public boolean isEmpty() {
	    	boolean vacio=false;
	        if(head==tail) {
	        	vacio=true;
	        }
	        return vacio;
	    }
		


}
