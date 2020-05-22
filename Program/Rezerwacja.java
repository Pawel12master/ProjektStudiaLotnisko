package Program;

public class Rezerwacja {
	protected String data;
	protected String skad,dokad;
	protected int ilosc_miejsc;
	protected double czas_podrozy;
	protected Samolot s;
	
	public Rezerwacja(String b,String c,String d,int e,double f)
	{
		data=b;
		skad=c;
		dokad=d;
		
		ilosc_miejsc=e;
		czas_podrozy=f;
	}
}
