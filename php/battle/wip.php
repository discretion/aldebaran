<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="robots" content="noindex, nofollow">
      <meta name="author" content="Benjamin Hung">
      <title>Assignment 5, CIS33, Benjamin Hung</title>

      <!-- <link type='text/css' rel="stylesheet" href= -->
    </head>
    <body>
      Test page for PHP classes, functions, constructors
      <div>
      <?php
            class Dog {
            public $numlegs = 4;
            public $name;
            function Dog($name) {
             $this->name = $name;
            }
            function bark() {
                echo "Arf!";
            }
            function greet() {
                echo "Shmrrshmrr!";
            }
        }

        $shmorky = new Dog("Shmorky");
        $poopie = new Dog("poopie");
        $shmorky->bark();
        ?>
      <?php
       function Player($name) {
       return $name;
       }
      echo Player("Cutty");
      ?>
      
      </div>


      <div>
      <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
      &nbsp;&nbsp;
      <a href="http://jigsaw.w3.org/css-validator/check/referer">Valid CSS</a>
      </div>
    </body>
</html>