import java.io.FileNotFoundException;
import java.util.Scanner;

import Program.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a,b,c,d;
		String m,n,o,p;
		double w;
		BazaDanych baza = new BazaDanych();
		while(true)
		{
			System.out.println("Menu:\n1.Samoloty\n2.Lotniska\n3.Klienci i Rezerwacje\n4.Zapisz stan na dysk");
			int x = sc.nextInt();
			switch(x) 
			{
			case 1: //Samoloty
			{
				while(true)
				{
					System.out.println("Samoloty:\n1.Dodaj samolot\n2.Usun samolot\n3.Wyswietl samoloty\n4.Powrot");
					x = sc.nextInt();
					if(x==4)
					{
						break;
					}
					switch(x)
					{
						case 1:
						{
							System.out.print("Dodawanie samolotu\nPodaj index(nie moze sie powtarzac): ");
							a = sc.nextInt();
							System.out.print("Liczba miejsc: ");
							b = sc.nextInt();
							System.out.print("Zasieg (km): ");
							c = sc.nextInt();
							System.out.print("Predkosc (km/h): ");
							d = sc.nextInt();
							Samolot s = new Samolot(a,b,c,d);
							baza.dodajSamolot(s);
							System.out.println("Samolot dodano\n");
							break;
							}
						case 2: 
						{
							System.out.print("Usuwanie samolotu\nPodaj nr indexu samolotu: ");
							a = sc.nextInt();
							baza.usunSamolot(a);
							System.out.println();
							break;
						}
						case 3:
						{
							System.out.println("Lista samolotow:");
							baza.wypiszSamolot();
							break;
						}
						default:
						{
							System.out.println("Podaj prawidlowa cyfre");
							break;
						}
					}
				}
				break;
			}		
			case 2: //Lotniska
			{
				while(true)
				{
					System.out.println("Lotniska:\n1.Dodaj lotnisko\n2.Usun lotnisko\n3.Wyswietl lotniska\n4.Wyswietl trasy\n5.Powrot");
					x = sc.nextInt();
					if(x==5)
					{
						break;
					}
					switch(x)
					{
						case 1:
						{
							System.out.print("Dodawanie lotniska\nPodaj nazwe: ");
							m = sc.next();
							//zalozenie ze 1 jednostka na ukladzie wspolrzednych to 1 km
							System.out.print("Wspolrzedna x: ");
							a = sc.nextInt();
							System.out.print("Wspolrzedna y: ");
							b = sc.nextInt();
							Lotnisko l = new Lotnisko(m,a,b);
							baza.dodajLotnisko(l);
							System.out.println("Lotnisko dodano\n");
							break;
						}
						case 2:
						{
							System.out.print("Usuwanie lotniska\nPodaj nazwe lotniska: ");
							m = sc.next();
							baza.usunLotnisko(m);
							System.out.println();
							break;
						}
						case 3:
						{
							System.out.println("Lista lotnisk:");
							baza.wypiszLotnisko();
							break;
						}
						case 4:
						{
							System.out.println("Lista tras:");
							baza.wypiszTrasa();
							break;
						}
						default:
						{
							System.out.println("Podaj prawidlowa cyfre");
							break;
						}
					}
				}
				break;
			}
			case 3: //Klienci
			{
				while(true)
				{
					System.out.println("Klienci:\n1.Dodaj klienta\n2.Usun klienta\n3.Wyswietl klientow\n4.Dodaj rezerwacje\n5.Wyswietl rezerwacje\n6.Powrot");
					x = sc.nextInt();
					if(x==6)
					{
						break;
					}
					switch(x)
					{
						case 1:
						{
							System.out.print("Dodawanie klienta\nPodaj imie: ");
							m = sc.next();
							System.out.print("Nazwisko: ");
							n = sc.next();
							System.out.print("PESEL: ");
							o = sc.next();
							Klient k = new Klient(m,n,o);
							baza.dodajKlienta(k);
							System.out.println("Klient dodany\n");
							break;
						}
						case 2:
						{
							System.out.print("Usuwanie klienta:\nPodaj PESEL osoby: ");
							m = sc.next();
							baza.usunKlienta(m);
							System.out.println();
							break;
						}
						case 3:
						{
							System.out.println("Lista klientow:");
							baza.wypiszKlienta();
							break;
						}
						case 4:
						{
							System.out.print("Dodawanie rezerwacji\nPodaj PESEL osoby: ");
							m = sc.next();
							System.out.print("Data: ");
							n = sc.next();
							System.out.print("Skad: ");
							o = sc.next();
							System.out.print("Dokad: ");
							p = sc.next();
							System.out.print("Liczba rezerwowanych miejsc: ");
							a = sc.nextInt();
							System.out.print("Czas podrozy (h): ");
							w = sc.nextDouble();
							Rezerwacja r = new Rezerwacja(n,o,p,a,w);
							baza.dodajRezerwacje(m, r);
							break;
						}
						case 5:
						{
							System.out.println("Wyswietlanie rezerwacji:");
							baza.wypiszRezerwacje();
							break;
						}
						default:
						{
							System.out.println("Podaj prawidlowa cyfre");
							break;
						}
					}
				}
			}
			case 4:
			{
				baza.zapis();
				break;
			}
			default:
			{
				System.out.println("Podaj prawidlowa cyfre");
				break;
			}
			}
		}		
	}

}
