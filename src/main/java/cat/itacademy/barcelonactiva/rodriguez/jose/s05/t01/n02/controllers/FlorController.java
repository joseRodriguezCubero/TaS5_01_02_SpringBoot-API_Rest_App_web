package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.entity.Flor;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n02.model.services.FlorServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Flower", description = "Flower management APIs")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

public class FlorController {

    private final FlorServices florServices;

    @Operation(
            summary = "Get All Flowers",
            description = "Get all Flower objects. The response is a list of all objects with id, name, country and the type of Euro or Not Euro country",
            tags = { "flowers", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Flor.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(path = "/flor/getAll")
    public ResponseEntity<List<FlorDTO>> getAllFlowers() {
        return ResponseEntity.ok().body(florServices.getAllFlowers());
    }

    @Operation(
            summary = "Retrieve a Flower by Id",
            description = "Get a Flower object by specifying its id. The response is Flower object with id, title, description and published status.",
            tags = { "flowers", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Flor.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "The Flower with given Id was not found.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "409", description = "Flor ID cannot be null.", content = { @Content(schema = @Schema()) })
    })
    @GetMapping(path = "/flor/getOne/{id}")
    public ResponseEntity<FlorDTO> getFlowerById(@PathVariable Long id) {
        return ResponseEntity.ok().body(florServices.getFlorById(id));
    }


    @Operation(
            summary = "Create a Flower",
            description = "Create a Flower object. The response is a httpStatus showing the result of the operation.",
            tags = { "flowers", "post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = Flor.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "409", description = "Flor ID cannot be null.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping(path = "/flor/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlorDTO> save(@RequestBody FlorDTO florDTO){
        FlorDTO newFlor = florServices.createFlor(florDTO);
        return new ResponseEntity<>(newFlor, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update a Flower by Id",
            description = "Update a Flower object by specifying its id. The response is a httpStatus showing the result of the operation.",
            tags = { "flowers", "put" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Flor.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "The Flower with given Id was not found.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "409", description = "Flor ID cannot be null.", content = { @Content(schema = @Schema()) })
    })
    @PutMapping(path = "/flor/update/{id}")
    public ResponseEntity<FlorDTO> updateFlor(@PathVariable(value = "id") Long id,
                                                     @RequestBody FlorDTO florDTO) {
        return ResponseEntity.ok().body(florServices.updateFlor(florDTO,id));
    }

    @Operation(
            summary = "Delete a Flower by Id",
            description = "Delete a Flower object by specifying its id. The response is a httpStatus showing the result of the operation.",
            tags = { "flowers", "delete" })
    @ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "The Flower with given Id was not found.", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(value = "/flor/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable Long id) {
        florServices.deleteFlorById(id);
        return new ResponseEntity<>(("Flower deleted successfully- Flower ID:" + id), HttpStatus.OK);
    }
}