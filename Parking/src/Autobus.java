public class Autobus extends Pojazd{

    Autobus(){

    }

    Autobus(String marka1, int pojemnosc_silnika1, int rok_produkcji1, String numer_rejestracyjny1, String nazwisko1, String data_parkowania1){
        super(marka1,pojemnosc_silnika1, rok_produkcji1, numer_rejestracyjny1, nazwisko1, data_parkowania1);
    }

    Autobus(String marka1, int pojemnosc_silnika1, int rok_produkcji1, String numer_rejestracyjny1, String nazwisko1, String data_parkowania1, int i, int j){
        super(marka1,pojemnosc_silnika1, rok_produkcji1, numer_rejestracyjny1, nazwisko1, data_parkowania1, i, j);
    }

    @Override
    public String toString(){
        super.toString();
        String nazwa = new String("Informacje o autobusie: marka "+getMarka()+", pojemność silnika "+getPojemnosc_silnika()+", rok produkcji "+getRok_produkcji()+", numer rejestracyjny "+getNumer_rejestracyjny()+", nazwisko właściciela "+getNazwisko()+", data parkowania: "+getData_parkowania() + ", na miejscu: "+ getI() + ", " + getJ());
        return nazwa;
    }
}
