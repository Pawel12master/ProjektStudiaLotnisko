package Program;

public class Trasa {
	protected Lotnisko l1,l2;
	protected double odleglosc;
	
	public Trasa(Lotnisko a,Lotnisko b) 
	{
		l1=a;
		l2=b;
		odleglosc=Math.sqrt((l1.x-l2.x)*(l1.x-l2.x)+(l1.y-l2.y)*(l1.y-l2.y));
	}
}
