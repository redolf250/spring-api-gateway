package com.redolf.gateway.utils;

import com.redolf.gateway.dto.ApiKey;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.redolf.gateway.utils.AppConstant.*;

public class HelperMethods {
    public List<ApiKey> getKeys() {
        List<String> studentServiceKey = List.of(STUDENT_SERVICE_KEY,PAYMENT_SERVICE_KEY);
        List<String> studentServiceKey2 = List.of(PAYMENT_SERVICE_KEY);
        ApiKey apiKey = new ApiKey("4837-8C4B",studentServiceKey);
        ApiKey apiKey1 = new ApiKey("4E54-8F0C",studentServiceKey2);
        return Stream
            .of(apiKey,apiKey1)
            .toList();
    }
    public ApiKey getApiKey(String id){
        return getKeys()
                .stream()
                .filter(key -> Objects.equals(key.getKey(), id)).toList().get(0);
    }
}
