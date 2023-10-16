import java.util.Scanner;

public class DES{
    // таблица перестановок для расширенного ключа
    private static final int[] PC1_TABLE = {56, 48, 40, 32, 24, 16, 8,
            0, 57, 49, 41, 33, 25, 17,
            9, 1, 58, 50, 42, 34, 26,
            18, 10, 2, 59, 51, 43, 35,
            62, 54, 46, 38, 30, 22, 14,
            6, 61, 53, 45, 37, 29, 21,
            13, 5, 60, 52, 44, 36, 28,
            20, 12, 4, 27, 19, 11, 3};

    // таблица перестановок для сжатия ключа
    private static final int[] PC2_TABLE = {13, 16, 10, 23, 0, 4,
            2, 27, 14, 5, 20, 9,
            22, 18, 11, 3, 25, 7,
            15, 6, 26, 19, 12, 1,
            40, 51, 30, 36, 46, 54,
            29, 39, 50, 44, 32, 47,
            43, 48, 38, 55, 33, 52,
            45, 41, 49, 35, 28, 31};

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        // Начальный ключ
        String key = "";
        System.out.println("Введите 8-разрядный исходный ключ");
        key= in.nextLine();

        // Преобразование ключа
        String transformedKey = transformKey(key);

        // Вывод полученных ключей
        System.out.println("Полученные ключи:");
        for (int i = 1; i <= 16; i++) {
            System.out.println("k" + i + ": " + generateKey(transformedKey, i));
        }
    }

    // Преобразование начального ключа в бинарную строку
    private static String transformKey(String key) {
        StringBuilder binaryKey = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            String binaryByte = Integer.toBinaryString((int) key.charAt(i));
            while (binaryByte.length() < 8) {
                binaryByte = "0" + binaryByte;
            }
            binaryKey.append(binaryByte);
        }
        return binaryKey.toString();
    }

    // Генерация ключа Ki
    private static String generateKey(String key, int roundNumber) {
        // Расширение ключа
        String expandedKey = permute(key, PC1_TABLE);

        // Разделение расширенного ключа на левую и правую половины
        String leftHalf = expandedKey.substring(0, 28);
        String rightHalf = expandedKey.substring(28);

        // Циклический сдвиг левой и правой половин в зависимости от номера цикла
        int shift = (roundNumber == 1 || roundNumber == 2 || roundNumber == 9 || roundNumber == 16) ? 1 : 2;
        leftHalf = leftShift(leftHalf, shift);
        rightHalf = leftShift(rightHalf, shift);

        // Сжатие ключа
        String compressedKey = leftHalf + rightHalf;
        String subKey = permute(compressedKey, PC2_TABLE);
        return subKey;
    }

    // Циклический сдвиг битов влево
    private static String leftShift(String bits, int shift) {
        return bits.substring(shift) + bits.substring(0, shift);
    }

    // Перестановка битов по заданной таблице
    private static String permute(String bits, int[] table) {
        StringBuilder permutedBits = new StringBuilder();
        for (int i : table) {
            permutedBits.append(bits.charAt(i));
        }
        return permutedBits.toString();

        //перестановка
        //шифр плейфера
        //гаммирование
        //DES
        //SHA
        //RSA
    }
}