<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
 <title>CIS 33 Assignment 1 </title>
 <link rel="stylesheet" href="css/index.css" type="text/css">
</head>
<body>
<article>
 <h1>Welcome to CIS 33!</h1>

 <p>The current time (Unix) is: <?php 
 echo date('Y-m-d H:i:s'); 
 ?></p>
 <p>Your IP Address: <?php 
 echo $_SERVER['REMOTE_ADDR']; 
 ?></p>

</article>
<footer>
 <div>
 <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
<!--  &nbsp;&nbsp;
<a href="http://jigsaw.w3.org/css-validator/check/referer">Valid CSS</a> -->
 </div>
</footer>
</body>
</html>