package eigthweek;

public class Debugging {

    static int fib(int n) {
        int f = 0;
        int f0 = 0;
        int f1 = 0;

        while(n > 1){
            n--;
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }
}
