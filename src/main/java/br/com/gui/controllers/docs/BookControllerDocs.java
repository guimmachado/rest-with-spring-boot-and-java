package br.com.gui.controllers.docs;

import br.com.gui.dto.v1.BookDTO;
import br.com.gui.dto.v1.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookControllerDocs {
    @Operation(summary = "Find all books", description = "Finds all books", tags = {"Book"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))}), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    List<BookDTO> findAll();

    @Operation(summary = "Find book by id", description = "Finds book by id", tags = {"Book"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    BookDTO findById(@PathVariable("id") Long id);

    @Operation(summary = "Add a new book.", description = "Add a new book by passing in a JSON or XML representation.", tags = {"Book"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    BookDTO create(@RequestBody BookDTO book);

    @Operation(summary = "Update a book", description = "Update a book by passing in the updated JSON or XML.", tags = {"Book"}, responses = {@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = PersonDTO.class))), @ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    BookDTO update(@RequestBody BookDTO book);

    @Operation(summary = "Delete a book", description = "Delete a book by passing their id.", tags = {"Book"}, responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content), @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content), @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content), @ApiResponse(description = "Not Found", responseCode = "404", content = @Content), @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)})
    ResponseEntity<?> delete(@PathVariable("id") Long id);
}
