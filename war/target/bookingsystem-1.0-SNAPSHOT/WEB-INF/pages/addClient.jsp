<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <META http-equiv="contentType" content="text/html;charset=UTF-8">
    <meta http-equiv="Content-Language" content="pl">
    <title>Add Message to DB</title>
</head>
<body>
<stripes:form beanclass="pl.bookingsystem.action.AddClientActionBean">
    <stripes:errors globalErrorsOnly="true"/>
    <table>
        <tr>
            <td><stripes:label for="client.name"/>:</td>
            <td><stripes:text name="client.name"/></td>
            <td><stripes:errors field="client.name"/></td>
        </tr>
    </table>
    <c:choose>
        <%--@elvariable id="actionBean" type="pl.bookingsystem.action.AddClientActionBean"--%>
        <c:when test="${actionBean.client.id > 0}">
            <stripes:hidden name="client.name" value="client.name"/>
        </c:when>
        <c:otherwise>
                   <span>No Clients!</span>
        </c:otherwise>
    </c:choose>
    <stripes:submit name="save" value="Save"/>
</stripes:form>
</body>
</html>