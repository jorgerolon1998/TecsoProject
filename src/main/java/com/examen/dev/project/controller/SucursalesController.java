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
import com.examen.dev.project.entity.Sucursal;
import com.examen.dev.project.entity.SucursalFilter;
import com.examen.dev.project.service.SucursalService;
import com.examen.dev.project.ui.response.BootstrapTableResultPage;

@SuppressWarnings("unused")
@Controller
public class SucursalesController {

    private static final Logger logger = LoggerFactory.getLogger(SucursalesController.class);

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/sucursales")
    public ModelAndView getView() {
        return new ModelAndView("sucursales");
    }

    @GetMapping("/api/sucursales")
    public ResponseEntity<BootstrapTableResultPage<Sucursal>> getSucursals(
            @ModelAttribute(binding = false) PageOptions pageOptions,
            @ModelAttribute(binding = false) SucursalFilter filter) {
        ResultPage<Sucursal> resultPage = sucursalService.getSucursal(filter, pageOptions);
        BootstrapTableResultPage<Sucursal> uiResult = BootstrapTableResultPage.fromResultPage(resultPage);
        return ResponseEntity.ok(uiResult);
    }
    
    @GetMapping("/api/findSucursales")
    public ResponseEntity<Sucursal> getSucursalbyLatAndLong(Double latitud, Double longitud) {
        Sucursal sucursal = sucursalService.getSucursalByLatAndLong(latitud, longitud);
        return ResponseEntity.ok(sucursal);
    } 
    
    @DeleteMapping("/api/sucursales/{id:\\d+}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idSucursal) {
        logger.debug("delete");
        sucursalService.delete(idSucursal);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/api/sucursales")
    public ResponseEntity<?> post(@RequestBody Sucursal sucursal) {
        logger.debug("post");
        sucursalService.insert(sucursal);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/sucursales/{id:\\d+}")
    public ResponseEntity<?> put(@RequestBody Sucursal sucursal) {
        logger.debug("put");
        sucursalService.update(sucursal);
        return ResponseEntity.noContent().build();
    }

    @ModelAttribute
    public SucursalFilter getFilter() {
    	SucursalFilter filter = new SucursalFilter();
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
