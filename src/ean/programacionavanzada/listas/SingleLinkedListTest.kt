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

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Clase para probar la implementación de listas con nodos sencillamente encadenados
 */
internal class SingleLinkedListTest {
    /**
     * Prueba de agregar al final
     */
    @Test
    fun pruebaAgregarAlFinal() {
        // Creamos una lista
        val lista = SingleLinkedList<Int>()

        // Llenamos la lista de una serie de datos
        lista.add(5)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(67)
        lista.add(45)

        // Verificamos el contenido de la lista
        assertEquals(6, lista.size)

        // Imprimimos la lista
        println("La lista es igual a $lista")

        // Comparamos listas
        var otraLista = SingleLinkedList(5, 8, 3, 43, 67, 45)
        assertTrue(lista == otraLista)

        // Ahora verificamos el contenido de la lista
        val primero = lista[0]
        assertEquals(5, primero)

        val ultimo = lista.last
        assertEquals(45, ultimo)

        val mitad = lista[3] // El quinto elemento
        assertEquals(43, mitad)
    }

    @Test
    fun pruebasAgregarAlPrincipio() {
        // Creamos una lista
        val lista:IList<Int> = SingleLinkedList()

        // Llenamos la lista de una serie de datos
        lista.addToHead(15)
        lista.addToHead(38)
        lista.addToHead(3)
        lista.addToHead(43)
        lista.addToHead(67)
        lista.addToHead(25)
        lista.addToHead(78)

        // Verificamos el contenido de la lista
        assertEquals(7, lista.size)

        // Ahora verificamos el contenido de la lista
        val primero = lista.first
        assertEquals(78, primero)

        val ultimo = lista.last
        assertEquals(15, ultimo)

        val mitad = lista[3] // El quinto elemento
        assertEquals(43, mitad)
    }

    @Test
    fun clear() {
        // Creamos una lista
        val lista:IList<Int> = SingleLinkedList()

        // Llenamos la lista de una serie de datos
        lista.add(5)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(67)
        lista.add(45)

        // Verificamos el contenido de la lista
        assertEquals(6, lista.size)

        // Ahora limpiamos la lista
        lista.clear()

        // Ahora verificamos que la lista está vacía
        assertEquals(0, lista.size)
        assertTrue(lista.isEmpty)
    }

    @Test
    fun lastIndexOf() {
        // Creamos una lista
        val lista: IList<Int> = SingleLinkedList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size)

        // Encontramos la posicion de un elemento existente
        var pos = lista.lastIndexOf(35)
        val elem = lista[pos]
        assertEquals(8, pos)
        assertEquals(35, elem)

        // Y ahora la posicion de un elemento que no existe
        pos = lista.lastIndexOf(7)
        assertEquals(-1, pos)
    }

    @Test
    fun indexOf() {
        // Creamos una lista
        val lista: IList<Int> = SingleLinkedList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size)

        // Encontramos la posicion de un elemento existente
        var pos = lista.indexOf(8)
        val elem = lista[pos]
        assertEquals(1, pos)
        assertEquals(8, elem)

        // Y ahora la posicion de un elemento que no existe
        pos = lista.indexOf(7)
        assertEquals(-1, pos)
    }

    @Test
    fun isEmpty() {

        // Creamos una lista
        val lista: IList<Int> = SingleLinkedList()

        // Verificamos que la lista esté vacía
        assertTrue(lista.isEmpty)

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size)

        // Verificamos que la lista no esté vacía
        assertFalse(lista.isEmpty)
    }

    @Test
    fun remove() {
        // Creamos una lista
        val lista: IList<Int> = SingleLinkedList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size)

        // Ahora borramos el segundo elemento, posicion 1
        lista.remove(1)

        // Verificamos el tamaño
        assertEquals(9, lista.size)

        // Verificar el contenido de la lista
        val antes = lista[0]
        val desp = lista[1]
        assertTrue(antes == 35 && desp == 3)

        // Eliminamos el ultimo
        lista.removeLast()

        // Verificamos el tamaño
        assertEquals(8, lista.size)

        // Verificamos el contenido. El último debera ser 35
        val ultimo = lista.last
        assertEquals(35, ultimo)
    }

    @Test
    fun set() {
        // Creamos una lista
        val lista: IList<Int> = SingleLinkedList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)
        lista.add(81)

        // Verificamos el contenido de la lista
        assertEquals(11, lista.size)

        var elem = lista[5]
        assertEquals(45, elem)

        lista[5] = 99
        assertEquals(11, lista.size)
        elem = lista[5]
        val antes = lista[4]
        assertTrue(elem == 99 && antes == 35)
    }
}