<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
 <meta name="robots" content="noindex, nofollow">
 <meta name="author" content="Benjamin Hung">
 <title>Snake Eyes! Ben Hung's CIS33 Ass. 4</title>
</head>
<body>
<?php
class SixSidedDie {
  // Variables
  protected $currentValue = -1;
  // Functions
  function SixSidedDie() {
  $this->currentValue = -1;
  }
  function roll() {
  $this->currentValue = rand(1,6);
  }
  function getValue() {
  return $this->currentValue;
  }
}
?>

<!-- dice pair follows -->
<?php
class DicePair {
 // Variables
  protected $die1;
  protected $die2;
  //protected $snakeeyes;
  protected $value1;
  protected $value2;
  //protected $url1;
  //protected $url2;
 // Functions
  function DicePair() {
    $this->die1 = new SixSidedDie();
    $this->die2 = new SixSidedDie();
  }
  function roll() {
    return $this->die1->roll();
    return $this->die2->roll();
  }
// Rewrite so they actually call the appropriate urls.
  function getDie() {
    return $this->die1->getValue();
    return $this->die2->getValue();
  }
  function getImageURL() {
    echo 'http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0'.$this->die1.'.png';
    echo 'http://jeff.cis.cabrillo.edu/~jbergamini/33data/dice/die_0'.$this->die2.'.png';
  }
  function isSnakeEyes() {
    $value1 = $this->die1->getValue();
    $value2 = $this->die2->getValue();
   if ($value1 + $value2) == 2) {
    true;
   } else {
    false;
   }
  }
}
?>
 
 <?php 
  $round = 1;
  $dice = new DicePair();
//while ($round <100) {
  do {
  	echo "<section id=\"round$round\">";
  	echo '<h2>Roll ' . $round . '</h2>';
    // $dice_roll = $dice->roll();
    // Report what happened:
    echo '$dice->getImageURL()';
  	echo '</section>';
  	echo '<br>';
    echo $dice->isSnakeEyes();
    $round ++;
  } while ($round < 100);
  	echo "<section id=\"round$round\">";
  	echo '<h2>Roll ' . $round . '</h2>';
    $dice->roll();
    // Report what happened:
    echo '$dice->getImageURL()';
  	echo '</section>';
  }
//}
 ?>

 <h1 id="total"><?= $round ?> total rolls!</h1>

 <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
</body>
</html>