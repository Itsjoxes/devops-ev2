package com.citt.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;

    // Explicit constructor to avoid Lombok dependency during compilation
    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
