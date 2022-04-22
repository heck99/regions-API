package dev.Alexandrov.regions.services;

import dev.Alexandrov.regions.exceptions.RegionNotFound;
import dev.Alexandrov.regions.exceptions.ValidatorException;
import dev.Alexandrov.regions.mappers.RegionsMapper;
import dev.Alexandrov.regions.models.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionsServiceImp implements RegionService{

    Logger log = LoggerFactory.getLogger(RegionsServiceImp.class);

    @Autowired
    RegionsMapper regionsMapper;

    @Override
    public Long createRegion(Region region) {
        validate(region);
        int rows = regionsMapper.createRegion(region);
        log.info("Добавлено записей:" + rows);
        return region.getId();
    }

    @Override
    public Region getRegion(Long regId) {
        Region region = regionsMapper.getRegionById(regId);
        if(region == null) {
            log.warn("Регион с данным id не найден");
            throw new RegionNotFound("Регион с данным id не найден");
        }
        return region;
    }

    @Override
    public List<Region> getAllRegions() {
        return regionsMapper.getAllRegions();
    }

    @Override
    public Region updateRegion(Region region) {
        validate(region);
        int row = regionsMapper.updateRegion(region);
        if(row == 0) {
            log.warn("Регион с данным id не найден");
            throw new RegionNotFound("Регион с данным id не найден");
        }
        return region;
    }

    @Override
    public boolean deleteRegion(Long regId) {
        return regionsMapper.deleteRegion(regId);
    }

    private boolean validate(Region region) {
        if(region.getId() == null) {
            log.warn("У объекта не задан id");
            throw new ValidatorException("id не может быть пустым");
        }
        if(region.getFullName() == null) {
            log.warn("У объекта не задано полное имя");
            throw new ValidatorException("Необходимо задать полное имя");
        }
        if(region.getShortName() == null) {
            log.warn("У объекта не задано сокращённое имя");
            throw new ValidatorException("Необходимо задать сокращённое название");
        }
        return true;
    }
}
