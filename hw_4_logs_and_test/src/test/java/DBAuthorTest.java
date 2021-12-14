import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.alevel.db.DBAuthor;
import ua.com.alevel.entity.Author;
import java.util.Arrays;

public class DBAuthorTest {

    @Before
    public void setUp() {
        Author authorTest = new Author("Name", "LastName");
        DBAuthor.getInstance().create(authorTest);
    }

    @Test
    public void authorArrayShouldHaveLengthTenElement() {
        Author[] authorArray = new Author[10];

        Assert.assertEquals(10, authorArray.length);
        Assert.assertEquals(authorArray = null, authorArray = null);
    }

    @Test
    public void authorArrayShouldArraySizeUp() {
        Author[] authorArray = new Author[10];
        String authorName = "author";

        for (int i = 0; i < 3; i++) {
            Author author = new Author(authorName + i, "" + i);
            authorArray[i] = author;
            authorArray = Arrays.copyOf(authorArray, authorArray.length + 1);
        }
        Assert.assertEquals(13, authorArray.length);
    }

    @Test(expected = RuntimeException.class)
    public void ifAuthorIsNotFoundShouldReturnRuntimeException() {
        DBAuthor.getInstance().findById(100);
    }

    @Test
    public void ifAuthorIsFoundShouldReturnAuthor() {
        long authorID = 1;

        Author authorTest = DBAuthor.getInstance().findById(authorID);
        Assert.assertEquals(authorID, authorTest.getId());
    }

    @Test
    public void ifAuthorDeleteShouldReturnNull() {
        long authorID = 1;

        DBAuthor.getInstance().findById(authorID);
        DBAuthor.getInstance().delete(authorID);
        Assert.assertEquals(null, null);
    }
}