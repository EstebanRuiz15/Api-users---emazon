package com.emazon.api_users.infraestructure.driving_http.dtos;

import java.time.LocalDate;

import com.emazon.api_users.domain.model.RoleEnum;
import com.emazon.api_users.infraestructure.util.ConstantsInfra;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Valid
public class UserDtoAdd {
    @Null
    private final  Long id;
    @NotBlank(message = ConstantsInfra.ERROR_NAME_NULL)
    private final String name;

    @NotBlank(message = ConstantsInfra.ERROR_LAST_NAME)
    private final String lastName;

    @NotBlank(message = ConstantsInfra.ERROR_DOCUMENT_ID)
    @Pattern(regexp = ConstantsInfra.REGEX_Document,message = ConstantsInfra.ERROR_DOCUMENT)
    private final String idDocument;

    @NotBlank(message = ConstantsInfra.ERROR_CEL_NULL)
    @Pattern(regexp =ConstantsInfra.REGEX_CEL,message = ConstantsInfra.ERROR_CEL_INVALID)
    @Size(min=10, max=13,message = ConstantsInfra.ERROR_CEL)
    private final String celular;

    @Past(message = ConstantsInfra.ERROR_DATE_INVALID)
    private final LocalDate dateOfBirth;

    @NotBlank(message = ConstantsInfra.ERROR_EMAIL_NULL)
    @Email(message = ConstantsInfra.ERROR_EMAIL_INCORRECT)
    private final String email;

    @NotBlank(message = ConstantsInfra.ERROR_PASSWORD_NULL)
    @Pattern(regexp = ConstantsInfra.PASS_REGEX,message = ConstantsInfra.ERROR_PASSWORD_INCORRECT)
    private final String password;

    @Null
    private final RoleEnum role;
}
