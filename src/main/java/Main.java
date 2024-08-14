package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random;
import java.util.logging.Logger;
import java.util.Scanner;


public class Main {
    private static Random random = new Random();
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static Scanner scanner = new Scanner(System.in);

    static int errorCounter;
    static boolean canReadFileWithWords = false;
    static char[] lettersInWord;
    static int[] guessedLettersInWord;

    public static void main(String[] args) {

    }

    // Старт игры.
    public static void startGame() {
        String wordToGuess = "";
        errorCounter = 0;

        wordToGuess = getWord();
        // Находим количество букв в слове.
        // Создаем массив букв слова.
        // Создаем пустой массив с 0 и 1 для отображения отгаданных букв.


    }

    // Окончание игры.
    public static void endGame() {
        logger.info("Игра окончена!");
        enteringLetterForStartGame();
    }

    // Получаем случайное слово из файла Words.
    public static String getWord() {
        int lineNumber = getRandomLineNumber();
        return "";
    }

    // Получаем случайный номер строки из Words.
    public static int getRandomLineNumber() {
        int minNumber = 0;
        int maxNumber = getNumberOfRowsFromFileOfWords();

        return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    // Получаем максимальное количество строк в файле Words.
    public static int getNumberOfRowsFromFileOfWords() {
        String filePath = "src/main/resources/Words";
        int countRowsInFile = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((reader.readLine()) != null) {
                countRowsInFile++;
            }
        } catch(IOException error) {
            logger.warning("Ошибка при чтении файла: " + error.getMessage());
            canReadFileWithWords = false;
            return 0;
        }
        
        canReadFileWithWords = true;
        logger.info("Количество строк в файле: " + countRowsInFile);
        return countRowsInFile;
    }

    // Отображаем интерфейс для пользователя в терминале.
    public static void showGameInterface() {
        showPictureOfTheGallows();
        showWord();
        enteringLetterFromKeyboard();
    }

    // Показываем изображение, в зависимости от количества ошибок игрока.
    public static void showPictureOfTheGallows() {
        switch (errorCounter) {
            case 0:
                logger.info("""

                        _________
                       |/
                       |
                       |
                       |
                      /|\\
                ======|||==============================
                """);
                break;
            case 1:
                logger.info("""

                        _________
                       |/      |
                       |       .O
                       |
                       |
                      /|\\
                ======|||==============================
                """);
                break;
            case 2:
                logger.info("""

                        _________
                       |/      |
                       |       .O
                       |       U
                       |
                      /|\\
                ======|||==============================
                """);
                break;
            case 3:
                logger.info("""

                        _________
                       |/      |
                       |       .O
                       |      /U
                       |
                      /|\\
                ======|||==============================
                """);
                break;
            case 4:
                logger.info("""

                        _________
                       |/      |
                       |       .O
                       |      /U\\
                       |
                      /|\\
                ======|||==============================
                """);
                break;
            case 5:
                logger.info("""

                        _________
                       |/      |
                       |       .O
                       |      /U\\
                       |       |
                      /|\\
                ======|||==============================
                """);
                break;
            case 6:
                logger.info("""

                       _________
                       |/      |
                       |       .O
                       |      /U\\
                       |       ||
                      /|\\
                ======|||==============================
                """);
                break;
            default:
                logger.info("""

                        _________
                       |/       |
                       |      error
                       |
                       |
                      /|\\
                ======|||==============================
                """);
                break;
        }
    }

    // Показываем слово пользователю в зависимости от открытых букв.
    // Пример:
    // [0, 0, 0, 0, 0, 0, 0] -> _ _ _ _ _ _ _
    // [1, 1, 1, 1, 0, 1, 0] -> Р Е Л И _ И _
    public static void showWord() {

    }

    // Ввод буквы с клавиатуры.
    public static void enteringLetterFromKeyboard() {
        char letter;

        // Получаем букву с клавиатуры.
        letter = 'a';

        if (!isInputLetterValid(letter)) {
            // Сообщить о том что буква указана неверно.
            enteringLetterFromKeyboard();
        }

        if (isLetterInWordGuessed(letter)) {
            // Сообщить о том что буква уже открыта.
            enteringLetterFromKeyboard();
        }

        if (!isLetterInWord(letter)) {
            // Увеличиваем счетчик ошибки
            showGameInterface();
        }

        toggleLetterVisibility(letter);
    }

    // Проверка - буква а-я, А-Я.
    public static boolean isInputLetterValid(char letter) {

        return true;
    }

    // Проверка - скрыта ли буква в слове.
    public static boolean isLetterInWordGuessed(char letter) {

        return true;
    }

    // Проверяем есть ли буква в слове.
    public static boolean isLetterInWord(char letter) {

        return true;
    }

    // Переключаем угаданные буквы, чтобы сделать их видимыми.
    public static void toggleLetterVisibility(char letter) {
        // Узнаем под какими индексами находятся буквы.
        // Меняем 0 на 1 в guessedLettersInWord во всех индексах.

        showGameInterface();
    }

    // Ввод буквы с клавиатуры
    public static void enteringLetterForStartGame() {
        logger.info("Нажми `Y`, чтобы начать с начала: ");
        char letter = scanner.next().charAt(0);

        if (!isInputLetterForStartGameValid(letter)) {
            enteringLetterForStartGame();
        }
    }

    public static boolean isInputLetterForStartGameValid(char letter) {
        if (letter == 'y' || letter == 'Y') {
            return true;
        } else {
            logger.warning("Введена неверная буква.");
            return false;
        }
    }





    // Правила:
// 1. Без ООП. Код пишется в процедурном стиле.
// 2. Есть список слов из которого выбирается случайное.
// 3. Всего 6 попыток отгадать слово.
//    Порядок рисовки: голова с веревкой, тело, руки, ноги.


// Рисунок:
/*
        logger.info("""

                        _________
                       |/      |
                       |       .O
                       |      /U\\
                       |       ||
                      /|\\
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

    // Примерный план работы приложения:

    // Создаем базу данных из слов и сохраняем из в файл.

    // Функция startGame() начинает игру и запрашивает слово из getWord()
    // Функция endGame() заканчивает игру. В консоли будет написано как начать игру заново.

    // Функция getWord() обращается к getRandomNumberFromRowsInFile(), получает
    // число и по этому числу ищет строку в файле.

    // Функция int getRandomNumberFromRowsInFile() обращается к функции
    // int getNumberOfRowsFromFileWords(), получая количество строк, после чего
    // int getRandomNumberFromRowsInFile() возвращает случайную строку.

    // После того как мы получили слово у нас есть 6 попыток отгадать его.
    // Нужно организовать проверку введенного символа.
    // Это должны быть только буквы а-я и А-Я.
    // Проверка осуществляется в методе isInputLetterValid()

    // Алгоритм: ввод буквы с клавиатуры -> isInputLetterValid() true ->
    // isLetterInWord() false - меняем рисунок и счетчик ошибок на +1. Проверяем не равен ли он 6.
    // isLetterInWord() true -> toggleLetterVisibility()

    // Отображение букв в слове: в начале игры получаем длину слова -> создаем массив со всеми нулями,
    // где 0 - `_`, а 1 - `буква`.
    // [0, 0, 0, 0, 0, 0, 0] -> _ _ _ _ _ _ _
    // [1, 1, 1, 1, 0, 1, 0] -> Р Е Л И _ И _

}