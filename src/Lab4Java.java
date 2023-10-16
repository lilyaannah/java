import java.util.*;
public class Lab4Java {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите задачу: ");
        int choice=in.nextInt();
        if(choice==1){
        // создание коллекции LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
            // создание коллекции HashSet
            HashSet<String> hashSet = new HashSet<>();
        task1(linkedList,hashSet);}

        // создание карты
        HashMap<Integer, String> map = new HashMap<>();
        if(choice==2){
        task2(map);}

        if(choice==3){
        // Генерируем массив целых чисел случайным образом
             ArrayList<Integer> list = new ArrayList<>();
        task3(list);}

        if(choice==4){
            System.out.print("Введите первую строку: ");
            String first =new Scanner(System.in).nextLine();
        task4(first);
        }
    }

    public static void task1(LinkedList<String> linkedList, HashSet<String> hashSet){
        //1) Создайте следующие коллекции. Выполните различные действия с ними.
        //Коллекция для хранения объектов: LinkedList
        //Коллекция для хранения и поиска уникальных идентификаторов: HashSet
        String str1 = "Hello World!";
        String str2 = "My name is Liliana";
        String str3 = "It's 4th lab.";
        String str4 = "I live in Bishkek";
        String str5= "It's a new sentence";
        Scanner in = new Scanner(System.in);
        // добавление элементов в LinkedList
        linkedList.add(str1);
        linkedList.add(str2);
        linkedList.add(str3);
        linkedList.add(str4);
        System.out.println("LinkedList before: " + linkedList);

        linkedList.indexOf(str2);
        linkedList.size();
        linkedList.element();
        linkedList.offer(str1);
        System.out.println("LinkedList after offer: " + linkedList);
        linkedList.poll();
        System.out.println("LinkedList after poll: " + linkedList);
        linkedList.pop();
        System.out.println("LinkedList after pop: " + linkedList);
        linkedList.push("09102004");
        System.out.println("LinkedList after push: " + linkedList);
        System.out.println("LinkedList after empty: " + linkedList.isEmpty());
        linkedList.subList(2, 4);
        System.out.println("LinkedList after sublist: " + linkedList);

        linkedList.add("Sun");
        linkedList.removeLast();
        System.out.println("LinkedList after removeLast: " + linkedList);
        System.out.println("<<I live in Bishkek>> YES or NOT "+linkedList.contains(str4));
        linkedList.addFirst(str5);
        System.out.println("LinkedList after addFirst: " + linkedList);
        System.out.println("LinkedList indexOf <<It's a new sentence>>: " +  linkedList.indexOf(str5));
        linkedList.pollFirst();
        System.out.println("LinkedList after pollFirst: " + linkedList);
        String[] linkedArray=linkedList.toArray(new String[5]);

        System.out.println("LinkedList after toArray: " + linkedList);
        System.out.println("linkedListArray[1]: "+ linkedArray[1]);

        System.out.println(" ");
        // добавление элементов в HashSet
            hashSet.add("Earth");
            hashSet.add("Sun");
            hashSet.add("Moon");
            hashSet.add("Saturn");
            hashSet.add("Mars");
            hashSet.add("Moon");

        System.out.println("HashSet before: " + hashSet);
        System.out.println("<<Sun>> YES or NOT "+hashSet.contains("Sun"));
        System.out.println("<<Pluto>> YES or NOT "+hashSet.contains("Pluto"));

        System.out.println("HashSet after retainALL with Linkedlist: "+hashSet.retainAll(linkedList));

        // удаление элемента из HashSet
        hashSet.remove("Saturn");
        System.out.println("HashSet after remove Saturn: "+hashSet);

        System.out.print("Iterating over list:");
        Iterator<String> i = hashSet.iterator();
        while (i.hasNext())
            System.out.print(i.next()+" ");

        System.out.println("\nisEmpty? "+hashSet.isEmpty());
        hashSet.add("Uranus");
        System.out.println("add Uranus: "+hashSet);
        hashSet.clear();
        System.out.println("HashSet after clear: ");
        System.out.println("isEmpty? "+hashSet.isEmpty());
    }
    public static void task2(HashMap<Integer, String> map){
        //2) Создайте карту, заполните тремя элементами (ключ + значение), запишите все ключи в одну
        //коллекцию, а значения в другую (2 строки кода). Организуйте вывод (две строки кода)

        // добавление элементов в карту
        map.put(1, "значение 1");
        map.put(2, "значение 2");
        map.put(3, "значение 3");

        // разделение ключей и значений в коллекции
        Collection<Integer> keys = map.keySet();
        Collection<String> values = map.values();

        // вывод ключей и значений
        System.out.println("Ключи: " + keys);
        System.out.println("Значения: " + values);
    }
    public static void task3( ArrayList<Integer> list){
        //3) Сгенерируйте массив целых чисел, используя класс Random(). Используя методы классов-
        //коллекций:
        //А) создайте новый массив, переписав в него часть элементов из первого массива
        //Б) определите уникальные числа
        //Д) найдите макс, мин и сумму чисел массива

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomInt = random.nextInt(10); // генерация случайного целого числа от 0 до 99
            list.add(randomInt);
        }
        System.out.println("Исходный массив: "+list);

        //А) создайте новый массив, переписав в него часть элементов из первого массива
        ArrayList<Integer> newList = new ArrayList<>(list.subList(1, 5));
        System.out.println("Новый массив: " + newList);

        // Б) Определяем уникальные числа
        Set<Integer> uniqueNumbers = new HashSet<>(list);
        System.out.println("Уникальные числа: ");
        for (int num : uniqueNumbers) {
            System.out.print(num + " ");
        }

        // Д) Находим максимальное, минимальное и сумму чисел в массиве
        int max = Collections.max(list);
        int min = Collections.min(list);
        int sum = 0;
        for (int num : list) {
            sum += num;
        }

        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
        System.out.println("Сумма чисел: " + sum);
    }
    public static void task4(String first){
        System.out.print("Введите вторую строку: ");
        String second =new Scanner(System.in).nextLine();
        // 4) Проведите частотный анализ слов и символов из первой строки. Определите символы,которые:
        // В) содержатся хотя бы в одной строке.
        Set<Character> symbols = new HashSet<>();

        String[] words = second.split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            Integer frequency = frequencyMap.get(word);
            frequencyMap.put(word, frequency == null ? 1 : frequency + 1);
        }

        for (String word : frequencyMap.keySet()) {
            System.out.println(word + " - " + frequencyMap.get(word) + " раз(а)");
        }

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            symbols.add(c);
        }
        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            if (symbols.contains(c)) {
                System.out.println("Символ " + c + " содержится в обеих строках");
            }
        }
        System.out.println("Символы, которые содержатся хотя бы в одной строке:");
        for (char c : symbols) {
            System.out.print(c + " ");
        }
        }
    }

