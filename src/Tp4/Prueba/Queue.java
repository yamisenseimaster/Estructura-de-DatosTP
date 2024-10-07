package Tp4.Prueba;
/*
public interface Queue<E>
extends Collection<E>

Una colección diseñada para contener elementos antes del procesamiento. Además de las operaciones básicas de recolección, las colas proporcionan inserción adicional operaciones de extracción e inspección. Cada uno de estos métodos existe en dos formas: una lanza una excepción si la operación falla, la otra devuelve un valor especial (ya sea nulo o falso, dependiendo de la operación). La última forma de la operación de inserción está diseñada específicamente para su uso con implementaciones de cola restringidas por capacidad; en la mayoría de las implementaciones, las operaciones de inserción no pueden fallar.

Las colas típicamente, pero no necesariamente, ordenan elementos en una FIFO (primero en primer lugar) manera. Entre las excepciones están las colas de prioridad, qué elementos de orden según un comparador suministrado, o los elementos' orden natural, y colas LIFO (o pilas) que ordenan los elementos LIFO (último en salir). Cualquiera que sea el pedido utilizado, el jefe de la la cola es ese elemento que se eliminaría mediante una llamada a remove() o encuesta(). En una cola FIFO, todos los elementos nuevos se insertan en la cola de la cola. Otros tipos de colas pueden usar diferentes reglas de colocación. Cada implementación de cola debe especificar sus propiedades de pedido.

El método de oferta inserta un elemento si es posible, de lo contrario regresa falso. Esto difiere del método Collection.add, que puede fallar agregue un elemento solo lanzando una excepción sin verificar. La oferta el método está diseñado para su uso cuando la falla es normal, en lugar de ocurrencia excepcional, por ejemplo, en capacidad fija (o "limitada") colas.

Los métodos remove() y poll() eliminan y devuelven el encabezado de la cola. Exactamente qué elemento se elimina de la cola es una función de la la política de pedidos de la cola, que difiere de la implementación a implementación. Los métodos remove() y poll() difieren solo en sus comportamiento cuando la cola está vacía: el método remove() lanza un excepción, mientras que el método poll() devuelve null. Los métodos element() y peek() devuelven, pero no retiran, la cabeza de la cola.

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




public class Queue<ELEMENT> {

    //region Constants

    private final static Integer defaulDimension = 10;

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
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    //endregion


    //region Queue Methods

    //Operación EnQueue en la teoría de Estructura de Datos 
    // Inserta el elemento especificado en esta cola si es posible hacerlo 
    //inmediatamente sin violar las restricciones de capacidad, volviendo verdadero a 
    //éxito y lanzar una IlegalStateException si no hay espacio actualmente 
    //disponible.
    public boolean add(ELEMENT element) {

        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    // Operacion peek en la teoría de Estructura de Datos
    //
    // Retrieves, but does not remove, the head of this queue. This method differs
    // from peek only in that it throws an exception if this queue is empty.
    public ELEMENT element() {

        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return this.data[this.head];
    }

    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions. When using a
    // capacity-restricted queue, this method is generally preferable to add(E),
    // which can fail to insert an element only by throwing an exception.
    public boolean offer(ELEMENT element) {

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
    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }

        return this.data[this.head];
    }

    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue, or returns null if this queue
    // is empty.
    public ELEMENT pool() {
        if (this.size() <= 0) {
            return null;
        }

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

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

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

}
// 