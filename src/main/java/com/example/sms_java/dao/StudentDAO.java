package com.example.sms_java.dao;


import com.example.sms_java.db.DatabaseConnection;
import com.example.sms_java.model.Student;

public class StudentDAO {

    public void addStudent(Student student) {
        java.lang.String sql =
                "INSERT INTO students (reg_no, name, course) VALUES (?, ?, ?)";

        try (java.sql.Connection con = DatabaseConnection.getConnection();
             java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getRegNo());
            ps.setString(2, student.getName());
            ps.setString(3, student.getCourse());
            ps.executeUpdate();

        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public java.util.List<Student> getAllStudents() {
        java.util.List<Student> students = new java.util.ArrayList<>();
        java.lang.String sql = "SELECT * FROM students";

        try (java.sql.Connection con = DatabaseConnection.getConnection();
             java.sql.Statement st = con.createStatement();
             java.sql.ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("reg_no"),
                        rs.getString("name"),
                        rs.getString("course")
                ));
            }

        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException(e);
        }

        return students;
    }
}