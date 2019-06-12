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
import com.examen.dev.project.ui.response.BootstrapTableResultPage;

@SuppressWarnings("unused")
@Controller
public class CuentasController {

    private static final Logger logger = LoggerFactory.getLogger(CuentasController.class);

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/cuentas")
    public ModelAndView getView() {
        return new ModelAndView("cuentas");
    }

    @GetMapping("/api/cuentas")
    public ResponseEntity<BootstrapTableResultPage<Cuenta>> getCuentas(
            @ModelAttribute(binding = false) PageOptions pageOptions,
            @ModelAttribute(binding = false) CuentaFilter filter) {
        ResultPage<Cuenta> resultPage = cuentaService.getCuenta(filter, pageOptions);
        BootstrapTableResultPage<Cuenta> uiResult = BootstrapTableResultPage.fromResultPage(resultPage);
        return ResponseEntity.ok(uiResult);
    }
    

    @DeleteMapping("/api/cuentas/{id:\\d+}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idCuenta) {
        logger.debug("delete");
        cuentaService.delete(idCuenta);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/api/cuentas")
    public ResponseEntity<?> post(@RequestBody Cuenta cuenta) {
        logger.debug("post");
        cuentaService.insert(cuenta);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cuentas/{id:\\d+}")
    public ResponseEntity<?> put(@RequestBody Cuenta cuenta) {
        logger.debug("put");
        cuentaService.update(cuenta);
        return ResponseEntity.noContent().build();
    }

    @ModelAttribute
    public CuentaFilter getFilter() {
    	CuentaFilter filter = new CuentaFilter();
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
