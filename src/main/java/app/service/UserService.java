package app.service;

import app.model.User;


public interface UserService {
    Iterable<User> buscarTodos();
    User buscarPorId(Long id);
    void inserir(User user);
    void atualizar(Long id, User user);
    void deletar(Long id);
}
