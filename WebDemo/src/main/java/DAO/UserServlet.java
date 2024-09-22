package DAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Views/index.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        
       
        try {
            // Kết nối tới MSSQL với driver mssql-jdbc-12.4.1.jre
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=user_db;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(url);

            // Lưu tên vào bảng
            String sql = "INSERT INTO users (name) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.executeUpdate();

            // Đóng kết nối
            stmt.close();
            conn.close();

            // Chuyển hướng về trang form sau khi lưu
            request.getRequestDispatcher("/WEB-INF/Views/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}
