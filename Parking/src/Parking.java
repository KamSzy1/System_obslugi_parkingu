import java.util.ArrayList;

public class Parking {
    private char[][] plac_parkingu;
    private Pojazd p = new Pojazd();
    private int wybor_miejsca_i, wybor_miejsca_j;
    private boolean sprawdz = false;
    int p_1, p_2;
    public static boolean dodawanie;


    Parking(){
        p_1 = 11;
        p_2 = 20;
        plac_parkingu = new char[p_1][p_2];

        for (int i = 0; i < p_1; i++){
            for (int j = 0; j < p_2; j++){
                if((i)%3 == 2){
                    plac_parkingu[i][j] = 'p';
                }
                else{
                    plac_parkingu[i][j] = 'x';
                }
            }
        }
    }

    public void Przyjazd(int p, int wybor_i, int wybor_j) {
        dodawanie = false;
        this.wybor_miejsca_i = wybor_i;
        this.wybor_miejsca_j = wybor_j;
            if (p == 1) {
                if(plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] == 'x') {
                    System.out.println("Dodano motocykl na miejsce: " + wybor_miejsca_i + ", " + wybor_miejsca_j);
                    plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] = ('m');
                    dodawanie = true;
                }
                else{
                    System.out.println("Miejsce parkingowe jest zajęte");
                }
            }

            if (p == 2) {
                for (int i = 0; i < 2; i++){
                    for (int j = 0; j < 1; j++){
                        if (plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] == 'x' &&  plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] == 'x')
                            {
                                dodawanie = true;
                                sprawdz = true;
                            }
                    }
                }

                if (sprawdz == true) {
                    System.out.println("Dodano samochód na miejsce: " + wybor_miejsca_i + ", " + wybor_miejsca_j);
                    plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] = 's';
                    plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] = 's';

                    sprawdz = false;
                } else {
                    System.out.println("Nie można dodać pojazdu na wybrane miejsce. Proszę wybrać inne");
                }
            }

            if (p == 3) {
                for (int i = 0; i < 2; i++){
                    for (int j = 0; j < 2; j++){
                        if (plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] == 'x' &&  plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] == 'x'
                                &&  plac_parkingu[wybor_miejsca_i][wybor_miejsca_j+1] == 'x' &&  plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j + 1] == 'x'){
                            sprawdz = true;
                            dodawanie = true;
                        }
                    }
                }

            if (sprawdz == true) {
                System.out.println("Dodano autobus na miejsce: " + wybor_miejsca_i + ", " + wybor_miejsca_j);
                plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] = 'a';
                plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] = 'a';
                plac_parkingu[wybor_miejsca_i][wybor_miejsca_j + 1] = 'a';
                plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j + 1] = 'a';

                sprawdz = false;
                }
            else{
                System.out.println("Nie można dodać pojazdu na wybrane miejsce. Proszę wybrać inne");
            }
            }
        }

    public void Odjazd(int p, int wybor_i, int wybor_j){
        this.wybor_miejsca_i = wybor_i;
        this.wybor_miejsca_j = wybor_j;
        if (p == 1) {
            if(plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] == 'm') {
                System.out.println("Motocykl odjechał z miejsca: " + wybor_miejsca_i + ", " + wybor_miejsca_j);
                plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] = ('x');

            }
            else{
                System.out.println("Na miejscu parkingowym nie istnieje taki pojazd");
            }
        }

        if (p == 2) {
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 1; j++){
                    if (plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] == 's' &&  plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] == 's')
                    {
                        sprawdz = true;
                    }
                }
            }

            if (sprawdz == true) {
                System.out.println("Samochód odjechał z miejsca: " + wybor_miejsca_i + ", " + wybor_miejsca_j);
                plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] = 'x';
                plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] = 'x';
                sprawdz = false;
            } else {
                System.out.println("Na miejscu parkingowym nie istnieje taki pojazd");
            }
        }

        if (p == 3) {
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 2; j++){
                    if (plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] == 'a' &&  plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] == 'a'
                            &&  plac_parkingu[wybor_miejsca_i][wybor_miejsca_j+1] == 'a' &&  plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j + 1] == 'a'){
                        sprawdz = true;
                    }
                }
            }

            if (sprawdz == true) {
                System.out.println("Autobus odjechał z miejsca: " + wybor_miejsca_i + ", " + wybor_miejsca_j);
                plac_parkingu[wybor_miejsca_i][wybor_miejsca_j] = 'x';
                plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j] = 'x';
                plac_parkingu[wybor_miejsca_i][wybor_miejsca_j + 1] = 'x';
                plac_parkingu[wybor_miejsca_i + 1][wybor_miejsca_j + 1] = 'x';

                sprawdz = false;
            }
            else{
                System.out.println("Na miejscu parkingowym nie istnieje taki pojazd");
            }
        }
    }


    public void Wyglad_parkingu() {
        for (int i = 0; i < p_1; i++){
            for (int j = 0; j < p_2; j++){
                System.out.print(plac_parkingu[i][j] + " ");
            }
            System.out.println();
        }
    }

}

