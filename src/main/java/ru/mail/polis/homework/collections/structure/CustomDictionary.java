package ru.mail.polis.homework.collections.structure;

import java.util.*;

/**
 * Задание оценивается в 4 балла.
 * Необходимо реализовать класс которы умеет хранить строки и возвращать
 * список строк состоящий из того же набора буков, что ему передали строку.
 * Напишите какая сложность операций у вас получилась для каждого метода.
 */
public class CustomDictionary {

    HashSet<String> customDictionary;

    public CustomDictionary() {
        customDictionary = new HashSet<>();
    }

    /**
     * Сохранить строку в структуру данных
     *
     * @param value - передаваемая строка
     * @return - успешно сохранили строку или нет.
     * <p>
     * Сложность - [O(1)]
     */
    public boolean add(String value) {
        return customDictionary.add(value);
    }

    /**
     * Проверяем, хранится ли такая строка уже у нас
     *
     * @param value - передаваемая строка
     * @return - есть такая строка или нет в нашей структуре
     * <p>
     * Сложность - [O(n)]
     */
    public boolean contains(String value) {
        return customDictionary.contains(value);
    }

    /**
     * Удаляем сохраненную строку если она есть
     *
     * @param value - какую строку мы хотим удалить
     * @return - true если удалили, false - если такой строки нет
     * <p>
     * Сложность - [O(n)]
     */
    public boolean remove(String value) {
        return customDictionary.remove(value);
    }

    /**
     * Возвращает список из сохраненных ранее строк, которые состоят
     * из тех же букв что нам передали строку.
     * Примеры: сохраняем строки ["aaa", "aBa", "baa", "aaB"]
     * При поиске по строке "AAb" нам должен вернуться следующий
     * список: ["aBa","baa","aaB"]
     * <p>
     * Как можно заметить - регистр строки не должен влиять на поиск, при этом
     * возвращаемые строки хранятся в том виде что нам передали изначально.
     *
     * @return - список слов которые состоят из тех же букв, что и передаваемая
     * строка.
     * <p>
     * Сложность - [O(m * n), где m - длина переданной строки, n - количество сохраненных строк]
     */
    public List<String> getSimilarWords(String value) {
        List<String> result = new ArrayList<>();
        if (value == null || value.equals("") || size() == 0) {
            return result;
        }
        for (String s : customDictionary) {
            StringBuilder buffer = new StringBuilder(value.toLowerCase());
            for (int i = 0; i < buffer.length(); i++) {
                int currentIndex = s.toLowerCase().indexOf(buffer.charAt(i));
                if (currentIndex == -1) {
                    break;
                }
                buffer.deleteCharAt(currentIndex);
            }
            if (buffer.length() == 0) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Колл-во хранимых строк.
     *
     * @return - Колл-во хранимых строк.
     * <p>
     * Сложность - [O(1)]
     */
    public int size() {
        return customDictionary.size();
    }
}
