package com.enviro.assessment.grad001.atisomofokeng.service;

import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.DisposalGuidelineRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.DisposalGuidelineResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;

import java.util.List;

/**
 * Service interface for managing Disposal Guidelines.
 * Provides methods to perform CRUD operations and fetch disposal guidelines by category.
 */
public interface DisposalGuidelineService {

  /**
   * Creates a new disposal guideline based on the provided request data.
   *
   * @param disposalGuidelineRequest the DisposalGuidelineRequest object containing the necessary data
   *                                 to create a new disposal guideline.
   * @return a ServiceResponse containing the created DisposalGuidelineResponse object,
   *         or an appropriate error message if creation fails.
   */
  ServiceResponse<DisposalGuidelineResponse> createDisposalGuideline(DisposalGuidelineRequest disposalGuidelineRequest);

  /**
   * Retrieves a list of all disposal guidelines.
   *
   * @return a ServiceResponse containing a list of DisposalGuidelineResponse objects,
   *         or an appropriate error message if the operation fails.
   */
  ServiceResponse<List<DisposalGuidelineResponse>> getAllDisposalGuidelines();

  /**
   * Retrieves a list of disposal guidelines associated with a specific waste category.
   *
   * @param categoryId the ID of the waste category for which disposal guidelines are to be fetched.
   * @return a ServiceResponse containing a list of DisposalGuidelineResponse objects,
   *         or an appropriate error message if no guidelines are found for the given category.
   */
  ServiceResponse<List<DisposalGuidelineResponse>> getDisposalGuidelinesByCategory(Long categoryId);

  /**
   * Retrieves a specific disposal guideline by its unique identifier.
   *
   * @param id the ID of the disposal guideline to retrieve.
   * @return a ServiceResponse containing the DisposalGuidelineResponse object if found,
   *         or an appropriate error message if the guideline is not found.
   */
  ServiceResponse<DisposalGuidelineResponse> getDisposalGuidelineById(Long id);

  /**
   * Updates an existing disposal guideline identified by its ID with new data.
   *
   * @param id                      the ID of the disposal guideline to update.
   * @param disposalGuidelineRequest the DisposalGuidelineRequest object containing updated data.
   * @return a ServiceResponse containing the updated DisposalGuidelineResponse object,
   *         or an appropriate error message if the update fails.
   */
  ServiceResponse<DisposalGuidelineResponse> updateDisposalGuideline(Long id, DisposalGuidelineRequest disposalGuidelineRequest);

  /**
   * Deletes a specific disposal guideline identified by its unique identifier.
   *
   * @param id the ID of the disposal guideline to delete.
   * @return a message indicating the success or failure of the delete operation.
   */
  String deleteDisposalGuideline(Long id);
}
