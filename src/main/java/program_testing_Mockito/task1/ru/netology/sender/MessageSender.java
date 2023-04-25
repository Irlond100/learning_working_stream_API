package program_testing_Mockito.task1.ru.netology.sender;

import java.util.Map;

public interface MessageSender {

    String send(Map<String, String> headers);
}
