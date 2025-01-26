package com.enviro.assessment.grad001.atisomofokeng.repository;

import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository Interfaces
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long>
{
  List<WasteCategory> findAll();
  WasteCategory findById(long id);
  List<WasteCategory> findWasteCategoryByCategoryName(String categoryName);
}