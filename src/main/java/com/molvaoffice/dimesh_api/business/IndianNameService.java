package com.molvaoffice.dimesh_api.business;

import com.molvaoffice.dimesh_api.db_layer.IndianNameRepository;
import com.molvaoffice.dimesh_api.domain.dto.IndianNameDTO;
import com.molvaoffice.dimesh_api.domain.entity.IndianNameEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndianNameService {

    private final ModelMapper modelMapper;
    private final IndianNameRepository indianNameRepository;

    public IndianNameService(IndianNameRepository indianNameRepository) {
        this.modelMapper = new ModelMapper();
        this.indianNameRepository = indianNameRepository;
    }

    public List<IndianNameDTO> getAllIndianNames() {
        return ((List<IndianNameEntity>) indianNameRepository
                .findAll())
                .stream()
                .map(this::convertIndianNameEntityToIndianNameDTO)
                .collect(Collectors.toList());
    }

    private IndianNameDTO convertIndianNameEntityToIndianNameDTO(IndianNameEntity indianNameEntity) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper
                .map(indianNameEntity, IndianNameDTO.class);
    }
}
