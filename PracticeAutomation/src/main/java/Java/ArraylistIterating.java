package Java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArraylistIterating {
	
	public static void main(String[] args) {
		
		ArrayList<String> series=new ArrayList<String>();
		series.add("Tarak");
		series.add("GOT");
		series.add("Money Heist");
		series.add("Mirzapur");
		
		System.out.println(series);
		
		System.out.println("************Using Iterator************");
		Iterator<String> it=series.iterator();
		while(it.hasNext())
		{
			String str=it.next();
			System.out.println(str);
		}
		
		System.out.println("************Using For Each Loop************");
		
		for (String show : series) {
			
			System.out.println(show);
			
		}
		
		
		System.out.println("************Using For Loop************");
		
		for (int i = 0; i <series.size(); i++) {
			System.out.println(series.get(i));
			
		}
		
		System.out.println("************Using Listiterator in reverse order************");
		
		ListIterator<String> listiterator=series.listIterator(series.size());
		while(listiterator.hasPrevious())
		{
			String inreverse=listiterator.previous();
			System.out.println(inreverse);
		}
		
	}

}
