


<%--
  Created by IntelliJ IDEA.
  User: nitro5
  Date: 7/11/2566
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row bg-primary">
        <h2>Classic Model Offices ::</h2>
    </div>
    <form action="office-list" method="get"> <hr>
        <label for="cityOrCountry">Search City Or Country:</label>
        <input type="text" id="cityOrCountry" name="cityOrCountry" value="">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2
                ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
                <div>
                    <a href="javascript:loadOffice('${office.officeCode}')">
                            ${office.city}</a>, ${office.country}
                </div>
                <div>${office.phone}</div>
                    <form action="office-delete" method="post">
                        <input type="hidden" name="officeCode" value="${office.officeCode}">
                    <button type="submit" class="btn btn-primary">Delete</button>
                    </form>
                <form action="office-update" method="post">
                    <input type="hidden" name="officeCode" value="${office.officeCode}">
                    <button type="submit" class="btn btn-primary">Update</button>
                </form>
            </div>
        </c:forEach>
    </div>
    <br>
    <div class="row bg-light">
        <b>Employees ::</b>
    </div>
    <div class="row">
        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="col-2 pl-2 m-2 border border-secondary rounded-pill">
                <div> ${employee.firstName}
                        ${employee.lastName} - ${employee.jobTitle}
                </div>
            </div>
        </c:forEach>
    </div>
</div>




