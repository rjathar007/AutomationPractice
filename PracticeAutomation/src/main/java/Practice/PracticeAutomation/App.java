package Practice.PracticeAutomation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String str="foo";
    	Object obj=(Object)str;
        System.out.println( obj );
        if (str.equals(obj)) {
        	System.out.println("AAA");
			
		}
        else if(obj.equals(str))
        {
        	System.out.println("CCC");
        }
        else
        {
        	System.out.println("DDD");
        }
    }
}
