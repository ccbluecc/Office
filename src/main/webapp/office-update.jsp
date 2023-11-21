<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: nitro5
  Date: 13/11/2566
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-info">
        <h2>Update Offices :: Code ${offices.officeCode}</h2>
    </div>
    <hr>
    <c:if test="${error ne null}">
        <div class="text-danger">${error}</div>
    </c:if>
    <form class="row g-3" method="post" action="office-update">
        <div class="col-md-6">
            <label for="inputCountry" class="form-label">Country<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputCountry" name="country" value="${offices.country}" required>
        </div>
        <div class="col-md-6">
            <label for="inputCity" class="form-label">City<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputCity" name="city" value="${offices.city}" required>
        </div>
        <div class="col-md-6">
            <label for="inputpostalCode" class="form-label">PostalCode<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputpostalCode" name="postalCode"
                   value="${offices.postalCode}" required>
        </div>
        <div class="col-md-6">
            <label for="inputState" class="form-label">State</label>
            <input type="text" class="form-control" id="inputState" name="state" value="${offices.state}">
        </div>
        <div class="col-md-6">
            <label for="inputAddress1" class="form-label">Address 1<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputAddress1" name="addressLine1"
                   value="${offices.addressLine1}" required>
        </div>
        <div class="col-md-6">
            <label for="inputAddress2" class="form-label">Address 2</label>
            <input type="text" class="form-control" id="inputAddress2" name="addressLine2"
                   value="${offices.addressLine2}">
        </div>
        <div class="col-md-6">
            <label for="inputphone" class="form-label">Phone<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputphone" name="phone" value="${offices.phone}"
                   required>
        </div>
        <div class="col-md-6">
            <label for="inputterritory" class="form-label">Territory<sup class="text-danger">*</sup></label>
            <input type="text" class="form-control" id="inputterritory" name="territory"
                   value="${offices.territory}" required>
        </div>
        <div class="col-12">
            <input type="hidden" name="officeCode" value="${offices.officeCode}">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
</body>
</html>

