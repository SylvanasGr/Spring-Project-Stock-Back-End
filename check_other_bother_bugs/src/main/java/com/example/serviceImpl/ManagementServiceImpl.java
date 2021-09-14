package com.example.serviceImpl;

import com.example.dto.ManagementDTO;
import com.example.dto.StockRecoveryDTO;
import com.example.entity.Management;
import com.example.repository.ManagementRepository;
import com.example.service.ManagementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ManagementServiceImpl implements ManagementService {


    @Autowired
    private ManagementRepository managementRepository;

    public Management toEntity(ManagementDTO managementDTO) {
        Management management = new Management();
        BeanUtils.copyProperties(managementDTO, management);

        return management;
    }
    public ManagementDTO toDTO(Management management){
        ManagementDTO managementDTO = new ManagementDTO();
        BeanUtils.copyProperties(management,managementDTO);

        return managementDTO;
    }

    public List<ManagementDTO> findAll(){
        List<Management> managementList = this.managementRepository.findAll();
        List<ManagementDTO> managementDTOList = new ArrayList<>();

        for (Management management : managementList){
            managementDTOList.add(this.toDTO(management));
        }
        return managementDTOList;
    }


    @Override
    public Management getById(Long id_action) {
        Optional<Management> result = managementRepository.findById(id_action);
        Management management = null;

        if (result.isPresent()) {
            management = result.get();
        } else {
            throw new RuntimeException("Did not find warehouse id - " + id_action);
        }
        return management;
    }

    @Override
    public List<Management> findByDescription(String description){
        Optional<Management> result = Optional.ofNullable(managementRepository.findByDescription(description));
        List<Management> list = new ArrayList(Arrays.asList(result));
        return list;
    }

    @Override
    public List<StockRecoveryDTO> findImports(){
        List<StockRecoveryDTO> stockRecoveryDTOList = this.managementRepository.findImports();
        return stockRecoveryDTOList;
    }

    @Override
    public List<StockRecoveryDTO> findExports(){
        List<StockRecoveryDTO> stockRecoveryDTOList = this.managementRepository.findExports();
        return stockRecoveryDTOList;
    }




    @Override
    public void create(ManagementDTO managementDTO) {
        if (managementDTO != null && managementDTO.getId_action() == null) {
            this.managementRepository.save(this.toEntity(managementDTO));
        }

    }

    @Override
    public void update(ManagementDTO managementDTO) {
        if (managementDTO != null && managementDTO.getId_action()!= null) {
            this.managementRepository.save(this.toEntity(managementDTO));
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            this.managementRepository.deleteById(id);
        }
    }
}
