package com.decathlon.nps.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7176390653391227433L;

    public ResourceNotFound(String message) {
        super(message);
    }
}
