package ua.com.foxminded.db;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String bookName = request.getParameter("bookName");

		if (bookName != null && !bookName.isEmpty()) {
			DatabaseFacade.addBook(bookName);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Назва книги не може бути порожньою.");
		}
	}
}
