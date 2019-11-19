package patternMatcher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
/*	1. Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
	операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
	отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по
	алфавиту.*/
	public static void main(String[] args) {
		String text = "No more conversation; the toil of the trail will not permit such extravagance."
				+ "\nAnd of all deadening labors, that of the Northland trail is the worst. Happy is the man who can weather a day's travel at the price of silence, and that on a beaten track. And of all heartbreaking labors, that of breaking trail is the worst. At every step the great webbed shoe sinks till the snow is level with the knee. Then up, straight up, the deviation of a fraction of an inch being a certain precursor of disaster, the snowshoe must be lifted till the surface is cleared; then forward, down, and the other foot is raised perpendicularly for the matter of half a yard. He who tries this for the first time, if haply he avoids bringing his shoes in dangerous propinquity and measures not his length on the treacherous footing, will give up exhausted at the end of a hundred yards; he who can keep out of the way of the dogs for a whole day may well crawl into his sleeping bag with a clear conscience and a pride which passeth all understanding; and he who travels twenty sleeps on the Long Trail is a man whom the gods may envy."
				+ "\nThe afternoon wore on, and with the awe, born of the White Silence, the voiceless travelers bent to their work. Nature has many tricks wherewith she convinces man of his finity—the ceaseless flow of the tides, the fury of the storm, the shock of the earthquake, the long roll of heaven's artillery—but the most tremendous, the most stupefying of all, is the passive phase of the White Silence. All movement ceases, the sky clears, the heavens are as brass; the slightest whisper seems sacrilege, and man becomes timid, affrighted at the sound of his own voice. Sole speck of life journeying across the ghostly wastes of a dead world, he trembles at his audacity, realizes that his is a maggot's life, nothing more."
				+ "\nStrange thoughts arise unsummoned, and the mystery of all things strives for utterance.";

		System.out.println(text);
		System.out.println();
		sortSentences(text);

	}

	// Сортировка абзацев
	public static String sortParagraphs(String text) {

		String paragraphs[] = text.split("\n");
		for (int i = 0; i < paragraphs.length; i++) {
			for (int j = 0; j < paragraphs.length - i - 1; j++) {
				int size1 = paragraphs[j].split("[!?.]+").length;
				int size2 = paragraphs[j + 1].split("[!?.]+").length;
				if (size1 > size2) {
					String buffer = paragraphs[j];
					paragraphs[j] = paragraphs[j + 1];
					paragraphs[j + 1] = buffer;

				}
			}
		}

		String result = "";
		for (int i = 0; i < paragraphs.length; i++) {
			result = result + paragraphs[i] + "\n";

		}

		return result;

	}

	// Сортировка по вхождению данного символа в словах
	public static String sort(String text, char ch) {
		String[] sentences = text.split("[!?.]+");
		for (int z = 0; z < sentences.length; z++) {
			String[] words = sentences[z].split(" ");
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words.length - 1 - i; j++) {
					int counter1 = countChars(words[j], ch);
					int counter2 = countChars(words[j + 1], ch);

					if (counter1 < counter2) {
						String buffer = words[j];
						words[j] = words[j + 1];
						words[j + 1] = buffer;
					} else if (counter1 == counter2) {
						if (words[j].charAt(0) > words[j + 1].charAt(0)) {
							String buffer = words[j];
							words[j] = words[j + 1];
							words[j + 1] = buffer;
						}
					}
				}

			}
			sentences[z] = "";
			for (int i = 0; i < words.length; i++) {
				sentences[z] = sentences[z] + " " + words[i];
			}

		}
		String result = "";
		for (int i = 0; i < sentences.length; i++) {
			result = result + (i + 1) + "." + sentences[i] + " ";
		}
		return result;
	}

	public static int countChars(String word, char ch) {
		int counter = 0;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch) {
				counter++;
			}
		}
		return counter;
	}

	// Сортировка предложений
	public static String sortSentences(String text) {
		String[] sentences = text.split("[!?.]+");
		System.out.println(Arrays.toString(sentences));
		System.out.println();
		for (int z = 0; z < sentences.length; z++) {
			String[] words = sentences[z].split(" ");
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words.length - 1 - i; j++) {
					if (words[j].length() > words[j + 1].length()) {
						String buffer = words[j];
						words[j] = words[j + 1];
						words[j + 1] = buffer;
					}
				}
			}
			sentences[z] = "";
			for (int i = 0; i < words.length; i++) {
				sentences[z] = sentences[z] + " " + words[i];
			}

		}
		String result = "";
		for (int i = 0; i < sentences.length; i++) {
			result = result + (i + 1) + "." + sentences[i] + " ";
		}
		System.out.println("Слова в предложениях отсортированы по возрастанию:");
		System.out.println(result);
		return result;
	}

}
