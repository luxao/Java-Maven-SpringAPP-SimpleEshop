package sk.stuba.fei.uim.oop.eshop.user.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.eshop.user.domain.User;

@Service
public interface UserService {

    User findUserByEmail(String email);

    User register(String email, String password, String name, String surname);
}
