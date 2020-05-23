package practice.post.practice2;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Реализация паттерна Singleton
 * На этапе запуска программы создаётся объект UserCache в Heap. Одновременно создаётся и поле объекта, ссылающееся на
 * вновь созданную пустую потокозащищённую map. А ссылка на синглетон хранится в приватном поле в PermGen
 * Вызвав у класса UserCache статический метод getInstance() можно получить ссылку на синглетон.
 * Используя эту ссылку у синглетона можно вызывать публичные методы - получить мапу юзеров, добавлять юзеров.
 * Так как map потокозащищённая, то экземпляры разных сервлетов могут независимо к ней обращаться
 * @author Ihor Savchenko
 * @version 1.0
 */
public class UserCache {

    private static final UserCache INSTANCE = new UserCache();
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    private UserCache() {
    }

    public static UserCache getInstance() {
        return INSTANCE;
    }

    public Collection<User> values(){
        return this.users.values();
    }

    public void add(final User user){
        this.users.put(user.getId(), user);
    }
}
