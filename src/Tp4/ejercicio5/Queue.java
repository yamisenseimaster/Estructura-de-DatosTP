package Tp4.ejercicio5;
/*
public interface Queue<E>
extends Collection<E>

A collection designed for holding elements prior to processing.
Besides basic Collection operations, queues provide additional insertion,
extraction, and inspection operations. Each of these methods exists in
two forms: one throws an exception if the operation fails, the other
returns a special value (either null or false, depending on the operation).

The latter form of the insert operation is designed specifically for use
with capacity-restricted Queue implementations; in most implementations,
insert operations cannot fail.

Queues typically, but do not necessarily, order elements in a FIFO
(first-in-first-out) manner. Among the exceptions are priority queues,
which order elements according to a supplied comparator, or the elements'
natural ordering, and LIFO queues (or stacks) which order the elements
LIFO (last-in-first-out). Whatever the ordering used, the head of the
queue is that element which would be removed by a call to remove() or
poll(). In a FIFO queue, all new elements are inserted at the tail of
the queue. Other kinds of queues may use different placement rules.
Every Queue implementation must specify its ordering properties.

The offer method inserts an element if possible, otherwise returning
false. This differs from the Collection.add method, which can fail to
add an element only by throwing an unchecked exception. The offer
method is designed for use when failure is a normal, rather than
exceptional occurrence, for example, in fixed-capacity (or "bounded")
queues.

The remove() and poll() methods remove and return the head of the queue.
Exactly which element is removed from the queue is a function of the
queue's ordering policy, which differs from implementation to
implementation. The remove() and poll() methods differ only in their
behavior when the queue is empty: the remove() method throws an
exception, while the poll() method returns null.

The element() and peek() methods return, but do not remove, the head
of the queue.

The Queue interface does not define the blocking queue methods, which
are common in concurrent programming. These methods, which wait for
elements to appear or for space to become available, are defined in
the BlockingQueue interface, which extends this interface.

Queue implementations generally do not allow insertion of null elements,
although some implementations, such as LinkedList, do not prohibit
insertion of null. Even in the implementations that permit it, null
should not be inserted into a Queue, as null is also used as a special
return value by the poll method to indicate that the queue contains no
elements.

Queue implementations generally do not define element-based versions of
methods equals and hashCode but instead inherit the identity based
versions from class Object, because element-based equality is not
always well-defined for queues with the same elements but different
ordering properties.

This interface is a member of the Java Collections Framework.



from https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Queue.html
from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html
from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Queue.html

 */



 //Queue <ELEMENT> se define como una clase generica llamada "queue" puede contener elementos de cualquier tipo "ELEMENT".
 //"ELEMENT" es un parametro de tipo, que indica que la clase "queue" es generica y puede trabajar con cualquier tipo de elementos
 // en otras palabra "ELEMENT" es un placeholder que va almacenar en la cola.


