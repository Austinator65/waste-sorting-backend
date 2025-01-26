package com.enviro.assessment.grad001.atisomofokeng.model.dto.mapper;

import com.enviro.assessment.grad001.atisomofokeng.model.RecyclingTip;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.request.RecyclingTipRequest;
import com.enviro.assessment.grad001.atisomofokeng.model.dto.response.RecyclingTipResponse;
import org.springframework.stereotype.Component;

/**
 * A mapper class for converting between RecyclingTip entities and their corresponding DTOs.
 * This class provides methods to map between entity and response/request DTOs,
 * as well as to update an existing entity with new data from a request.
 */
@Component
public class RecyclingTipMapper {

  /**
   * Converts a RecyclingTip entity to a RecyclingTipResponse DTO.
   *
   * @param recyclingTip The RecyclingTip entity to convert.
   * @return A RecyclingTipResponse DTO containing the mapped data.
   */
  public RecyclingTipResponse toResponse(RecyclingTip recyclingTip) {
    return new RecyclingTipResponse(
            recyclingTip.getId(),
            recyclingTip.getRecyclingTip(),
            recyclingTip.getWasteCategory().getCategoryName()
    );
  }

  /**
   * Converts a RecyclingTipRequest DTO to a RecyclingTip entity.
   *
   * @param request The RecyclingTipRequest DTO containing the input data.
   * @param wasteCategory The WasteCategory entity to associate with the RecyclingTip.
   * @return A RecyclingTip entity created from the input data.
   */
  public RecyclingTip toEntity(RecyclingTipRequest request, WasteCategory wasteCategory) {
    return new RecyclingTip(
            request.getRecyclingTip(),
            wasteCategory
    );
  }

  /**
   * Updates an existing RecyclingTip entity with new data from a RecyclingTipRequest.
   *
   * @param recyclingTip The existing RecyclingTip entity to update.
   * @param request The RecyclingTipRequest DTO containing the new data.
   * @param wasteCategory The WasteCategory entity to associate with the updated RecyclingTip.
   */
  public void updateEntity(RecyclingTip recyclingTip, RecyclingTipRequest request, WasteCategory wasteCategory) {
    recyclingTip.setRecyclingTip(request.getRecyclingTip());
    recyclingTip.setWasteCategory(wasteCategory);
  }
}
