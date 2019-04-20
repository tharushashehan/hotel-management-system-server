package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hotelmanagementsystem.model.LeaveDetails;;

@RepositoryRestResource
public interface LeaveDetailRepository extends JpaRepository <LeaveDetails, Long> {
	
}
