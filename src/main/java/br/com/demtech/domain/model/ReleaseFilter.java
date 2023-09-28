package br.com.demtech.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 *
 * @author Mateus Dantas
 */
@Data
public class ReleaseFilter {
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDateFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDateTo;
}
