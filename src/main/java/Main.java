package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random;


public class Main {
    private static Random random = new Random();

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
            String line;
            while ((line = reader.readLine()) != null) {
                countRowsInFile++;
            }
            System.out.println("Количество строк в файле: " + countRowsInFile);
        } catch(IOException error) {
            System.err.println("Ошибка при чтении файла: " + error.getMessage());
            canReadFileWithWords = false;
            return 0;
        }
        
        canReadFileWithWords = true;
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
                System.out.println("""
                        _________
                       |/                         
                       |                         
                       |     
                       |                          
                      /|\\
                ======|||==============================
                """);
            case 1:
                System.out.println("""
                        _________
                       |/      |                     
                       |       .O                    
                       |      
                       |                          
                      /|\\
                ======|||==============================
                """);
            case 2:
                System.out.println("""
                        _________
                       |/      |                     
                       |       .O                    
                       |       U
                       |                          
                      /|\\
                ======|||==============================
                """);
            case 3:
                System.out.println("""
                        _________
                       |/      |                     
                       |       .O                    
                       |      /U
                       |                         
                      /|\\
                ======|||==============================
                """);
            case 4:
                System.out.println("""
                        _________
                       |/      |                     
                       |       .O                    
                       |      /U\\
                       |                          
                      /|\\
                ======|||==============================
                """);
            case 5:
                System.out.println("""
                        _________
                       |/      |                     
                       |       .O                    
                       |      /U\\
                       |       |                   
                      /|\\
                ======|||==============================
                """);
            case 6:
                System.out.println("""
                        _________
                       |/      |                     
                       |       .O                    
                       |      /U\\
                       |       ||                   
                      /|\\
                ======|||==============================
                """);
            default:
                System.out.println("""
                        _________
                       |/       |                  
                       |      error                   
                       |     
                       |                          
                      /|\\
                ======|||==============================
                """);
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





    // Правила:
// 1. Без ООП. Код пишется в процедурном стиле.
// 2. Есть список слов из которого выбирается случайное.
// 3. Всего 6 попыток отгадать слово.
//    Порядок рисовки: голова с веревкой, тело, руки, ноги.


// Рисунок:
/*
        System.out.println("""
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