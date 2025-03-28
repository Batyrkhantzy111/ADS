import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        //int n = in.nextInt();

//        int[] numbers = new int[n];
//        for (int i=0; i<n;i++)
//        {
//            numbers[i]=in.nextInt();
//        }

        // int a = in.nextInt();

//        String s=in.nextLine();

        
//        char[] a = s.toCharArray();

        findMin (new int[]{10,1,32,3,45}, 5);
        avg (new int[]{3,2,4,1}, 4);
        ChPr(11);
        System.out.println(fact(5));
        fib(5);
        pow(2,10);
        generatePermutations("","IOX");
        isalldigits("123a12");
        System.out.println(binomialcoef(7,3));
        System.out.println(  GCF(32,48));
    }

    //Time complexity: O(n), space complexity: O(1)
    public static void findMin(int[] numbers, int n)
    {
        int min = numbers[0];
        for (int i=1; i<n; i++)
        {
            if (numbers[i]<min)
            {
                min = numbers[i];
            }
        }
        System.out.println(min);
    }

    //Time complexity: O(n), space complexity: O(1)
    public static void avg (int[] numbers, int n)
    {
        float sum = 0;
        for (int i=0; i<n;i++)
        {
            sum+=numbers[i];
        }
        float Avg=sum/n;
        System.out.println(Avg);
    }

    //Time complexity: O(sqrt(n)), space complexity: O(1)
    public static void ChPr(int n) {
        if (n <=1)
        {
            System.out.println("Composite");
            return;
        }

        if (n==2)
        {
            System.out.println("Prime");
            return;
        }

        if (n%2==0)
        {
            System.out.println("Composite");
            return;
        }

        for (int i=3; (i*i)<=n; i+=2)
        {
            if (n%i==0) {
                System.out.println("Composite");
                return;
            }
        }
        System.out.println("Prime");
    }

    //Time complexity: O(n), space complexity: O(n)
    public static int fact(int n) {
        return (n<=1) ? 1 : n*fact(n-1);
    }

    //Time complexity: O(2^n), space complexity: O(n)
    public static int fib(int n) {
        return (n<=1) ? n : fib(n-1)+fib(n- 2);
    }

    //Time complexity: O(n), space complexity: O(1)
    public static int pow (int a, int n)
    {
        int result = 1;
        for (int i=0; i<n; i++)
        {
            result *=a;
        }
        return result;
    }

    //Time complexity: O(n*n!), space complexity: O(n)
    public static void generatePermutations(String pref,String remaining)
    {
        if (remaining.isEmpty())
        {
            System.out.println(pref);
        }
        else
        {
            for (int i=0; i<remaining.length(); i++)
            {
                String newPref=pref+remaining.charAt(i);
                String newRemaining=remaining.substring(0,i) + remaining.substring(i+1);
                generatePermutations(newPref, newRemaining);
            }
        }
    }

    //Time complexity: O(n), space complexity: O(1)
    public static void isalldigits(String s) {
        for (int i=0; i<s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
            {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }


    //Time complexity: O(2^n), space complexity: O(n)
    public static int binomialcoef (int n, int k)
    {
        if (k==0 || k==n)
        {
            return 1;
        }
        else
        {
            return binomialcoef(n-1,k-1) + binomialcoef(n-1,k);
        }
    }

    //Time complexity: O(log(min(a,b)), space complexity: O(log(min(a,b))
    public static int GCF (int a, int b)
    {
        if (b == 0) {
            return a;
        }

        else if (a%b==0)
        {
            return b;
        }

        else {
            return GCF(b,a%b);
        }
    }
}