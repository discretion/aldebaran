<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="robots" content="noindex, nofollow">
    <meta name="author" content="Benjamin Hung">
    <title>Create a New Account</title>
  </head>
  <body>
    <header>
    </header>
    <section>
    <!-- Check whether user has been authenticated; if not, present this form. -->
    <?php
    $dbhost = 'localhost';
    $dbuser = 'bdhung';
    $dbpass = 'KASp10AtKjhRZ3Nd';
    $dbdatabase = 'bdhung';
    $db = new mysqli($dbhost, $dbuser, $dbpass, $dbdatabase);
    if (mysqli_connect_errno()) {
      //exit('Connect failed: '. mysqli_connect_error());
      exit('Error');
    }
    if (isset($_GET['username']) and isset($_GET['password']) and isset($_GET['password_repeat'])) {
      $username = $_GET['username'];
      $password = $_GET['password'];
      $password_repeat = $_GET['password_repeat'];
      echo $username, $password, $password_repeat;
      if (strlen($username) > 11 and strlen($username) < 64) {
        if (strlen($password) >= 12) {
          if ($password == $password_repeat) {
            $stmt = $db->prepare("SELECT Username FROM USER WHERE Username=?");
            $stmt->bind_param('s', $username);
            $stmt->execute();
            $stmt->bind_result($name);
            while ($stmt->fetch()) {
              $dbusername = $name;
            if ($username != $dbusername) {
              //salt and hash
              $salt = substr(base64_encode(mcrpyt_create_iv(24, MCRYPT_DEV_URANDOM)), 0, 16);
              $hashed = crypt($pw, '$6$'.salt.'$');
              //store in db
              $stmt = $db->prepare('INSERT INTO USER (Username, Password) VALUES (?, ?)');
              $stmt->bind_param('ss', $username, $password);
              $stmt->execute();
              $stmt->close();
              //display success
            }
            //else include form w/ username availability message
          }
          //else include form w/ password matching requirement
        }
        //else include form w/ password requirement
      }
      //else include form w/ username requirement
    }
    //else include form w/o messages
    ?>
      <form action="#" method="GET" id="newuserform">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="password" name="password_repeat">
        <button type="submit" id="login">Authenticate</button>
      </form>
    </section>
    <footer>
    <!-- Validators go here -->
    </footer>
  </body>
</html>