package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Service.MemberService;
import com.example.LibraryManagementSystem.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Member> addMember(@RequestBody Member member){
        Member member1=  memberService.addMember(member);
       if(member1!=null){
           return ResponseEntity.ok(member1);
       }
       else{
           return ResponseEntity.badRequest().build();
       }

    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMember(){
        List<Member> members= memberService.getAllMember();
        if(members.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok().body(members);
        }
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") int memberId){
        Object memberById= memberService.getbyId(memberId);
        if(memberById!=null){
            return ResponseEntity.ok(memberById);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<Member> editMember(@RequestBody Member member ,@PathVariable("id") int memberId){

        Member memberUpdated= memberService.updateMember(member,memberId);
        if(memberUpdated!=null){
          return  ResponseEntity.ok(memberUpdated);
        }
        else{
           return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int memberId){

        boolean memberDeleted= memberService.deleteMember(memberId);
        if(memberDeleted){
            return  ResponseEntity.ok("Deleted Successfully");
        }
        else{
            return  ResponseEntity.notFound().build();
        }
    }

}
