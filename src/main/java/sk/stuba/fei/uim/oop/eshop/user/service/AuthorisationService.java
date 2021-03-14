package sk.stuba.fei.uim.oop.eshop.user.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthorisationService {

    boolean logIn(String email, String password);
}
