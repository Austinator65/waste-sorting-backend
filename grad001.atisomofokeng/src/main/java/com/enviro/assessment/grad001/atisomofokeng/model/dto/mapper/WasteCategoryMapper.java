package com.enviro.assessment.grad001.atisomofokeng.model.dto.mapper;

import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.WasteCategoryRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.DisposalGuidelineResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.RecyclingTipResponse;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.WasteCategoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between WasteCategory entities and DTOs.
 */
@Component
public class WasteCategoryMapper {

  /**
   * Converts a WasteCategory entity to a WasteCategoryResponse DTO.
   *
   * @param wasteCategory The WasteCategory entity to be converted.
   * @return The corresponding WasteCategoryResponse DTO containing details of the waste category,
   *         associated recycling tips, and disposal guidelines.
   */
  public WasteCategoryResponse toResponse(WasteCategory wasteCategory) {
    // Map associated RecyclingTips to RecyclingTipResponse DTOs.
    if(wasteCategory.getRecyclingTips() == null) {
      // Construct and return the WasteCategoryResponse DTO.
      return new WasteCategoryResponse(
              wasteCategory.getId(),
              wasteCategory.getCategoryName()
      );
    }
    List<RecyclingTipResponse> recyclingTips = wasteCategory.getRecyclingTips().stream()
            .map(tip -> new RecyclingTipResponse(
                    tip.getId(),
                    tip.getRecyclingTip(),
                    tip.getWasteCategory().getCategoryName()))
            .collect(Collectors.toList());

    // Map associated DisposalGuidelines to DisposalGuidelineResponse DTOs.
    List<DisposalGuidelineResponse> disposalGuidelines = wasteCategory.getDisposalGuidelines().stream()
            .map(guideline -> new DisposalGuidelineResponse(
                    guideline.getId(),
                    guideline.getDisposalGuideline(),
                    guideline.getWasteCategory().getCategoryName()))
            .collect(Collectors.toList());

    // Construct and return the WasteCategoryResponse DTO.
    return new WasteCategoryResponse(
            wasteCategory.getId(),
            wasteCategory.getCategoryName(),
            recyclingTips,
            disposalGuidelines
    );
  }

  /**
   * Converts a WasteCategoryRequest DTO to a WasteCategory entity.
   *
   * @param request The WasteCategoryRequest DTO containing the category details to be persisted.
   * @return A WasteCategory entity populated with the data from the request DTO.
   */
  public static WasteCategory toEntity(WasteCategoryRequest request) {
    // Create a new WasteCategory entity and set its name from the request DTO.
    WasteCategory category = new WasteCategory();
    category.setCategoryName(request.getCategoryName());
    return category;
  }
}
