package dev.Alexandrov.regions.services;

import dev.Alexandrov.regions.models.Region;

import java.util.List;

public interface RegionService {
    //добавление региона в базу данных
    public Long createRegion(Region region);
    //получение региона по его номеру
    public Region getRegion(Long regId);
    //получения списка всех регионов
    public List<Region> getAllRegions();
    //обновление региона
    public Region updateRegion(Region region);
    //удаление региона по id
    public boolean deleteRegion(Long regId);
}
