package com.efunzo.services.epellation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.efunzo.services.epellation.domaine.GradeType;
import com.efunzo.services.epellation.domaine.Level;


@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
	
	Optional<Level> findLevelById(Long id);
	
	Optional<Level> findLevelByNumber(Integer number);
	
	Optional<Level> findLevelBynumberAndGrade(Integer number, GradeType grade);

	Optional<Level> findLevelByNumberAndGrade(Integer grade, GradeType dificulty);

	
}
