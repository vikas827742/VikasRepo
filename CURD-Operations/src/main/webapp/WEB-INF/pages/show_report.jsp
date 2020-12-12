<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: blue;text-align: center">Employee Information Record</h1>

<c:choose>
  <c:when test="${empList ne null && !empty empList }">
    <table align="center" border="1">
      <tr>
        <th>Serial No.</th>
        <th>EMPNO</th>
        <th>EMPNAME</th>
        <th>JOB</th>
        <th>MGR</th>
        <th>HIREDATE</th>
        <th>SALARY</th>
        <th>COMMISSION</th>
        <th>DEPTNO</th>
        <th>Gross Salary</th>
        <th>Net Salary</th>
        <th>Operations</th>
      </tr>
      <c:forEach var="dto" items="${empList }">
        <tr>
          <td>${dto.serialNo }</td>
          <td>${dto.empNo }</td>
          <td>${dto.empName }</td>
          <td>${dto.job }</td>
          <td>${dto.mgr }</td>
          <td>${dto.hireDate }</td>
          <td>${dto.sal }</td>
          <td>${dto.comm }</td>
          <td>${dto.deptNo }</td>
          <td>${dto.grossSal }</td>
          <td>${dto.netSal }</td>
          <td>
            <a href="editEmp.htm?empNo=${dto.empNo }"><img src="images/edit.png" width="50" height="50" border="1"/></a>
            <a href="deleteEmp.htm?empNo=${dto.empNo }" onclick="CONFIRM('are you sure to delete ${dto.empName}')"><img src="images/delete.jpg" width="50" height="50" border="1"/></a>
          </td>        
        </tr>
      </c:forEach>          
    </table>
  </c:when>
  <c:otherwise>
    <h1 style="color: blue;text-align: center">Records are not found......!!</h1>
  </c:otherwise>
</c:choose>


<br><br><br>

<c:if test="${resultMsg ne null && !empty resultMsg }">
  <marquee dir="rtl"><h1 style="color: blue;text-align: center">${resultMsg }</h1></marquee>
</c:if>

<center> <h2><a href="saveEmp.htm"><img src="images/add.jpg" width="50" height="50"/></a> 
    &nbsp; &nbsp;<a href="welcome.htm"><img src="images/home.gif" width="50" height="50"/></a>
    &nbsp; &nbsp;<a  href="JavaScript:doPrint()"><img src="images/print.jpg" width="50" height="50"></a>
</h2> </center>



<script lang="JavaScript">
  function doPrint(){
	  frames.focus();
	  frames.print();
  }
</script>