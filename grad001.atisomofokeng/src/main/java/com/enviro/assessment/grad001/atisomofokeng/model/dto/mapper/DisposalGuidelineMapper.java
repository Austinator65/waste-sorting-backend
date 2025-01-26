package com.enviro.assessment.grad001.atisomofokeng.model.dto.mapper;

import com.enviro.assessment.grad001.atisomofokeng.model.DisposalGuideline;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.DisposalGuidelineRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.DisposalGuidelineResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between DisposalGuideline entities and DTOs.
 */
@Component
public class DisposalGuidelineMapper {

  /**
   * Converts a DisposalGuideline entity to a DisposalGuidelineResponse DTO.
   *
   * @param disposalGuideline The entity to be converted.
   * @return The corresponding DisposalGuidelineResponse DTO.
   */
  public DisposalGuidelineResponse toResponse(DisposalGuideline disposalGuideline) {
    return new DisposalGuidelineResponse(
            disposalGuideline.getId(),
            disposalGuideline.getDisposalGuideline(),
            disposalGuideline.getWasteCategory().getCategoryName()
    );
  }

  /**
   * Converts a DisposalGuidelineRequest DTO to a DisposalGuideline entity.
   *
   * @param request The request DTO containing the disposal guideline details.
   * @param wasteCategory The WasteCategory associated with the disposal guideline.
   * @return The corresponding DisposalGuideline entity.
   */
  public DisposalGuideline toEntity(DisposalGuidelineRequest request, WasteCategory wasteCategory) {
    return new DisposalGuideline(
            request.getDisposalGuideline(),
            wasteCategory
    );
  }

  /**
   * Updates an existing DisposalGuideline entity with details from a DisposalGuidelineRequest DTO.
   *
   * @param disposalGuideline The existing entity to be updated.
   * @param request The request DTO containing updated disposal guideline details.
   * @param wasteCategory The updated WasteCategory associated with the disposal guideline.
   */
  public void updateEntity(DisposalGuideline disposalGuideline, DisposalGuidelineRequest request, WasteCategory wasteCategory) {
    disposalGuideline.setDisposalGuideline(request.getDisposalGuideline());
    disposalGuideline.setWasteCategory(wasteCategory);
  }
}
