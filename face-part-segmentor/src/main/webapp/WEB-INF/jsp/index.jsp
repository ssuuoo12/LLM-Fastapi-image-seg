<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이미지 분할</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .chat-container {
            width: 100%;
            max-width: 600px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            display: flex;
            flex-direction: column;
            height: auto; /* 수정 */
        }
        .chat-header {
            background-color: #4a90e2;
            color: white;
            padding: 10px;
            text-align: center;
            font-size: 1.2em;
        }
        .chat-body {
            padding: 20px;
            background-color: #fafafa;
            overflow-y: visible; /* 수정: 스크롤 대신 모두 보이도록 */
        }
        .message {
            margin-bottom: 15px;
            padding: 10px;
            border-radius: 5px;
            max-width: 70%;
            word-wrap: break-word;
        }
        .user-message {
            background-color: #4a90e2;
            color: white;
            margin-left: auto;
            text-align: right;
        }
        .bot-message {
            background-color: #e9ecef;
            color: #333;
            margin-right: auto;
        }
        .chat-footer {
            padding: 10px;
            border-top: 1px solid #ddd;
            background-color: #fff;
        }
        .chat-footer img {
            margin-top: 10px; /* 이미지 간격 추가 */
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1em;
        }
        input[type="submit"]:hover {
            background-color: #357abd;
        }
    </style>
</head>
<body>
    <div class="chat-container">
        <div class="chat-header">
            <h1>얼굴 분석하고 싶은 사진을 업로드하세요</h1>
        </div>
        <div class="chat-body">
            <% if (request.getAttribute("message") != null) { %>
                <div class="message user-message">
                    ${message}
                </div>
            <% } %>
            <% if (request.getAttribute("response") != null) { %>
                <div class="message bot-message">
                    ${response}
                </div>
            <% } %>
        </div>
        <div class="chat-footer">
            <form action="/segment" method="post" enctype="multipart/form-data">
                <input type="file" name="image"/>
                <button type="submit">분석 요청</button>
            </form>

            <c:if test="${not empty resultImage}">
                <h3>분석 결과</h3>
                <img src="data:image/png;base64,${resultImage}" style="width: 512px;" />
            </c:if>

            <h3>기본 이미지</h3>
            <img src="/image/result.png" style="width: 200px;" />
        </div>
    </div>
</body>
</html>
