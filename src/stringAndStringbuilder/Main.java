package stringAndStringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		task1();
		task2();
		task4();
		System.out.println(task3("корок"));
		task5();
		task10();
	}
	// 1. Дан текст (строка). Найдите наибольшее количество подряд идущих
	// пробелов в нем.

	public static void task1() {
		String givenString = "Найдите  наибольшее количество      подряд идущих пробелов в нем.";
		int counter = 0;

		int counters[] = new int[givenString.length()];
		char array[] = givenString.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (Character.isSpaceChar(array[i])) {
				counter++;
			} else {
				if (counter != 0) {
					counters[i] = counter;
					counter = 0;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < counters.length; i++) {
			if (counters[i] > max) {
				max = counters[i];
			}
		}
		System.out.println("Наибольшее кол-во подряд идущих пробелов = " + max);
	}

	// 2. В строке вставить после каждого символа 'a' символ 'b'.

	public static void task2() {
		String givenString = "В строке aвставить после aкаждого символа 'a' символ 'b'";
		givenString = givenString.replaceAll("a", "ab");

		System.out.println(givenString);
	}

	// 3. Проверить, является ли заданное слово палиндромом.

	public static Boolean task3(String word) {
		Boolean isPalindrome = true;
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}

	// 4. С помощью функции копирования и операции конкатенации составить из
	// частей слова “информатика” слово “торт”.

	public static void task4() {
		String givenStr = "информатика";
		givenStr = "" + givenStr.charAt(7) + givenStr.charAt(3) + givenStr.charAt(4) + givenStr.charAt(7);

		System.out.println(givenStr);
	}

	// 5. Подсчитать, сколько раз среди символов заданной строки встречается
	// буква “а”.

	public static void task5() {
		String givenStr = "Подсчитать, сколько раз среди символов заданной строки";
		char array[] = givenStr.toCharArray();
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 'а') {
				counter++;
			}

		}
		System.out.println("В заданной строке " + counter + " букв а");
	}

	// 6. Из заданной строки получить новую, повторив каждый символ дважды.

	public static void task6() {
		String givenStr = "Из заданной строки получить новую,";
		StringBuilder sb = new StringBuilder(givenStr);

		for (int i = 0; i < givenStr.length(); i++) {
			sb.insert(i * 2, givenStr.charAt(i));

		}
		System.out.println(sb.toString());

	}

	// 7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все
	// пробелы. Например, если было введено "abc cde def", то должно быть
	// выведено "abcdef".

	public static void task7() {
		String str = "Требуется удалить из нее повторяющиеся символы и все";
		StringBuilder sb = new StringBuilder();

		str.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(sb.toString().replaceAll(" ", ""));
	}

	// 8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово
	// и вывести его на экран. Случай, когда самых длинных слов может быть
	// несколько, не обрабатывать.

	public static void task8() {
		String str = "ssssspublic static void task7()";
		String[] array = str.split(" ");
		String max = "";
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() > max.length()) {
				max = array[i];
			}

		}
		System.out.println("Самое длинное слово в строке: " + max);
	}

	// 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в
	// введенной строке. Учитывать только английские буквы.

	public static void task9() {
		String str = "ssssspublic AstaticB vCCCddgsввпфыаа";
		int counterLow = 0;
		int counterHigh = 0;
		char array[] = str.replaceAll(" ", "").replaceAll("\\W", "").toCharArray();
		System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
			if (Character.isLowerCase(array[i])) {
				counterLow++;
			} else {
				counterHigh++;
			}
		}

		System.out.println("Строчных букв: " + counterLow + "\n" + "Прописных букв: " + counterHigh);
	}

	// 10. Строка X состоит из нескольких предложений, каждое из которых
	// кончается точкой, восклицательным или вопросительным знаком. Определить
	// количество предложений в строке X.
	public static void task10() {
		String x = "Строка X состоит из! нескольких. предложений?";
		Pattern p = Pattern.compile("[!.?]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(x);
		System.out.println(x);
		int count = 0;

		while (m.find()) {
			count = count + 1;
			System.out.println("position " + m.start() + ": " + x.charAt(m.start()));
		}
		System.out.println("В строке " + count + " предложения.");
	}
}
