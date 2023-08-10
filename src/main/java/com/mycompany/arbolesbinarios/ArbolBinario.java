/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolesbinarios;

/**
 *
 * @author riosr
 */
public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(String pathDirectorio) {
        raiz = insertarRecursivo(raiz, pathDirectorio);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, String pathDirectorio) {
        if (actual == null) {
            return new NodoArbol(pathDirectorio);
        }
        if (pathDirectorio.compareTo(actual.datos) < 0) {
            actual.izquierda = insertarRecursivo(actual.izquierda, pathDirectorio);
        } else {
            actual.derecha = insertarRecursivo(actual.derecha, pathDirectorio);
        }
        return actual;
    }

    public boolean busqueda(String pathDirectorio) {
        return busquedaRecursiva(raiz, pathDirectorio);
    }

    private boolean busquedaRecursiva(NodoArbol actual, String pathDirectorio) {
        if (actual == null) {
            return false;
        }
        if (pathDirectorio.equals(actual.datos)) {
            return true;
        }
        if (pathDirectorio.compareTo(actual.datos) < 0) {
            return busquedaRecursiva(actual.izquierda, pathDirectorio);
        } else {
            return busquedaRecursiva(actual.derecha, pathDirectorio);
        }
    }

    private void recorridoPreOrden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println(nodo.datos + " ");
        recorridoPreOrden(nodo.izquierda);
        recorridoPreOrden(nodo.derecha);
    }

    private void recorridoInorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        recorridoInorden(nodo.izquierda);
        System.out.println(nodo.datos + " ");
        recorridoInorden(nodo.derecha);
    }

    private void recorridoPosOrden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        recorridoPosOrden(nodo.izquierda);
        recorridoPosOrden(nodo.derecha);
        System.out.println(nodo.datos + " ");
    }

    public void recorridoPreOrden() {
        recorridoPreOrden(raiz);
    }

    public void recorridoInorden() {
        recorridoInorden(raiz);
    }

    public void recorridoPosOrden() {
        recorridoPosOrden(raiz);
    }
}

class NodoArbol {
    String datos;
    NodoArbol izquierda;
    NodoArbol derecha;

    public NodoArbol(String datos) {
        this.datos = datos;
        izquierda = null;
        derecha = null;
    }
}
