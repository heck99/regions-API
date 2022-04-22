package dev.Alexandrov.regions.controllers;

import dev.Alexandrov.regions.models.Region;
import dev.Alexandrov.regions.services.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.kerberos.KerberosTicket;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionsController {

    Logger log = LoggerFactory.getLogger(RegionsController.class);

    @Autowired
    RegionService regionsService;

    @GetMapping()
    public List<Region> getAllEmployee() {
        log.info("Получен запрос на получение всех регионов");
        List<Region> regions = regionsService.getAllRegions();
        return regions;
    }

    @GetMapping("/{regId}")
    public Region getRegion(@PathVariable Long regId) {
        log.info("Получен запрос на получение региона по id: " + regId);
        return regionsService.getRegion(regId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
     public void createRegion(HttpServletResponse response, @RequestBody Region region) {
        log.info("Получен запрос на создание региона: " + region.toString());
        Long id = regionsService.createRegion(region);
        response.addHeader("Location", "/regions/" + id);
    }

    @DeleteMapping("/{regId}")
    public boolean deleteRegion(@PathVariable Long regId) {
        log.info("Получен запрос на удаление региона по id: " + regId);
        return regionsService.deleteRegion(regId);
    }

    @PutMapping()
    public Region updateRegion(@RequestBody Region region) {
        log.info("Получен запрос на обновление региона: " + region.toString());
        return regionsService.updateRegion(region);
    }
}
