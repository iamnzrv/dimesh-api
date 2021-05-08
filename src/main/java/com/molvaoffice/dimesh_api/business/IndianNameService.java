package com.molvaoffice.dimesh_api.business;

import com.molvaoffice.dimesh_api.db_layer.IndianNameRepository;
import com.molvaoffice.dimesh_api.db_layer.IndianSurnameRepository;
import com.molvaoffice.dimesh_api.domain.dto.IndianNameAndSurnameDTO;
import com.molvaoffice.dimesh_api.domain.dto.IndianNameDTO;
import com.molvaoffice.dimesh_api.domain.dto.IndianSurnameDTO;
import com.molvaoffice.dimesh_api.domain.entity.IndianNameEntity;
import com.molvaoffice.dimesh_api.domain.entity.IndianSurnameEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class IndianNameService {

    private final ModelMapper modelMapper;
    private final IndianNameRepository indianNameRepository;
    private final IndianSurnameRepository indianSurnameRepository;

    public IndianNameService(IndianNameRepository indianNameRepository, IndianSurnameRepository indianSurnameRepository) {
        this.modelMapper = new ModelMapper();
        this.indianNameRepository = indianNameRepository;
        this.indianSurnameRepository = indianSurnameRepository;
    }

    public IndianNameAndSurnameDTO getRandomIndianNameAndSurname() {
        List<IndianNameDTO> indianNameDTOList = getAllIndianNames();
        List<IndianSurnameDTO> indianSurnameDTOList = getAllIndianSurnames();
        Random rand = new Random();
        IndianNameDTO randomIndianName = indianNameDTOList.get(rand.nextInt(indianNameDTOList.size()));
        IndianSurnameDTO randomIndianSurname = indianSurnameDTOList.get(rand.nextInt(indianSurnameDTOList.size()));
        return IndianNameAndSurnameDTO
                .builder()
                .indianName(randomIndianName.getIndianName())
                .indianNameMeaning(randomIndianName.getMeaning())
                .indianSurname(randomIndianSurname.getIndianSurname())
                .indianSurnameMeaning(randomIndianSurname.getMeaning())
                .build();
    }

    public List<IndianNameDTO> getAllIndianNames() {
        return ((List<IndianNameEntity>) indianNameRepository
                .findAll())
                .stream()
                .map(this::convertIndianNameEntityToIndianNameDTO)
                .collect(Collectors.toList());
    }

    public List<IndianSurnameDTO> getAllIndianSurnames() {
        return ((List<IndianSurnameEntity>) indianSurnameRepository
                .findAll())
                .stream()
                .map(this::convertIndianSurnameEntityToIndianSurnameDTO)
                .collect(Collectors.toList());
    }

    private IndianNameDTO convertIndianNameEntityToIndianNameDTO(IndianNameEntity indianNameEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(indianNameEntity, IndianNameDTO.class);
    }

    private IndianSurnameDTO convertIndianSurnameEntityToIndianSurnameDTO(IndianSurnameEntity indianSurnameEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(indianSurnameEntity, IndianSurnameDTO.class);
    }
}
