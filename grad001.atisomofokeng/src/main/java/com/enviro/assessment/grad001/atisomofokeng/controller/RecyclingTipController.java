package com.enviro.assessment.grad001.atisomofokeng.controller;

import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.RecyclingTipRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.RecyclingTipResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.service.RecyclingTipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Recycling Tips. This controller allows for the creation, retrieval,
 * updating, and deletion of recycling tips associated with different waste categories.
 */
@Tag(name = "Recycling Tips", description = "APIs for managing recycling tips")
@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

  private final RecyclingTipService recyclingTipService;

  public RecyclingTipController(RecyclingTipService recyclingTipService) {
    this.recyclingTipService = recyclingTipService;
  }

  /**
   * Fetches all recycling tips.
   * @return ServiceResponse containing a list of all recycling tips.
   */
  @Operation(summary = "Get all recycling tips")
  @GetMapping
  public ResponseEntity<ServiceResponse<List<RecyclingTipResponse>>> getAllRecyclingTips() {

    ServiceResponse<List<RecyclingTipResponse>> serviceResponse = recyclingTipService.getAllRecyclingTips();
    return  ResponseEntity
            .created(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Fetches recycling tips by a given category ID.
   *
   * @param categoryId The ID of the waste category for which recycling tips are needed.
   * @return ServiceResponse containing a list of recycling tips for the specified category.
   */
  @Operation(summary = "Get recycling tips by category ID")
  @GetMapping("/category/{categoryId}")
  @ResponseStatus(HttpStatus.FOUND)
  public ResponseEntity<ServiceResponse<List<RecyclingTipResponse>>> getRecyclingTipsByCategory(
          @Parameter(description = "ID of the waste category") @PathVariable Long categoryId)
  {
    ServiceResponse<List<RecyclingTipResponse>> serviceResponse = recyclingTipService.getRecyclingTipsByCategory(categoryId);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Fetches a specific recycling tip by its ID.
   *
   * @param id The ID of the recycling tip.
   * @return ServiceResponse containing the recycling tip.
   */
  @Operation(summary = "Get a recycling tip by its ID")
  @GetMapping("/{id}")
  public ResponseEntity<ServiceResponse<RecyclingTipResponse>> getRecyclingTipById(
          @Parameter(description = "ID of the recycling tip") @PathVariable Long id)
  {

    ServiceResponse<RecyclingTipResponse> serviceResponse = recyclingTipService.getRecyclingTipById(id);
    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Creates a new recycling tip.
   * @param request The details of the new recycling tip to be created.
   * @return ServiceResponse containing the created recycling tip along with a URI to the new resource.
   */
  @Operation(summary = "Create a new recycling tip")
  @PostMapping
  public ResponseEntity<ServiceResponse<RecyclingTipResponse>> createRecyclingTip(
          @RequestBody @Valid RecyclingTipRequest request) {
    ServiceResponse<RecyclingTipResponse> serviceResponse = recyclingTipService.createRecyclingTip(request);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Updates an existing recycling tip.
   *
   * @param id      The ID of the recycling tip to be updated.
   * @param request The new details to update the recycling tip with.
   * @return ServiceResponse containing the updated recycling tip.
   */
  @Operation(summary = "Update an existing recycling tip")
  @PutMapping("/{id}")
  public ResponseEntity<ServiceResponse<RecyclingTipResponse>> updateRecyclingTip(
          @Parameter(description = "ID of the recycling tip to be updated") @PathVariable Long id,
          @RequestBody @Valid RecyclingTipRequest request)
  {
    ServiceResponse<RecyclingTipResponse> serviceResponse = recyclingTipService.updateRecyclingTip(id, request);

    // Return 200 OK with the response body and location header
    return ResponseEntity
            .ok()
            .location(serviceResponse.getLocation())
            .body(serviceResponse);
  }

  /**
   * Deletes a recycling tip by its ID.
   * @param id The ID of the recycling tip to be deleted.
   * @return String message indicating successful deletion.
   */
  @Operation(summary = "Delete a recycling tip by its ID")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<String> deleteRecyclingTip(
          @Parameter(description = "ID of the recycling tip to be deleted") @PathVariable Long id) {

    String response = recyclingTipService.deleteRecyclingTip(id);

    return ResponseEntity
            .ok()
            .body(response);
  }
}
