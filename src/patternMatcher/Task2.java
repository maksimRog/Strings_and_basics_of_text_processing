package patternMatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
	/*
	 * Напишите анализатор, позволяющий последовательно возвращать содержимое
	 * узлов xml-документа и его тип (открывающий тег, закрывающий тег,
	 * содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для
	 * решения данной задачи нельзя.
	 */
	public static void main(String[] args) {
		Scanner sc;
		List<Note> notes = new ArrayList<>();
		Note.Builder builder = new Note.Builder();
		Path path = Paths.get("");

		String s = path.toAbsolutePath().toString();
		s = s + "\\src\\patternMatcher\\File.xml";
		System.out.println(s);
		try {
			File file = new File(s);
			sc = new Scanner(file);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println(line);

				if (line.contains("<to>")) {
					builder.setTo(line.replace("<to>", "").replace("</to>", ""));

				} else if (line.contains("<from>")) {

					builder.setFrom(line.replace("<from>", "").replace("</from>", ""));
				} else if (line.contains("id")) {
					builder.setId(Integer.parseInt(line.replaceAll("[^0-9]+", "")));

				} else if (line.contains("<heading>")) {
					builder.setHeading(line.replace("<heading>", "").replace("</heading>", ""));

				} else if (line.contains("<body>")) {
					builder.setBody(line.replace("<body>", "").replace("</body>", ""));

				} else if (line.contains("</note>")) {
					notes.add(builder.build());
					builder = new Note.Builder();

				}

			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(notes.toString());

	}
}
