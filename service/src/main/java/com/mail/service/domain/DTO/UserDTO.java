package com.mail.service.domain.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@NotBlank String nome,@NotBlank @Email String email) {
}
