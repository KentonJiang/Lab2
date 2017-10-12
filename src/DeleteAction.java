import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteAction extends ActionSupport{
	private String isbn;
	private String name;
	private ArrayList<String> books = new ArrayList<>();
	
	public String getISBN() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getBooks() {
		return this.books;
	}
	
	public String execute() throws Exception {
		Connection con = ConnectionGet.getConnetion();
		try {
			Statement statement = con.createStatement();
			String authorID = null;
			
			//根据ISBN找到对应AuthorID
			String sq1 = "select * from Book where ISBN = " + "\"" + isbn + "\"";
			ResultSet result = statement.executeQuery(sq1);
			if (result.first()) {
				authorID = result.getString("AuthorID");
			}
			
			//根据ISBN删除图书信息
			String sq2 = "delete from Book where ISBN = " + "\"" + isbn + "\"";
			statement.executeUpdate(sq2);
			
			//根据AuthorID找到作者名
			String sq3 = "select * from Author where AuthorID = " + "\"" + authorID + "\"";
			result = statement.executeQuery(sq3);
			if (result.first()) {
				name = result.getString("Name");
			}
			
			//根据AuthorID找到该作者所著的图书
			String sq4 = "select * from Book where AuthorID = " + "\"" + authorID + "\"";
			result = statement.executeQuery(sq4);
			while (result.next()) {
				books.add(result.getString("Title"));
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
