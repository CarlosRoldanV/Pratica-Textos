/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Palabra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class Controlador {

    private String palabra;
    private List<Palabra> lista;

    public Controlador() {
        lista = new ArrayList<>();
    }

    public void modelo(String ruta) throws IOException {
        palabra = "";
        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader leer = new BufferedReader(archivo);
            while (palabra != null) {
                palabra = leer.readLine();
                if (palabra != null) {
                    leer();
                }
            }

        } catch (FileNotFoundException errorArc) {

            System.out.println("No existe");
            System.out.println(errorArc.toString());

        } catch (IOException errorLeer) {

            System.out.println("Error de Escritura");
            System.out.println(errorLeer.toString());

        }

    }

    public void comprobar(String palabra) {

        int cont = 0;
        for (Palabra pala : lista) {

            if (pala.getNombre().equals(palabra)) {

                pala.setCantidad(pala.getCantidad() + 1);
                cont++;

                break;

            }
        }

        if (cont == 0) {

            Palabra pal = new Palabra();
            pal.setNombre(palabra);
            pal.setCantidad(1);
            lista.add(pal);

        }
    }

    public void leer() {

        String palabras[] = palabra.split(" ");
            System.out.println("");
        for (int i = 0; i < palabras.length; i++) {

            comprobar(palabras[i].toLowerCase());
        
            System.out.print(palabras[i] + " ");
            

        }

    }

    public void escribir() throws IOException {

        Collections.sort(lista, new Comparator<Palabra>() {
            public int compare(Palabra p1, Palabra p2) {
                return p1.getNombre().compareTo(p2.getNombre());

            }

        });

        try {

            String ruta = "C:\\Users\\Carlos\\OneDrive\\Documentos\\NetBeansProjects\\Practica-Archivo\\src\\ec\\edu\\ups\\archivo\\Resultado.txt";
            FileWriter archivo = new FileWriter(ruta, false);
            BufferedWriter escribir = new BufferedWriter(archivo);
            System.out.println("");
            System.out.println("");
            System.out.println("Resultado");
            for (Palabra p1 : lista) {
                escribir.append(p1.getNombre() + " " + p1.getCantidad());
                escribir.newLine();
                System.out.println(p1.getNombre() + " " + p1.getCantidad());
            }

            escribir.close();
            archivo.close();

        } catch (IndexOutOfBoundsException error) {

            System.out.println("No se pudo Escribir");

        }
    }
}
