<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AIMedia</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="container">
		<div class="navBar">
			<button class="upload-btn">Upload</button>
			<div class="view-options">
				<select id="view-mode">
					<option value="list">List</option>
					<option value="large-icon">Large Icon</option>
					<option value="ai-view">AI View</option>
				</select> <select id="view-detail-mode">
					<option value="none">None</option>
					<option value="preview">Preview</option>
					<option value="details">Details</option>
				</select>
			</div>
			<div class = "storage">
				<div class="storage__bar">
					<div class="storage__bar--used"></div>
				</div>
				<button class="folder-btn">Open Folder</button>
			</div>
			<div class="account">acc</div>
		</div>
		<div class="content">
			<div class="file-list" id="fileListSection">
				<table>
					<thead>
						<tr>
							<th>No.</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < 10; i++) {
							out.print("<tr>");
							out.print("<td>" + i + "</td>");
							out.print("<td> File name </td>");
							out.print("</tr>");
						}
						%>
					</tbody>
				</table>
			</div>
			<div class="detail-sidebar" id="details-section">

				<div class="details">None</div>
			</div>
		</div>
	</div>

	<script src="script.js"></script>
</body>
</html>
