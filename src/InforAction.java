import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings({ "serial" })
public class InforAction extends ActionSupport {
	private String title = null;
	
	private String isbn;
	private String authorID;
	private String publisher;
	private String publishDate;
	private float price;
	//xiugainjfd
	private String name;
	private int age;
	private String country;
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getAuthorID() {
		return this.authorID;
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public String getPublishDate() {
		return this.publishDate;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public String execute() throws Exception {
		Connection connctn = ConnectionGet.getConnetion();
		System.out.println(title);
		try {
			Statement statement = connctn.createStatement();
			String sqlstr1 = "select * from Book";
			ResultSet result = statement.executeQuery(sqlstr1);
			while (result.next()) {
				if (title.trim().equals(result.getString("Title").trim())) {
					isbn = result.getString("ISBN");
					authorID = result.getString("AuthorID");
					publisher = result.getString("Publisher");
					publishDate = result.getDate("PublishDate").toString();
					price = result.getFloat("Price");
				}
			}
			String sqlstr2 = "select * from Author";
			result = statement.executeQuery(sqlstr2);
			while (result.next()) {
				if (authorID.equals(result.getString("AuthorID"))) {
					name = result.getString("Name");
					age = result.getInt("Age");
					country = result.getString("Country");
				}
			}
			connctn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
