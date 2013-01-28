<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="template/header.html" %>

<form class="form-horizontal">
  <div class="control-group">
    <label class="control-label" for="leavingFrom">Leaving From</label>
    <div class="controls">
      <input type="text" id="leavingFrom" placeholder="Leaving From">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="goingTo">Going To</label>
    <div class="controls">
      <input type="text" id="goingTo" placeholder="Going To">
    </div>
  </div>
</form>

<%@include file="template/footer.html" %>
