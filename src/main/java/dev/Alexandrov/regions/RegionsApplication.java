package dev.Alexandrov.regions;

import dev.Alexandrov.regions.models.Region;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Region.class)
@MapperScan("dev.Alexandrov.regions.mappers")
@SpringBootApplication
public class RegionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionsApplication.class, args);
	}

}
