package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Service.BookService;
import com.example.LibraryManagementSystem.Service.BorrowService;
import com.example.LibraryManagementSystem.model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowController {

    @Autowired
    BorrowService bService;

    @PostMapping("/borrow")
    public ResponseEntity<Object> addToRecord(@RequestBody Borrow borrow){
        Borrow borrow1= bService.addToRecord(borrow);
        if(borrow1!=null){
          return  ResponseEntity.ok(borrow1);
        }
        else{
            return ResponseEntity.status(404).body("Sorry book is not available right now !!");
        }

    }


    @PutMapping("/return/{Id}")
    public ResponseEntity<Object> updateRecord(@RequestBody Borrow borrow, @PathVariable("Id") int borrowId){
        Borrow borrow1= bService.update(borrow,borrowId);

        if(borrow1!=null){
            return ResponseEntity.ok(borrow1);
        }
        else{
            return ResponseEntity.status(400).body("Invalid BorrowId !!");
        }
    }

    @GetMapping("/borrows")
    public ResponseEntity<?> getallRecords(){
        List<Borrow> borrowList=bService.getall();

        if(borrowList.isEmpty()){
            return ResponseEntity.status(404).body("No Records Found");
        }
        else{
            return ResponseEntity.ok(borrowList);
        }
    }

    @GetMapping("/borrow/member/{Id}")
    public ResponseEntity<?> getByMemberId(@PathVariable("Id") int memberId){
        List<Borrow> borrowList =bService.getbyMid(memberId);
        if(borrowList.isEmpty()){
            return ResponseEntity.status(404).body("No borrow records found by this member Id");
        }
        else{
            return ResponseEntity.ok(borrowList);
        }
    }

    @GetMapping("/borrow/active")
    public ResponseEntity<?> getActive(){

        List<Borrow> borrowList=bService.getActive();
        if(borrowList.isEmpty()){
            return ResponseEntity.status(404).body("No active Borrower");
        }
        else{
            return ResponseEntity.ok(borrowList);
        }

    }

}
