package com.enviro.assessment.grad001.atisomofokeng.controller;

import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.WasteCategoryRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.WasteCategoryResponse;
import com.enviro.assessment.grad001.atisomofokeng.service.WasteCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing waste categories. This controller allows for the creation, retrieval,
 * updating, and deletion of waste categories.
 */
@Tag(name = "Waste Categories", description = "APIs for managing waste categories")
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

  private final WasteCategoryService wasteCategoryService;

  public WasteCategoryController(WasteCategoryService wasteCategoryService) {
    this.wasteCategoryService = wasteCategoryService;
  }

  /**
   * Retrieves all waste categories.
   *
   * @return ServiceResponse containing a list of all waste categories.
   */
  @Operation(summary = "Get all waste categories")
  @GetMapping
  public ResponseEntity<ServiceResponse<List<WasteCategoryResponse>>> getAllWasteCategories() {
    // Fetch the response from the service
    ServiceResponse<List<WasteCategoryResponse>> serviceResponse = wasteCategoryService.getAllWasteCategories();

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Fetches a specific waste category by its ID.
   *
   * @param id The ID of the waste category.
   * @return ServiceResponse containing the waste category details.
   */
  @Operation(summary = "Get waste category by ID")
  @GetMapping("/{id}")
  public ResponseEntity<ServiceResponse<WasteCategoryResponse>> getWasteCategoryById(
          @Parameter(description = "ID of the waste category") @PathVariable Long id)
  {

    ServiceResponse<WasteCategoryResponse> serviceResponse = wasteCategoryService.getWasteCategoryById(id);

// Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Creates a new waste category.
   * @param request The details of the new waste category to be created.
   * @return ServiceResponse containing the created waste category and its URI.
   */
  @Operation(summary = "Create a new waste category")
  @PostMapping
  public ResponseEntity<ServiceResponse<WasteCategoryResponse>> createWasteCategory(
          @RequestBody @Valid WasteCategoryRequest request) {

    ServiceResponse<WasteCategoryResponse> response = wasteCategoryService.createWasteCategory(request);
    return ResponseEntity
            .created(response.getLocation())
            .body(response);
  }

  /**
   * Updates an existing waste category.
   *
   * @param id      The ID of the waste category to be updated.
   * @param request The new details to update the waste category with.
   * @return ServiceResponse containing the updated waste category.
   */
  @Operation(summary = "Update an existing waste category")
  @PutMapping("/{id}")
  public ResponseEntity<ServiceResponse<WasteCategoryResponse>> updateWasteCategory(
          @Parameter(description = "ID of the waste category to be updated") @PathVariable Long id,
          @RequestBody @Valid WasteCategoryRequest request)
  {

    ServiceResponse<WasteCategoryResponse> serviceResponse = wasteCategoryService.updateWasteCategory(id, request);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Deletes a waste category by its ID.
   * @param id The ID of the waste category to be deleted.
   * @return String message indicating successful deletion.
   */
  @Operation(summary = "Delete a waste category by ID")
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteWasteCategory(
          @Parameter(description = "ID of the waste category to be deleted") @PathVariable Long id) {

    String response = wasteCategoryService.deleteWasteCategory(id);

    return ResponseEntity
            .ok()
            .body(response);
  }
}
