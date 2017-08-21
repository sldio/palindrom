/**
 * Created by 1 on 21.08.2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        Palindrom palindrom = new Palindrom();
        palindrom.findAllPalindroms();
        System.out.println(palindrom.maxPalindrom());

//        System.out.println(Palindrom.isPalindrom(1234554321));
        System.out.println("working time - " + (System.currentTimeMillis() - start) + " ms");
    }
}
