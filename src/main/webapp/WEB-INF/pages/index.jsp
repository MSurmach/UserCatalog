<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <link href="<c:url value="/res/styles/index.css"/>" rel="stylesheet" type="text/css">
    <title>User Catalog</title>
</head>
<body>
<div id="header_place">
    <h1>User Catalog</h1>
</div>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>
                    <a href="/seeFullUserDescription/${user.id}">
                        <img src="/res/icons/icons8-more-details-128.png" alt="Extra" width="30" height="30">
                    </a>
                    <a href="/editUser/${user.id}">
                        <img src="/res/icons/icons8-edit-64.png" alt="Edit" width="30" height="30">
                    </a>
                    <a href="/deleteUser/${user.id}">
                        <img src="/res/icons/icons8-delete-bin-100.png" alt="Delete" width="30" height="30">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<div id="addLink">
    <img src="/res/icons/icons8-add-property-80.png" width="30" height="30">
    <a href="/addUser">Add new user</a>
</div>
</body>
</html>