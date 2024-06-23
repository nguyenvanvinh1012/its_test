package test.example.its_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.example.its_test.dto.SystemDto;
import test.example.its_test.entity.SystemEntity;
import test.example.its_test.exception.DataValidationException;
import test.example.its_test.exception.ResourceNotFoundException;
import test.example.its_test.repository.SystemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemService {
    @Autowired
    SystemRepository systemRepository;

    //check valid system id, if system id is not exist -> throw exception else return system entity with that id
    public SystemEntity checkValidSystemId(Long id){
        return systemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("System is not exist with id: "+ id));
    }

    public List<SystemDto> getAllSystems(){
        List<SystemEntity> systems = systemRepository.findAll();
        return systems.stream().map(SystemDto::new).collect(Collectors.toList());
    }

    public SystemDto getSystemById(Long id){
        return new SystemDto(checkValidSystemId(id));
    }

    public SystemDto createSystem(SystemDto systemDto){
        if(systemDto.getSystemName() == null || systemDto.getSystemName().isEmpty()) throw new DataValidationException("System name must not be empty");
        SystemEntity system = new SystemEntity();
        system.setSystemName(systemDto.getSystemName());
        systemRepository.save(system);
        return new SystemDto(system);
    }

    public SystemDto updateSystemById(Long id, SystemDto systemDto){
        SystemEntity system = checkValidSystemId(id);
        if(systemDto.getSystemName() == null || systemDto.getSystemName().isEmpty()) throw new DataValidationException("System name must not be empty");
        system.setSystemName(systemDto.getSystemName());
        return new SystemDto(systemRepository.save(system));
    }

    public void deleteSystemById(Long id){
        checkValidSystemId(id);
        systemRepository.deleteById(id);
    }
}
