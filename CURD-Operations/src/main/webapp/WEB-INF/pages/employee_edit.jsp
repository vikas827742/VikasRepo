<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color: blue;text-align: center;">Employee Editing Page</h1>

<script lang="JavaScript" src="js/validation.js">
</script>

<form:form action="editEmp.htm" modelAttribute="empForm" onsubmit="return validate(this)">
  <table border="1" bgcolor="pink" align="center">
    <tr>
      <td>Employee No ::</td>
      <td><form:input path="empNo" readonly="true"/><form:errors path="empNo"/><span id="empNoId"></span></td>
    </tr>
    <tr>
      <td>Employee Name ::</td>
      <td><form:input path="ename"/><form:errors path="ename"/><span id="enameId"></span></td>
    </tr>
    <tr>
      <td>Employee Job ::</td>
      <td><form:input path="job"/><form:errors path="job"/><span id="jobId"></span></td>
    </tr>
    <tr>
      <td>Employee MGR ::</td>
      <td><form:input path="mgr"/><form:errors path="mgr"/><span id="mgrId"></span></td>
    </tr>
    <tr>
      <td>Employee HireDate ::</td>
      <td><form:input path="hireDate"/><form:errors path="hireDate"/></span></td>
    </tr>
    <tr>
      <td>Employee Salary ::</td>
      <td><form:input path="sal"/><form:errors path="sal"/><span id="salId"></span></td>
    </tr>
    <tr>
      <td>Employee Commission ::</td>
      <td><form:input path="comm"/><form:errors path="comm"/><span id="commId"></span></td>
    </tr>
    <tr>
      <td>Employee DeptNo ::</td>
      <td><form:select path="deptNo">
                <form:options items="${deptInfo }"/>
              </form:select>
      </td>
    </tr>
    <tr>
      <td><form:hidden path="vflag"/></td>
      <td><input type="submit" value="Update Employee"/></td>
    </tr>
  </table>
</form:form>


<center><a href="welcome.htm"><img src="images/home.gif" width="50" height="50"/></a></center>