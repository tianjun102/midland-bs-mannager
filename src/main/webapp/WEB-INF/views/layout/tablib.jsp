<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    response.setHeader("X-Frame-Options", "SAMEORIGIN");
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Pragma","no-cache");
    response.setHeader("Expires","0");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<head>
    <link rel="stylesheet" href="${ctx }/assets/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx }/assets/css/easydropdown.css" />
    <script type="text/javascript" src="${ctx}/assets/scripts/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/scripts/jquery.easydropdown.js" ></script>
    <script type="text/javascript" src="${ctx}/assets/scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/assets/scripts/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx}/assets/scripts/common.js"></script>
    <script type="text/javascript" src="${ctx}/assets/scripts/base.js" ></script>
</head>

<c:set var="ctx" value="${pageContext['request'].contextPath}"/>