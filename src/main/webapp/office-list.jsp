<%--
  Created by IntelliJ IDEA.
  User: nitro5
  Date: 7/11/2566
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        a {
            background-color: transparent;
            padding: 14px 25px;
            text-decoration: none;
            display: inline-block;
        }

        .black {
            color: #000000 !important;
        }
    </style>
</head>
<body>
<div class="container-md">
    <div class="row bg-info align-items-center">
        <div class="col-6">
            <h2>Classic Model Offices ::</h2>
        </div>
        <div class="col-6 text-end">
            <form action="office-insert" method="get" class="d-inline">
                <button type="submit" class="btn btn-primary">Insert</button>
            </form>
        </div>
    </div>
    <form action="office-list" method="get">
        <hr>
        <label for="cityOrCountry">Search By City Or Country:</label>
        <div class="input-group mb-3">
            <input type="text" id="cityOrCountry" name="cityOrCountry" value="" placeholder="City Or Country"
                   class="input-group-text">
            <button type="submit" class="btn btn-outline-primary" id="button-addon2">Search</button>
        </div>
    </form>
    <c:if test="${error ne null}">
        <div class="text-danger">${error}</div>
    </c:if>
    <c:if test="${errorCityOrCountry != null}">
        <div class="alert alert-danger mt-3">${errorCityOrCountry}</div>
    </c:if>
    <c:if test="${errorCityOrCountry == null}">
    </c:if>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2 ${office.officeCode == selectedOffice.officeCode ? 'bg-info' : ''}">
                <a href="office-list?officeCode=${office.officeCode}" class="text-primary black">
                    <div>
                            ${office.city}, ${office.country}
                    </div>
                    <div>${office.phone}</div>
                    <div class="d-flex justify-content-end mt-2">
                        <form action="office-update" method="get">
                            <input type="hidden" name="officeCode" value="${office.officeCode}">
                            <button type="submit" class="btn btn-outline-primary me-2">Update</button>
                        </form>
                        <form action="office-delete" method="post">
                            <input type="hidden" name="officeCode" value="${office.officeCode}">
                            <button type="submit" class="btn btn-outline-primary">Delete</button>
                        </form>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-6">
            <c:forEach items="${offices}" var="office">
                <c:if test="${office.officeCode eq selectedOffice.officeCode}">
                    <div class="card mt-3">
                        <div class="card-body">
                            <h5 class="card-title">Office Detail</h5>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><strong>Office Code:</strong> ${office.officeCode}</li>
                                <li class="list-group-item"><strong>City:</strong> ${office.city}</li>
                                <li class="list-group-item"><strong>Country:</strong> ${office.country}</li>
                                <li class="list-group-item"><strong>Address Line 1:</strong> ${office.addressLine1}</li>
                                <li class="list-group-item"><strong>Address Line 2:</strong> ${office.addressLine2}</li>
                                <li class="list-group-item"><strong>Postal Code:</strong> ${office.postalCode}</li>
                                <li class="list-group-item"><strong>Phone:</strong> ${office.phone}</li>
                                <li class="list-group-item"><strong>State:</strong> ${office.state}</li>
                                <li class="list-group-item"><strong>Territory:</strong> ${office.territory}</li>
                            </ul>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <hr>
    <div class="row bg-light">
        <b>Employees ::</b><br>
    </div>
    <div class="row">
        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="col-md-2 mb-2">
                <div class="card border-secondary">
                    <div class="card-body">
                        <h6 class="card-title">${employee.firstName} ${employee.lastName}</h6>
                        <p class="card-text">${employee.jobTitle}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>




