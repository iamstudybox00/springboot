package com.edu.springboot.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface MemberRepository extends JpaRepository<Member, Long>
{
//	List<Member> findByNameLike(String keyword, Pageable pageable);
	Page<Member> findByNameLike(String keyword, Pageable pageable);
}
