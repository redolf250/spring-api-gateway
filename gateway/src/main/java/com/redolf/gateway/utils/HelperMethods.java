package com.redolf.gateway.utils;

import com.redolf.gateway.dto.ApiKey;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static com.redolf.gateway.utils.AppConstant.*;

@UtilityClass
public class HelperMethods {
    public List<ApiKey> getKeys() {
        return Stream
            .of(
                    new ApiKey("4837-8C4B",List.of(STUDENT_SERVICE_KEY)),
                    new ApiKey("4E54-8F0C",List.of(STUDENT_SERVICE_KEY,PAYMENT_SERVICE_KEY)))
            .toList();
    }
    public ApiKey getApiKey(String id){
        return (ApiKey) getKeys()
                .stream()
                .filter(key -> Objects.equals(key.getKey(), id));
    }
}
