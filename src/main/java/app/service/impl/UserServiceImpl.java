package app.service.impl;

import app.model.Endereco;
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

        salvarComCep(user);
    }

    @Override
    public void atualizar(Long id, User user) {

        Optional<User> userbd = userRepository.findById(id);

        if (userbd.isPresent()) {
            salvarComCep(user);
        }

    }

    @Override
    public void deletar(Long id) {
        userRepository.deleteById(id);
    }


    private void salvarComCep(User user) {
        String cep = user.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });


        user.setEndereco(endereco);
        userRepository.save(user);
    }
}
