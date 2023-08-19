package faker;

import com.github.javafaker.Faker;
import user.User;

public class FakeUser {
    static Faker faker = new Faker();
    public static User fakeUser() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new User(name, email, password);
    }

    public static User fakeUserWithShortPassword() {
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(1, 3);
        return new User(name, email, password);
    }
}
