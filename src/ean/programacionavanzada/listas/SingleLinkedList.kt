/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto EAN Kotlin Collections
 * @author Universidad EAN
 * Fecha: Mar 09, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package ean.programacionavanzada.listas

import java.awt.SystemColor.info

/**
 * Implementación del tipo abstracto de datos lista, especificado en la interface IList,
 * utilizando nodos sencillamente encadenados
 * Este esquema dinámico es mucho mejor que con los arreglos, en varios métodos.
 */
open class SingleLinkedList<T> : IList<T> {
    //---------------------------------------------------------
    // Atributos
    //---------------------------------------------------------

    // La cabeza de la lista
    private var cabeza: Node<T>? = null

    // El número de elementos en la lista
    private var tam: Int = 0

    //---------------------------------------------------------
    // Constructor
    //---------------------------------------------------------
    constructor()

    /**
     * Permite crear una lista a partir de un conjunto de elementos que se pasan como parámetros
     */
    constructor(vararg elements: T) {
        for (elem: T in elements) {
            this.add(elem)
        }
    }

    //---------------------------------------------------------
    // Métodos
    //---------------------------------------------------------

    /**
     * Retorna `true` si la lista está vacía (no contiene elementos), `false` si tiene al menos un elemento
     */
    override val isEmpty: Boolean
        get() {
            if (tam == 0) {
                return true
            }
            return false
        }

    /**
     * Retona el número de elementos que hacen parte de la lista
     */
    override val size: Int
        get() = tam

    /**
     * Agrega un elemento al final de la lista
     */
    override fun add(element: T) {
        var nodo = Node<T>(element)
        if (isEmpty) {
            cabeza = nodo
        } else {
            var nodo2 = cabeza
            while (nodo2!!.next != null) {
                nodo2 = nodo2!!.next
            }
            nodo2!!.next = nodo
        }
        tam++
    }

    /**
     * Agrega un nuevo elemento al principio de la lista
     */
    override fun addToHead(element: T) {
        var nodo = Node<T>(element)
        if (cabeza != null) {
            nodo.next = cabeza
        }
        cabeza = nodo
        tam = tam + 1
    }

    /**
     * Agrega un elemento en la posición específica de la lista
     */
    override fun add(position: Int, element: T) {
        var nodo = Node(element)
        if (cabeza == null) {
            cabeza = nodo
        } else {
            var juancho = cabeza
            while (juancho!!.next != null) {
                juancho = juancho.next
            }
            juancho!!.next = nodo
        }
        tam++
    }

    /**
     * Elimina el elemento que se encuentra en la posición indicada
     */
    override fun remove(position: Int) {
        if (position >= 0 && position < tam) {
            if (position == 0) {
                cabeza = cabeza!!.next
            } else {
                var nodo2 = cabeza
                for (i in 1..position - 1) {
                    nodo2 = nodo2!!.next
                }
                var nodo3 = nodo2!!.next
                nodo2.next = nodo3!!.next
            }
            tam--
        }
    }

    /**
     * Elimina el primer elemento de la lista
     */
    override fun removeFirst() {
        remove(0)
    }

    /**
     * Elimina el último elemento de la lista
     */
    override fun removeLast() {
        var nodo = cabeza
        for (i in 1 until tam - 1) {
            nodo = nodo!!.next
        }
        nodo!!.next = null
        tam--
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado
     */
    override fun removeElement(element: T) {
        require(cabeza != null)
        var nodo = cabeza
        var posicion = 0
        for (i in 1 until tam) {
            if (nodo!!.info == element) {
                posicion = i
            }
            nodo = nodo!!.next
        }
        remove(posicion)
    }

    /**
     * Retorna el elemento que se encuentra una determinada posición de la lista
     */
    override fun get(position: Int): T {
        require(position in 0 until tam+1)

        var i = 0
        var p = cabeza
        while (i != position) {
            p = p!!.next
            i++
        }
        return p!!.info
    }

    /**
     * Retorna el elemento que se encuentra en la primera posición de la lista
     *
     */
    override fun head(): T {
        require(!isEmpty) //No puedo trabajar con gente vacia
        return cabeza!!.info
    }

    /**
     * Retorna la lista sin el primer elemento. Es una copia de esta lista, no modifica la lista que recibe el
     * mensaje correspondiente
     */
    override fun tail(): IList<T> {
        TODO("not implemented")
    }

    /**
     * Retorna el índice de la primer ocurrencia del elemento especificado en la lista, o -1 si el elemento dado no
     * existe en la lista
     */
    override fun indexOf(element: T): Int {
        var nodo2 = cabeza
        var fund = false
        var bandera = 0
        if (fund == false) {
            for (i in 1..tam) {
                if ((nodo2!!.info == element)) {
                    fund = true
                    break;
                } else if (nodo2.next != null) {
                    nodo2 = nodo2!!.next
                    bandera++
                }
            }
        }
        if (fund == false) {
            bandera = -1
        }
        return bandera

    }



    /**
     * Retorna el índice de la última ocurrencia del elemento dado en la lista, o -1 si el elemento dado no existe en
     * la lista
     */
    override fun lastIndexOf(element: T): Int {
        var nodo2 = cabeza
        var fund = false
        var bandera = tam
        if (fund == false) {
            for (i in tam downTo 0) {
                if ((nodo2!!.info == element)) {
                    fund = true
                    break;
                } else if (nodo2.next != null) {
                    nodo2 = nodo2!!.next
                    bandera--
                }
            }
        }
        if (fund == false) {
            bandera = -1
        }
        return bandera

    }



    /**
     * Reemplaza el elemento en la posición especificada en la lista por elemento dado
     *
     */
    override fun set(position: Int, element: T) {

    }

    /**
     * Obtiene una copia idéntica de esta lista.
     */
    override fun copy(): IList<T> {
        TODO("not implemented")
    }

//------------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------
// Esta clase implementa las operaciones de un nodo
// de la lista doblemente encadenada
//-------------------------------------------------
    private inner class Node<T>(theInfo: T) {
        // Atributos
        var info: T = theInfo
        var next: Node<T>? = null
    }

    /**
     * Retorna un iterador sobre los elementos de esta secuencia de elementos
     */
    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            // Atributos
            private var nodo = cabeza

            /**
             * Returns `true` if the iteration has more elements.
             */
            override fun hasNext(): Boolean = (nodo != null)

            /**
             * Returns the next element in the iteration.
             */
            override fun next(): T {
                val resp = nodo?.info
                nodo = nodo?.next
                return resp!!
            }
        }
    }

    /**
     * Elimina todos los elementos de esta lista
     */
    override fun clear() {
        cabeza = null
        tam = 0
    }

    /**
     * Convierte a cadena el objeto actual
     */
    override fun toString(): String {
        var res = StringBuffer("[")
        var p = cabeza
        var i = 0

        while (p != null) {
            res.append(p.info.toString())
            if (i != (tam - 1)) {
                res.append(", ")
            }
            i++
            p = p.next
        }
        res.append("]")

        return "LinkedList(tam=$tam, info=$res)"
    }

    /**
     * Permite saber si una lista es igual a otra. Solo podemos comparar listas, sin importar la implementación
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is IList<*>) {
            return false
        }

        other as IList<T>

        if (this.size != other.size) {
            return false
        }

        var p = cabeza

        var i = 0

        while (p != null) {
            if (p.info != other[i]) {
                return false
            }
            i++
            p = p.next
        }

        return true
    }

    /**
     * Obtiene un código Hash para este objeto a partir del tamaño
     */
    override fun hashCode(): Int {
        return tam
    }
}
