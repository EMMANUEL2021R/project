package com.efunzo.services.epellation.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="spelling_word")
public class SpellingWord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String word;
	
	private  String inPhrase;
	
	private String definition;
	
	@ManyToMany
		@JoinTable(name="spelling_word_level",
		joinColumns = @JoinColumn(name="spelling_word_id"),
		inverseJoinColumns =@JoinColumn(name="level_id")
	)
	private List<Level> levels = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getInPhrase() {
		return inPhrase;
	}

	public void setInPhrase(String inPhrase) {
		this.inPhrase = inPhrase;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpellingWord other = (SpellingWord) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpellingWord [id=" + id + ", word=" + word + ", inPhrase=" + inPhrase + ", definition=" + definition
				+ ", levels=" + levels + "]";
	}


	
	
	
	

}
