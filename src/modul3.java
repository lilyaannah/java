public class modul3 {
    public static void main(String[] args) {
        String text = "Differences between data protection, security and privacy.\n" +
                "Although some businesses use the terms data protection, data security and data privacy, they have different\n" +
                "purposes. 1) Data protection safeguards information from loss through backup and recovery. 2) Data security\n" +
                "refers specifically to measures taken to protect the integrity of the data itself against manipulation and malware.\n" +
                "It provides defense from internal and external threats. 3) Data privacy refers to controlling access to the data.\n" +
                "Organizations must determine who has access to data. Understandably, a privacy breach can lead to data security\n" +
                "issues.\n";
//Поиск первого 2хзначного числа.
        char[] textArray = text.toCharArray();
        int textLength = text.length();
        char[] textArrayLower=text.toLowerCase().toCharArray();
        String vowels = "aeiouAEIOU";
        char[] vowelsArray = vowels.toCharArray();

        int i = 0;

        for (char ch : textArrayLower) {
            for (char ch2 : vowelsArray) {
                if (ch==ch2) {
                    i++;
                }
            }
        }
        int firstNumber = textLength / i;

        int j = 0;
        for (char ch : textArray) {
                if (Character.isDigit(ch)) {
                    j++;
                }

        }
        int secondNumber = j;
        int firstTwoDigit = firstNumber * 10 + secondNumber;

//Поиск второго 2хзначного числа.
        String consonants = "bcdfghjklmnpqrstvywxz";
        char[] consonantsArray = consonants.toCharArray();
        int n = 0;
        for (char ch : textArrayLower) {
            for (char ch2 : consonantsArray) {
                if (ch == ch2) {
                    n++;
                }
            }
        }
        int temp=0;
        int value1=n;
        while(n>0){
            value1=n%10;
            n=n/10;
            temp+=value1;
        }
        int secondTwoDigit=temp*3;

//Поиск третьего 2хзначного числа.
        int m = 0;
        for (char ch : textArray) {

                if (ch == ',') {
                    m++;
                }

        }
        double value = Math.pow(m,3);
        int thirdTwoDigit = (int) value;

//Поиск четвертого 2хзначного числа.
        int count = text.split("[!?.]+").length;

        int upperCase = 0;
        for (int k = 0; k < textLength; k++) {
            if (Character.isUpperCase(text.charAt(k)))
                upperCase++;
        }
        double cub=Math.cbrt(upperCase);
        int result = (int)cub;
        String result1=count+""+result;
        int fourthTwoDigit=Integer.parseInt(result1);


        int[] password={firstTwoDigit,secondTwoDigit,thirdTwoDigit,fourthTwoDigit};
        for (int index=0; index<password.length; index++){
            System.out.print(password[index]+" ");
        }
        System.out.println(" ");
        for (int index=0; index<password.length; index++){
            System.out.print((char)password[index]+"  ");
        }

    }
}
