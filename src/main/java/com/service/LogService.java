package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoggyService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/loggyDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;

    public LoggyService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize the database connection.");
        }
    }

    public void addSubmission(Submission submission) {
        try {
            String sql = "INSERT INTO submissions (title, description, content_type, thumbnail_url) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, submission.getTitle());
            statement.setString(2, submission.getDescription());
            statement.setString(3, submission.getContentType());
            statement.setString(4, submission.getThumbnailUrl());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add submission to the database.");
        }
    }

    public List<Submission> getAllSubmissions() {
        List<Submission> submissions = new ArrayList<>();

        try {
            String sql = "SELECT * FROM submissions ORDER BY timestamp DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String contentType = resultSet.getString("content_type");
                String thumbnailUrl = resultSet.getString("thumbnail_url");

                // Create Submission object and add it to the list
                Submission submission = new Submission(title, description, contentType, thumbnailUrl);
                submissions.add(submission);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve submissions from the database.");
        }

        return submissions;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
