package stringAsArray;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		task1();
		task2();
		task3();
		task4();
		task5();
	}
	// Task1
	// 1. Дан массив названий переменных в camelCase. Преобразовать названия в
	// snake_case.

	public static void task1() {
		String camel = "camel";
		String casee = "Case";
		String array[] = new String[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = camel + casee;
		}
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			char[] ch = array[i].toCharArray();
			int index = getIndex(ch);
			array[i] = array[i].toLowerCase();
			array[i] = array[i].substring(0, index) + "_" + array[i].substring(index);
		}
		System.out.println(Arrays.toString(array));

	}

	public static int getIndex(char[] array) {
		int index = 0;
		for (int j = 0; j < array.length; j++) {

			if (Character.isUpperCase(array[j])) {
				index = j;
				break;
			}

		}
		return index;
	}

	// Task2
	// 2. Замените в строке все вхождения 'word' на 'letter'.

	public static void task2() {
		String givenString = "word is asfsa awoksoak word, wor, word. ";
		String changedString = givenString.replaceAll("word", "letter");
		System.out.println(givenString);
		System.out.println(changedString);

	}
	// Task3
	// 3. В строке найти количество цифр.

	public static void task3() {
		String givenString = "В строке 7найти8 количество цифр.999 ";
		char array[] = givenString.toCharArray();
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (Character.isDigit(array[i])) {
				counter++;
			}
		}
		System.out.println(givenString);
		System.out.println("Кол-во цифр в строке: " + counter);
	}

	// Task4
	// 4. В строке найти количество чисел.

	public static void task4() {
		String givenString = "В 2строке 3найти кол456ичество чисел ";
		System.out.println("Исходная строка ");

		System.out.println(givenString);
		givenString = givenString.replaceAll("[^0-9]+", " ");

		List<String> list = Arrays.asList(givenString.trim().split(" "));
		System.out.println("Кол-во чисел в строке " + list.size());
	}

	// Task5
	// 5. Удалить в строке все лишние пробелы, то есть серии подряд идущих
	// пробелов заменить на одиночные пробелы. Крайние пробелы в строке удалить.
	public static void task5() {
		String givenString = " Удалить в строке все   лишние    пробелы, то есть серии подряд идущих    ";
		System.out.println(givenString.replaceAll("[\\s]{2,}", " ").trim());
	}
}
