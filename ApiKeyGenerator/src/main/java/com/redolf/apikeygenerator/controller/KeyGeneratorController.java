package com.redolf.apikeygenerator.controller;

import com.redolf.apikeygenerator.dto.ApiKeySpecRequest;
import com.redolf.apikeygenerator.dto.ApiKeySpecResponse;
import com.redolf.apikeygenerator.service.KeyGeneratorService;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/key-service")
public class KeyGeneratorController {

    private final KeyGeneratorService generatorService;
    public KeyGeneratorController(KeyGeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @SneakyThrows
    @PostMapping("/generate-key")
    private ResponseEntity<?> generateKey (@RequestBody ApiKeySpecRequest keySpec) {
        ApiKeySpecResponse response = generatorService.generateKey(keySpec);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/api-keys/{username}")
    private ResponseEntity<?> getAllApiKeySpecsByUsername(@PathVariable String username){
        List<ApiKeySpecResponse> apiKeys = generatorService.getAllApiKeySpecByUsername(username);
        return new ResponseEntity<>(apiKeys,HttpStatus.OK);
    }
}
