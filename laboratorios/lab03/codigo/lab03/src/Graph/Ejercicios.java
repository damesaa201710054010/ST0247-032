/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;
import java.util.ArrayList;
/**
 *
 * @author danys
 */
public class Ejercicios {

    private boolean puedoPonerReina(int[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] nReinas(int n) {
        int[] tablero = new int[n];
        return nReinas(0, tablero);
    }

    private int[] nReinas(int n, int[] tablero) {
        if (n == tablero.length) {
            if (!puedoPonerReina(tablero)) {
                return tablero;
            }
        } else if (n != tablero.length) {
            int[] aux = new int[tablero.length];
            for (int i = 0; i < tablero.length; i++) {
                tablero[n] = i;
                aux = nReinas(n + 1, tablero);
                if (aux != null) {
                    return aux;
                }
            }
        }
        return null;
    }

    public void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static ArrayList<Integer> recorrido(Digraph g, int star, int finish) {
        int tamano = g.size();
        int[] costo = new int[tamano];
        ArrayList<Integer> recorridos = new ArrayList<>();
        ArrayList<Integer> suc = g.getSuccessors(star);
        for(int i = 0; i < suc.size(); i++)
        {
            costo[suc.get(i)] = -1;
        }
        recorrido(g, star, finish, costo, recorridos);
        return recorridos;
    }

    private static void recorrido(Digraph g, int pos, int finish, int[] costo, ArrayList<Integer> recorridos) {
        recorridos.add(pos);
        ArrayList<Integer> sucesores = g.getSuccessors(pos);
        if (sucesores != null) {
            for (int i = 0; i < sucesores.size(); i++) {
                if(costo[sucesores.get(i)] == -1)
                {
                    costo[sucesores.get(i)] = g.getWeight(pos, sucesores.get(i));
                }
                //return;
            }
        }

    }

}
