package com.enviro.assessment.grad001.atisomofokeng.service;

import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.RecyclingTipRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.RecyclingTipResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;

import java.util.List;

/**
 * Service interface for managing Recycling Tips.
 * Provides methods to perform CRUD operations on recycling tips,
 * including retrieval by category and ID.
 */
public interface RecyclingTipService {

  /**
   * Retrieves a list of all recycling tips.
   *
   * @return a ServiceResponse containing a list of RecyclingTipResponse objects,
   *         or an appropriate error message if the operation fails.
   */
  ServiceResponse<List<RecyclingTipResponse>> getAllRecyclingTips();

  /**
   * Retrieves a list of recycling tips associated with a specific waste category.
   *
   * @param categoryId the ID of the waste category to filter tips by.
   * @return a ServiceResponse containing a list of RecyclingTipResponse objects
   *         matching the specified category, or an appropriate error message.
   */
  ServiceResponse<List<RecyclingTipResponse>> getRecyclingTipsByCategory(Long categoryId);

  /**
   * Retrieves a specific recycling tip by its unique identifier.
   *
   * @param id the ID of the recycling tip to retrieve.
   * @return a ServiceResponse containing the RecyclingTipResponse object if found,
   *         or an appropriate error message if the tip is not found.
   */
  ServiceResponse<RecyclingTipResponse> getRecyclingTipById(Long id);

  /**
   * Creates a new recycling tip based on the provided request data.
   *
   * @param request the RecyclingTipRequest object containing the necessary data
   *                for creating a new recycling tip.
   * @return a ServiceResponse containing the created RecyclingTipResponse object,
   *         or an appropriate error message if creation fails.
   */
  ServiceResponse<RecyclingTipResponse> createRecyclingTip(RecyclingTipRequest request);

  /**
   * Updates an existing recycling tip identified by its ID with the new data provided.
   *
   * @param id      the ID of the recycling tip to update.
   * @param request the RecyclingTipRequest object containing the updated data.
   * @return a ServiceResponse containing the updated RecyclingTipResponse object,
   *         or an appropriate error message if the update fails.
   */
  ServiceResponse<RecyclingTipResponse> updateRecyclingTip(Long id, RecyclingTipRequest request);

  /**
   * Deletes a specific recycling tip identified by its unique identifier.
   *
   * @param id the ID of the recycling tip to delete.
   * @return a message indicating the success or failure of the delete operation.
   */
  String deleteRecyclingTip(Long id);
}
