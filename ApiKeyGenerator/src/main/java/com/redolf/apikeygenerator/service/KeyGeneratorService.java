package com.redolf.apikeygenerator.service;

import com.redolf.apikeygenerator.dto.ApiKeySpecRequest;
import com.redolf.apikeygenerator.dto.ApiKeySpecResponse;
import com.redolf.apikeygenerator.model.ApiKeySpec;
import com.redolf.apikeygenerator.repository.ApiKeySpecRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import static com.redolf.apikeygenerator.utils.KeyGenerator.*;

@Service
public class KeyGeneratorService {
    private final ApiKeySpecRepository specRepository;
    public KeyGeneratorService(ApiKeySpecRepository specRepository) {
        this.specRepository = specRepository;
    }

    @SneakyThrows
    public ApiKeySpecResponse generateKey(ApiKeySpecRequest keySpec) {
        try{
            ApiKeySpecResponse response = mapRequestToResponse(keySpec);
            ApiKeySpec apiKeySpec = mapRequestToEntity(keySpec, response.getApiKey());
            specRepository.save(apiKeySpec);
            return response;
        }catch(Exception e){
            throw  new RuntimeException("Oops! something went wrong try again later!!!");
        }

    }
    public List<ApiKeySpecResponse> getAllApiKeySpecByUsername(String username){
        return specRepository
                .findApiKeySpecByUsername(username)
                .stream().map(this::mapEntityToResponse)
                .toList();
    }
    @SneakyThrows
    private ApiKeySpecResponse mapRequestToResponse(ApiKeySpecRequest keySpec){
        return ApiKeySpecResponse.builder()
                .apiKey(generateApiKey(keySpec.getUsername()))
                .description(keySpec.getDescription())
                .validity(Period.ofDays(keySpec.getValidity()))
                .expiresOn(LocalDateTime.now().plusDays(keySpec.getValidity()))
                .build();
    }

    private ApiKeySpec mapRequestToEntity(ApiKeySpecRequest keySpec, String generatedKey){
        return ApiKeySpec.builder()
                .username(keySpec.getUsername())
                .apiKey(generatedKey)
                .validity(Period.ofDays(keySpec.getValidity()))
                .description(keySpec.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }

    private ApiKeySpecResponse mapEntityToResponse(ApiKeySpec keySpec){
        return ApiKeySpecResponse.builder()
                .apiKey(keySpec.getApiKey())
                .validity(keySpec.getValidity())
                .description(keySpec.getDescription())
                .createdAt(keySpec.getCreatedAt())
                .expiresOn(keySpec.getCreatedAt().plusDays(keySpec.getValidity().getDays()))
                .build();
    }
}
