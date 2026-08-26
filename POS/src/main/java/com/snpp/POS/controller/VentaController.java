package com.snpp.POS.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snpp.POS.Entity.TipoMovimiento;
import com.snpp.POS.Entity.Venta;
import com.snpp.POS.service.VentaService;

import lombok.RequiredArgsConstructor;



	@RestController
	@RequestMapping("/api/ventas")
	@RequiredArgsConstructor
	public class VentaController {
	

	    private VentaService ventaService;
	    

	    public VentaController(VentaService ventaService) {
			super();
			this.ventaService = ventaService;
		}

		@PostMapping
	    public Venta registrarVenta(@RequestParam(required = false) Long clienteId,
	                                @RequestParam Long empleadoId,
	                                @RequestParam Long productoId,
	                                @RequestParam Integer cantidad) {
	        return ventaService.registrarVenta(clienteId, empleadoId, productoId, cantidad);
	    }

	    @PostMapping("/ingreso")
	    public Venta registrarIngreso(@RequestParam Long empleadoId,
	                                  @RequestParam BigDecimal monto,
	                                  @RequestParam String descripcion) {
	        return ventaService.registrarIngreso(empleadoId, monto, descripcion);
	    }

	    @PostMapping("/egreso")
	    public Venta registrarEgreso(@RequestParam Long empleadoId,
	                                 @RequestParam BigDecimal monto,
	                                 @RequestParam String descripcion) {
	        return ventaService.registrarEgreso(empleadoId, monto, descripcion);
	    }

	    @GetMapping("/tipo/{tipo}")
	    public List<Venta> listarPorTipo(@PathVariable TipoMovimiento tipo) {
	        return ventaService.listarPorTipo(tipo);
	    }

	    @GetMapping("/reportes/total")
	    public BigDecimal totalPorTipo(@RequestParam TipoMovimiento tipo,
	                                   @RequestParam LocalDateTime inicio,
	                                   @RequestParam LocalDateTime fin) {
	        return ventaService.calcularTotalPorTipo(tipo, inicio, fin);
	    }

	    @GetMapping("/reportes/balance")
	    public Map<String, BigDecimal> balanceCaja(@RequestParam LocalDateTime inicio,
	                                               @RequestParam LocalDateTime fin) {
	        return Map.of("balance", ventaService.calcularBalanceCaja(inicio, fin));
	    }

	    @GetMapping("/reportes/productos-mas-vendidos")
	    public List<Object[]> productosMasVendidos() {
	        return ventaService.obtenerProductosMasVendidos();
	    }

	    @GetMapping("/reportes/ventas-por-empleado")
	    public List<Object[]> ventasPorEmpleado() {
	        return ventaService.obtenerTotalVentasPorEmpleado();
	    }
	}

