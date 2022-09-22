package com.efunzo.services.epellation.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efunzo.services.epellation.domaine.SpellingSession;



@Repository
public interface SpellingSessionRepository  extends JpaRepository<SpellingSession, Long> {

	Optional<SpellingSession> findSpellingSessionById(Long id);
	
	
	List<SpellingSession> findSpellingSessionByEpellationUser_Id(Long userId);


	Page<SpellingSession> findSpellingSessionByEpellationUser_Id(Long userId, Pageable pageable);
	
}
