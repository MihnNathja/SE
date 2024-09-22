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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ShowDataServlet
 */

public class ShowDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Kết nối tới MSSQL với driver mssql-jdbc-12.4.1.jre
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=user_db;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(url);

            // Truy vấn dữ liệu từ bảng
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM users");
            // Tạo danh sách lưu tên người dùng
            List<String> userList = new ArrayList<>();

            // Thêm tên từ ResultSet vào danh sách
            while (rs.next()) {
                userList.add(rs.getString("name"));
            }
            
            

            // Chuyển hướng đến JSP để hiển thị
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("/WEB-INF/Views/showData.jsp").forward(request, response);
            

            // Đóng kết nối
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
