/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author meimarcel
 */
public class BSL {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            FileReader arquivo = new FileReader("src/textos/texto.txt");
            BufferedReader conteudo = new BufferedReader(arquivo);
            List<String> texto = conteudo.lines().collect(Collectors.toList());
            String palavra = "";
            System.out.print("Digite a palavra chave: ");
            String palavra_chave = input.nextLine().toLowerCase();
            List<Integer> indices = new ArrayList<>();
            int contador_linha = 1;

            for(String linha : texto) {
                linha += "\n";
                palavra = "";
                int estado = 0;
                boolean fim = false;
                for(String token : linha.split("")) {
                    switch(estado) {
                        case 0:
                            switch(token.toLowerCase()) {
                                case "a" : estado = 1; break;
                                case "ã" : estado = 1; break;
                                case "â" : estado = 1; break;
                                case "á" : estado = 1; break;
                                case "b" : estado = 1; break;
                                case "c" : estado = 1; break;
                                case "ç" : estado = 1; break;
                                case "d" : estado = 1; break;
                                case "e" : estado = 1; break;
                                case "é" : estado = 1; break;
                                case "ẽ" : estado = 1; break;
                                case "ê" : estado = 1; break;
                                case "f" : estado = 1; break;
                                case "g" : estado = 1; break;
                                case "h" : estado = 1; break;
                                case "i" : estado = 1; break;
                                case "í" : estado = 1; break;
                                case "j" : estado = 1; break;
                                case "k" : estado = 1; break;
                                case "l" : estado = 1; break;
                                case "m" : estado = 1; break;
                                case "n" : estado = 1; break;
                                case "o" : estado = 1; break;
                                case "ô" : estado = 1; break;
                                case "ó" : estado = 1; break;
                                case "p" : estado = 1; break;
                                case "q" : estado = 1; break;
                                case "r" : estado = 1; break;
                                case "s" : estado = 1; break;
                                case "t" : estado = 1; break;
                                case "u" : estado = 1; break;
                                case "v" : estado = 1; break;
                                case "w" : estado = 1; break;
                                case "x" : estado = 1; break;
                                case "y" : estado = 1; break;
                                case "z" : estado = 1; break;
                                default: fim = true; break;
                            };
                            break;
                        case 1 :
                            switch(token.toLowerCase()) {
                                case "a" : estado = 1; break;
                                case "ã" : estado = 1; break;
                                case "â" : estado = 1; break;
                                case "á" : estado = 1; break;
                                case "b" : estado = 1; break;
                                case "c" : estado = 1; break;
                                case "ç" : estado = 1; break;
                                case "d" : estado = 1; break;
                                case "e" : estado = 1; break;
                                case "é" : estado = 1; break;
                                case "ẽ" : estado = 1; break;
                                case "ê" : estado = 1; break;
                                case "f" : estado = 1; break;
                                case "g" : estado = 1; break;
                                case "h" : estado = 1; break;
                                case "i" : estado = 1; break;
                                case "í" : estado = 1; break;
                                case "j" : estado = 1; break;
                                case "k" : estado = 1; break;
                                case "l" : estado = 1; break;
                                case "m" : estado = 1; break;
                                case "n" : estado = 1; break;
                                case "o" : estado = 1; break;
                                case "ô" : estado = 1; break;
                                case "ó" : estado = 1; break;
                                case "p" : estado = 1; break;
                                case "q" : estado = 1; break;
                                case "r" : estado = 1; break;
                                case "s" : estado = 1; break;
                                case "t" : estado = 1; break;
                                case "u" : estado = 1; break;
                                case "v" : estado = 1; break;
                                case "w" : estado = 1; break;
                                case "x" : estado = 1; break;
                                case "y" : estado = 1; break;
                                case "z" : estado = 1; break;
                                default: fim = true; break;
                            };
                            break;     
                    }
                    if(fim) {
                        if(estado == 1) {
                            if(palavra.equals(palavra_chave)) {
                                indices.add(contador_linha);
                                break;
                            }
                        } 
                        
                        estado = 0;
                        palavra = "";
                        fim = false;
                        
                    } else {
                        palavra += token.toLowerCase();
                    }
                }
                contador_linha++;
            }
            
            System.out.println();
            System.out.println("=====================================");
            System.out.println();
            
            if(indices.size() > 0) {
                System.out.print("Palavra encontrada na(s) linha(s): [ ");
                for(int i = 0; i< indices.size() - 1; i++) {
                    System.out.print(indices.get(i)+" | ");
                }
                System.out.print(indices.get(indices.size() - 1)+" ]");
                System.out.println();
            } else {
                System.out.println("A palavra nao foi encontrada no texto");
            }
            
            System.out.println();
            System.out.println("=====================================");
            System.out.println();
            
            int cont = 0;
            for(int i = 0; i < texto.size(); i++) {
                if(indices.size() > 0) {
                    if((indices.get(cont) - 1) == i) {
                        System.out.println("\033[1m"+texto.get(i));
                        if(cont < indices.size() - 1) {
                            cont ++;
                        }
                    } else {
                        System.out.println(texto.get(i));
                    }
                } else {
                    System.out.println(texto.get(i));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
}
