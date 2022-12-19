package spring.spring.security.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.spring.security.jwt.model.User;
import spring.spring.security.jwt.repository.UserRepository;

@Service
public class UserService { //salvar usuário com o meu sevice
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder; // habilitar uma criptografia com senhas mais seguras

    public void createUser(User user){
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}