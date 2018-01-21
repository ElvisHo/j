
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									
								          <span style="color:red;">${login_failed }</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
							    <td valign="middle" align="right">
									验证码:
							   </td>
							    <td>
							    <input name="number" class="inputgri"/><br>
							     <img src="checkcode.do" border="1px" onclick="this.src='checkcode.do?'+Math.random()"/>
							    
							     <span style="color:red;">
							    ${number_error }
							     </span>
							    </td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
				<%@ include file="footer.jsp" %>
			</div>
		</div>
	</body>
</html>
