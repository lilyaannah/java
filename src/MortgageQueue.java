import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class MortgageQueue {
    private static String[] surnames = {"Авдеева", "Агапова", "Власова", "Галкина", "Бычкова", "Исакова"};
    private static String[] names = {"Агата", "Адель", "Адиля", "Азиза", "Алена", "Анеля"};
    private static String[] patronymics = {"Дайн", "Жанн", "Заир", "Клар", "Наил", "Саид"};
    private double amount;
    private LocalDate date;
    private double interestRate;
    private int term;
    public double getAmount() {
        return amount;
    }
    public MortgageQueue() {
        this.amount = generateRandomAmount();
        this.date = generateRandomDate();
        this.interestRate = generateRandomInterestRate();
        this.term = generateRandomTerm();
    }
    public LocalDate getDate() {
        return date;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    @Override
    public String toString() {
        return String.format("Выдана ипотека на сумму %.2f числа %s под годовой процент %.2f на срок %d лет", amount, date.toString(), interestRate, term);
    }

    public static void main(String[] args) throws IOException {
        List<Client> clients = generateClients(20); // генерируем список клиентов
        Collections.sort(clients); // сортируем по порядку обращения
        System.out.println("Очередь на получение ипотеки:");
        File clientsFile = new File("clients.txt"); //createFile(clientsFile.toPath());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(clientsFile,false))) {
            for (int i = 0; i < clients.size(); i++) {
                String ClientsInFile=(i+1)+"."+clients.get(i).getName();
                writer.write(ClientsInFile);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }

        List<Client> forСonsideration = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(clientsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\t");
                String fullName = fields[0].trim();
                String inn = fields[1].trim();
                String birthDate = fields[2].trim();
                String passport = fields[3].trim();
                String citizenship = fields[4].trim();
                String address = fields[5].trim();
                String employmentBookNumber = fields[6].trim();
                String workPlace = fields[7];
                String position = fields[8];
                double salary = Double.parseDouble(fields[9].trim());
                boolean realEstate = Boolean.parseBoolean(fields[10].trim());
                int num=1;
                if (citizenship.equalsIgnoreCase("Кыргызстан") && !realEstate) {
                    num++;
                    forСonsideration.add(new Client(fullName+"\t" +inn +"\t"+
                            birthDate+"\t"+passport+"\t"+  citizenship+"\t"+address+"\t"+
                            employmentBookNumber+"\t"+workPlace+"\t"+
                            position+"\t"+salary+"\t"+"Недвижимость:"+realEstate, num));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File forConsideration=new File("На рассмотрение.txt"); //createFile(forConsideration.toPath());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(forConsideration,false))) {
            for (int i = 0; i < forСonsideration.size(); i++) {
                String forConsiderationInFile=(i+1)+"."+forСonsideration.get(i).getName();
                writer.write(forConsiderationInFile);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }

//        if(clientsFile.isFile()){clientsFile.delete();
//            System.out.println("File clients deleted");
//        }

        forСonsideration.clear();

        try {
            // Читаем данные из файла и сохраняем в список
            List<String> lines = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(forConsideration));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

            // Сортируем список по убыванию зарплаты
            Collections.sort(lines, new Comparator<String>() {
                @Override
                public int compare(String line1, String line2) {
                    double salary1 = Double.parseDouble(line1.split("\t")[9]);
                    double salary2 = Double.parseDouble(line2.split("\t")[9]);
                    return Double.compare(salary2, salary1);
                }
            });

            // Записываем отсортированные данные в новый файл
            PrintWriter pw = new PrintWriter(new FileWriter(forConsideration));
            int i=0;
            for (String sortedLine : lines) {
                i++;
                pw.println(i+"."+sortedLine);
            }
            pw.close();

            System.out.println("Данные успешно отсортированы и записаны в файл.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        File approved = new File("Выдача ипотеки.txt"); //createFile(approved.toPath());

        try (BufferedReader br = new BufferedReader(new FileReader(forConsideration));
             BufferedWriter bw = new BufferedWriter(new FileWriter(approved,false))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null && count < 5) {
                String[] parts = line.split("\t");
                String fullName = parts[0];
                String inn = parts[1];
                String birthDate = parts[2];
                String passport = parts[3];
                String citizenship = parts[4];
                String address = parts[5];
                String employmentBookNumber = parts[6];
                String workPlace = parts[7];
                String position = parts[8];
                double salary = Double.parseDouble(parts[9]);
                String realEstate = parts[10];
                int num=0; num++;
                forСonsideration.add(new Client(fullName+"\t" +inn +"\t"+
                        birthDate+"\t"+passport+"\t"+  citizenship+"\t"+address+"\t"+
                        employmentBookNumber+"\t"+workPlace+"\t"+
                        position+"\t"+salary+"\t"+"Недвижимость:"+realEstate, num));
                    count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(approved))) {
            for (int i = 0; i < forСonsideration.size(); i++) {
                String approvedInFile=(i+1)+"."+forСonsideration.get(i).getName();
                writer.write(approvedInFile);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
//             if(approved.isFile()){forConsideration.delete();
//            System.out.println("Файл <<На рассмотрение>> удален успешно!");}

        forСonsideration.clear();
        // Открываем файл для чтения
        try (BufferedReader reader = new BufferedReader(new FileReader(approved))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Разбиваем строку на поля по запятой
                String[] parts = line.split("\t");
                String fullName = parts[0];
                String inn = parts[1];
                String birthDate = parts[2];
                String passport = parts[3];
                String citizenship = parts[4];
                String address = parts[5];
                String employmentBookNumber = parts[6];
                String workPlace = parts[7];
                String position = parts[8];
                double salary = Double.parseDouble(parts[9]);
                String realEstate = parts[10];
                int num=0; num++;
                // Генерируем случайную сумму ипотеки
                double sum = generateRandomAmount();
                sum=Math.floor(sum*1000/1000);
                LocalDate date =generateRandomDate();
                double percent=generateRandomInterestRate();
                percent=Math.ceil(percent);
                int term=generateRandomTerm();
                forСonsideration.add(new Client(fullName+"\t" +inn +"\t"+
                        birthDate+"\t"+passport+"\t"+  citizenship+"\t"+address+"\t"+
                        employmentBookNumber+"\t"+workPlace+"\t"+
                        position+"\t"+salary+"\t"+"Недвижимость:"+realEstate+"\n [ Выдана ипотека на сумму - "+sum
                        +"\nчисла "+date+"\nпод годовой процент "+percent+"%"+"\nна срок "+term+"лет ]", num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(approved))) {
            for (int i = 0; i < forСonsideration.size(); i++) {
                String approvedInFile=(i+1)+"."+forСonsideration.get(i).getName();
                writer.write(approvedInFile);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }//main

    private static double generateRandomAmount() {
        Random rand = new Random();
        return rand.nextDouble() * 1000000 + 100000;
    }

    private static LocalDate generateRandomDate() {
        Random rand = new Random();
        int year = rand.nextInt(10) + 2022;
        int month = rand.nextInt(12) + 1;
        int day = rand.nextInt(28) + 1;
        return LocalDate.of(year, month, day);
    }

    private static double generateRandomInterestRate() {
        Random rand = new Random();
        return rand.nextDouble() * 5 + 4;
    }

    private static int generateRandomTerm() {
        Random rand = new Random();
        return rand.nextInt(26) + 5;
    }
    private static List<Client> generateClients(int count) {
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String fullName=generateFullName(); String inn=generateInn(); LocalDate birthDate=generateBirthDate();
            String passport=generatePassportData();  String citizenship=generateCitizenship();
            String address=generateAddress();  String employmentBookNumber=generateEmploymentBookNumber();
            String workPlace=generateWorkplace(); String position=generatePosition();
            double salary=generateSalary();   boolean realEstate=generateRealEstate();
            clients.add(new Client(fullName+"\t" +inn +"\t"+
                    birthDate+"\t"+passport+"\t"+  citizenship+"\t"+address+"\t"+
                    employmentBookNumber+"\t"+workPlace+"\t"+
                    position+"\t"+salary+"\t"+"Недвижимость:"+realEstate, i + 1));
        }
        return clients;
    }


    private static boolean generateRealEstate() {
        double random = Math.random();
        if (random < 0.5) {
            return true;
        } else {
            return false;
        }
    }
    private static double generateSalary() {
        double minSalary = 10000;
        double maxSalary = 15000;
        double range = maxSalary - minSalary;
        double randomValue = minSalary + (range * new Random().nextDouble());
        return Math.floor((randomValue * 12)*1000/1000);
    }
    private static String generatePosition() {
        String[] positions = {"developer", "tester   ", "analyst  ",
                "sys admin", "engineer ", "designer "};
        return positions[new Random().nextInt(positions.length)];
    }
    private static String generateWorkplace() {
        String[] workplaces = {"Apple    ", "Samsung  ", "Microsoft", "Amazon   ", "Google   "};
        Random random = new Random();
        return workplaces[random.nextInt(workplaces.length)];
    }
    private static String generateEmploymentBookNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    private static String generateAddress() {
        String[] streets = {"Авенида", "Пушкина", "Бронная", "Варшава", "Донская", "Мирская"};
        int houseNumber = new Random().nextInt(100) + 1; // Случайный номер дома от 1 до 100
        String street = streets[new Random().nextInt(streets.length)]; // Случайная улица из списка
        return "ул." + street + " " + houseNumber;
    }
    private static String generateCitizenship() {
        String[] citizenships = {"Кыргызстан", "Казахстан", "Узбекистан"};
        Random random = new Random();
        int index = random.nextInt(citizenships.length);
        return citizenships[index];
    }
    private static String generatePassportData() {
        Random random = new Random();
        String series = String.format("%02d", random.nextInt(100)); // генерация серии паспорта от 01 до 99
        String number = String.format("%06d", random.nextInt(1000000)); // генерация номера паспорта от 000001 до 999999
       return  series +number ;
    }
    private static LocalDate generateBirthDate() {
        Random random = new Random();
        int year = random.nextInt(56) + 1950; // генерируем год от 1950 до 2005
        int month = random.nextInt(12) + 1; // генерируем месяц от 1 до 12
        int day = random.nextInt(28) + 1; // генерируем день от 1 до 28
        return LocalDate.of(year, month, day);
    }
    private static String generateInn() {
        Random random = new Random();
        StringBuilder inn = new StringBuilder();
        for (int i = 0; i < 14; i++) {
            inn.append(random.nextInt(10));
        }
        return inn.toString();
    }
    private static String generateFullName() {
        Random random = new Random();
        String surname = surnames[random.nextInt(surnames.length)];
        String name = names[random.nextInt(names.length)];
        String patronymic = patronymics[random.nextInt(patronymics.length)];
        return surname + " " + name + " " + patronymic;
    } //методы генерирующие рандомно документы

    private static class Client implements Comparable<Client> {
        private String name;
        private int order;
        public Client(String name, int order) {
            this.name = name;
            this.order = order;}
        public String getName() {
            return name;  }

        // сравнение клиентов по порядку обращения
        @Override
        public int compareTo(Client other) {
            return Integer.compare(this.order, other.order);
        }
    }
}