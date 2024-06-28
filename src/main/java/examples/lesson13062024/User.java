package examples.lesson13062024;

public class User {
    //под каждый entity класс создаем репозиторий, для управления entity
    //controller - отправ запросы и ответы, расботает с один или неск. service
    //service - обращение к репоз., чтобы извлечь данные из базы. Либо связаны с др сервисами
    //entity
    // controller - service: repository (entity классами)

    //@Service - помещает в конт Spring

    //Page<Animal> findByAnimalShelterCode(String animalShelterCode, Pageable pageable);

    //метод save - обновляет (если запись существует) и сохраняет (если запись отсутствует)

    //@Modifying - аннотац для запросов UPDATE И DELETE - замена jdbc[executeQuery на jdbc[executeUpdate]
    //все запросы выполняются executeQuery ResultSet

    //@Transactional - если над методом репоз. -> открывает, выполняется, закрыв.
    // если ставится над методом сервиса -> открыв, выполняется, закрыв. Но при ошибке - откатывает к началу
}
