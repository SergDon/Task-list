import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static String purchase;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            mainMenu(scanner);

            if (purchase.equalsIgnoreCase("end")) {
                break;
            } else {
                switch (purchase) {
                    case ("1"): {
                        itemToBuy(scanner, list);
                        break;
                    }
                    case ("2"): {
                        show(list);
                        break;
                    }
                    case ("3"): {
                        deleteItem(scanner, list);
                        show(list);
                        break;
                    }
                    case ("4"): {
                        findItem(scanner, list);
                        break;
                    }

                }
            }
        }
    }

    private static void mainMenu(Scanner scanner) {
        System.out.println("Пожалуйста! Выберите Операцию или Введите end Для Завершения:");

        System.out.println("1. Сделать Операцию  - добавить");
        System.out.println("2. Сделать Операцию  - показать");
        System.out.println("3. Сделать Операцию - удалить");
        System.out.println("4. Запустить Операцию - найти");

        purchase = scanner.nextLine();
    }

    private static void deleteItem(Scanner scanner, ArrayList<String> list) {
        System.out.println("Внимание! Какую Хотите Удалить Покупку? Введите Название Покупки:");
        show(list);
        purchase = scanner.nextLine();
        try {
            list.remove(Integer.parseInt(purchase) - 1);
        } catch (NumberFormatException e) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equalsIgnoreCase(purchase)) {
                    list.remove(i);
                    System.out.println("Ваша Покупка Удалена, Обновим Список Покупок:");
                }
            }
        }
    }
    private static void itemToBuy(Scanner scanner, ArrayList<String> list) {
        System.out.println("Какую Вы Покупку Хотите Добавить?");
        purchase = scanner.nextLine();
        list.add(purchase);
        System.out.println("Итого Сейчас В Списке Покупок: " + list.size());
    }

    private static void findItem(Scanner scanner, ArrayList<String> list) {
        System.out.println("Внимание Введите Сюда Текст Для Поиска: ");
        purchase = scanner.nextLine();
        try {
            System.out.println("О-о! Найдено так: " + purchase + ". " + list.get(Integer.parseInt(purchase) - 1));
        } catch (NumberFormatException e) {
            String lowerCase;
            String scanLow = purchase.toLowerCase();
            for (int i = 0; i < list.size(); i++) {
                lowerCase = list.get(i).toLowerCase();
                if (lowerCase.contains(scanLow)) {
                    System.out.println((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                }
            }
        }
    }

    public static void show(ArrayList<String> list) {
        for (String i : list) {
            System.out.println(list.indexOf(i) + 1 + ". " + i);
        }
    }
}