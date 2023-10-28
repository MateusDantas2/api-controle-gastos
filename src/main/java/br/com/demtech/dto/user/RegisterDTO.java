package br.com.demtech.dto.user;

import br.com.demtech.domain.model.UserRole;

/**
 *
 * @author Mateus Dantas
 */
public record RegisterDTO(String name, String email, String password, UserRole role) {}
