package dev.Alexandrov.regions.mappers;

import dev.Alexandrov.regions.models.Region;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegionsMapper {

    @Select("SELECT * FROM regions")
    public List<Region> getAllRegions();

    @Select("SELECT * FROM regions WHERE id = #{id}")
    public Region getRegionById(Long id);

    @Insert("insert into regions values (#{id}, #{fullName}, #{shortName})")
    public int createRegion(Region region);

    @Delete("Delete FROM regions WHERE id = #{id}")
    public boolean deleteRegion(Long regId);

    @Update("update regions set id=#{id}, full_name=#{fullName}, short_name=#{shortName} where id=#{id}")
    public int updateRegion(Region emp);
}
