<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <title>List of all messages in DB</title>
</head>
<body>
<stripes:form beanclass="pl.bookingsystem.action.AddMessageActionBean">
    <stripes:submit name="addMessage" value="Add message"/>
    <table>
        <tr>
            <td><stripes:label for="message.text"/></td>
        </tr>
        <c:forEach var="message" items="${actionBean.messages}">
            <tr>
                <td>${message.value.text}</td>
                <td>
                    <stripes:link href="/addMessage.action" event="edit">Edit <stripes:param name="message.id"
                                                                                             value="${message.value.id}"/></stripes:link>
                </td>
                <td>
                    <stripes:link href="/addMessage.action" event="delete">Delete<stripes:param name="message.id"
                                                                                                value="${message.value.id}"/></stripes:link>
                </td>
            </tr>
        </c:forEach>
    </table>
</stripes:form>
</body>
</html>