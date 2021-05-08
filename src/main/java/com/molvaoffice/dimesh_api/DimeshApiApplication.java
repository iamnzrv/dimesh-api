package com.molvaoffice.dimesh_api;

import com.molvaoffice.dimesh_api.db_layer.IndianNameRepository;
import com.molvaoffice.dimesh_api.domain.entity.IndianNameEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DimeshApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DimeshApiApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(IndianNameRepository indianNameRepository) throws IOException {
//        return args -> {
//            Path path = Paths.get("/home/iamnzrv/Code/dimesh_api/src/main/resources/names.txt");
//            Files.lines(path).forEach(line -> {
//                if (!line.isEmpty()) {
//                    String[] splitLine = line.split(" – ");
//                    indianNameRepository.save(new IndianNameEntity(splitLine[0], splitLine[1]));
//                }
//            });
//        };
//    }
}
