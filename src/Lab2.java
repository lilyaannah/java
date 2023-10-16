import java.util.*;
public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи: ");
        int choice = scanner.nextInt();
       switch (choice){
           case 1: System.out.print("Введите строку: ");
                   String inputString = new Scanner(System.in).nextLine();
                   task1(inputString);break;
           case 2: System.out.print("Введите первый город: ");
                   String firstCity = scanner.nextLine();
                   System.out.print("Введите второй город: ");
                   String secondCity = scanner.nextLine();
                   task2(firstCity, secondCity); break;
           case 3: String textJava="Java Is the Language of Possibilities";
                   System.out.println("Before: "+textJava);
                   task3(textJava);break;
           case 4: System.out.print("Введите текст: ");
                   String textAtoThe = scanner.nextLine();
                   task4(textAtoThe); break;
           case 5://5) Вводится строка с клавиатуры. Удалите символы с середины до последнего символа.
               System.out.print("Введите текст: ");
                   String text = new Scanner(System.in).nextLine();
               int length=text.length()/2;
               StringBuilder sb = new StringBuilder(text);
               sb.delete(length, sb.length());
               System.out.println("Строка после удаления символов: " + sb.toString()); break;
           default:
               System.out.println("Error");
        }
    }
        public static String task1(String inputString){
            // 1) С клавиатуры вводится строка. Определить последний согласный символ в строке.
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'а', 'е', 'ё', 'и', 'о','у', 'ы', 'э', 'ю', 'я'};
        char lastConsonant = ' ';
        for (int i = inputString.length() - 1; i >= 0; i--) {
            char currentChar = inputString.charAt(i);
            if (Character.isLetter(currentChar) && !isVowel(currentChar, vowels)) {
                lastConsonant = currentChar;
                break;
            }
        }

        if (lastConsonant != ' ') {
            System.out.println("Последний согласный символ: " + lastConsonant);
        } else {
            System.out.println("В строке нет согласных символов.");}
            return inputString;
        }

    public static boolean isVowel(char ch, char[] vowels) {
        for (char vowel : vowels) {
            if (ch == vowel || ch == Character.toUpperCase(vowel)) {
                return true;
            }
        }
        return false;
    }
    public static boolean task2(String firstCity, String secondCity){
//2) С клавиатуры вводятся два названия городов (тип String).
// Проверить совпадают ли названия. Регистр при этом учитывать
        boolean result=firstCity.equals(secondCity);
       if(result) {
        System.out.println("match");
    } else {
        System.out.println("don't match");
    }
    return result;}

    public static String task3(String text) {
        // 3) Дана строка: “Java Is the Language of Possibilities” Преобразуйте строку в нижний регистр.
        text = text.toLowerCase();
        System.out.println("After: " + text);
        return text;
    }
    public static String task4(String text){
//        4) Вводится строка с клавиатуры. Используйте метод, заменяющий в строке все вхождения слова «a» на «the»
        String result;
        result=text.replace("a", "the");
        System.out.println(result);
        return result;
    }

}
