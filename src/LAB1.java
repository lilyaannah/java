import java.util.*;
public class LAB1 {
    public static void main(String[] args) {
        //1) Сформировать возрастающий массив из четных чисел
//        Scanner input = new Scanner(System.in);
//        Random rand=new Random();
//        System.out.println("Enter a size of array:");
//        int size=input.nextInt();
//        int[] array=new int[size];
//        int k=rand.nextInt(220);
//        for(int i=0;i<array.length;i++){
//            while(k%2!=0)
//            k=rand.nextInt(220);
//        array[i]=k;
//        k=rand.nextInt(220);   }
//        for(int i=0;i<array.length;i++)
//            for(int j=0;j<array.length;j++)
//            if(array[i]<array[j]) {
//                k = array[i];
//                array[i] = array[j];
//                array[j] = k; }
//        for(int i=0;i<array.length;i++)
//            System.out.print(array[i]+"\t");

        // 2) Сформировать убывающий массив из чисел, которые делятся на 3.
//    Scanner input = new Scanner(System.in);
//    Random rand=new Random();
//        System.out.println("Enter a size of array:");
//    int size=input.nextInt();
//    int[] array=new int[size];
//    int k;
//    k=rand.nextInt(220);
//        for(int i=0;i<array.length;i++){
//        while(k%3!=0)
//            k=rand.nextInt(220);
//        array[i]=k;
//        k=rand.nextInt(220);
//    }
//        for(int i=0;i<array.length-1;i++)
//            for(int j=i+1;j<array.length;j++)
//            if(array[i]<array[j]){
//        k=array[i];
//        array[i]=array[j];
//        array[j]=k;
//    }
//        for(int i=0;i<array.length;i++)
//            System.out.print(array[i]+"\t");

        //3) Найдите количество элементов массива, которые отличны от наибольшего элемента не более чем на 10%.
//        Scanner input = new Scanner(System.in);
//        Random rand = new Random();
//        System.out.println("Enter a size of array:");
//        int size = input.nextInt();
//        int[] array = new int[size];
//        for (int i = 0; i < array.length; i++)
//            array[i] = rand.nextInt(50);
//        int max = array[0], k = 0;
//        for (int i = 0; i < array.length; i++)
//            if (max < array[i])
//                max = array[i];
//        for (int i = 0; i < array.length; i++)
//            System.out.print(array[i] + "\t");
//        System.out.println();
//        System.out.println("max=" + max);
//        int otlich = 10 ;
//        double value;
//        for (int i = 0; i < array.length; i++) {
//            value =(double)max / array[i]*100-100;
//            if (value < otlich && array[i]!=max) {
//                System.out.println(array[i]);
//                k++;
//            }
//        }
//        System.out.println("Count of array  elements : " + k);

        //4) Определите, можно ли вычеркнуть из данного массива одно число так, чтобы оставшиеся числа оказались упорядоченными по возрастанию.
//            Scanner input = new Scanner(System.in);
//            System.out.println("Enter a size of array:");
//            int size = input.nextInt();
//            int[] array = new int[size];
//            int[] test_array = new int[size];
//            int[] sort_array = new int[size];
//            for (int i = 0; i < array.length; i++)
//                array[i]=input.nextInt();
//            System.arraycopy(array,0,test_array,0,array.length);//Копируем массив
//            print(array,size);
//
//            for (int i = 0; i < array.length; i++) {
//                for (int j = i; j < test_array.length - 1; j++)
//                    test_array[j] = test_array[j + 1];
//                System.arraycopy(test_array,0,sort_array,0,array.length);//Копируем массив
//                sort_array = sort(sort_array);
//                if (Arrays.equals(sort_array,test_array)) {
//                    System.out.print("\nДа, вот отсортированный массив:");
//                    print(sort_array,size-1);
//                    print(test_array,size-1);
//                    System.out.println();
//                    break;
//                }
//                System.arraycopy(array,0,test_array,0,array.length);}//Копируем массив


        //5) Дан массив из n элементов. Переставьте его элементы случайным образом.
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter a size of array:");
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(59);
        print(array, size);
        shuffle(array);
        print(array, size);

    }

    //функции 5 задания
    static void shuffle(int[] arr) {
        int x, index;
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            x = arr[i];
            index = rand.nextInt(arr.length);
            arr[i] = arr[index];
            arr[index] = x;
        }
    }

    static void print(int[] arr, int n) {
        for (int l = 0; l < n; l++)
            System.out.print(arr[l] + "\t");
        System.out.println();
    }

//функции 4 задания
//    static int[] sort(int[]arr){
//        for(int i=0;i<arr.length-1;i++)
//            for(int j=i+1;j<arr.length;j++)
//                if(arr[i]>arr[j])
//                {
//                    int x;
//                    x=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=x;
//                }
//        return arr;
//    }
//    static void print(int[]arr,int n)
//    {
//        for (int l = 0; l <n; l++)
//            System.out.print(arr[l]+"\t");
//        System.out.println();
//    }
}