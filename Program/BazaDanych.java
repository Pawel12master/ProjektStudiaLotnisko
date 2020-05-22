package Program;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class BazaDanych {
	private LinkedList<Samolot> s = new LinkedList<Samolot>();	
	private LinkedList<Lotnisko> l = new LinkedList<Lotnisko>();
	private LinkedList<Trasa> t = new LinkedList<Trasa>();
	private LinkedList<Klient> k = new LinkedList<Klient>();
	
	public BazaDanych() {}
	
	public void dodajSamolot(Samolot sam)
	{
		s.add(sam);	
	}
	public void wypiszSamolot()
	{
		for (int i=0;i<s.size();i++)
		{
			System.out.println("Samolot nr: "+s.get(i).index+" miejsca: "+s.get(i).miejsca+" zasieg: "+s.get(i).zasieg+
			" predkosc: "+s.get(i).predkosc+" wolne miejsca: "+s.get(i).wolne_miejsca);
		}
		System.out.println("Liczba samolotow: "+s.size()+"\n");
		
		
	}
	public void usunSamolot(int nr)
	{
		for (int i=0;i<s.size();i++)
		{
			if(nr==s.get(i).index)
			{
				s.remove(i);
				System.out.println("Samolot usunieto");
				break;
			}
			if(i==s.size()-1)
			{
				System.out.println("Nie ma samolotu o takim numerze");
			}
		}
	}
	
	public void dodajLotnisko(Lotnisko lot)
	{
		l.add(lot);
		if(l.size()>1) //automatyczne generowanie tras
		{
			for(int i=0;i<l.size();i++)
			{
				for(int j=0;j<l.size();j++)
				{
					if(l.get(i).nazwa!=l.get(j).nazwa)
					{
						Trasa tt = new Trasa(l.get(i),l.get(j));
						t.add(tt);
					}
				}
			}
			for(int i=0;i<t.size();i++)
			{
				for(int j=0;j<t.size();j++)
				{
					if(t.get(i).l1.nazwa==t.get(j).l1.nazwa && t.get(i).l2.nazwa==t.get(j).l2.nazwa && i!=j)
					{
						t.remove(j);
						j--;
					}
				}
			}
		}
	}
	public void wypiszLotnisko()
	{
		for(int i=0;i<l.size();i++)
		{
			System.out.println("Lotnisko: "+l.get(i).nazwa+" wspolrzedne: "+l.get(i).x+" , "+l.get(i).y);
		}
		System.out.println("Liczba lotnisk: "+l.size()+"\n");
	}
	public void usunLotnisko(String nazwa)
	{
		int y=t.size();
		for(int i=0;i<y;i++) // automatyczne usuwanie tras w ktorych bylo usuniete lotnisko
		{
			if(t.get(i).l1.nazwa.equals(nazwa) || t.get(i).l2.nazwa.equals(nazwa))
			{
				t.remove(i);
				i--;
				y--;
			}
		}
		for (int i=0;i<l.size();i++)
		{
			if(nazwa.equals(l.get(i).nazwa))
			{
				l.remove(i);
				System.out.println("Lotnisko usunieto");
				break;
			}
			if(i==l.size()-1)
			{
				System.out.println("Nie ma takiego lotniska");
			}
		}
	}
	
	public void wypiszTrasa()
	{
		System.out.println("Trasy:");
		for(int i=0;i<t.size();i++)
		{
			System.out.println(t.get(i).l1.nazwa+" "+t.get(i).l2.nazwa);
		}
		System.out.println("Liczba tras: "+t.size()+"\n");
	}
	
	public void dodajKlienta(Klient kli)
	{		
		k.add(kli);
	}
	public void wypiszKlienta()
	{
		for(int i=0;i<k.size();i++)
		{
			System.out.println(k.get(i).imie+" "+k.get(i).nazwisko+" PESEL: "+k.get(i).PESEL);				
		}
		System.out.println();
	}
	public void usunKlienta(String pesel)
	{
		for (int i=0;i<k.size();i++)
		{
			if(pesel.equals(k.get(i).PESEL))
			{
				k.remove(i);
				break;
			}
		}
	}
	public void dodajRezerwacje(String pesel, Rezerwacja r)
	{
		int a=0;
		Trasa tr = null;
		if(k.size()<1)
		{
			System.out.println("Dodaj klienta!!!");
		}
		else
		{
			for(int i=0;i<k.size();i++)
			{
				if(l.size()<2)
				{
					System.out.println("Dodaj lotniska!!!");
					break;
				}
				if(s.size()<1)
				{
					System.out.println("Dodaj samoloty!!!");
					break;
				}
				if(pesel.equals(k.get(i).PESEL))
				{
					for(int j=0;j<t.size();j++)
					{
						if(r.skad.equals(t.get(j).l1.nazwa) && r.dokad.equals(t.get(j).l2.nazwa))
						{
							tr=t.get(j);
							break;
						}
						if(j==t.size()-1)
						{
							System.out.println("Nie ma takich lotnisk");
							a=1;
						}
					}
					if(a==1)
					{
						break;
					}
					for(int j=0;j<s.size();j++)
					{
						if(r.ilosc_miejsc<=s.get(j).wolne_miejsca && r.czas_podrozy>=tr.odleglosc/s.get(j).predkosc)
						{
							r.s=s.get(j);
							s.get(j).wolne_miejsca = s.get(j).wolne_miejsca-r.ilosc_miejsc;
							k.get(i).dodajRezerwe(r);
							System.out.println("Rezerwacja dodana");
							a=1;
							break;
						}
						if(j==s.size()-1)
						{
							System.out.println("Nie ma odpowiedniego samolotu");
							a=1;
							break;
						}
					}
				}
				if(a==1)
				{
					break;
				}
				if(i==k.size()-1)
				{
					System.out.println("Nie ma takiego klienta");
				}
			}
		}
		
		System.out.println();
	}
	public void wypiszRezerwacje()
	{
		for(int i=0;i<k.size();i++)
		{
				System.out.println("Rezerwacje "+k.get(i).imie+" "+k.get(i).nazwisko+" "+k.get(i).PESEL);
				k.get(i).wypiszRezerwe();		
		}
	}
	
	public void zapis() throws FileNotFoundException
	{
		File f = new File("dane.txt");
		boolean exist = f.exists();
		if(exist == false)
		{
			System.out.println("Nie udalo sie znalezc pliku");
		}
		else
		{
			PrintWriter wrt = new PrintWriter(f);
			wrt.println("Lista samolotow:");
			for (int i=0;i<s.size();i++)
			{
				wrt.println("Samolot nr: "+s.get(i).index+" miejsca: "+s.get(i).miejsca+" zasieg: "+s.get(i).zasieg+
				" predkosc: "+s.get(i).predkosc+" wolne miejsca: "+s.get(i).wolne_miejsca);
			}
			wrt.println("Liczba samolotow: "+s.size()+"\n");
			wrt.println("Lista lotnisk:");
			for(int i=0;i<l.size();i++)
			{
				wrt.println("Lotnisko: "+l.get(i).nazwa+" wspolrzedne: "+l.get(i).x+" , "+l.get(i).y);
			}
			wrt.println("Liczba lotnisk: "+l.size()+"\n");
			wrt.println("Lista tras:");
			for(int i=0;i<t.size();i++)
			{
				wrt.println(t.get(i).l1.nazwa+" "+t.get(i).l2.nazwa);
			}
			wrt.println("Liczba tras: "+t.size()+"\n");
			wrt.println("Lista klientow:");
			for(int i=0;i<k.size();i++)
			{
				wrt.println(k.get(i).imie+" "+k.get(i).nazwisko+" PESEL: "+k.get(i).PESEL);				
			}
			wrt.println("Liczba klientow: "+k.size()+"\n");
			wrt.println("Lista rezerwacji:");
			for(int i=0;i<k.size();i++)
			{
					wrt.println("Rezerwacje "+k.get(i).imie+" "+k.get(i).nazwisko+" "+k.get(i).PESEL);
					k.get(i).wypiszRezerwe();		
			}
			wrt.close();
		}
	}
}
 