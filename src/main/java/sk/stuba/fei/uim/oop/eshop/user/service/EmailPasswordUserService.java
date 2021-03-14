package sk.stuba.fei.uim.oop.eshop.user.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.eshop.user.domain.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailPasswordUserService implements UserService, AuthorisationService {

    private Map<String, User> users;

    public EmailPasswordUserService() {
        this.users = new HashMap<>();
    }

    @Override
    public User register(String email, String password, String name, String surname) {
        User user = new User(name, surname, email, hash(password));
        users.put(email, user);
        return user;
    }

    @Override
    public boolean logIn(String email, String password) {
        User user = findUserByEmail(email);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(hash(password));
    }

    @Override
    public User findUserByEmail(String email) {
        return users.get(email);
    }

    protected String hash(String word) {
        return DigestUtils.sha256Hex(word);
    }
}
