import java.util.concurrent.TimeUnit;
public class Lotto {
    private static double computeChances_BI(int howManyGuessedNumbers)
    {//nota: "BI" din denumire se refera la o functie de bucatarie interna

        //constanta luata de la Mircea Rus, reprezinta combinari de 49 luate cate 6,
        //adica numarul tuturor combinatiilor posibile pentru un jucator
        double constanta = 13983816;

        return switch (howManyGuessedNumbers) {
            case 3 -> 246820 / constanta;
            case 4 -> 13545 / constanta;
            case 5 -> 256 / constanta;
            case 6 -> 1 / constanta;
            default -> 0;
        };
    }

    public void getChances(int howManyGuessedNumbers){
        System.out.println("Sansele de castig la 6/49 daca un jucator a nimerit " + howManyGuessedNumbers +
                " numere sunt de " + computeChances_BI(howManyGuessedNumbers) + "\n");
    }

    private static boolean cauta(int[] A, int n, int elem)
    {
        //nu am putut sa fac o cautare binara, fiindca as fi avut nevoie de un sir ordonat pentru asta
        //hence cautam liniar
        int i;
        for(i = 0; i < n; i++)
            if(A[i] == elem)
                return true;
        return false;
    }

    private static void fillRandomArray_BI(int[] A, int n)
    {
        //Pentru ca, din teste, observam ca Math.random nu produce numere unice
        //vom face noi o metoda care umple un vector cu valori UNICE
        int counter = 0, x;
        boolean aMaiAparutDeja;
        do{
            x = (int)(Math.random()*49 + 1);
            aMaiAparutDeja = cauta(A, counter, x);
            if(aMaiAparutDeja == false)
            {
                A[counter++] = x;
            }
        }while(counter < n);
    }
    public void initExtragere(int[] colectorBile) {
        System.out.println("Doamnelor si Domnilor, incepe extragerea:");
        fillRandomArray_BI(colectorBile, 6);
        for(int i = 0; i < 6; i++)
            System.out.println(colectorBile[i]);
        System.out.println("Status: extragere incheiata\n");
    }

    private static int EXTRACT_MIN_BI(int[] A, int n)
    {
        int smallest = A[0], i, position = 0;
        for(i = 1; i < n; i++)
            if(smallest > A[i])
            {
                smallest = A[i];
                position = i;
            }
        for(i = position; i < n - 1; i++)
            A[i] = A[i+1];
        n = n - 1;
        return smallest;
    }
    public void listInOrder(int[] A)
    {
        System.out.println("Numerele extrase, dar in ordine crescatoare, sunt:");
        int n = A.length, x;
        do{
            x = EXTRACT_MIN_BI(A, n);
            System.out.println(x);
            n--;
        }while(n > 0);
    }
}
