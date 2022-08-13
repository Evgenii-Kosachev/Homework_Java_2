/*
   1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
   2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
   3. *Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
   4. Дано два числа, например 3 и 56, необходимо составить следующие строки:
       3 + 56 = 59
       3 – 56 = -53
       3 * 56 = 168
       Используем метод StringBuilder.append().
   5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(), StringBuilder.deleteCharAt().
   6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
   7. **Сравнить время выполнения пункта 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
*/

import java.util.Scanner;

public class TaskSolution {
    public static void main(String[] args) {
        substringSearch(getData());

        int numberOne = 3, numberTwo = 56;
        System.out.println(math(numberOne, numberTwo));
        replaceSymbolInsert(math(numberOne, numberTwo), "равно");
        replaceSymbolReplace(math(numberOne, numberTwo), "равно");
    }

    public static String[] getData() {
        Scanner scanner = new Scanner(System.in);
        String[] result = new String[2];

        System.out.print("Введите строку: ");
        result[0] = scanner.nextLine();
        System.out.print("Что ищем: ");
        result[1] = scanner.nextLine();
        scanner.close();

        return result;
    }

    public static void substringSearch(String[] data) {
        String str = data[0];
        StringBuilder sb = new StringBuilder(data[1]);

        if (str.contains(sb) || str.contains(sb.reverse())) System.out.println("Подстрока содержится в строке.");
        else System.out.println("Подстрока не содержится в строке.");
    }

    public static StringBuilder math(int numb1, int numb2) {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%d + %d = %d \n", numb1, numb2, numb1 + numb2));
        result.append(String.format("%d - %d = %d \n", numb1, numb2, numb1 - numb2));
        result.append(String.format("%d * %d = %d \n", numb1, numb2, numb1 * numb2));

        return result;
    }

    public static void replaceSymbolInsert(StringBuilder data, String newSymbol) {
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '=') {
                data.deleteCharAt(i);
                data.insert(i, newSymbol);
            }
        }
        System.out.println(data);
    }

    public static void replaceSymbolReplace(StringBuilder data, String newSymbol) {
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == '=') {
                data.deleteCharAt(i);
                data.replace(i, i, newSymbol);
            }
        }
        System.out.println(data);
    }
}
