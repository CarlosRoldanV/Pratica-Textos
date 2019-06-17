/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import ec.edu.ups.controlador.Controlador;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Carlos
 */
public class Principal {

    public static void main(String[] args) throws IOException {
        System.out.println("Textos :");
        Controlador control = new Controlador();
        String ruta = "C:\\Users\\Carlos\\OneDrive\\Documentos\\NetBeansProjects\\Practica-Archivo\\src\\ec\\edu\\ups\\archivo";
        File archivo1 = new File(ruta);
        File[] archivo2 = archivo1.listFiles();
        for (File archivo3 : archivo2) {
            if (!archivo3.getName().equals("ConteoPalabras.txt")) {
                control.modelo(ruta + "\\" + archivo3.getName());
            }
        }
        control.escribir();
    }

}
