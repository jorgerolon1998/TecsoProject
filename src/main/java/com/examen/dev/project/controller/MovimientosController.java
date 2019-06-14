package com.examen.dev.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examen.dev.project.dao.PageOptions;
import com.examen.dev.project.dao.ResultPage;
import com.examen.dev.project.entity.Cuenta;
import com.examen.dev.project.entity.CuentaFilter;
import com.examen.dev.project.entity.Movimiento;
import com.examen.dev.project.entity.MovimientoFilter;
import com.examen.dev.project.service.CuentaService;
import com.examen.dev.project.service.MovimientoService;
import com.examen.dev.project.ui.response.BootstrapTableResultPage;

@SuppressWarnings("unused")
@Controller
public class MovimientosController {

    private static final Logger logger = LoggerFactory.getLogger(MovimientosController.class);

    @Autowired
    private MovimientoService movimientoService;



    @GetMapping("/movimientos/{id:\\d+}")
    public ResponseEntity<BootstrapTableResultPage<Movimiento>> getMovimiento (
            @ModelAttribute(binding = false) PageOptions pageOptions,
            @PathVariable(name = "id") Long idCuenta,
            @ModelAttribute(binding = false) MovimientoFilter filter) {
        ResultPage<Movimiento> resultPage = movimientoService.getMovimiento(filter, pageOptions, idCuenta);
        BootstrapTableResultPage<Movimiento> uiResult = BootstrapTableResultPage.fromResultPage(resultPage);
        return ResponseEntity.ok(uiResult);
    }
    


    @PostMapping("/movimientos/{id:\\d+}")
    public ResponseEntity<?> post(@RequestBody Movimiento movimiento) {
        logger.debug("post");
        movimientoService.insert(movimiento);
        return ResponseEntity.noContent().build();
    }

 

    @ModelAttribute
    public MovimientoFilter getFilter() {
    	MovimientoFilter filter = new MovimientoFilter();
        return filter;
    }

    @ModelAttribute
    public PageOptions getPageOptions(@RequestParam(name = "limit", defaultValue = "5") Integer limit,
            @RequestParam(name = "offset", defaultValue = "0") Integer offset) {
        PageOptions pageOptions = new PageOptions();
        pageOptions.setSize(limit);
        pageOptions.setOffset(offset);
        return pageOptions;
    }
}
