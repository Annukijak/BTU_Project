import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class Task3Tests {

    @Test
    public void statusCode() {
        int statusCode=
                given()
                        .when()
                        .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                        .assertThat()
                        .getStatusCode(200);
    }

    @Test
    public void bookIsbn {
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then()
                .body("books[-1].isbn", equalTo("9781593277574"));
    }

    @Test
    public void pageCount {
        given()
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books")
                .then()
                .body("books[0,1].pages", hasItems(234);
    }
}
