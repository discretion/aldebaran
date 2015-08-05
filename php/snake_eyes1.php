<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
 <meta name="robots" content="noindex, nofollow">
 <meta name="author" content="Benjamin Hung">
 <title>Snake Eyes! Ben Hung's CIS33 Ass. 3</title>
</head>
<body>
 <!-- define initial variables here. -->
 <?php 
  $round = 1;
  //$total = 1;
  $die_1 = mt_rand(1, 6);
  $die_2 = mt_rand(1, 6);
  $dietotal = $die_1 + $die_2;
 ?>

 <!-- need:
  -A script that randomly generates two separate values between 1 and 6.
  -Display each roll in a <section id=roundX>
  -To make that work, we need a $round.
  -Each roll's section will al.
so display an <h2> with text announcing each roll, again using $round.
  -Roll values shall be displayed with the corresponding die image.
  -An <h1 id="total"> element at the top of the page will announce the total number of rounds.
 -->

 <!-- 
<section id="round{$round}\">
<h2>Round{$round}!</h2>
  	 '<img src=\"http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0' . $die_1 . '.png \" alt="' . $die_1 . '\">' .
  	 '<img src=\"http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0' . $die_2 . '.png \" alt="' . $die_2 . '\">' . 
  	'</section>'
 -->
 <?php
  do {
  	echo "<section id=\"round$round\">";
  	echo '<h2>Roll ' . $round . '</h2>';
  	echo "<img src='http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0$die_1.png' alt='$die_1'>";
  	echo '<img src="http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0' . $die_2 . '.png " alt="' . $die_2 . '">';
  	//echo $die_1 . ' ' . $die_2 . ' dice roll!' . '<br>';
  	echo '</section>';
  	//echo $total . ' total rounds' . '<br>';
  	//echo $dietotal . '<br>';
  	echo '<br>';
  	$die_1 = mt_rand(1, 6);
    $die_2 = mt_rand(1, 6);
    $dietotal = $die_1 + $die_2;
    $round ++;
  } while ($dietotal != 2);
  	echo "<section id=\"round$round\">";
  	echo '<h2>Roll ' . $round . '</h2>';
  	echo "<img src='http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0$die_1.png' alt='$die_1'>";
  	echo '<img src="http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0' . $die_2 . '.png " alt="' . $die_2 . '">';
  	//echo $die_1 . ' ' . $die_2 . ' dice roll!' . '<br>';
  	echo '</section>';
    //echo $die_1 . $die_2 . ' dice roll!' . '<br>';
  	//echo $total . ' total rounds' . '<br>';
  	//echo $dietotal . '<br>';
  	//echo $round . ' current roll'
 ?>

 <h1 id="total"><?= $round ?> total rolls!</h1>

 <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
</body>
</html>