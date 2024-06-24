package test.example.its_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.example.its_test.dto.SystemDto;
import test.example.its_test.service.SystemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/systems")
public class SystemController {
    @Autowired
    private SystemService systemService;

    @GetMapping()
    public List<SystemDto> getAllSystem(){
        return systemService.getAllSystems();
    }

    @GetMapping("/{systemId}")
    public SystemDto getSystemById(@PathVariable("systemId") Long systemId){
        return systemService.getSystemById(systemId);
    }

    @PostMapping()
    public SystemDto createSystem(@RequestBody SystemDto systemDto){
        return systemService.createSystem(systemDto);
    }

    @PutMapping("/{systemId}")
    public SystemDto updateSystemById(@PathVariable("systemId") Long systemId, @RequestBody SystemDto systemDto){
        return systemService.updateSystemById(systemId, systemDto);
    }

    @DeleteMapping("/{systemId}")
    public ResponseEntity<String> deleteSystemById(@PathVariable("systemId") Long systemID){
        systemService.deleteSystemById(systemID);
        return ResponseEntity.ok("system deleted successfully!");
    }
}
