package com.enviro.assessment.grad001.atisomofokeng.service;

import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.WasteCategoryRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.WasteCategoryResponse;
import java.util.List;

/**
 * Service interface for managing Waste Categories.
 * Provides methods to perform CRUD operations on waste categories.
 */
public interface WasteCategoryService {

  /**
   * Retrieves a list of all waste categories.
   *
   * @return a ServiceResponse containing a list of WasteCategoryResponse objects,
   *         or an appropriate error message if the operation fails.
   */
  ServiceResponse<List<WasteCategoryResponse>> getAllWasteCategories();

  /**
   * Retrieves a specific waste category by its unique identifier.
   *
   * @param id the ID of the waste category to retrieve.
   * @return a ServiceResponse containing the WasteCategoryResponse object if found,
   *         or an appropriate error message if the category is not found.
   */
  ServiceResponse<WasteCategoryResponse> getWasteCategoryById(Long id);

  /**
   * Creates a new waste category based on the provided request data.
   *
   * @param wasteCategoryRequest the WasteCategoryRequest object containing the necessary data
   *                             for creating a new waste category.
   * @return a ServiceResponse containing the created WasteCategoryResponse object,
   *         or an appropriate error message if creation fails.
   */
  ServiceResponse<WasteCategoryResponse> createWasteCategory(WasteCategoryRequest wasteCategoryRequest);

  /**
   * Updates an existing waste category identified by its ID with the new data provided.
   *
   * @param id      the ID of the waste category to update.
   * @param request the WasteCategoryRequest object containing the updated data.
   * @return a ServiceResponse containing the updated WasteCategoryResponse object,
   *         or an appropriate error message if the update fails.
   */
  ServiceResponse<WasteCategoryResponse> updateWasteCategory(Long id, WasteCategoryRequest request);

  /**
   * Deletes a specific waste category identified by its unique identifier.
   *
   * @param id the ID of the waste category to delete.
   * @return a message indicating the success or failure of the delete operation.
   */
  String deleteWasteCategory(Long id);
}
