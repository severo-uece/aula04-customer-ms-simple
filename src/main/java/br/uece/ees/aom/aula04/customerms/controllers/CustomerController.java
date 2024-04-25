package br.uece.ees.aom.aula04.customerms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.uece.ees.aom.aula04.customerms.model.SimpleCustomer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private ArrayList<SimpleCustomer> clientes;

    public CustomerController(Environment env) {
        this.clientes = new ArrayList<>();
    }

    @GetMapping()
    public List<SimpleCustomer> listarClientes() {
            return this.clientes;
    }

    @GetMapping("/{id}")
    public String detalhesCliente(@PathVariable Integer id) {
        return new String();
    }

    @PostMapping()
    public String criarCliente(@RequestBody SimpleCustomer entity) {
        this.clientes.add(entity);
        return "Novo cliente: " + entity;
    }

    @PutMapping("/{id}")
    public void editarCliente(@PathVariable Long id, @RequestBody SimpleCustomer entity) {
        SimpleCustomer cliente = this.clientes.stream().filter(customer -> customer.getId() == id).findAny()
                .orElse(null);
        if (cliente != null) {
            cliente.setNome(entity.getNome());
            cliente.setIdade(entity.getIdade());
            cliente.setEmail(entity.getEmail());
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        SimpleCustomer cliente = this.clientes.stream().filter(customer -> customer.getId() == id).findAny()
                .orElse(null);
        if (cliente != null) {
            cliente.setAtivo(Boolean.FALSE);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found.");
    }

}