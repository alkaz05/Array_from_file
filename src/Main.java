import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
       //int[] massiv = inputArray();
        int[] massiv= readArrayFromF("number_array.txt");
       int countD = countDistinct(massiv);
       System.out.println("в массиве "+countD+" разных чисел");
        System.out.println(Arrays.toString(massiv));
    }

    private static int[] readArrayFromF(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        int n = scan.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        return mas;
    }

    private static int[] inputArray() {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите размер массива");
        int n = scan.nextInt();
        int[] mas = new int[n];
        System.out.println("введите "+n+" чисел");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        return mas;
    }

    public static int countDistinct(int[] mas){
        int count =0;
        for (int i = 0; i < mas.length; i++) {
            int y = mas[i];
            if(!isPresent(y, mas, 0, i-1))
                count++;
        }
        return count;
    }

    public static boolean isPresent(int x, int[] mas, int from, int to){
        for (int i = from; i<=to; i++)        {
            if(mas[i] == x)
                return true;
        }
        return false;
    }
}