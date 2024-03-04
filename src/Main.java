import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        //Introducem metoda de scanare
        Scanner scan = new Scanner(System.in);
        System.out.println("I.Giosan: Buna, dragilor!");
        Lotto jocLotto = new Lotto();
        int x = 0;
        int[] A = new int[6];
        boolean inputOK = false, testNumber;
        String inData = null;
        //punctul A
        System.out.println("Introduceti cate numere vreti sa fi ghicit jucatorul: ");
        //Citim numarul cerut de consola
        while(!inputOK)
        {
            testNumber = true;
            inData = scan.nextLine();
            try
            {
                x = Integer.parseInt(inData);
                inputOK = true;
            }
            catch(NumberFormatException ex) {
                System.out.println("\nAti introdus date invalide");
                System.out.println("Va rugam reincercati");
                System.out.print("here you go -> ");
                testNumber = false;
            }
            if(testNumber == true)
            {
                if(x < 3 || x > 6)
                {
                    System.out.println("\nAti introdus un numar necorespunzator pentru categoria de castig");
                    System.out.println("Numerele disponibile sunt [3, 4, 5, 6]");
                    System.out.println("Va rugam reincercati");
                    System.out.print("here you go -> ");
                    inputOK = false;
                }
            }

        }
        //Chemam, in conjunctie cu numele obiectului, metoda getChances, care ne va spune, in functie de
        //cate numere vrem sa fi ghicit jucatorul, sansa de a castiga la categoria respectiva (cat. 1/2/3/4)
        jocLotto.getChances(x);
        //punctul B
        jocLotto.initExtragere(A);
        //punctul C
        jocLotto.listInOrder(A);
    }
}