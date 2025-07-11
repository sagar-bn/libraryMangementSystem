package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member,Integer> {
}
