<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="robots" content="noindex, nofollow">
      <meta name="author" content="Benjamin Hung">
      <title>Assignment 5, CIS33, Benjamin Hung</title>
      <style>
        .P1 img {
          -webkit-transform: rotateY(180deg);
          transform: rotateY(180deg);
        }
      </style>
      <!-- <link type='text/css' rel="stylesheet" href= -->
    </head>
    <body id="hijeff">
      <div>
      <?php
      /*
      TODO
      ===============================
      Build the initial state:
      Hook up the constructor with the inputs from the form page; given name, initial hp (randomized)
      Randomly choose which of the two will attack first (initiative function?)
      Display the characters with their -normal images, as well as the given names
      ===============================
      In each attack round, repeatedly:
      Simulate each of the two players taking turns attacking the $other (while loop; counter++; $initiative determines order)
      Attacker deducts random HP from defender in range [1, maxattack]
      Display HP in <span id="roundXp1hp"> or <span id="roundXp1hp">, where X is the number of the attack round (starting at 1).
      Depict the attacker thusly: If the attacker has not defeated the defender following the attack, use the -attack image. Otherwise, use the -victory image. (conditional)
      --Depict the defender thusly: If the defender has died, use the -dead image. If the defender has 5 or fewer HP remaining after attack, use -weak image. Otherwise use the -defend image.
      --Use descriptive alt attributes for the images.

      After the battle, have the script announce the victor: "Victory for X"

      ===============================
      while loop for attack round:
      while ($Player1->getHP() > 0) || ($Player2->getHP() > 0) {
        
      }
      


      */
        //Initiative: Use array shuffle?
        function Initiative() {
          global $first;
          global $second;
          $first = rand(0, 1);
          if ($first == 0) {
            $second = 1;
          }
          //elseif ($first != 0);
            //$second = 0
        }
        //function Grab() {
        //}
        //Grab();

        class Player {
          protected static $characters = array('Cecil', 'Edge', 'Kain', 'Rosa', 'Rydia');
          protected $name, $char;
          public $hp, $status, $attack;
          protected $maxattack;

          function Player($name) {
          $this->char = Player::$characters[rand(0, count(Player::$characters)-1)];
          $this->name = $name;
          $this->hp = rand(($_GET['maxhp'] / 2), $_GET['maxhp']);
          $this->maxattack = rand(0,$_GET['maxattack']);
          //Create an array to describe the three states; healthy, weak, dead
          $this->status = "Normal";
          global $maxhp; 
          return $maxhp = $_GET['maxhp'];
          global $maxmaxattack; 
          return $maxmaxattack = $_GET['maxattack'];
          //echo $maxmaxattack;
          }

          /**
          * Attacks the other character, updating the respective HP and status.
          */
          function attack($other) {
          $this->attack = rand(1,$this->getPOW());
//          echo $other->getHP();
          $other->hp -= $this->attack;
          //echo $this->getName()." attacks ".$other->getName()." for ".$attack."HP";
          $other->getStatus();
          if ($other->getStatus() != "dead") {
            $this->status = "attack";
          }
          else $this->status = "victory";
          }

          function getHP() {
            if ($this->hp < 0)
              return 0;
            else
              return $this->hp;
          }

          function getStatus() {
            if ($this->getHP() > 5) {
              return $this->status = "normal";
            }
            elseif ($this->getHP() < 1) {
              return $this->status = "dead";
            }
            elseif ($this->getHP() < 5) {
              return $this->status = "weak";
            }

          }

          function getPOW() {
            return $this->maxattack;
          }
          function getName() {
            return $this->name;
          }
          function getChar() {
            return $this->char;
          }
          /** Returns an img tag representing the current state of this player */
          function getImg() {
          return "<img src=\"http://jeff.cis.cabrillo.edu/~jbergamini/33data/ff/$this->char-$this->status.gif\" alt=\"$this->name: $this->status\">";
          } 
        }

        $Player1 = new Player($_GET['p1']);
        $Player2 = new Player($_GET['p2']);
        echo "<br>".$Player1->getName()." as ".$Player1->getChar();
        echo $Player1->getHP();
        //HP: ".$Player1->getHP()." Power: ";
        echo "<br>".$Player2->getName()." as ".$Player2->getChar();
        echo $Player2->getHP();
        // HP: ".$Player2->ready()." Power: ";
        echo "<br> <br>";
        
        $round = 1;

        $coin = rand(0, 1);
        if ($coin == 0) {
          do {
            $Player1->attack($Player2);
            //$Player1->getStatus();
            //$Player1->getStatus($Player2);
            //$Player2->getStatus();
            //if ($Player2->getHP() > 0)
            //  $Player1->status = "attack";
            //else 
            //  $Player1->status = "victory";
            echo '<span id=\'round'.$round.'p1hp\'> <span class="P1">'.$Player1->getImg().$Player1->getHP()."HP </span></span>";
        
          //echo $Player1->getName()." attacks ".$Player2->getName()." for ".$Player1->$attack."HP";
          echo '<span id=\'round'.$round.'p2hp\'> '.$Player2->getImg().$Player2->getHP()."HP</span>";
  
          echo "<br> <br> <br>";
  
          $round++;

          //$Player1->getStatus();
          //var_dump($Player1);
          //$Player2->getStatus();
          if ($Player2->getHP() > 0) {
          $Player2->attack($Player1);
          echo '<span id=\'round'.$round.'p1hp\'> <span class="P1">'.$Player1->getImg().$Player1->getHP()."HP </span></span>";
          echo '<span id=\'round'.$round.'p2hp\'> '.$Player2->getImg().$Player2->getHP()."HP</span>";
          }

          $round++;

          echo "<br> <br> <br>";
          //if ($Player1->getHP() < 1) {
          //echo "win!"
          //}
          } while ($Player1->getHP() > 0 && $Player2->getHP() > 0);

        if ($Player1->getHP() < 1) {
          echo "Victory for ".$Player2->getName()."!";
        }
        elseif ($Player2->getHP() < 1) {
          echo "Victory for ".$Player1->getName()."!";
        }

        }
        //elseif ($coin = 1) {

        //}

        
        
        

        //echo $Player1->hp;
        //echo "<br> <br>";
        //var_dump($Player1);
      ?>

      </div>
      <div>
      <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
      </div>
    </body>
</html>