public class Pojazd {

    private String marka;
    private int pojemnosc_silnika;
    private int rok_produkcji;
    private String numer_rejestracyjny;
    private String nazwisko;
    private String data_parkowania;
    private int i, j;

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    Pojazd(){
        this.marka = new String();
        this.pojemnosc_silnika = 0;
        this.rok_produkcji = 0;
        this.numer_rejestracyjny = new String();
        this.nazwisko = new String();
        this.data_parkowania = new String();
        this.i = 0;
        this.j = 0;
    }

    Pojazd(String marka1, int pojemnosc_silnika1, int rok_produkcji1, String numer_rejestracyjny1, String nazwisko1, String data_parkowania1){
        this.marka = new String(marka1);
        this.pojemnosc_silnika = pojemnosc_silnika1;
        this.rok_produkcji = rok_produkcji1;
        this.numer_rejestracyjny = new String(numer_rejestracyjny1);
        this.nazwisko = new String(nazwisko1);
        this.data_parkowania = new String(data_parkowania1);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    Pojazd(String marka1, int pojemnosc_silnika1, int rok_produkcji1, String numer_rejestracyjny1, String nazwisko1, String data_parkowania1, int i, int j){
        this.marka = new String(marka1);
        this.pojemnosc_silnika = pojemnosc_silnika1;
        this.rok_produkcji = rok_produkcji1;
        this.numer_rejestracyjny = new String(numer_rejestracyjny1);
        this.nazwisko = new String(nazwisko1);
        this.data_parkowania = new String(data_parkowania1);
        this.i = i;
        this.j = j;
    }

    public String getMarka() {
        return marka;
    }

    public int getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public String getNumer_rejestracyjny() {
        return numer_rejestracyjny;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getData_parkowania() {
        return data_parkowania;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setPojemnosc_silnika(int pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public void setNumer_rejestracyjny(String numer_rejestracyjny) {
        this.numer_rejestracyjny = numer_rejestracyjny;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setData_parkowania(String data_parkowania) {
        this.data_parkowania = data_parkowania;
    }

    @Override
    public String toString(){
        String nazwa = new String("Marka "+marka+", pojemność silnika "+pojemnosc_silnika+", rok produkcji "+rok_produkcji
                +", numer rejestracyjny "+numer_rejestracyjny+", nazwisko właściciela "+nazwisko+", data parkowania: "+data_parkowania + ", na miejscu: " + i + ", " + j);
        return nazwa;
    }

}
