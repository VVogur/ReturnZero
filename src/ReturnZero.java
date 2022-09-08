import java.util.Arrays;
import java.util.Scanner;

/*
Есть массив чисел неограниченного размера, с любыми числами
От отрицательных до положительных
Нужно найти сумму трёх чисел, которые бы равнялись нулю


!!! Рандомный размер и диапазоны для такой задачи, загружают компьютер и он не справляется с рассчётами,
по этому пришлослось уменьшить диапазон заполнения массива, и размер массива передать в руки пользователю.
 */
public class ReturnZero {
    public static void main(String[] args) {
        //Вводим размер массива
        System.out.print("Введите размер массива: ");
        Scanner src = new Scanner(System.in);
        int number = src.nextInt();

        //Создаем массив с длинной от -50 до 50
        int[] a = new int[number];
        for (int i = 0; i < a.length; i++) {
            a[i] = ((int)(Math.random() * 100) - 50);
        }

//        int[] a = new int[number];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = ((int)(Math.random() * 2147483647) - 1073741823);
//        }

        //Вызываем метод на поиск 3 чисел которые будут равны 0, либо любому числу которое будет указано в targetNumber
        System.out.println(((Object) isThreeSumEqualsTarget(a, 0)).toString());
        }

    public static boolean isThreeSumEqualsTarget(int[] array, int targetNumber) {

            Arrays.sort(array);
            System.out.println(Arrays.toString(array));

            int leftIndex = 0;
            int rightIndex = array.length - 1;

            while (leftIndex + 1 < rightIndex - 1) {
                //Возьмем сумму двух крайних значений
                int sum = array[leftIndex] + array[rightIndex];
                //Ищем, совпадает ли число. Или получаем ближайщее совпадение
                int binarySearchClosestIndex = binarySearch(leftIndex + 1, rightIndex - 1, targetNumber - sum, array);
                //Если найдено совпадение, то мы получаем ответ
                if (-1 == binarySearchClosestIndex) {
                    System.out.println(("combo is " + array[leftIndex] + ", " + array[rightIndex] + ", " + (targetNumber - sum)));
                    return true;
                }
                //Если совпадение не найдено, мы двигаем левый или правый указатель внутрь
                else {
                    //Мы закончили поиск в направлении начала массива, т.е. нам нужна меньшая сумма, двигаемся внутрь справа
                    if (binarySearchClosestIndex == leftIndex + 1) {
                        //Нам нужна меньшая сумма, уменьшаем правый индекс
                        rightIndex--;
                    } else if (binarySearchClosestIndex == rightIndex - 1) {
                        //Нужна большая сумма, увеличим левый индекс
                        leftIndex++;
                    }
                }
            }
            return false;
        }

        public static int binarySearch(int start, int end, int elem, int[] array) {
            int mid = 0;
            while (start <= end) {
                mid = (start + end) >>> 1;
                if (elem < array[mid]) {
                    end = mid - 1;
                } else if (elem > array[mid]) {
                    start = mid + 1;
                } else {
                    return -1;
                }
            }
            return mid;
        }
    }

