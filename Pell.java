import java.util.Scanner;

public class Pell {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println(0);
            } else if (n == 1) {
                System.out.println(1);
            } else {
                double sqrtNum = Math.sqrt(2);
                double a = Math.pow((1 + sqrtNum), n);
                double b = Math.pow((1 - sqrtNum), n);
                double c = 2 * sqrtNum;
                double res = (a - b) / c;
                System.out.println(Math.round(res));
            }
        }
    }
}