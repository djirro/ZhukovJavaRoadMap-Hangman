package main.java;// Правила:
// 1. Без ООП. Код пишется в процедурном стиле.
// 2. Есть список слов из которого выбирается случайное.
// 3. Всего 6 попыток отгадать слово.
//    Порядок рисовки: голова с веревкой, тело, руки, ноги.


// Рисунок:
/*
System.out.println("""
                        _________
                       |/      |                     \s
                       |       .O                    \s
                       |      /U\                   \\s
                       |       ||                    \s
                      /|\                            \
                ======|||==============================
                """);
*/

// Интерфейс:
/*
        _________
       |/                            \s
       |                             \s
       |                            \\s
       |                             \s
      /|\                            \
======|||==============================

Р Е Л И _ И _

Введите букву:
 */

public class Main {

    // Счетчик ошибок.
    // При достижении 6 - игра заканчивается.
    static int errorCounter;

    static char[] lettersInWord;
    static int[] guessedLettersInWord;

    public static void main(String[] args) {

    }

    public static void startGame() {
        // errorCounter = 0

        // getWord();
        // Находим количество букв в слове.
        // Создаем массив букв слова.
        // Создаем пустой массив с 0 и 1 для отображения отгаданных букв.


    }

    public static void endGame() {

    }

    public static String getWord() {
        int numberOfRows = getRandomNumber();
        return "";
    }

    public static int getRandomNumber() {
        int minNumber = 0;
        int maxNumber = getNumberOfRowsFromFileOfWords();

        // возвращаем число от minNumber до maxNumber
        return 0;
    }

    public static int getNumberOfRowsFromFileOfWords() {
        // Открываем файл со словами.
        // Возвращаем максимальное количество строк.
        return 0;
    }

    public static void showInterface() {
        showPictureOfTheGallows();
        showWord();
        enteringLetterFromKeyboard();
    }

    public static void showPictureOfTheGallows() {
        // Смотрим переменную errorCounter и показываем изображение.
        // Всего их 7.
    }

    public static void showWord() {
        // [0, 0, 0, 0, 0, 0, 0] -> _ _ _ _ _ _ _
        // [1, 1, 1, 1, 0, 1, 0] -> Р Е Л И _ И _
    }

    public static void enteringLetterFromKeyboard() {
        char letter;

        // Получаем букву с клавиатуры.
        letter = 'a';

        if (!isInputLetterValid(letter)) {
            // Сообщить о том что буква указана неверно.
            enteringLetterFromKeyboard();
        };

        if (isLetterInWordGuessed(letter)) {
            // Сообщить о том что буква уже открыта.
            enteringLetterFromKeyboard();
        }

        if (!isLetterInWord(letter)) {
            // Увеличиваем счетчик ошибки
            showInterface();
        }

        showLetterInWord(letter);
    }

    public static boolean isInputLetterValid(char letter) {
        // Проверка - буква а-я, А-Я;
        return true;
    }

    public static boolean isLetterInWordGuessed(char letter) {
        // Проверка - скрыта ли буква в слове.
        return true;
    }

    public static boolean isLetterInWord(char letter) {
        // Проверяем есть ли буква в слове
        return true;
    }

    public static void showLetterInWord(char letter) {
        // Узнаем под какими индексами находятся буквы.
        // Меняем 0 на 1 в guessedLettersInWord во всех индексах.

        showInterface();
    }


    // Примерный план работы приложения:

    // Создаем базу данных из слов и сохраняем из в файл.

    // Функция startGame() начинает игру и запрашивает слово из getWord()
    // Функция endGame() заканчивает игру. В консоли будет написано как начать игру заново.

    // Функция getWord() обращается к getRandomNumberFromRowsInFile(), получает
    // число и по этому числу ищет строку в файле.

    // Функция int getRandomNumberFromRowsInFile() обращается к функции
    // int getNumberOfRowsFromFileWords(), получая количество строк, после чего
    // int getRandomNumberFromRowsInFile() возвращает рандомную строку.

    // После того как мы получили слово у нас есть 6 попыток отгадать его.
    // Нужно организовать проверку введенного символа.
    // Это должны быть только буквы а-я и А-Я.
    // Проверка осуществляется в методе isInputLetterValid()

    // Алгоритм: ввод буквы с клавиатуры -> isInputLetterValid() true ->
    // isLetterInWord() false - меняем рисунок и счетчик ошибок на +1. Проверяем не равен ли он 6.
    // isLetterInWord() true -> showLetterInWord()

    // Отображение букв в слове: в начале игры получаем длину слова -> создаем массив со всеми нулями,
    // где 0 - `_`, а 1 - `буква`.
    // [0, 0, 0, 0, 0, 0, 0] -> _ _ _ _ _ _ _
    // [1, 1, 1, 1, 0, 1, 0] -> Р Е Л И _ И _

}