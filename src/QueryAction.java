import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.TODO;

@SuppressWarnings({ "unused", "serial" })
public class QueryAction extends ActionSupport {
	private String name;
	private ArrayList<String> books = new ArrayList<>();
	
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
		Connection connctn = ConnectionGet.getConnetion();
		try {
			Statement statement = connctn.createStatement();
			String sqlstr1 = "select * from Author";
			ResultSet result = statement.executeQuery(sqlstr1);
			String authorID = null;
			
			while (result.next()) {
				if (name.equalsIgnoreCase(result.getString("Name"))) {
					authorID = result.getString("AuthorID");
					break;
				}
			}
			
			if (authorID != null) {
				String sqlstr2 = "select * from Book";
				result = statement.executeQuery(sqlstr2);
				while (result.next()) {
					if (authorID.equals(result.getString("AuthorID"))) {
						books.add(result.getString("Title"));
					}
				}
				connctn.close();
				return "success";
			} else {
				connctn.close();
				return "fail";
			}
		} catch (Exception e) {
			//TODO handle the exception
			e.printStackTrace();
			return "fail";
		}
	}
}
