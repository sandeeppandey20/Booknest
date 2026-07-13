package com.booknest.repository;

import com.booknest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Finds books whose title contains the provided text, ignoring case.
     *
     * @param title the partial title value to search for
     * @return list of matching books
     */
    List<Book> findByTitleContainingIgnoreCase(String title);

    /**
     * Finds books whose author contains the provided text, ignoring case.
     *
     * @param author the partial author value to search for
     * @return list of matching books
     */
    List<Book> findByAuthorContainingIgnoreCase(String author);

    /**
     * Finds books that match the given status value.
     *
     * @param status the status to filter by
     * @return list of books in the requested status
     */
    List<Book> findByStatus(String status);

    /**
     * Checks whether a book with the supplied ISBN already exists.
     *
     * @param isbn the ISBN to validate uniqueness for
     * @return true if a book with the ISBN exists, otherwise false
     */
    boolean existsByIsbn(String isbn);
}
