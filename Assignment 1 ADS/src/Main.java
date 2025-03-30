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

        System.out.println(findMinRec(new int[]{10,1,32,3,45}, 5));
        avg (new int[]{3,2,4,1}, 4);
        chPr(11);
        System.out.println(fact(5));
        fib(5);
        pow(2,10);
        generatePermutations("","IOX");
        digitalis("123a12");
        System.out.println(binomial(7,3));
        System.out.println(  GCF(32,48));
    }

    //Time complexity: O(n), space complexity: O(n)
    public static int findMinRec(int[] numbers, int n) {
        if (n==1) {
            return numbers[0];
        }
        int minOfRest = findMinRec(numbers, n-1);
        return Math.min(minOfRest, numbers[n-1]);
    }

    //Time complexity: O(n), space complexity: O(n)
    public static float sumRecursive(int[] numbers, int n) {
        if (n==1)
        {
            return numbers[0];
        }
        return numbers[n-1] + sumRecursive(numbers, n-1);
    }

    public static void avg(int[] numbers, int n) {
        float sum=sumRecursive(numbers, n);
        float Avg=sum /n;
        System.out.println(Avg);
    }


    //Time complexity: O(sqrt(n)), space complexity: O(sqrt(n))
    public static void chPr(int n) {
        if (n<=1)
        {
            System.out.println("Composite");
        } else if (n==2)
        {
            System.out.println("Prime");
        }
        else if (n%2==0)
        {
            System.out.println("Composite");
        }
        else if
        (isPrimeRec(n,3)) {
            System.out.println("Prime");
        }
        else
        {
            System.out.println("Composite");
        }
    }

    public static boolean isPrimeRec(int n, int i)
    {
        if (i*i>n) return true;
        if (n%i == 0) return false;
        return isPrimeRec(n, i+2);
    }


    //Time complexity: O(n), space complexity: O(n)
    public static int fact(int n) {
        return (n<=1) ? 1 : n*fact(n-1);
    }

    //Time complexity: O(2^n), space complexity: O(n)
    public static int fib(int n) {
        return (n<=1) ? n : fib(n-1)+fib(n- 2);
    }

    //Time complexity: O(logn), space complexity: O(log n)
    public static int pow(int a, int n)
    {
        if (n==0) return 1;
        int half=pow(a,n/2);
        if (n%2==0) return half*half;
        else return half*half*a;
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

    //Time complexity: O(n), space complexity: O(n)
    public static void digitalis(String s) {
        if (isAllDigits(s,0)) {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }

    public static boolean isAllDigits(String s,int index) {
        if (index==s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return isAllDigits(s, index+1);
    }



    //Time complexity: O(2^n), space complexity: O(n)
    public static int binomial(int n, int k)
    {
        if (k==0 || k==n)
        {
            return 1;
        }
        else
        {
            return binomial(n-1,k-1) + binomial(n-1,k);
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
