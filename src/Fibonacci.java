public class Fibonacci {

   // public static void main(String[] args) {
      //  int n = 3;

       // System.out.println(fib(n));

        public static int fib(int n)
        {
            if (n <= 1)
                return n;
            return fib(n-1) + fib(n-2);
        }

        public static void main (String args[])
        {
            int n = 9;
            System.out.println(fib(n));
        }

    }

   // public  static int fib(int n){
/*
        if (n <= 2)
            return 1;

            return fib(n-2 ) + fib(n-1);
       // return n;
    }
*/
//}

