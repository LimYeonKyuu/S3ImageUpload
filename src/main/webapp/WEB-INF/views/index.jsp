<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        .add-button,
        .action-button {
            display: inline-block;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .add-button {
            background-color: #007bff;
            color: #fff;
        }

        .add-button:hover,
        .action-button:hover {
            background-color: #0056b3;
        }

        .thumbnail {
            max-width: 100px;
            max-height: 100px;
        }
    </style>
</head>
<body>
<a href="${context}/s3Example/upload" class="add-button">게시물 추가</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Image</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="example" items="${response}">
        <tr>
            <td>${example.getId()}</td>
            <td>${example.getName()}</td>
            <td><img src="${example.getImageUrl()}" alt="Image" class="thumbnail"></td>
            <td>
                <a href="${context}/s3Example/delete/${example.getId()}">Delete</a>
                <a href="${context}/s3Example/update/${example.getId()}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
