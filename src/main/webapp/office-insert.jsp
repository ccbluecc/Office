<%--
  Created by IntelliJ IDEA.
  User: nitro5
  Date: 8/11/2566
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-info">
        <h2>Insert Offices ::</h2>
    </div><hr>
    <form class="row g-3" method="post" action="office-insert">
        <c:if test="${error ne null}">
            <div class="text-danger">${error}</div>
        </c:if>
        <div class="col-md-6">
            <label for="inputCountry" class="form-label">Country<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputCountry" name="country" required>
        </div>
        <div class="col-md-6">
            <label for="inputCity" class="form-label">City<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputCity" name="city" required>
        </div>
        <div class="col-md-6">
            <label for="inputpostalCode" class="form-label">PostalCode<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputpostalCode" name="postalCode" required>
        </div>
        <div class="col-md-6">
            <label for="inputState" class="form-label">State</label>
            <input type="text" class="form-control" id="inputState" name="state">
        </div>
        <div class="col-md-6">
            <label for="inputAddress1" class="form-label">Address 1<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputAddress1" name="addressLine1" required>
        </div>
        <div class="col-md-6">
            <label for="inputAddress2" class="form-label">Address 2</label>
            <input type="text" class="form-control" id="inputAddress2" name="addressLine2">
        </div>
        <div class="col-md-6">
            <label for="inputphone" class="form-label">Phone<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputphone" name="phone" required>
        </div>
        <div class="col-md-6">
            <label for="inputterritory" class="form-label">Territory<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputterritory" name="territory" required>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
