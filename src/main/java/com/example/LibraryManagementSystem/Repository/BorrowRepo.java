package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BorrowRepo extends JpaRepository<Borrow,Integer> {
    List<Borrow> findByMemberMemberId(int memberId);

    List<Borrow> findByReturnedFalse();
}
