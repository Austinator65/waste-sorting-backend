package com.enviro.assessment.grad001.atisomofokeng.service.Implementation;

import com.enviro.assessment.grad001.atisomofokeng.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.atisomofokeng.model.RecyclingTip;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.mapper.RecyclingTipMapper;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.RecyclingTipRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.RecyclingTipResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.atisomofokeng.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.atisomofokeng.service.RecyclingTipService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing recycling tips. This service handles the CRUD operations for recycling tips.
 */
@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

  private final RecyclingTipRepository recyclingTipRepository;
  private final WasteCategoryRepository wasteCategoryRepository;
  private final RecyclingTipMapper recyclingTipMapper;

  public RecyclingTipServiceImpl(RecyclingTipRepository recyclingTipRepository,
                                 WasteCategoryRepository wasteCategoryRepository,
                                 RecyclingTipMapper recyclingTipMapper) {
    this.recyclingTipRepository = recyclingTipRepository;
    this.wasteCategoryRepository = wasteCategoryRepository;
    this.recyclingTipMapper = recyclingTipMapper;
  }

  /**
   * Retrieves all recycling tips from the repository.
   * @return ServiceResponse containing all recycling tips.
   */
  @Override
  public ServiceResponse<List<RecyclingTipResponse>> getAllRecyclingTips() {
    List<RecyclingTipResponse> recyclingTips = recyclingTipRepository.findAll().stream()
            .map(recyclingTipMapper::toResponse)
            .collect(Collectors.toList());

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
    return new ServiceResponse<>(recyclingTips, location);
  }

  /**
   * Retrieves recycling tips for a specific waste category.
   * @param categoryId The ID of the waste category to fetch tips for.
   * @return ServiceResponse containing the recycling tips for the given category.
   */
  @Override
  public ServiceResponse<List<RecyclingTipResponse>> getRecyclingTipsByCategory(Long categoryId) {
    // Fetch the waste category or throw an exception if not found
    WasteCategory category = wasteCategoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    // Fetch and map the recycling tips related to the category
    List<RecyclingTipResponse> recyclingTips = recyclingTipRepository.findByWasteCategory(category).stream()
            .map(recyclingTipMapper::toResponse)
            .collect(Collectors.toList());

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .build(category.getId());

    return new ServiceResponse<>(recyclingTips, location);
  }

  /**
   * Retrieves a specific recycling tip by its ID.
   * @param id The ID of the recycling tip.
   * @return ServiceResponse containing the recycling tip details.
   */
  @Override
  public ServiceResponse<RecyclingTipResponse> getRecyclingTipById(Long id) {
    // Fetch the recycling tip or throw an exception if not found
    RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found"));

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().build(recyclingTip.getId());

    return new ServiceResponse<>(recyclingTipMapper.toResponse(recyclingTip), location);
  }

  /**
   * Creates a new recycling tip and saves it to the repository.
   * @param request The request object containing the new recycling tip details.
   * @return ServiceResponse containing the created recycling tip and its URI.
   */
  @Override
  public ServiceResponse<RecyclingTipResponse> createRecyclingTip(RecyclingTipRequest request) {
    // Fetch the waste category to associate with the new tip or throw an exception if not found
    WasteCategory wasteCategory = wasteCategoryRepository.findById(request.getWasteCategoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    // Map the request data to a RecyclingTip entity
    RecyclingTip recyclingTip = recyclingTipMapper.toEntity(request, wasteCategory);

    // Save the entity to the repository
    RecyclingTip savedRecyclingTip = recyclingTipRepository.save(recyclingTip);

    // Generate the URI for the created resource
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedRecyclingTip.getId())
            .toUri();

    return new ServiceResponse<>(recyclingTipMapper.toResponse(savedRecyclingTip), location);
  }

  /**
   * Updates an existing recycling tip with new details.
   * @param id The ID of the recycling tip to be updated.
   * @param request The updated details for the recycling tip.
   * @return ServiceResponse containing the updated recycling tip details.
   */
  @Override
  public ServiceResponse<RecyclingTipResponse> updateRecyclingTip(Long id, RecyclingTipRequest request) {
    // Fetch the recycling tip to update or throw an exception if not found
    RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found"));

    // Fetch the waste category to associate with the updated tip
    WasteCategory wasteCategory = wasteCategoryRepository.findById(request.getWasteCategoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    // Update the entity using the mapper
    recyclingTipMapper.updateEntity(recyclingTip, request, wasteCategory);

    // Save the updated entity to the repository
    RecyclingTip updatedRecyclingTip = recyclingTipRepository.save(recyclingTip);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .build(updatedRecyclingTip.getId());

    return new ServiceResponse<>(recyclingTipMapper.toResponse(updatedRecyclingTip), location);
  }

  /**
   * Deletes a recycling tip by its ID.
   * @param id The ID of the recycling tip to be deleted.
   * @return ServiceResponse indicating successful deletion.
   */
  @Override
  public String deleteRecyclingTip(Long id) {
    // Fetch the recycling tip to delete or throw an exception if not found
    RecyclingTip recyclingTip = recyclingTipRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recycling tip not found"));

    // Delete the entity from the repository
    recyclingTipRepository.delete(recyclingTip);

    return "Recycling tip deleted successfully";
  }
}
