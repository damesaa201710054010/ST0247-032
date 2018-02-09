/**
 * 
 * 
 * @author Kevin Parra, Daniel Mesa, Felipe Olaya.
 * @version 08/02/2018 Clase#2
 */
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
public class Taller2
{
    
    private static ArrayList<String> combinationsAux(String base, String s, ArrayList<String> p)
    {
	//ArrayList<String> combination = new ArrayList<>();
        if(s.length() == 0)
	    {
		p.add(base);
	    }else
	    {   
		combinationsAux(base+s.charAt(0), s.substring(1), p);
		combinationsAux(base, s.substring(1), p);
	    }
	return p;
	
    }
    
    public static ArrayList<String> combinations(String s)
    {
	ArrayList<String> p = new ArrayList<>();
        return combinationsAux("", s, p);
    }

    public static ArrayList<String> permutations(String s) {
	ArrayList<String> r = new ArrayList<String>();
	permutations("", s, r);
	return r;
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
	if(pos.length() == 0){
	    System.out.println(pre);
	    list.add(pre);
	}else{
	    for(int i = 0; i < pos.length(); ++i ){
		permutations(pre+pos.charAt(i), pos.substring(0,i)+pos.substring(i+1), list);
	    }
	}
    }

    public static int reinas(int numero)
    {
	int [] tablero = new int[numero];
	//ArrayList<Integer> p = new ArrayList<>();
	int ta = 0;
	auxiliar(tablero, 0, ta);
	System.out.println(ta);
	return ta;
    }

    public static void auxiliar(int[] tablero, int posicion , int ta)
    {
	if(posicion == tablero.length)
	    {
		if(!valido(tablero))
		    {
			ta++;
			System.out.println(ta);
		    }
	    }else
	    {
		for(int i = 0; i < tablero.length; i++)
		    {
			tablero[posicion] = i;
			auxiliar(tablero, posicion+1, ta);
		    }
	    }
    }

    public static boolean valido(int[] tablero)
    {
	for(int i = 0; i < tablero.length; i++)
	    {
		for(int j = 0; j <tablero.length; j++)
		    {
			if(tablero[i] == tablero[j] || Math.abs(tablero[i]-tablero[j])== Math.abs(j-i))
			    {
				return true;
				
			    }
		    }
	    }
	return false;
    }
    
    
    /*public static void main(String[] args )
      {
      TallerCom primero = new TallerCom();
      ArrayList<String> p = primero.combinations("abc");
      for(int i = 0; i < p.size(); i++)
      {
      System.out.println(p.get(i));
      }
      }*/
}
