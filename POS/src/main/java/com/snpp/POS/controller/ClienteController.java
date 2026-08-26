package com.snpp.POS.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snpp.POS.Entity.Cliente;
import com.snpp.POS.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController
	@RequestMapping("/api/clientes")
	@RequiredArgsConstructor
	public class ClienteController {

	    private ClienteService clienteService;
	    

	    public ClienteController(ClienteService clienteService) {
			super();
			this.clienteService = clienteService;
		}

		@GetMapping
	    public List<Cliente> listar() {
	        return clienteService.listar();
	    }

	    @GetMapping("/{id}")
	    public Cliente obtener(@PathVariable Long id) {
	        return clienteService.obtenerPorId(id);
	    }

	    @PostMapping
	    public Cliente crear(@RequestBody Cliente cliente) {
	        return clienteService.guardar(cliente);
	    }

	    @PutMapping("/{id}")
	    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
	        return clienteService.actualizar(id, cliente);
	    }

	    @DeleteMapping("/{id}")
	    public void eliminar(@PathVariable Long id) {
	        clienteService.eliminar(id);
	    }
	}

