public class MultTable {
    public static void main(String[] args) throws Exception {
        int num = 9;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
            System.out.println();
        }
    }
}