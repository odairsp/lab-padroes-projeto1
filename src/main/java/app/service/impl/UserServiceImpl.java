package app.service.impl;

import app.model.User;
import app.repository.EnderecoRepository;
import app.repository.UserRepository;
import app.service.UserService;
import app.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<User> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public User buscarPorId(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public void inserir(User user) {
        if (enderecoRepository.existsById()) {
            userRepository.save(user);
        }else {

        }

    }

    @Override
    public void atualizar(Long id, User user) {

    }

    @Override
    public void deletar(Long id) {

    }
}
