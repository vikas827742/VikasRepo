<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color: red;text-align: center;">Employee Registration Form</h1>

<form:form modelAttribute="empForm">
  <table border="1" bgcolor="cyan" align="center">
    <tr>
      <td>Employee No ::</td>
      <td><form:input path="empNo"/></td>
    </tr>
    <tr>
      <td>Employee Name ::</td>
      <td><form:input path="empName"/></td>
    </tr>
    <tr>
      <td>Employee Job ::</td>
      <td><form:input path="job"/></td>
    </tr>
    <tr>
      <td>Employee MGR ::</td>
      <td><form:input path="mgr"/></td>
    </tr>
    <tr>
      <td>Employee HireDate ::</td>
      <td><form:input path="hireDate"/></td>
    </tr>
    <tr>
      <td>Employee Salary ::</td>
      <td><form:input path="sal"/></td>
    </tr>
    <tr>
      <td>Employee Commission ::</td>
      <td><form:input path="comm"/></td>
    </tr>
    <tr>
      <td>Employee DeptNo ::</td>
      <td><form:input path="deptNo"/></td>
    </tr>
    <tr>
      <td><form:hidden path="vflag"/></td>
      <td><input type="submit" value="Register"/></td>
    </tr>
  </table>
</form:form>