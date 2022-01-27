package com.efunzo.services.epellation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efunzo.services.epellation.domaine.EpellationUser;

public interface EpellationUserRepository  extends JpaRepository<EpellationUser, Long> {
	

	Optional<EpellationUser> findEpellationUserById(Long id);
	

	Optional<EpellationUser>  findEpellationUserByUserNameAndPassword(String userName, String password);
	

	Optional<EpellationUser> findEpellationUserByUserName(String name);
	
	Optional<EpellationUser> findEpellationUserIdByUserName(String userName);

	void deleteById(Long id);
	
	

}
