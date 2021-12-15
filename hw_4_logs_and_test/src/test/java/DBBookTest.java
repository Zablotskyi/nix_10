import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.alevel.db.DBBook;
import ua.com.alevel.entity.Book;

import java.util.Arrays;

public class DBBookTest {

    @Before
    public void setUp() {
        Book bookTest = new Book("Name", "AuthorName");
        Book bookTest2 = new Book("Name2", "AuthorName2");
        DBBook.getInstance().create(bookTest);
        DBBook.getInstance().create(bookTest2);
    }

    @Test
    public void booksArrayShouldHaveLengthTenElement() {
        Book[] booksArray = new Book[10];

        Assert.assertEquals(10, booksArray.length);
        Assert.assertEquals(booksArray = null, booksArray = null);
    }

    @Test
    public void booksArrayShouldArraySizeUp() {
        Book[] booksArray = new Book[10];
        String name = "book";
        String authorName = "author";

        for (int i = 0; i < 3; i++) {
            Book book = new Book(name + i, authorName + 1);
            booksArray[i] = book;
            booksArray = Arrays.copyOf(booksArray, booksArray.length + 1);
        }
        Assert.assertEquals(13, booksArray.length);
    }

    @Test(expected = RuntimeException.class)
    public void ifBookIsNotFoundShouldReturnRuntimeException() {
        DBBook.getInstance().findById(100);
    }

    @Test
    public void ifBookIsFoundShouldReturnBook() {
        long bookID = DBBook.getInstance().getBooksArray()[0].getId();

        Book bookTest = DBBook.getInstance().findById(bookID);
        Assert.assertEquals(bookID, bookTest.getId());
    }

    @Test
    public void ifAuthorDeleteShouldReturnNull() {
        booksArrayShouldArraySizeUp();
        DBBook.getInstance().delete(DBBook.getInstance().getBooksArray()[0].getId());
        Assert.assertNull(DBBook.getInstance().getBooksArray()[0]);
    }
}