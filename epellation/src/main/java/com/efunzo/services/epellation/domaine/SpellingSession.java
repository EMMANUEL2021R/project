package com.efunzo.services.epellation.domaine;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="spelling_session")
public class SpellingSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    private EpellationUser epellationUser;
    
    private Instant createdDate = Instant.now();

   
    
	public SpellingSession(EpellationUser epellationUser, Instant createDate) {
		super();
		this.epellationUser = epellationUser;
		this.createdDate = createDate;
	}

	public SpellingSession() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EpellationUser getEpellationUser() {
		return epellationUser;
	}

	public void setEpellationUser(EpellationUser epellationUser) {
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


		return "SpellingSession [id=" + id + ", epellationUser=" + epellationUser + ", createDate=" + createdDate
				+ ", ItemList=" + "]";
	}

}



