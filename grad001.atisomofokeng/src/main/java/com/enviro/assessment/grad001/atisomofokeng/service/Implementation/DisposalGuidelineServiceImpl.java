package com.enviro.assessment.grad001.atisomofokeng.service.Implementation;

import com.enviro.assessment.grad001.atisomofokeng.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.atisomofokeng.model.DisposalGuideline;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.mapper.DisposalGuidelineMapper;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.DisposalGuidelineRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.DisposalGuidelineResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.ServiceResponse;
import com.enviro.assessment.grad001.atisomofokeng.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.atisomofokeng.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.atisomofokeng.service.DisposalGuidelineService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing disposal guidelines. Handles CRUD operations using mappers for conversions.
 */
@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidelineService {

  private final DisposalGuidelineRepository disposalGuidelineRepository;
  private final WasteCategoryRepository wasteCategoryRepository;
  private final DisposalGuidelineMapper disposalGuidelineMapper;

  public DisposalGuidelineServiceImpl(DisposalGuidelineRepository disposalGuidelineRepository,
                                      WasteCategoryRepository wasteCategoryRepository,
                                      DisposalGuidelineMapper disposalGuidelineMapper) {
    this.disposalGuidelineRepository = disposalGuidelineRepository;
    this.wasteCategoryRepository = wasteCategoryRepository;
    this.disposalGuidelineMapper = disposalGuidelineMapper;
  }

  /**
   * Retrieves all disposal guidelines.
   * @return ServiceResponse containing a list of all disposal guidelines.
   */
  @Override
  public ServiceResponse<List<DisposalGuidelineResponse>> getAllDisposalGuidelines() {
    List<DisposalGuidelineResponse> disposalGuidelines = disposalGuidelineRepository.findAll().stream()
            .map(disposalGuidelineMapper::toResponse)
            .collect(Collectors.toList());

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

    return new ServiceResponse<>(disposalGuidelines, location);
  }

  /**
   * Retrieves disposal guidelines for a specific waste category.
   * @param categoryId The ID of the waste category to fetch tips for.
   * @return ServiceResponse containing the recycling tips for the given category.
   */
  @Override
  public ServiceResponse<List<DisposalGuidelineResponse>> getDisposalGuidelinesByCategory(Long categoryId) {
    // Fetch the waste category or throw an exception if not found
    WasteCategory category = wasteCategoryRepository.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    // Fetch and map the recycling tips related to the category
    List<DisposalGuidelineResponse> disposalGuidelines = disposalGuidelineRepository.findByWasteCategory(category).stream()
            .map(disposalGuidelineMapper::toResponse)
            .collect(Collectors.toList());

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .build(category.getId());

    return new ServiceResponse<>(disposalGuidelines, location);
  }

  /**
   * Retrieves a specific disposal guideline by its ID.
   * @param id The ID of the disposal guideline.
   * @return ServiceResponse containing the disposal guideline details.
   */
  @Override
  public ServiceResponse<DisposalGuidelineResponse> getDisposalGuidelineById(Long id) {
    DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found"));

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest().build(disposalGuideline.getId());

    return new ServiceResponse<>(disposalGuidelineMapper.toResponse(disposalGuideline), location);
  }

  /**
   * Creates a new disposal guideline.
   * @param request The request object containing the new disposal guideline details.
   * @return ServiceResponse containing the created disposal guideline and its URI.
   */
  @Override
  public ServiceResponse<DisposalGuidelineResponse> createDisposalGuideline(DisposalGuidelineRequest request) {
    WasteCategory wasteCategory = wasteCategoryRepository.findById(request.getWasteCategoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    DisposalGuideline disposalGuideline = disposalGuidelineMapper.toEntity(request, wasteCategory);
    DisposalGuideline savedDisposalGuideline = disposalGuidelineRepository.save(disposalGuideline);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedDisposalGuideline.getId())
            .toUri();

    return new ServiceResponse<>(disposalGuidelineMapper.toResponse(savedDisposalGuideline), location);
  }

  /**
   * Updates an existing disposal guideline.
   * @param id The ID of the disposal guideline to be updated.
   * @param request The updated details for the disposal guideline.
   * @return ServiceResponse containing the updated disposal guideline.
   */
  @Override
  public ServiceResponse<DisposalGuidelineResponse> updateDisposalGuideline(Long id, DisposalGuidelineRequest request) {
    DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found"));

    WasteCategory wasteCategory = wasteCategoryRepository.findById(request.getWasteCategoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Waste category not found"));

    disposalGuidelineMapper.updateEntity(disposalGuideline, request, wasteCategory);

    DisposalGuideline updatedDisposalGuideline = disposalGuidelineRepository.save(disposalGuideline);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .build(updatedDisposalGuideline.getId());

    return new ServiceResponse<>(disposalGuidelineMapper.toResponse(updatedDisposalGuideline), location);
  }

  /**
   * Deletes a disposal guideline by its ID.
   * @param id The ID of the disposal guideline to be deleted.
   * @return A message indicating successful deletion.
   */
  @Override
  public String deleteDisposalGuideline(Long id) {
    DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Disposal guideline not found"));

    disposalGuidelineRepository.delete(disposalGuideline);

    return "Disposal guideline deleted successfully";
  }
}
