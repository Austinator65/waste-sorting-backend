package com.enviro.assessment.grad001.atisomofokeng;

import com.enviro.assessment.grad001.atisomofokeng.model.DisposalGuideline;
import com.enviro.assessment.grad001.atisomofokeng.model.RecyclingTip;
import com.enviro.assessment.grad001.atisomofokeng.model.WasteCategory;
import com.enviro.assessment.grad001.atisomofokeng.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.atisomofokeng.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.atisomofokeng.repository.WasteCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WasteSortingApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(WasteSortingApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(WasteCategoryRepository wasteCategoryRepository,
																 RecyclingTipRepository recyclingTipRepository,
																 DisposalGuidelineRepository disposalGuidelineRepository)
	{
		return args -> {
			WasteCategory plastic = new WasteCategory("Plastic");
			WasteCategory glass = new WasteCategory("Glass");

			wasteCategoryRepository.saveAll(List.of(plastic, glass));

			recyclingTipRepository.save(new RecyclingTip("Rinse plastic containers before recycling.", plastic));
			recyclingTipRepository.save(new RecyclingTip("Recycle glass bottles by washing and drying them.", glass));

			disposalGuidelineRepository.save(new DisposalGuideline("Flatten plastic bottles before disposal.", plastic));
			disposalGuidelineRepository.save(new DisposalGuideline("Remove bottle caps before recycling glass.", glass));
		};
	}
}
