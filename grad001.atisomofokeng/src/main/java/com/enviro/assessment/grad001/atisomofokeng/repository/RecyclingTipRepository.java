package com.enviro.assessment.grad001.atisomofokeng.repository;

import com.enviro.assessment.grad001.atisomofokeng.model.RecyclingTip;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository Interfaces
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long>
{
  List<RecyclingTip> findAll();
  List<RecyclingTip> findByWasteCategory(WasteCategory wasteCategory);
}
