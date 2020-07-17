package com.personal.phonelookup.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.personal.phonelookup.Entity.UserInfo;

public interface RequestRepository extends JpaRepository<UserInfo, Long>{

	public List<UserInfo> findByMsisdn(String msisdn);
	
	@Query(
			  value = "select * from User_Info t where name like %:name% order by (name = :othername) desc, length(name)", //order by (name = :name) desc, length(name)
			  nativeQuery = true)
	public List<UserInfo> findByName(@Param("name") String name,@Param("othername") String othername);
	
	
}
