import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 1 on 21.08.2017.
 */
public class Palindrom
{
    private boolean[] tabOfPrimes;
    private ArrayList<Long> listOfPalindroms = new ArrayList<Long>();

    public void findAllPalindroms()
    {
        tabOfPrimes = Atkin.getIsPrimes();
        long rez = 0;

        long  firstPrime = getNextPrime(tabOfPrimes.length-1);
        while (firstPrime > 10000)
        {
            long secondPrime = getNextPrime(firstPrime - 1);
            while(secondPrime > 10000)
            {
                long orPalindrom = firstPrime * secondPrime;
                if (isPalindrom(orPalindrom))
                {
                    listOfPalindroms.add(orPalindrom);
                }
                secondPrime = getNextPrime(secondPrime - 1);
            }
            firstPrime = getNextPrime(firstPrime - 1);
        }
    }

    public void showAllPalindroms()
    {
        for (int i = 0; i < listOfPalindroms.size(); i++)
        {
            System.out.println(listOfPalindroms.get(i));
        }
        System.out.println(listOfPalindroms.size());
    }

    public long maxPalindrom()
    {
        Collections.sort(listOfPalindroms);
        long rez = listOfPalindroms.get(listOfPalindroms.size()-1);
        return rez;
    }

    private long getNextPrime(long primeValue)
    {
        long rez = 0;
        while (primeValue > 0)
        {
            if (tabOfPrimes[(int)primeValue])
            {
                rez = primeValue;
                break;
            }
            primeValue--;
        }
        return rez;
    }

    private boolean isPalindrom(long number)
    {
        boolean rez = false;
        char[] arrayOfChars =(String.valueOf(number)).toCharArray();

        for (int i = 0; i < (arrayOfChars.length/2); i++)
        {
            if (arrayOfChars[i] != arrayOfChars[arrayOfChars.length - 1 - i])
            {
                break;
            }
            if (i == (arrayOfChars.length/2 - 1))
            {
                rez = true;
            }
        }
        return  rez;
    }
}
