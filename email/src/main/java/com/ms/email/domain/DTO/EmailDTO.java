package com.ms.email.domain.DTO;

import java.util.UUID;

public record EmailDTO(UUID id, String emailTo, String subject, String text) {
}
