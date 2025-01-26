package com.enviro.assessment.grad001.atisomofokeng.repository;

import com.enviro.assessment.grad001.atisomofokeng.model.DisposalGuideline;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository Interfaces
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long>
{
  List<DisposalGuideline> findAll();
  List<DisposalGuideline> findByWasteCategory(WasteCategory wasteCategory);

}
