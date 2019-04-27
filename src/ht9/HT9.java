/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht9;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

/**
 *
 * @author gianlucariverabiagioni / franciscorosal
 */
public class HT9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String archivoNombre;

        System.out.println("Ingrese la implementacion de BST que desea usar: ");
        System.out.println("Red Black Tree: rbt");
        System.out.println("Splay Tree: splay");
        String tipo = read.next();

        BSTInterface tree = BSTFactory.createBST(tipo);

        //Para leer el archivo
        System.out.println("Ingrese el nombre del diccionario");
        archivoNombre = read.next();
        ArrayList<String> archivo = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(archivoNombre + ".txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(archivo::add);
        } catch (IOException e ){
            System.out.println("Ha ocurrido un error");
        }

        for (String linea : archivo) {
            String lineaClean = linea.replaceAll("\t", " ").replaceAll(",", "").replaceAll(";", "");

            String ingles = lineaClean.trim().split("\\s+")[0].toLowerCase();
            String espanol = lineaClean.trim().split("\\s+")[1].toLowerCase();
            tree.put(ingles, espanol);
        }

        //IMPRIMIR IN ORDER
        System.out.println();
        //tree.inOrder();
        //System.out.println(tree.inOrder());


        //TRADUCCION DE ARCHIVO

        //Para leer el archivo
        System.out.println();
        System.out.println("Ingrese el nombre del archivo a traducir");
        archivoNombre = read.next();
        archivo = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(archivoNombre + ".txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(archivo::add);
        } catch (IOException e ){
            System.out.println("Ha ocurrido un error");
        }

        String traduccion = "";
        for (String linea : archivo) {
            String lineaClean = linea.replaceAll("\\.","");

            for (String palabra : lineaClean.trim().split("\\s+")) {
                if (tree.get(palabra) == null) {
                    traduccion += "*"+palabra+"* ";
                } else {
                    traduccion += tree.get(palabra) + " ";
                }
            }
            traduccion += "\n";
        }

        System.out.println(traduccion);

    }

}
