package com.aroha.kams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aroha.kams.model.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Integer> {

	public OtpEntity findByeMail(String eMail);

}
