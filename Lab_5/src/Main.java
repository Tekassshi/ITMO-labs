import Managers.CollectionManager;
import Managers.CommandManager;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Получение адреса файла при помощи переменных окружения
        String filepath = System.getProperty("user.dir") + "\\Collection.json";
        CollectionManager.setFilePath(filepath);

        CommandManager.run();

    }

}
