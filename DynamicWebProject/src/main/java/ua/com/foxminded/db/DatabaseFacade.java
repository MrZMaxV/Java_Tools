package ua.com.foxminded.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {
	public static List<String> getBooks() {
		List<String> result = new ArrayList<String>();

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234")) {
			System.out.println("Java JDBC PostgreSQL Example");

			System.out.println("Connected to PostgreSQL database!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM books.books");
			while (resultSet.next()) {
				result.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
		return result;
	}
	
	public static void addBook(String bookName) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "1234")) {
            String sql = "INSERT INTO books.books (name) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, bookName);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Failed to add book.");
            e.printStackTrace();
        }
    }
	
	public static void removeBook(String bookName) {
	    String removeSql = "DELETE FROM books.books WHERE name = ?";
	    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
	            "postgres", "1234");
	         PreparedStatement preparedStatement = connection.prepareStatement(removeSql)) {
	        preparedStatement.setString(1, bookName);
	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Книгу '" + bookName + "' успішно видалено з бази даних.");
	        } else {
	            System.out.println("Книга '" + bookName + "' не була знайдена в базі даних.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Сталася помилка при спробі видалити книгу '" + bookName + "' з бази даних.");
	        e.printStackTrace();
	    }
	}

    
}