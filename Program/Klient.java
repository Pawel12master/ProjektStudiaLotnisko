package Program;
import java.util.LinkedList;

public class Klient {
	protected String imie;
	protected String nazwisko;
	protected String PESEL;
	protected LinkedList<Rezerwacja> r = new LinkedList<Rezerwacja>();
	
	public Klient(String i,String n,String P)
	{
		imie=i;
		nazwisko=n;
		PESEL=P;
	}
	
	public void dodajRezerwe(Rezerwacja rez)
	{
		r.add(rez);
	}
	public void wypiszRezerwe()
	{
		for (int i=0;i<r.size();i++)
		{
			System.out.println(r.get(i).data+" "+r.get(i).skad+" "+r.get(i).dokad);
		}
	}
}
