<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
 <meta name="robots" content="noindex, nofollow">
 <meta name="author" content="Benjamin Hung">
 <title>CIS33 Assignment 2</title>
</head>
<body>
 <!-- generate a random integer and assign it to $number -->
 <?php 
 	$number = mt_rand(0,999);
 ?>
 <!-- display the $number in a div id=number -->
<div id="number">
 <p><?php
  echo "$number";
 ?></p>
</div>

<div id="signs">
 <!-- figure will contain: 
 img element referring to the appropriate small version of the images. 
 A <figcaption> element containing a textual description of the value, "x hundreds" etc. 
 <img> has alt attribute with same text as <figcaption>. 
 <figure> has title attribute with same text as <figcaption>. -->

 <!-- below: declare variables that represent each digit, and define strings to print to the captions -->
 <?php
   $hundreds_0 = "$number"/100;
   $hundreds = floor($hundreds_0);
   $hun_string = '%d hundreds';

   $tens_0 = ("$number" - ("$hundreds" * 100))/10;
   $tens = floor($tens_0);
   $ten_string = '%d tens';

   $ones = "$number" - ("$hundreds" * 100) - ("$tens" * 10);
   $one_string = '%d ones'
  ?> 
 <!-- below: figure for hundreds place, with (dynamically generated): title, img, figcaption -->
 <figure id="hundreds" title="<?php
      echo sprintf("$hun_string", $hundreds);
    ?>">
  <img src="<?php 
  	 echo sprintf("http://jeff.cis.cabrillo.edu/~jbergamini/33data/asl-0-10/us-0" . "$hundreds" . "_sm.png"); 
  	?>" alt="<?php
      echo sprintf("$hun_string", $hundreds);
    ?>">
  <figcaption><?php
  	if("$number">99) {
      echo sprintf("$hun_string", $hundreds);
    }?>
  </figcaption>
 </figure>
<!-- below: figure for tens -->
 <figure id="tens" title="<?php
      echo sprintf("$ten_string", $tens);
    ?>">
  <img src="<?php 
  	 echo sprintf("http://jeff.cis.cabrillo.edu/~jbergamini/33data/asl-0-10/us-0" . "$tens" . "_sm.png"); 
  	?>" alt="<?php
      echo sprintf("$ten_string", $tens);
    ?>">
  <figcaption><?php
  	if("$number">9) {
      echo sprintf("$ten_string", $tens);
    }?>
  </figcaption>
 </figure>

<!-- below: figure for ones -->
 <figure id="ones" title="<?php
      echo sprintf("$one_string", $ones);
    ?>">
  <img src="<?php 
  	 echo sprintf("http://jeff.cis.cabrillo.edu/~jbergamini/33data/asl-0-10/us-0" . "$ones" . "_sm.png"); 
  	?>" alt="<?php
      echo sprintf("$one_string", $ones);
    ?>">
  <figcaption><?php
      echo sprintf("$one_string", $ones);
    ?>
  </figcaption>
 </figure>
<!-- place conditional before figure starts, enclose <figure>. -->
 </div>
 <footer>
  <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
 </footer>
</body>
</html>