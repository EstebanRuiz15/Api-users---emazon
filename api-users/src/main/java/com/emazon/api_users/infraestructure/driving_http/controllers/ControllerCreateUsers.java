package com.emazon.api_users.infraestructure.driving_http.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emazon.api_users.domain.interfaces.IUserService;
import com.emazon.api_users.infraestructure.driving_http.dtos.UserDtoAdd;
import com.emazon.api_users.infraestructure.driving_http.mappers.UserMapperDtoUser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/aux")
@Service 
@AllArgsConstructor
public class ControllerCreateUsers {
    private final IUserService userService;
    private final UserMapperDtoUser mappertoUser;

       @Operation(summary = "Method for created a warehouse assistent", 
    description = "This method is for creater a user with rol warehouse assistante (AUX_BODEGA)\n\n" + //
                "rules:\n\n"+//
                "       - encrypted password.\n\n" + //
                "       - Valid email structure must be verified.\n\n" + //
                "       - The phone number must contain a maximum of 13 characters and may contain the + symbol\n\n."+
                "       - The user will have the role aux_bodega\n\n"+
                "       - The user must be of legal age."
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "ok"),
        @ApiResponse(responseCode = "400", description = "     - `name`: Cannot be null.\n\n" +
                                                          "    - `Last name`: cannot be null.\n\n" +
                                                          "    - `cel phone`:Cannot be null .\n\n"+
                                                          "    - 'Identity': Cannot be null and only numbers.\n\n"+
                                                          "    - 'birth date': cannot be null or invalid date.\n\n"+
                                                          "    - 'email': cannot by null and valid email structure.\n\n"+
                                                          "    - 'Password': cannot be null and check eith some parameters.\n\n"+
                                                          "    - 'rol': only with 'AUX_BODEGA' rol.\n\n"),
        @ApiResponse(responseCode = "403", description = " forbiden\n\n" +
                                                          "    - `only admin have acces to this method'\n\n")
                                                        
})
    @PostMapping("/")
     public ResponseEntity<Void> addAuxBod(@Valid @RequestBody  UserDtoAdd request) {
        userService.createUserClient(mappertoUser.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
}
