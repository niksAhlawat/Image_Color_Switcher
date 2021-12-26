<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html "about:legacy-compat" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">
        <script class="jsbin" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
       <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
        <script src="js/bootstrap.min.js"></script>   
        <script type="text/javascript">
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah')
                        .attr('src', e.target.result)
                        .width(600)
                        .height(600);
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
        </script>
    </head>
    <body> 
    <header>   
    <div class="container">    
      <div class="row">
      <div class="col-lg-5 col-md-5 col-sm-5 col-xs-12">
      <div style="">
      
      
      <img id="blah" src="img/3.jpg" class="img-responsive img-rounded" style="height:600px; width:auto;">
      </div>
      </div>
      <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
      <div style="">
      <h2 style="text-align:center; letter-spacing:2px; word-spacing:3px; margin-bottom:20px; border-bottom:1px #868686 solid; color:#9d051d; padding-bottom:10px;"><strong>To Replace Colors In An Image</strong></h2>
     
     
      <form action="dochange" method="post" enctype="multipart/form-data">
	 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
   
       <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Specify Image In Format (JPG, PNG)</label>
         <input type="file" name="file" id="file" accept="image/gif, image/jpeg, image/png" onchange="readURL(this);" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">  
      </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; width:100%; font-size:16px;"><strong>From Color</strong></label>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Select By Color</label>
      <select name="oldcolor" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      <option value="#ff0000" style="background-color:#FF0000;">red</option>
      <option value="#e518e3" style="background-color:#e518e3;">pink</option>
      <option value="#9a18e5" style="background-color:#9a18e5;">purple</option>
      <option value="#0000ff" style="background-color:#0000ff;">blue</option>
      <option value="#1fabdf" style="background-color:#1fabdf;">turquoise</option>
      <option value="#7fc7ff" style="background-color:#7fc7ff;">light-blue</option>
      <option value="#99ff99" style="background-color:#99ff99;">light-green</option>
      <option value="#1ae829" style="background-color:#1ae829;" selected="selected">green</option>
      <option value="#fde307" style="background-color:#fde307;">yellow</option>
      <option value="#ff8c00" style="background-color:#ff8c00;">orange</option>
      </select>
     
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Or In RGB Format</label>
      <input type="text" placeholder="eg: 111,123,498" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      <!--<select style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      <option>0,0,0</option>
      <option>255,255,255</option>
      </select>-->
      </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; width:100%; font-size:16px;"><strong>To Color</strong></label>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Select By Color</label>
     
      <select name="newcolor" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      <option value="#ff0000" style="background-color:#FF0000;" selected="selected">red</option>
      <option value="#e518e3" style="background-color:#e518e3;">pink</option>
      <option value="#9a18e5" style="background-color:#9a18e5;">purple</option>
      <option value="#0000ff" style="background-color:#0000ff;">blue</option>
      <option value="#1fabdf" style="background-color:#1fabdf;">turquoise</option>
      <option value="#7fc7ff" style="background-color:#7fc7ff;">light-blue</option>
      <option value="#99ff99" style="background-color:#99ff99;">light-green</option>
      <option value="#1ae829" style="background-color:#1ae829;">green</option>
      <option value="#fde307" style="background-color:#fde307;">yellow</option>
      <option value="#ff8c00" style="background-color:#ff8c00;">orange</option>
      <option value="#000000">black</option>
      <option value="#f3f3f3">grey</option>
      <option value="#ffffff" style="background-color:#ffffff;">white</option>
      </select>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Or In RGB Format</label>
      <input type="color"  name="newcolor1" value="#004080" style="width:100%; border:1px #ccc solid; background:none; min-height:35px;">
      <!--<select style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      <option>0,0,0</option>
      <option>255,255,255</option>
      </select>-->
      </div>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Color Intensity</label>
      <input type="number" name="intensity" placeholder="0" value="25" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      </div>
      </div>
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Gain Of Replaced Color</label>
      <input type="number" name="gain" placeholder="0" value="50" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <label style="letter-spacing:1px; word-spacing:2px; margin-bottom:10px; color:#666666;">Smoothing Of Sharp Color Transitions</label>
      <input type="number" name="transitions" placeholder="0" value="5" style="width:100%; padding:8px; border:1px #ccc solid; margin-bottom:20px;">
      </div>
      </div>
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
      <input type="submit" value="Change Color" style="width:100%; text-align:center; text-transform:uppercase; padding:8px; margin-bottom:20px; border:none; background:#9d051d; color:#FFFFFF; letter-spacing:2px; word-spacing:2px;">
     
      </div>
      </div>
	   </form>
      </div>
      </div>
      </div>
      </div>
      </header>  
    </body>
</html>