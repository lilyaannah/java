import java.util.Random;
import java.util.Scanner;

public class BBS {
    private static int p = 11;
    private static int q = 19;
    private static int M = p * q;
    private static int x = 7; // начальное значение

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите текст для шифрования: ");
        String word =in.nextLine();
        int[] asciiValues = new int[word.length()];

        // шаг 3: вычисление кодов символов
        for (int i = 0; i < word.length(); i++) {
            asciiValues[i] = (int) word.charAt(i);
        }

        // шаг 4-5: шифрование
        int[] encryptedValues = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int randomNumber = generateRandomNumber();
            int encryptedValue = asciiValues[i] ^ randomNumber;
            encryptedValues[i] = encryptedValue;
        }

        // вывод зашифрованной строки
        System.out.print("Зашифрованная строка: ");
        for (int value : encryptedValues) {
            System.out.print(value + " ");
        }
    }

    // генерация псевдослучайного числа по алгоритму BBS
    private static int generateRandomNumber() {
        int x0 = x;
        int x1 = (int) Math.pow(x, 2) % M;
        x = x1;
        return x1 % 256;
    }
}