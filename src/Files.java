import java.io.*;
import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
//!!! 2) Copy мтеод
public class Files {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер задачи: ");
        int choice=scanner.nextInt();
       if(choice==1){
             File myfile=new File("file.txt");
                    task1(myfile);}
       if (choice==2 ) {
           File inputFile = new File("input.txt");  inputFile.createNewFile();
           File outputFile = new File("output.txt"); outputFile.createNewFile();
           task2(inputFile, outputFile); }
       if (choice==3) {
           File outputFile = new File("output.txt");
           task3(outputFile);
       }
       if(choice==4){
           File newFile = new File("newfile.txt"); newFile.createNewFile();
           task4(newFile);
       }
       if(choice==5){
           File file = new File("example.txt");
           task5(file);
       }
    }
    public static void task5(File file) {
        // 5.      Создайте файл. Откройте файл и заполнения текстом, введенным с клавиатуры.
       //Выведите на экран путь к текущему файлу.
        System.out.println("Введите текст для записи в файл:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Выводим путь к файлу на экран
        System.out.println("Путь к текущему файлу: " + file.getAbsolutePath());
    }
    public static void task4(File file) throws IOException {
          // 4.      Новый созданный файл переименуйте на «Next».
        File renamedFile = new File("Next.txt");

        boolean rename=file.renameTo(renamedFile);

        if (rename) {
            System.out.println("Файл исходный: "+ file.getName());
            System.out.println("Файл успешно переименован: "+ renamedFile.getName());
        } else {
            System.out.println("Не удалось переименовать файл");
        }

        if(file.createNewFile()){
            file.delete();
            System.out.println("Старый файл удален успешно!");
        }

        if(rename==true){
            renamedFile.delete();
            System.out.println("Переименованный файл удален успешно!");
        }
    }
    public static void task3(File outputFile ) {
        // 3.      С клавиатуры вводятся дробные числа. Открыть файл из предыдущего задания и
       //дописать в него числа с клавиатуры на отдельные строки, округлив их до четырех
        // знаков после запятой. Вывести на экран результаты до и после.
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        //чтение исходного файла
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            System.out.println("Исходное содержимое файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        // дописывание в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите числа (введите 'stop' для завершения ввода):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("stop")) {
                try {
                    double number = Double.parseDouble(input);
                    String roundedNumber = df.format(number);
                    writer.newLine(); // переход на новую строку
                    writer.write(roundedNumber); // запись числа в файл
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка формата числа: " + input);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }

        // чтение измененного файла
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            System.out.println("Измененное содержимое файла:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public static void task2(File inputFile,File outputFile ) {
        // 2.      Скопировать первые 10 строк из файла и создать новый файл с этими данными.
        int n = 10; // количество строк для копирования

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Читаем первые n строк из исходного файла и записываем их в новый файл
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null ) break;
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл успешно скопирован");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void task1(File myfile) {
        // 1.      Открыть файл с дробными числами, записанными в столбик. Обновить данные,
       //содержащиеся в файле, увеличив значения чисел в 2раза. Округлить дробные числа до
      //четырех знаков после запятой и перезаписать округленные результаты в исходный
     //файл. Вывести на экран результаты до и после.
        System.out.print("Мой файл: ");  print(myfile);
        double[] arr = null;
        try (BufferedReader in = new BufferedReader(new FileReader(myfile))) {
            arr = in.lines().mapToDouble(Double::parseDouble).toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length; i++) {
            double value = arr[i] * 2;
            arr[i] = Math.floor(value * 10000) / 10000; }
        try (FileWriter writer = new FileWriter(myfile)) {
            for (int i = 0; i < arr.length; i++) {
                String str = Double.toString(arr[i]);
                writer.write(str);
                writer.write(System.lineSeparator()); }
            System.out.print("Файл перезаписан: ");
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); }
        print(myfile); }

    public static void print(File fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);} }

    public static void task2DOP(File inputFile,File outputFile ) {
        // 2.      Скопировать первые 10 строк из файла и создать новый файл с этими данными.
        int n = 10; // количество строк для копирования

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Читаем первые n строк из исходного файла и записываем их в новый файл
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                if (line == null ) break;
                writer.write(line);
               writer.newLine();
           }

            System.out.println("Файл успешно скопирован");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
