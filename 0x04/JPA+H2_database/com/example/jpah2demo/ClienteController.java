package com.example.jpah2demo;

import com.sun.source.tree.TryTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        try {
            Cliente clienteCriado = clienteRepository.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> clientePorId = clienteRepository.findById(idClient);
        if (clientePorId.isPresent()) {
            return new ResponseEntity<>(clientePorId.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient) {
             clienteRepository.deleteById(idClient);

    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteAtualizado = clienteRepository.findById(id);
        if (clienteAtualizado.isPresent()) {
            Cliente cliente1 = clienteAtualizado.get();
            cliente1.setNome(cliente.getNome());
            cliente1.setIdade(cliente.getIdade());
            cliente1.setEmail(cliente.getEmail());
            cliente1.setListaDeEndereco(cliente.getListaDeEndereco());
            cliente1.setListaDeTelefones(cliente.getListaDeTelefones());
            clienteRepository.save(cliente1);
        }
    }
}