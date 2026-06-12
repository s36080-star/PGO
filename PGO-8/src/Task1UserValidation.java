import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Zadanie 1: Walidacja uzytkownika

record UserForm(String email, String password, int age) {
    UserForm {
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email cannot be empty");
        if (password == null || password.isEmpty()) throw new IllegalArgumentException("Password cannot be empty");
    }
}

class UserValidator {
    private final List<Predicate<UserForm>> rules = new ArrayList<>();

    public void addRule(Predicate<UserForm> rule) {
        rules.add(rule);
    }

    public boolean isValid(UserForm form) {
        for (Predicate<UserForm> rule : rules) {
            if (!rule.test(form)) return false;
        }
        return true;
    }
}
