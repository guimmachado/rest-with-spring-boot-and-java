package br.com.gui.controllers.docs;

import br.com.gui.dto.v1.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PersonControllerDocs {
    @Operation(summary = "Find all people", description = "Finds all people", tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))}), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    List<PersonDTO> findAll();

    @Operation(summary = "Find person by id", description = "Finds person by id", tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    PersonDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Add a new person.", description = "Add a new person by passing in a JSON or XML representation.", tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    PersonDTO create(@RequestBody PersonDTO person);

    @Operation(summary = "Update a person", description = "Update a person by passing in the updated JSON or XML.", tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    PersonDTO update(@RequestBody PersonDTO person);

    @Operation(summary = "Disable person by id", description = "Disable person by id", tags = {"People"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    PersonDTO disablePerson(@PathVariable("id") Long id);

    @Operation(summary = "Delete a person", description = "Delete a person by passing their id.", tags = {"People"}, responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    ResponseEntity<?> delete(@PathVariable("id") Long id);
}
