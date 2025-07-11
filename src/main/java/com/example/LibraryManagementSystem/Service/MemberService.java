package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Repository.MemberRepo;
import com.example.LibraryManagementSystem.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepo memberRepo;

    public  List<Member> getAllMember() {
        return  memberRepo.findAll();
    }

    public Member addMember(Member member) {
      return   memberRepo.save(member);
    }

    public Object getbyId(int memberId) {
        return memberRepo.findById(memberId);
    }

    public Member updateMember(Member member,int memberId) {
        Optional<Member> memberToUpdate = memberRepo.findById(memberId);
        if(memberToUpdate.isPresent()){
            return memberRepo.save(member);
        }
        else{
            return null;
        }
    }


    public boolean deleteMember(int memberId) {
         Optional<Member> memberToDelete=memberRepo.findById(memberId);
         if(memberToDelete.isPresent()){
              memberRepo.deleteById(memberId);
              return true;

         }
         else{
             return false;
         }
    }
}
