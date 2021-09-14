package com.example.serviceImpl;

import com.example.dto.ShelveDTO;
import com.example.entity.Shelve;
import com.example.repository.ShelveRepository;
import com.example.service.ShelveService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShelveServiceImpl implements ShelveService {

    @Autowired
    private ShelveRepository shelveRepository;

    public Shelve toEntity(ShelveDTO shelveDTO) {
        Shelve shelve = new Shelve();
        BeanUtils.copyProperties(shelveDTO, shelve);

        return shelve;
    }

    public ShelveDTO toDTO(Shelve shelve) {
        ShelveDTO shelveDTO = new ShelveDTO();
        BeanUtils.copyProperties(shelve, shelveDTO);

        return shelveDTO;
    }


    @Override
    public List<ShelveDTO> findAll() {
        List<Shelve> shelveList = this.shelveRepository.findAll();
        List<ShelveDTO> shelveDTOList = new ArrayList<>();

        for (Shelve shelve : shelveList) {
            shelveDTOList.add(this.toDTO(shelve));
        }
        return shelveDTOList;
    }


    @Override
    public Shelve getById(Long id_shelve) {
        Optional<Shelve> result = shelveRepository.findById(id_shelve);
        Shelve theShelve = null;

        if (result.isPresent()) {
            theShelve = result.get();
        } else {
            throw new RuntimeException("Did not find warehouse id - " + id_shelve);
        }
        return theShelve;
    }

    @Override
    public Optional<Shelve> findByDescription(String description){
        Optional<Shelve> result = Optional.ofNullable(shelveRepository.findByDescription(description));
        return result;
    }

    @Override
    public void create(ShelveDTO shelveDTO) {
        if (shelveDTO != null && shelveDTO.getId_shelve() == null) {
            this.shelveRepository.save(this.toEntity(shelveDTO));
        }
    }

    @Override
    public void update(ShelveDTO shelveDTO) {
        if (shelveDTO != null && shelveDTO.getId_shelve() != null) {
            this.shelveRepository.save(this.toEntity(shelveDTO));
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            this.shelveRepository.deleteById(id);
        }
    }
}