//*La clase Queue proporciona métodos como add, offer, element, peek, poll, remove, isEmpty, size, toArray, entre otros, que te permiten interactuar con la cola de manera eficiente y segura.

 public class Queue<ELEMENT> {

    //region Constants

//?sta constante se utiliza en el constructor de la clase Queue para establecer el tamaño predeterminado del arreglo data que 
//?se utiliza para almacenar los elementos de la cola.
    private final static Integer defaulDimension = 50;

    //endregion

    //region Attributes

    private ELEMENT [] data;
    private int head;
    private int tail;
    private int count;

    //endregion

    //region Constructors

    public Queue() {
        this(Queue.defaulDimension);
    }
    @SuppressWarnings("unchecked")
    public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    //endregion

    //region Queue Internal Methods

//* este método permite recorrer el arreglo data de manera circular, es decir, cuando se llega al final del arreglo, se vuelve al principio.
//* La función next(int pos) es un método que devuelve la posición siguiente en el arreglo data a partir de la posición actual pos.

    private int next(int pos) {
        //?"Incrementa pos en 1 y luego verifica si el resultado es mayor o igual que el tamaño del arreglo data".
        if (++pos >= this.data.length) {
            pos = 0;//?permite que la posición pos se "rebobine" al principio del arreglo data cuando se alcanza el final del arreglo, permitiendo un recorrido circular del arreglo
        }
        return pos;
    }
    //endregion


    //region Queue Methods

    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions, returning true upon
    // success and throwing an IllegalStateException if no space is currently
    // available.

    //?es un método que agrega un nuevo elemento al final de la cola.
    public boolean add(ELEMENT element) {
        //?Verifica si la cola está llena, es decir, si el tamaño actual de la cola es igual al tamaño máximo del arreglo data.
        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }
        //?Si la cola no está llena, agrega el nuevo elemento al final de la cola. Para hacer esto, utiliza la posición tail para acceder al último elemento de la cola y asigna el nuevo elemento a esa posición.
        //*"this.data": es el arreglo que almacena los elementos de la cola.
        //*"this.tail": es la ubicación en la que se encuentra el último elemento de la cola.
        //element es el nuevo elemento que se va a agregar a la cola.
        this.data[this.tail] = element;
        //?this.next(this.tail) llama al método next(int pos) que devuelve la posición siguiente en el arreglo this.data a partir de la posición actual this.tail.
        this.tail = this.next(this.tail);//En esta línea, se actualiza la posición this.tail para apuntar al siguiente elemento en el arreglo this.data
        ++this.count;//En esta línea, se actualiza la posición this.tail para apuntar al siguiente elemento en el arreglo this.data

        return true;
    }

    // Operacion peek en la teoría de Estructura de Datos
    //
    // Retrieves, but does not remove, the head of this queue. This method differs
    // from peek only in that it throws an exception if this queue is empty.
    //?es un método que devuelve el elemento que se encuentra en la cabeza de la cola.
    public ELEMENT element() {

        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return this.data[this.head];//?devuelve el elemento que se encuentra en la cabeza de la cola, que se almacena en la posición this.head del arreglo this.data.
    }

    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions. When using a
    // capacity-restricted queue, this method is generally preferable to add(E),
    // which can fail to insert an element only by throwing an exception.
    //?es un método que agrega un nuevo elemento a la cola si hay espacio disponible.
    public boolean offer(ELEMENT element) {

        //"Si el tamaño actual de la cola (this.size()) es mayor o igual que el tamaño 
        // máximo del arreglo (this.data.length), entonces devuelve false".
        if (this.size() >= this.data.length) {
            return false;
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    // Retrieves, but does not remove, the head of this queue, or returns null if
    // this queue is empty.

    //? es un método que devuelve el elemento que se encuentra en la cabeza de la cola, sin removerlo de la cola
    public ELEMENT peek() {
        if (this.size() <= 0) {//i la cola está vacía, es decir, si el tamaño actual de la cola es menor o igual a 0. Si la cola está vacía, devuelve null.
            return null;
        }
//?Si la cola no está vacía, devuelve el elemento que se encuentra en la cabeza de la cola, que se almacena en la posición this.head del arreglo this.data.
        return this.data[this.head];
    }

    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue, or returns null if this queue
    // is empty.
    //?es un método que remueve y devuelve el elemento que se encuentra en la cabeza de la cola.
    public ELEMENT pool() {
        //?Verifica si la cola está vacía, es decir, si el tamaño actual de la cola es menor o igual a 0. Si la cola está vacía, devuelve null.
        if (this.size() <= 0) {
            return null;
        }
        //*  this.data: es el arreglo que almacena los elementos de la cola.
        //*  this.head: es la posición actual de la cabeza de la cola.
        //*  this.data[this.head]: es el elemento que se encuentra en la posición this.head del arreglo this.data.
        //*  ELEMENT result: es la variable que se utiliza para almacenar el elemento que se encuentra en la cabeza de la cola.


        //*Si la cola no está vacía, almacena el elemento que se encuentra en la cabeza de la cola en la variable result. */
        //!"Asigna el valor del elemento que se encuentra en la posición this.head del arreglo this.data a la variable result de tipo ELEMENT".
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue. This method differs from poll()
    // only in that it throws an exception if this queue is empty.
    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
        //En otras palabras, esta parte del código remueve el elemento que se encuentra en la cabeza de la cola y actualiza la posición de la cabeza de la cola para apuntar al siguiente elemento.


        // como se lee
        //* */"Almacena el elemento que se encuentra en la cabeza de la cola 
        //* */ en la variable result, actualiza la posición de la cabeza de la cola para apuntar
        //* */ al siguiente elemento y decrementa el contador de elementos en la cola".
        ELEMENT result = this.data[this.head];//? Almacena el elemento que se encuentra en la posición this.head
        this.head = this.next(this.head);//?Actualiza la posición this.head para apuntar al siguiente elemento en la cola-.
        --this.count;//Decrementa el contador this.count en 1 para reflejar que se ha removido un elemento de la cola.

        return result;
    }
    //endregion


    //region Override Object basic methods

    @Override
    public String toString() {

        if (this.size() <=0) {
            return "";
        }

        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());

        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }

        sb.append("]");
        return sb.toString();
    }
    //endregion


    //region Collection Methods

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public int size() {
        return this.count;
    }

    public Object[] toArray() {
        //"Crea un nuevo arreglo de objetos llamado result con un tamaño igual al número de elementos en la cola (this.count)".
        Object[] result = new Object[this.count];
        for(int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
    //endregion


    //region Caso Ejemplo b) Methods

    public static Queue<Object> union(Queue<?> stack1, Queue<?> stack2) {

        Queue<Object> result = new Queue<Object>(stack1.size() + stack2.size());

        for(int pos = stack1.head, cta = stack1.size(); cta > 0; pos = stack1.next(pos), --cta) {
            result.offer( stack1.data[pos] );
        }
        for(int pos = stack2.head, cta = stack2.size(); cta > 0; pos = stack2.next(pos), --cta) {
            result.offer( stack2.data[pos] );
        }

        return result;
    }

    public Queue<Object> union(Queue<?> stack2) {
        return Queue.union(this, stack2);
    }
    //endregion

//  El método contains verifica si un elemento determinado está presente en la estructura de datos.
    // Método contains en la clase Queue
    public boolean contains(ELEMENT element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.data[this.head + i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    

}
