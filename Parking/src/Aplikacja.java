import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class Aplikacja extends JFrame{
    private JPanel Main;
    private JButton stanButton;
    private JButton motocyklButton;
    private JButton wizualizacjaParkinguButton;
    private JButton autobusButton;
    private JButton samochodButton;
    private JLabel przyjazd;
    private JButton odjazdMotocykl;
    private JButton odjazdSamochod;
    private JButton odjazdAutobus;
    private JPanel Dodawnko;
    private JTextField text_wybor_i;
    private JTextField text_Marka;
    private JTextField text_Pojemnosc;
    private JTextField text_RokProdukcji;
    private JTextField text_Numer_Rej;
    private JTextField text_Nazwisko;
    private JTextField textData;
    private JTextField text_wybor_j;
    private JButton ButtonWyczysc;
    private JTextField textWyjazd;
    private JButton numerzeRejestracyjnymButton;
    private JButton pojemnośćSilnikaButton;
    private JButton szukajButton;
    private JTextField textSzukaj;
    static Parking parking;
    private int wybor_pojazdu;
    private Pojazd motocykl;
    private Pojazd samochod;
    private Pojazd autobus;
    static ArrayList<Pojazd> lista;
    static ArrayList<Pojazd> lista_wyjazd;
    static ArrayList<Pojazd> lista_do_sortowanka;

    public Aplikacja() {
        super("Program obsługi parkingu");
        this.setContentPane(this.Main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setSize(1100, 350);
        setVisible(true);
        setLayout(null);

        //Stworzenie potrzebnych list
        lista = new ArrayList<Pojazd>();
        lista_wyjazd = new ArrayList<Pojazd>();
        lista_do_sortowanka = new ArrayList<Pojazd>();

        //Stworzenie parkingu
        parking = new Parking();

        //Przyjazdy
        motocyklButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybor_pojazdu = 1;
                    parking.Przyjazd(wybor_pojazdu, Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));
                    motocykl = new Motocykl(text_Marka.getText(), Integer.parseInt(text_Pojemnosc.getText()), Integer.parseInt(text_RokProdukcji.getText()), text_Numer_Rej.getText(), text_Nazwisko.getText(),  textData.getText(), Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));
                if(Parking.dodawanie == true){
                    lista.add(motocykl);
                    Parking.dodawanie = false;
                }
            }
        });

        samochodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybor_pojazdu = 2;
                    parking.Przyjazd(wybor_pojazdu, Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));
                    samochod = new Samochod(text_Marka.getText(), Integer.parseInt(text_Pojemnosc.getText()), Integer.parseInt(text_RokProdukcji.getText()), text_Numer_Rej.getText(), text_Nazwisko.getText(),  textData.getText(), Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));
                if(Parking.dodawanie == true){
                    lista.add(samochod);
                    Parking.dodawanie = false;
                }
            }
        });

        autobusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybor_pojazdu = 3;
                    parking.Przyjazd(wybor_pojazdu, Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));
                    autobus = new Autobus(text_Marka.getText(), Integer.parseInt(text_Pojemnosc.getText()), Integer.parseInt(text_RokProdukcji.getText()), text_Numer_Rej.getText(), text_Nazwisko.getText(),  textData.getText(), Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));
                if(Parking.dodawanie == true){
                    lista.add(autobus);
                    Parking.dodawanie = false;
                }
            }
        });
        //Wizualizacja
        wizualizacjaParkinguButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Wygląd parkingu:");
                parking.Wyglad_parkingu();
            }
        });
        //Stan parkingu
        stanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Aktualny stan parkingu:");
                System.out.println("Na parkingu znajdują się:");
                for(int i=0; i < lista.size(); i++){
                    System.out.println(i + " " + lista.get(i));
                }

                System.out.println("--------------------------");
                System.out.println("Z parkingu odjechały:");
                for(int i=0; i < lista_wyjazd.size(); i++){
                    System.out.println(i + " " + lista_wyjazd.get(i));
                }
            }
        });

        //Odjazdy
        odjazdMotocykl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybor_pojazdu = 1;
                parking.Odjazd(wybor_pojazdu, Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));

                lista_wyjazd.add(lista.get(Integer.parseInt(textWyjazd.getText())));
                lista.remove(Integer.parseInt(textWyjazd.getText()));
            }
        });
        odjazdSamochod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybor_pojazdu = 2;
                parking.Odjazd(wybor_pojazdu, Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));

                lista_wyjazd.add(lista.get(Integer.parseInt(textWyjazd.getText())));
                lista.remove(Integer.parseInt(textWyjazd.getText()));
            }
        });
        odjazdAutobus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wybor_pojazdu = 3;
                parking.Odjazd(wybor_pojazdu, Integer.parseInt(text_wybor_i.getText()),Integer.parseInt(text_wybor_j.getText()));

                lista_wyjazd.add(lista.get(Integer.parseInt(textWyjazd.getText())));
                lista.remove(Integer.parseInt(textWyjazd.getText()));
            }
        });

        //Czyszczenie przycisk
        ButtonWyczysc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text_wybor_i.setText("");
                text_Marka.setText("");
                text_Pojemnosc.setText("");
                text_RokProdukcji.setText("");
                text_Numer_Rej.setText("");
                text_Nazwisko.setText("");
                textData.setText("");
                text_wybor_j.setText("");
                textWyjazd.setText("");
                textSzukaj.setText("");
            }
        });
        //Sortowanko
        numerzeRejestracyjnymButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Lista posortowana według numeru rejestracyjnego: ");
                lista.sort(Comparator.comparing(Pojazd::getNumer_rejestracyjny));
                lista_do_sortowanka = lista;
                for(int i=0; i < lista_do_sortowanka.size(); i++){
                    System.out.println(i + " " + lista_do_sortowanka.get(i));
                }
            }
        });
        pojemnośćSilnikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Lista posortowana według numeru rejestracyjnego: ");
                lista.sort(Comparator.comparing(Pojazd::getPojemnosc_silnika));
                lista_do_sortowanka = lista;
                for(int i=0; i < lista_do_sortowanka.size(); i++){
                    System.out.println(i + " " + lista_do_sortowanka.get(i));
                }
            }
        });
        szukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Wynik wyszukiwania podanego numeru rejestracyjnego: ");
                for(Pojazd k : lista) {
                    if (k.getNumer_rejestracyjny().equals(textSzukaj.getText())) {
                        System.out.println("Samochód o podanym numerze rejestracyjnym znajduje" +
                                "się na liście pod numerem: " + lista.indexOf(k));
                    }
                }
                System.out.println("--------------------------");
                System.out.println("Jeśli nie wyświetlił się żaden rekord. Sprawdź poprawność numeru rejestracyjnego wpisanego w pole");
            }
        });
    }

    public static void main(String[] args){
        Aplikacja program = new Aplikacja();
        Pojazd jeden = new Motocykl("Audi", 330, 2001, "RSA8582", "Nowak", "22/12/2021", 0, 0);
        parking.Przyjazd(1, 0, 0);
        Pojazd dwa = new Motocykl("BMW", 655, 2001, "FSD9357", "Kowalski", "08/01/2022", 0, 5);
        parking.Przyjazd(1, 0, 5);
        Pojazd trzy = new Autobus("Autosan", 441, 2005, "WY30616", "Wincent", "14/01/2022", 6, 0);
        parking.Przyjazd(3, 6, 0);
        Pojazd cztery = new Samochod("Chevrolet", 560, 2006, "DDZ3483", "John", "09/01/2022", 3, 0);
        parking.Przyjazd(2, 3, 0);
        Pojazd piec = new Autobus("Citroen", 1200, 2005, "POB3803", "Bednarczyk", "08/02/2022", 3, 3);
        parking.Przyjazd(3, 3, 3);
        Pojazd szesc = new Samochod("Fiat", 562, 1997, "EL15404", "Szczepański", "01/01/2022", 3, 3);
        parking.Przyjazd(2, 0, 12);
        Pojazd siedem = new Samochod("Alfa Romeo", 890, 2002, "NGO3435", "Stępień", "12/12/2021", 3, 3);
        parking.Przyjazd(2, 3, 12);
        Pojazd osiem = new Samochod("Seat", 900, 2003, "KWA2016", "Brzeziński", "28/12/2021", 3, 3);
        parking.Przyjazd(2, 9, 3);
        Pojazd dziewiec = new Autobus("Peugeot", 1100, 2021, "ERA1080", "Tomczak", "31/12/2021", 3, 3);
        parking.Przyjazd(3, 6, 12);
        Pojazd dziesiec = new Autobus("Kia", 1120, 2000, "PKN9408", "Brzozowski", "27/12/2021", 3, 3);
        parking.Przyjazd(3, 3, 10);

        lista.add(jeden);
        lista.add(dwa);
        lista.add(trzy);
        lista.add(cztery);
        lista.add(piec);
        lista.add(szesc);
        lista.add(siedem);
        lista.add(osiem);
        lista.add(dziewiec);
        lista.add(dziesiec);
    }
}
