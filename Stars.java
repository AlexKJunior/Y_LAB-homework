import java.util.Scanner;

public class Stars {

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String template = scanner.next();
            String[][] arr = new String[n][m];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = template;
                    System.out.print(arr[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
}