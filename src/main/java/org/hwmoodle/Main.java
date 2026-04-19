package org.hwmoodle;


public class Main {
    static void main() {

        // Тестирование класса MyHashMap, чтобы убедиться, что все работает правильно

        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("\n Тест 1: Добавление и получение");
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        printTest("Размер равен 3", map.size() == 3);
        printTest("Apple == 10", map.get("Apple") == 10);
        printTest("Banana == 20", map.get("Banana") == 20);

        System.out.println("\n Тест 2: Обновление значения по ключу");
        map.put("Apple", 100);
        printTest("Размер все еще 3", map.size() == 3);
        printTest("Apple теперь 100", map.get("Apple") == 100);

        System.out.println("\n Тест 3: Проверка containsKey");
        printTest("Содержит Banana", map.containsKey("Banana"));
        printTest("Не содержит Grape", !map.containsKey("Grape"));

        System.out.println("\n Тест 4: Удаление элементов");
        map.remove("Banana");
        printTest("Размер уменьшился до 2", map.size() == 2);
        printTest("Banana больше не существует", map.get("Banana") == null);
        printTest("containsBanana == false", !map.containsKey("Banana"));

        System.out.println("\n Тест 5: Коллизии (симуляция)");
        for (int i = 0; i < 50; i++) {
            map.put("Key" + i, i);
        }
        printTest("Размер после массового добавления", map.size() == 52);
        printTest("Key49 == 49", map.get("Key49") == 49);

        System.out.println("\n Тест 6: Удаление несуществующего");
        int sizeBefore = map.size();
        map.remove("NoSuchKey");
        printTest("Размер не изменился", map.size() == sizeBefore);
    }
    private static void printTest(String description, boolean condition) {
        String result = condition ? " УСПЕХ " : " ОШИБКА ";
        System.out.println(result + " : " + description);
    }
}
