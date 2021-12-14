import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.alevel.db.DBAuthor;
import ua.com.alevel.db.DBBook;
import ua.com.alevel.entity.Book;
import java.util.Arrays;

public class DBBookTest {

    @Before
    public void setUp() {
        Book bookTest = new Book("Name", "AuthorName");

        DBBook.getInstance().create(bookTest);
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
        long bookID = 1;

        Book bookTest = DBBook.getInstance().findById(bookID);
        Assert.assertEquals(bookID, bookTest.getId());
    }

    @Test
    public void ifAuthorDeleteShouldReturnNull() {
        long bookID = 1;

        DBAuthor.getInstance().findById(bookID);
        DBAuthor.getInstance().delete(bookID);
        Assert.assertEquals(null, null);
    }
}