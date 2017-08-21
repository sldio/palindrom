/**
 * Created by 1 on 21.08.2017.
 */
public class Atkin
{
    private static boolean[] isPrimes;
    private static int limit;

    public static boolean[] getIsPrimes()
    {
        setLimit();
        findPrimes();
        return isPrimes;
    }

    public static void setLimit()
    {
        Atkin.limit = 99999;
    }

    public static void findPrimes()
    {
        isPrimes = new boolean[100000];
        double sqrt = Math.sqrt(limit);
        //double limit = (double) limit;
        for (int x = 1; x <= sqrt; x++)
        {
            for (int y = 1; y <= sqrt; y++)
            {
                int x2 = x * x;
                int y2 = y * y;
                int n = 4 * x2 + y2;

                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    isPrimes[n] ^= true;

                n -= x2;
                if (n <= limit && n % 12 == 7)
                    isPrimes[n] ^= true;

                n -= 2 * y2;
                if (x > y && n <= limit && n % 12 == 11)
                    isPrimes[n] ^= true;
            }
        }

        for (int n = 5; n <= sqrt; n += 2)
        {
            if (isPrimes[n])
            {
                int s = n * n;
                for (int k = s; k <= limit; k += s)
                    isPrimes[k] = false;
            }
        }
        System.out.println();
    }

}
