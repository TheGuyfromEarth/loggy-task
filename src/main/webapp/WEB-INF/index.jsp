<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Loggy - Microblogging System</title>
</head>
<body>
    <h1>Welcome to Loggy - Microblogging System</h1>

    <!-- Form for submitting new posts -->
    <form action="submit_post" method="post" enctype="multipart/form-data">
        <label for="title">Title (Max 60 chars):</label>
        <input type="text" name="title" id="title" maxlength="60" required><br>

        <label for="description">Description (Max 120 chars):</label>
        <textarea name="description" id="description" maxlength="120" required></textarea><br>

        <label for="content">Attach Content:</label>
        <input type="file" name="content" id="content" accept="text/plain, image/*, audio/*, video/*" required><br>

        <input type="submit" value="Submit">
    </form>

    <hr>

    <!-- Display list of previous submissions ordered by timestamp -->
    <h2>Recent Submissions:</h2>
    <ul>
        <%-- Iterate over the list of submissions using JSP tags --%>
        <c:forEach var="submission" items="${submissions}">
            <li>
                <strong>Title:</strong> ${submission.title}<br>
                <strong>Description:</strong> ${submission.description}<br>
                <%-- Example of displaying the thumbnail for the content --%>
                <img src="${submission.thumbnailUrl}" alt="Thumbnail"><br>
                <%-- Add more logic to display the appropriate content (text, image, audio, video) --%>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
