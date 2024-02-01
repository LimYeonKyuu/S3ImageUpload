<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
  <title>S3 Example Update Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    .container {
      max-width: 500px;
      margin: 50px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-label {
      font-weight: bold;
    }

    .form-control {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box;
      font-size: 16px;
    }

    .btn-submit {
      display: inline-block;
      background-color: #007bff;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }

    .btn-submit:hover {
      background-color: #0056b3;
    }

    .current-image {
      margin-top: 10px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Update S3 Example</h2>
  <form action="${context}/s3Example/update/${response.id}" enctype="multipart/form-data" method="post">
    <div class="form-group">
      <label for="name" class="form-label">이름</label>
      <input type="text" id="name" name="name" class="form-control" value="${response.getName()}" required>
    </div>
    <div class="form-group">
      <label for="image" class="form-label">새 이미지 업로드</label>
      <input type="file" id="image" name="image" class="form-control">
    </div>
    <div class="current-image">
      <label class="form-label">현재 이미지</label>
      <c:choose>
        <c:when test="${not empty response.getImageUrl()}">
          <img src="${response.getImageUrl()}" alt="Current Image" style="max-width: 100%;">
        </c:when>
        <c:otherwise>
          <p>이전에 업로드된 이미지 없음</p>
        </c:otherwise>
      </c:choose>
    </div>
    <button type="submit" class="btn-submit">Update</button>
  </form>
</div>
</body>
</html>
