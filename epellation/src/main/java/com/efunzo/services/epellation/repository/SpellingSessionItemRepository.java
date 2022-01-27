package com.efunzo.services.epellation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efunzo.services.epellation.domaine.SpellingSession;
import com.efunzo.services.epellation.domaine.SpellingSessionItem;


@Repository
public interface SpellingSessionItemRepository  extends JpaRepository<SpellingSessionItem, Long> {

	Optional<SpellingSessionItem> findSpellingSessionItemBySpellingSession(SpellingSession spellingSession);
	
	
	List<SpellingSessionItem>  findSpellingSessionItemBySpellingSession_Id(Long spellingSessionId);


	Optional<SpellingSessionItem> findSpellingSessionItemBySpellingSession_IdAndSpellingWord_Id(Long spellingSessionId,Long spellingWordId);
	

}
