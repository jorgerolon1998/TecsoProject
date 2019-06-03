package com.imagosur.dev.proyent.controller;

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

import com.imagosur.dev.proyent.dao.PageOptions;
import com.imagosur.dev.proyent.dao.ResultPage;
import com.imagosur.dev.proyent.entity.Empleado;
import com.imagosur.dev.proyent.entity.EmpleadoFilter;
import com.imagosur.dev.proyent.service.EmpleadoService;
import com.imagosur.dev.proyent.ui.response.BootstrapTableResultPage;

@Controller
public class EmpleadosController {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadosController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public ModelAndView getView() {
        return new ModelAndView("empleados");
    }

    @GetMapping("/api/empleados")
    public ResponseEntity<BootstrapTableResultPage<Empleado>> getEmpleados(
            @ModelAttribute(binding = false) PageOptions pageOptions,
            @ModelAttribute(binding = false) EmpleadoFilter filter) {
        ResultPage<Empleado> resultPage = empleadoService.getEmpleados(filter, pageOptions);
        BootstrapTableResultPage<Empleado> uiResult = BootstrapTableResultPage.fromResultPage(resultPage);
        return ResponseEntity.ok(uiResult);
    }

    @DeleteMapping("/api/empleados/{id:\\d+}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idEmpleado) {
        logger.debug("delete");
        empleadoService.delete(idEmpleado);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/api/empleados")
    public ResponseEntity<?> post(@RequestBody Empleado empleado) {
        logger.debug("post");
        empleadoService.insert(empleado);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/empleados/{id:\\d+}")
    public ResponseEntity<?> put(@RequestBody Empleado empleado) {
        logger.debug("put");
        empleadoService.update(empleado);
        return ResponseEntity.noContent().build();
    }

    @ModelAttribute
    public EmpleadoFilter getFilter() {
        EmpleadoFilter filter = new EmpleadoFilter();
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
