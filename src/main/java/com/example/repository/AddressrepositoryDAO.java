package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Address;
@Repository
public interface AddressrepositoryDAO extends JpaRepository<Address,Long>{
	
	@Modifying
	@Transactional
	@Query("update Address set area = :area, city =:city where id = :id ")
	Integer updateAddress(long id,String area,String city);
	
	
}
