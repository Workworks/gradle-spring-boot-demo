package org.kfaino.core.exception.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

class ApiError {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private List<String> details;
    

    ApiError(LocalDateTime timestamp, HttpStatus status, String message, List<String> details) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}