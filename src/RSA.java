import java.util.Random;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) { // Генерируем два случайных простых числа
        Scanner in=new Scanner(System.in);
        System.out.print("Введите простые числа p, q: ");
        int p=in.nextInt();
        int q=in.nextInt();

        int n=p*q;
        int Fn=(p-1)*(q-1);
        int e=generateCoPrimeNumber(Fn);
        // int d=extendedEuclidean(e, Fn);
        int d;
        do {
            d = extendedEuclidean(e, Fn);
        } while (d == e); // Проверяем, чтобы d не было равно e
        if (d < 0) {
            d = d + Fn;
        }

        int result = (d * e) % Fn;
        System.out.println(result); // Выводит 1

        System.out.println(n+" "+Fn+" "+e+" "+d);
        System.out.println("Открытый ключ ("+e+", "+n+")");
        System.out.println("Закрытый ключ ("+d+", "+n+")");
    }
    private static int extendedEuclidean(int a, int b) {
        int x = 0, y = 1, lastX = 1, lastY = 0, temp;
        while (b != 0) {
            int quotient = a / b;
            int remainder = a % b;

            a = b;
            b = remainder;

            temp = x;
            x = lastX - quotient * x;
            lastX = temp;

            temp = y;
            y = lastY - quotient * y;
            lastY = temp;
        }
        return lastX;
    }
    public static boolean areCoPrime(int a, int b) {
        // Находим наибольший общий делитель двух чисел
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        // Если НОД равен 1, числа взаимно простые
        return a == 1;
    }

    // Функция для генерации взаимно простого числа в заданном диапазоне
    public static int generateCoPrimeNumber(int m) {
        Random random = new Random();
        int e;

//        do {
//            e = random.nextInt(m - 1) + 1; // Генерируем случайное число в диапазоне (1 < e < m)
//        } while (!areCoPrime(e, m)); // Проверяем, является ли число взаимно простым с m

        do {
            e = random.nextInt(m - 1) + 1; // Генерируем случайное число в диапазоне (1 < e < m)
        } while (!areCoPrime(e, m) || e == m); // Проверяем, является ли число взаимно простым с m и не равно m

        return e;
    }
    // Функция для проверки простоты числа
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Функция для генерации случайного простого числа
    public static int generatePrimeNumber() {
        Random random = new Random();
        int number;

        do {
            number = random.nextInt(100) + 1; // Генерируем случайное число от 1 до 100
        } while (!isPrime(number)); // Проверяем, является ли число простым

        return number;
    }
}
