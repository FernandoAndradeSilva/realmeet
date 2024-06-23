package br.com.fernando.realmeet.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class  ResponseEntityUtils {

    private ResponseEntityUtils() {}

    public static <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }

}
