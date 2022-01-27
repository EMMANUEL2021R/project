package com.efunzo.services.epellation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efunzo.services.epellation.domaine.GradeType;
import com.efunzo.services.epellation.domaine.SpellingWord;




@Repository
public interface SpellingWordRepository extends JpaRepository<SpellingWord, Long> {
	
	Optional<SpellingWord> findSpellingWordById(Long id);
	
	List<SpellingWord> findSpellingWordByLevels_NumberAndLevels_Grade(Integer number, GradeType grade);
	
	List<SpellingWord> findSpellingWordByLevels_Number(Integer number);
	
}
