package com.efunzo.services.epellation.service.dto;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.efunzo.services.epellation.domaine.EpellationUser;


public class SpellingSessionDTO {
	
	private Long id;

    private EpellationUserDTO epellationUser;
    
    private Instant createdDate;
    
    
	public SpellingSessionDTO(EpellationUserDTO epellationUser, Instant createDate) {
		super();
		this.epellationUser = epellationUser;
		this.createdDate = createDate;
	}

	public SpellingSessionDTO() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EpellationUserDTO getEpellationUser() {
		return epellationUser;
	}

	public void setEpellationUser(EpellationUserDTO epellationUser) {
		this.epellationUser = epellationUser;
	}

	public Instant getCreatedDade() {
		return createdDate;
	}

	public void setCreatedDade(Instant createdDade) {
		this.createdDate = createdDade;
	}

	@Override
	public String toString() {


		return "SpellingSession [id=" + id + ", epellationUserDTO=" + epellationUser + ", createDate=" + createdDate
				+ ", ItemList=" + "]";
	}

}



