package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>Реалізуйте метод `getUniqueCharacters(String fileName)` який приймає як параметр назву файлу.
 * Для цього використовуйте TreeSet. Файл містить букви латинського алфавіту і розділові знаки.</p>
 *
 * <p>Метод повинен відсортувати всі букви по алфавіту і повернути строку з 5 різних букв без
 * розділових знаків.
 * Якщо у файлі міститься менше п'яти різних букв, то потрібно повернути їх усі.
 * Можливий випадок, коли переданого файлу не існує, в такому разі потрібно викинути помилку
 * про відсутність файлу.</p>
 *
 * <p>Приклад 1: ur-BvT?^ ra w; p
 * Результат 1: abprt</p>
 *
 * <p>Приклад 2: A _f*c a?F
 * Результат 2: acf</p>
 */
public class TreeSetCharacters {
    public String getUniqueCharacters(String fileName) throws IOException {
        File file = new File(fileName);
        Set<Character> treeSet = new TreeSet<>(Character::compareTo);
        try (FileReader fr = new FileReader(file)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                if ((ch > 96 && ch < 123) || (ch > 64 && ch < 91)) {
                    treeSet.add(Character.toLowerCase((char) ch));
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не найден");
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : treeSet) {
            sb.append(ch);
            if (sb.length() == 5) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
