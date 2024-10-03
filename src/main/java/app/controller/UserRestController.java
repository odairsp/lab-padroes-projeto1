package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> buscarTodos(){
        return ResponseEntity.ok(userService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(userService.buscarPorId(id));
    }

    @PostMapping("/")
    public ResponseEntity<User> inserir(@RequestBody User user){
        userService.inserir(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user){
        userService.atualizar(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> excluir(@PathVariable Long id){

        userService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
