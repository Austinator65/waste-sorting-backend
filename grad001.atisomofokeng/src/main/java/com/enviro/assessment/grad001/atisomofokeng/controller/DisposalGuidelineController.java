package com.enviro.assessment.grad001.atisomofokeng.controller;

import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.DisposalGuidelineRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.DisposalGuidelineResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.service.DisposalGuidelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing disposal guidelines. This controller allows CRUD operations on disposal guidelines.
 */
@Tag(name = "Disposal Guidelines", description = "APIs for managing disposal guidelines")
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

  private final DisposalGuidelineService disposalGuidelineService;

  public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
    this.disposalGuidelineService = disposalGuidelineService;
  }

  /**
   * Retrieves all disposal guidelines.
   * @return ServiceResponse containing a list of all disposal guidelines.
   */
  @Operation(summary = "Get all disposal guidelines")
  @GetMapping
  public ResponseEntity<ServiceResponse<List<DisposalGuidelineResponse>>> getAllDisposalGuidelines() {

    ServiceResponse<List<DisposalGuidelineResponse>> serviceResponse = disposalGuidelineService.getAllDisposalGuidelines();
    return  ResponseEntity
            .created(serviceResponse.getLocation())
            .body(serviceResponse);  }

  /**
   * Fetches disposal guideline by a given category ID.
   * @param categoryId The ID of the waste category for which disposal guidelines are needed.
   * @return ServiceResponse containing a list of disposal guidelines for the specified category.
   */
  @Operation(summary = "Get disposal guidelines by category ID")
  @GetMapping("/category/{categoryId}")
  public ResponseEntity<ServiceResponse<List<DisposalGuidelineResponse>>> getRecyclingTipsByCategory(
          @Parameter(description = "ID of the waste category") @PathVariable Long categoryId) {

    ServiceResponse<List<DisposalGuidelineResponse>> serviceResponse = disposalGuidelineService.getDisposalGuidelinesByCategory(categoryId);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Retrieves a specific disposal guideline by its ID.
   * @param id The ID of the disposal guideline.
   * @return ServiceResponse containing the disposal guideline details.
   */
  @Operation(summary = "Get disposal guideline by ID")
  @GetMapping("/{id}")
  public ResponseEntity<ServiceResponse<DisposalGuidelineResponse>> getDisposalGuidelineById(
          @Parameter(description = "ID of the disposal guideline") @PathVariable Long id) {

    ServiceResponse<DisposalGuidelineResponse> serviceResponse = disposalGuidelineService.getDisposalGuidelineById(id);
    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Creates a new disposal guideline.
   * @param request The details of the new disposal guideline.
   * @return ServiceResponse containing the created disposal guideline and its URI.
   */
  @Operation(summary = "Create a new disposal guideline")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ServiceResponse<DisposalGuidelineResponse>> createDisposalGuideline(
          @RequestBody @Valid DisposalGuidelineRequest request) {

    ServiceResponse<DisposalGuidelineResponse> serviceResponse = disposalGuidelineService.createDisposalGuideline(request);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Updates an existing disposal guideline.
   * @param id The ID of the disposal guideline to be updated.
   * @param request The new details to update the disposal guideline with.
   * @return ServiceResponse containing the updated disposal guideline.
   */
  @Operation(summary = "Update an existing disposal guideline")
  @PutMapping("/{id}")
  public ResponseEntity<ServiceResponse<DisposalGuidelineResponse>> updateDisposalGuideline(
          @Parameter(description = "ID of the disposal guideline to be updated") @PathVariable Long id,
          @RequestBody @Valid DisposalGuidelineRequest request) {

    ServiceResponse<DisposalGuidelineResponse> serviceResponse = disposalGuidelineService.updateDisposalGuideline(id, request);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Deletes a disposal guideline by its ID.
   * @param id The ID of the disposal guideline to be deleted.
   * @return String message indicating successful deletion.
   */
  @Operation(summary = "Delete a disposal guideline by ID")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteDisposalGuideline(
          @Parameter(description = "ID of the disposal guideline to be deleted") @PathVariable Long id) {

    String response = disposalGuidelineService.deleteDisposalGuideline(id);

    return ResponseEntity
            .ok()
            .body(response);
  }
}
