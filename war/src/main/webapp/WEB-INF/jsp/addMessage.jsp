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
<stripes:form action="/addBook.action">
    <stripes:errors globalErrorsOnly="true"/>
    <table>
        <tr>
            <td><stripes:label for="message.text"/>:</td>
            <td><stripes:text name="message.text"></stripes:text></td>
            <td><stripes:errors field="message.text"/></td>
        </tr>
        <tr>
            <td><stripes:label for="message.author"/>:</td>
            <td><stripes:text name="message.author"></stripes:text></td>
            <td><stripes:errors field="message.author"/></td>
        </tr>
    </table>
    <c:choose>
        <c:when test="${actionBean.message.id > 0}">
            <stripes:hidden name="message.id" value="message.id"></stripes:hidden>
        </c:when>
        <c:otherwise></c:otherwise>
    </c:choose>
    <stripes:submit name="save" value="Save"/>
</stripes:form>
</body>
</html>