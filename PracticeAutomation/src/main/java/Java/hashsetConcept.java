package Java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hashsetConcept {
	
	public static void main(String[] args) {
		
		HashSet<String> set=new HashSet<String>();
		
		set.add("Testing");
		set.add(null);
		set.add("Devl");
		set.add("Support");
		set.add("Admin");
		//set.add("Testing");
		System.out.println(set);
		
		System.out.println("**********Using for Iterator**********");
		
		Iterator<String> str=set.iterator();
		
		while(str.hasNext())
		{
			String values=str.next();
			System.out.println(values);
		}
		
		
		System.out.println("**********Using for each loop**********");
		
		for(String e:set)
		{
			System.out.println(e);
		}
		
		set.remove(null);
		System.out.println(set);
		
		HashSet<Integer> first=new HashSet<Integer>();
		first.add(1);
		first.add(3);
		first.add(5);
		first.add(2);
		System.out.println(first);
		
		Set<Integer> second=new HashSet<Integer>();
		second.add(0);
		second.add(4);
		second.add(8);
		second.add(3);
		second.add(2);
		System.out.println(second);
		
		Set<Integer> union=new HashSet<Integer>(first);
		union.addAll(second);
		System.out.println(union);
		
		Set<Integer> intersect=new HashSet<Integer>(first);
		intersect.retainAll(second);
		System.out.println(intersect);
		
		
	}

}
