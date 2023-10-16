import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.lang.String;
public class Main {
    public static void main(String[] args) throws IOException {
        String unknownString;
        String a = "*No mobile phones in this exam";
        String b = "Switch off your mobile phones!";
        String c = "Inheritance is a pillar of OOP";
        String d = "Java is a programming language";
        String e = "Inheritance is simple & useful";

        String[] arrString = {a, b, c, d, e};

        int aLenth = a.length();
        int bLenth = b.length();
        int cLenth = c.length();
        int dLenth = d.length();
        int eLenth = e.length();

        String vowels = "aeiouAEIOU";
        char[] vowelsArray = vowels.toCharArray();

        boolean isMatching = true;
        System.out.println("|   1))   |   2))   |   3))   |   4))   |   5))   |");
        System.out.println("|---------|---------|---------|---------|---------|");
//1)) С клавиатуры вводится строка из 30 символов.
        //int count=-1;
        int[] arrLenth = {aLenth, bLenth, cLenth, dLenth, eLenth};

        for (int i = 0; i < arrLenth.length; i++) {
            if (arrLenth[i] != 30) {
                isMatching = false;
                System.out.print("|  " + isMatching + "  ");
            } else {
                System.out.print("|  " + isMatching + "   ");
            }
        }
        System.out.println("| 1");

//2)) Причем количество слов в этой строке равна 1/6 части длины всей строки.
        for (int i = 0; i < arrString.length; i++) {
            int wordsCount = arrString[i].split(" ").length;
            if (wordsCount != arrString[i].length() / 6) {
                isMatching = false;
                System.out.print("|  " + isMatching + "  ");
            } else {
                isMatching = true;
                System.out.print("|  " + isMatching + "   ");
            }
        }
        System.out.println("| 2");

//3)) а количество гласных больше 10
        for (int i = 0; i < arrString.length; i++) {
            int vowelsCount = 0;
            for (char ch : arrString[i].toCharArray()) {
                if ("aeiouyAEIOUY".indexOf(ch) != -1) {
                    vowelsCount++;    }    }
            if (vowelsCount <= 10) {
                isMatching = false;
                System.out.print("|  "+isMatching+"  ");
            }else {
                isMatching = true;
                System.out.print("|  " + isMatching + "   ");
            }}System.out.println("| 3");

//4)) количество пробелов в 2 раза больше количества слов, начинающихся на гласную
        int vowelsStartCount = 0;
        for (int i = 0; i < arrString.length; i++) {
            String[] wordsCountRemove = arrString[i].split(" ");
            for (int j = 0; j < wordsCountRemove.length; j++)
                if (vowels.indexOf(wordsCountRemove[i].toLowerCase().charAt(0)) == vowelsArray[i])
                    vowelsStartCount += 1;
            if (vowelsStartCount * 2 != wordsCountRemove.length - 1){
                isMatching = false;
                System.out.print("|  "+isMatching+"  ");
            }else {
                isMatching=true;
                System.out.print("|  "+isMatching+"   ");
            }}System.out.println("| 4?");


//5)) строка не заканчивается на символ "."
        int wordsCountpointEnd=0;
        for (int i = 0; i < arrString.length; i++) {
            if(arrString[i].endsWith(".")){
                isMatching = false;
                System.out.print("|  "+isMatching+"  ");
            }else {
                isMatching=true;
                System.out.print("|  "+isMatching+"   ");
            }}System.out.println("| 5");


//6)) если удалить слова, содержащие слог 'i*' (*- любой символ), то длина новой строки будет составлять
//половину исходной(старой) длины строки

//7)) если вырезать из этой новой строки символы, начиная с 10го символа и заканчивая по 15ый символ, то
//получится слово, содержащее количество согласных равное половине длины этого слова.

        // Проверка длины новой строки
        for(int i=0; i<arrString.length; i++) {

            String[] newString = arrString[i].split("[\\s,.]+");;
            StringBuilder sb = new StringBuilder();
            for (String word : newString) {
                if (!word.contains("i")) {
                    sb.append(word).append(" ");
                }
            }

            if (newString[i].length() != arrString.length / 2) {
                isMatching = false;
                System.out.print("|  " + isMatching + "  ");
            } else {
                isMatching = true;
                System.out.print("|  " + isMatching + "  ");
            }
//            System.out.println(newString);
            if (newString[i].length() > 15) {
                // Проверка количества согласных в слове
                String word = newString[i].substring(9, 15);
                int consonantsCount = 0;
                for (char index : word.toCharArray()) {
                    if ("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(index) != -1) {
                        consonantsCount++;
                    }
                }
                if (consonantsCount != word.length() / 2) {
                    isMatching = false;
                    System.out.print("|  " + isMatching + "  ");
                } else {
                    isMatching = true;
                    System.out.print("|  " + isMatching + "  ");
                }
            }
            System.out.println("| 7");
        }

    }
}
