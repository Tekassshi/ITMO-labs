import Managers.CollectionManager;
import Managers.CommandManager;
import java.io.IOException;

public class Main {

    /** Основной метод для запуска программы и установки директории для входного json файла
     * @throws IOException если такого файла не существует
     * */
    public static void main(String[] args) throws IOException {

        // Получение адреса файла при помощи переменных окружения
        String filepath = System.getProperty("user.dir") + "\\Collection.json";
        CollectionManager.setFilePath(filepath);

        CommandManager.run();
    }

}
