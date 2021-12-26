<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
  %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/design.css">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Image processing result</title>
</head>
<body>
  <h2>${requestScope.message}</h2>
   <h3>${requestScope.Path}</h2>
<div id="page">
<div id="logo">Image Processing</div>
<div id="wtf">Processing of JPEG/PNG photos.</div>

<div id="content">
<script src="advertise.js"></script>
<script src="al2.js"></script>
<h1>Image processing result</h1>

<span style="color: green;"><b>OK, processing completed successfully!</b></span>
<br><br>Original image size: 800x800, 55.02 KB<br>Size after processing: <b>800x800</b>, <b>101.25 KB</b>
<br><br>Result file name: <b>filename</b><br><br>
<a href="<%=request.getContextPath()%>/download?req=open"><b>Open processed image</b></a><br><br>
<a href="<%=request.getContextPath()%>/download?req=download"><b>Download processed image</b></a><br><br>
<a href="<%=request.getContextPath()%>/download?req=reuse"><b>Reuse processed image</b></a><br><br>
<a href="<%=request.getContextPath()%>/download?req=back"><b>Go back</b></a><br><br><br><span style="font-size:12px;color:#4F4F4F;">Processing time: 0.21 sec.</span>

</div>

<div id="pf"><a href="">Contact</a> | <a href="">Site map, limitations</a> 
<div id="co">&copy; 2018 www.pickpamphlet.com</div>
</div>
</div>
</body>
</html>



