package app.service;

import app.model.User;


public interface UserService {
    Iterable<User> buscarTodos();
    void inserir(User user);
    User buscarPorId(Long id);
    void atualizar(Long id, User user);
    void deletar(Long id);
}
