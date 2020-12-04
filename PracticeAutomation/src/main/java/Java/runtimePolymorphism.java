package Java;

class parent {
	
	int d=90;
	
	void run()
	{
		System.out.println("in Parent class");
	}
	
	

}

class runtimePolymorphism extends parent
{
	int d=9100;
	void run()
	{
		System.out.println("In second class");
	}
	
	void demo()
	{
		System.out.println("in demo class");
	}
	
	public static void main(String[] args) {
		
		parent demo=new runtimePolymorphism();
		demo.run();
		System.out.println(demo.d);
	}
}
