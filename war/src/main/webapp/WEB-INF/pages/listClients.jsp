<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>

<stripes:form action="/add">
    <stripes:submit name="addClient" value="Add message"/>
    <%--@elvariable id="actionBean" type="pl.bookingsystem.db.dao.impl.ClientDAOImpl"--%>
    <table>
        <tr>
            <td><stripes:label for="client.name"/></td>
        </tr>

        <p>Client0: ${actionBean.clients[0].name}</p>

        <c:forEach var="client" items="${actionBean.clients}">
            <tr>
                <td>${client.name}</td>
                <td>
                    <stripes:link beanclass="pl.bookingsystem.action.AddClientActionBean">
                        Edit
                        <stripes:param name="client.name" value="${client.name}"/>
                    </stripes:link>
                </td>
            </tr>
        </c:forEach>
    </table>
</stripes:form>
