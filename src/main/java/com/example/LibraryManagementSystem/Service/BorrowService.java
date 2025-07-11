package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Repository.BookRepo;
import com.example.LibraryManagementSystem.Repository.BorrowRepo;
import com.example.LibraryManagementSystem.Repository.MemberRepo;
import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.model.Borrow;
import com.example.LibraryManagementSystem.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    @Autowired
    BorrowRepo brepo;

    @Autowired
    BookRepo bookrepo;

    @Autowired
    MemberRepo memberRepo;

    public Borrow addToRecord(Borrow borrow) {

        Optional<Book> getbook= bookrepo.findById(borrow.getBook().getBookId());
        Optional<Member> getmemeber= memberRepo.findById(borrow.getMember().getMemberId());
        if(getbook.isPresent()&& getmemeber.isPresent()){

            Book book=  getbook.get();
            Member member= getmemeber.get();

            if(book.getAvailableCopies()>0){
            book.setAvailableCopies(book.getAvailableCopies()-1);
            bookrepo.save(book);

            //return all detail of member and book detail
            borrow.setBook(book);
            borrow.setMember(member);

            borrow.setBorrowDate(LocalDate.now());
            borrow.setReturnDate(null);
            borrow.setReturned(false);
            return  brepo.save(borrow);
            }
            else{
                return null;
            }

        }
        else{
            return null;
        }




    }

    public Borrow update(Borrow borrow, int borrowId) {
        Optional<Borrow> findRecord= brepo.findById(borrowId);
        if(findRecord.isPresent()) {
            Borrow record = findRecord.get();

            Optional<Book> book = bookrepo.findById(record.getBook().getBookId());
            Optional<Member> getmemeber = memberRepo.findById(record.getMember().getMemberId());
            if (book.isPresent() && getmemeber.isPresent()) {

                Book bookRecord = book.get();
                Member member = getmemeber.get();
                if(bookRecord.getAvailableCopies()<bookRecord.getTotalCopies()) {
                    bookRecord.setAvailableCopies(bookRecord.getAvailableCopies() + 1);
                    bookrepo.save(bookRecord);
                }
                else{
                    return null;
                }

                record.setReturnDate(LocalDate.now());
                record.setReturned(true);
                record.setBook(bookRecord);
                record.setMember(member);
                return brepo.save(record);
            }
            else{
                return  null;
            }

        }
        else{
            return null;
        }

    }

    public List<Borrow> getall() {
        return brepo.findAll();
    }

    public List<Borrow> getbyMid(int memberId) {
      return  brepo.findByMemberMemberId(memberId);
    }

    public List<Borrow> getActive() {
        return brepo.findByReturnedFalse();
    }
}
