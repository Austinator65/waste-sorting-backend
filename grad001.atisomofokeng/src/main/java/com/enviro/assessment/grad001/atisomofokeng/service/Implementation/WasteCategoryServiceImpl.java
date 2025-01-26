package com.enviro.assessment.grad001.atisomofokeng.service.Implementation;

import com.enviro.assessment.grad001.atisomofokeng.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.mapper.WasteCategoryMapper;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.WasteCategoryRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.WasteCategoryResponse;
import com.enviro.assessment.grad001.atisomofokeng.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.atisomofokeng.service.WasteCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing waste categories. This service handles CRUD operations for waste categories.
 */
@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

  private final WasteCategoryRepository wasteCategoryRepository;
  private final WasteCategoryMapper wasteCategoryMapper;

  public WasteCategoryServiceImpl(WasteCategoryRepository wasteCategoryRepository, WasteCategoryMapper wasteCategoryMapper) {
    this.wasteCategoryRepository = wasteCategoryRepository;
    this.wasteCategoryMapper = wasteCategoryMapper;
  }

  /**
   * Retrieves all waste categories.
   * @return ServiceResponse containing a list of all waste categories.
   */
  @Override
  public ServiceResponse<List<WasteCategoryResponse>> getAllWasteCategories() {
    List<WasteCategoryResponse> wasteCategories = wasteCategoryRepository.findAll().stream()
            .map(wasteCategoryMapper::toResponse)
            .collect(Collectors.toList());

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

    return new ServiceResponse<>(wasteCategories, location);
  }

  /**
   * Retrieves a specific waste category by its ID.
   * @param id The ID of the waste category.
   * @return ServiceResponse containing the waste category details.
   */
  @Override
  public ServiceResponse<WasteCategoryResponse> getWasteCategoryById(Long id) {
    WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().build(wasteCategory.getId());

    return new ServiceResponse<>(wasteCategoryMapper.toResponse(wasteCategory), location);
  }

  /**
   * Creates a new waste category and saves it to the repository.
   * @param request The request object containing the new waste category details.
   * @return ServiceResponse containing the created waste category and its URI.
   */
  @Override
  public ServiceResponse<WasteCategoryResponse> createWasteCategory(WasteCategoryRequest request) {
    WasteCategory wasteCategory = WasteCategoryMapper.toEntity(request);

    WasteCategory savedWasteCategory = wasteCategoryRepository.save(wasteCategory);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedWasteCategory.getId())
            .toUri();

    return new ServiceResponse<>(wasteCategoryMapper.toResponse(savedWasteCategory), location);
  }

  /**
   * Updates an existing waste category with new details.
   * @param id The ID of the waste category to be updated.
   * @param request The updated details for the waste category.
   * @return ServiceResponse containing the updated waste category details.
   */
  @Override
  public ServiceResponse<WasteCategoryResponse> updateWasteCategory(Long id, WasteCategoryRequest request) {
    WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    wasteCategory.setCategoryName(request.getCategoryName());

    WasteCategory updatedWasteCategory = wasteCategoryRepository.save(wasteCategory);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .build(updatedWasteCategory.getId());

    return new ServiceResponse<>(wasteCategoryMapper.toResponse(updatedWasteCategory), location);
  }

  /**
   * Deletes a waste category by its ID.
   * @param id The ID of the waste category to be deleted.
   * @return ServiceResponse indicating successful deletion.
   */
  @Override
  public String deleteWasteCategory(Long id) {
    WasteCategory wasteCategory = wasteCategoryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));
    wasteCategoryRepository.delete(wasteCategory);

    return "Waste category deleted Successfully";
  }
}
