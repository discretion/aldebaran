<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="robots" content="noindex, nofollow">
    <meta name="author" content="Benjamin Hung">
    <title>Authenticate</title>
  </head>
  <body>
    <header>
    </header>
    <section>
    <!-- #script# connect to database, store connection as $db -->
    <?php
    //session_start();
    $dbhost = 'localhost';
    $dbuser = 'bdhung';
    $dbpass = 'KASp10AtKjhRZ3Nd';
    $dbdatabase = 'bdhung';
    $db = new mysqli($dbhost, $dbuser, $dbpass, $dbdatabase);
    if (mysqli_connect_errno())
      //exit('Connect failed: '. mysqli_connect_error());
      exit('Error');
    ?>
    <!-- #script# check for logout request, logged-in cookie, form submission-->
    <?php
    if (isset($_POST['logout'])) {
      $ip = $_SERVER['REMOTE_ADDR'];
      $stmt = $db->prepare('SELECT UserID FROM AuthLogEntry WHERE IP LIKE INET_ATON(?)');
      $stmt->bind_param('s', $ip);
      $stmt->execute();
      $stmt->bind_result($userid1);
      while ($stmt->fetch()) {
        $userid2 = $userid1;
      }
      $type = "logout";
      $stmt = $db->prepare('INSERT INTO AuthLogEntry (UserID, IP, EventType) VALUES (?, INET_ATON(?), ?)');
      $stmt->bind_param('iss', $userid2, $ip, $type);
      $stmt->execute();
      $stmt->close();
      setcookie('hunged', $_COOKIE['hunged'], 1);
      echo "You have been logged out.";
    }
    elseif (isset($_COOKIE['hunged'])) {
      $ip = $_SERVER['REMOTE_ADDR'];
      //echo $ip;
      $stmt = $db->prepare('SELECT UserID FROM AuthLogEntry WHERE IP LIKE INET_ATON(?)');
      $stmt->bind_param('s', $ip);
      $stmt->execute();
      $stmt->bind_result($userid1);
      while ($stmt->fetch()) {
        $userid2 = $userid1;
      }
      //echo $userid2;
      $stmt = $db->prepare('SELECT Username FROM USER WHERE UserID=?');
      $stmt->bind_param('i', $userid2);
      $stmt->execute();
      $stmt->bind_result($username1);
      while ($stmt->fetch()) {
        $username2 = $username1;
      }
      echo "Welcome, ".$username2."!";
      $loggedin = true;
    ?>
    <form action="#" method="POST" id="logout">
      <button type="submit" name="logout" id="logout">Log Out</button>
    </form>
    <?php
    }
    elseif (isset($_GET['username'])) {
      $submitted = true;
      $query = htmlentities($_GET['username']);
      //$select = ;
      //echo $query;
      $stmt = $db->prepare("SELECT UserID, Password FROM USER WHERE Username=?");
      $stmt->bind_param('s', $query);
      $stmt->execute();
      $stmt->bind_result($useridd, $hash);
      while ($stmt->fetch()) {
        $userid = $useridd;
        $hashed = $hash;
        //echo $hashed;
      }
      //$hashed = '$6$22izF2S79Vy1L/6v$SnSevoMrlfM/vkp5NQtvyG1fQp9oI/1i5IW7MOZKluJZld6urGUZNA8.MKlfW3lj5k7jVZjLs8ldH1fTrRZzJ.';
    }
    else 
      $submitted = false;
    ?>
    <!-- #script# validate login; select p/w algorithm p/w salt & hashed p/w from database by way of username index, salt/hash submitted p/w with the same, compare hashes -->
    <?php
    if ($submitted = true and isset($hashed)) {
      //set variables for login attempt
      $id = htmlentities($_GET['username']);
      $pw = htmlentities($_GET['password']);
      //retrieve algorithm and salt from hashed password
        $elements = explode('$', $hashed);
        //echo $elements[1];
        //echo $elements[2];
        $algorithm = $elements[1];
        $salt = $elements[2];
      //salt & hash submitted password
        $test_hash = crypt($pw, '$'.$algorithm.'$'.$salt.'$');
      //compare hashes
      //if hashes match, print a greeting and present a logout button.
      if ($hashed == $test_hash) {
        setcookie('hunged');
        echo "Welcome, ".$id."!"."<br>";
        $ip = $_SERVER['REMOTE_ADDR'];
        $type = "login";
        $stmt = $db->prepare('INSERT INTO AuthLogEntry (UserID, IP, EventType) VALUES (?, INET_ATON(?), ?)');
        $stmt->bind_param('iss', $userid, $ip, $type);
        $stmt->execute();
        $stmt->close();
        ?>
            <form action="#" method="POST" id="logout">
              <button type="submit" name="logout" id="logout">Log Out</button>
            </form>
        <?php
        //echo $pw."<br>";
        //echo $elements[1]."<br>";
        //echo $elements[2]."<br>";
        //echo $test_hash."<br>";
        //echo $hashed;
        //present a logout button
      }
      //if hashes do not match, present login form with message: invalid login.
      else {
        include("/home/bdhung/public_html/cis33/as10/login.php");
        echo "Invalid login."."<br>";
        //echo $pw."<br>";
        //echo $elements[1]."<br>";
        //echo $elements[2]."<br>";
        //echo $test_hash."<br>";
        //echo $hashed;
      }
    }
    elseif ($submitted = true and !isset($hashed) and !isset($loggedin)) {
      include("/home/bdhung/public_html/cis33/as10/login.php");
      echo "Please enter your password.";
    }
    else //if ($submitted = false and $loggedin = false) { //include form
      include("/home/bdhung/public_html/cis33/as10/login.php");
  //  }
    ?>
    <!-- table #script# activity log -->
    <table id="logentries">
      <tr><th>Activity Log</th></tr>
      <?php
      $results = $db->query('SELECT UserID, DateTime, INET_NTOA(IP) AS IP, EventType FROM AuthLogEntry ORDER BY DateTime desc');
      while ($row = $results->fetch_array(MYSQLI_ASSOC)) {
        $userid3 = $row['UserID'];
        $stmt = $db->prepare('SELECT Username FROM USER WHERE UserID=?');
        $stmt->bind_param('i', $userid3);
        $stmt->execute();
        $stmt->bind_result($username1);
        while ($stmt->fetch()) {
          $username2 = $username1;
        }
        if ($row['EventType'] == "create") {
      ?>
      <tr><td><?=$username2." created an account from ".$row['IP']?></td></tr>
      <?php
        }
        elseif ($row['EventType'] == "login") {
      ?>
      <tr><td><?=$username2." logged in from ".$row['IP']?></td></tr>
      <?php
        }
        elseif ($row['EventType'] == "logout") {
      ?>
      <tr><td><?=$username2." logged out from ".$row['IP']?></td></tr>
      <?php
        }
      }
      ?>
    </table>
    </section>
    <footer>
    <!-- Validators go here -->
    </footer>
  </body>
</html>
<!-- Specific Requirements
    Users shall remain logged in until (a) explicitly logging out, or (b) their browser closes the session (i.e. discards session cookies).

    Index page
    You should have at least an index page (named index.php) for your site. Upon visiting the index page:

    If the client is NOT authenticated as a user, present a form with id attribute userauth allowing either login or account creation:

      1. Text input fields with name and id attributes username and password.
      2. A submit button with id attribute login will attempt to log in using th username and password given in the input fields.
        a. Upon receiving a login request, the client shall be brought back to the index page. If the specified username and password were invalid, display the phrase "Invalid username/password. Please try again." somewhere visible on the page.
      3. A submit button with id attribute newuser will bring the client to an account creation page (described below)  .

    Otherwise, if the client IS authenticated as a user:
      1. Include the greeting "Welcome, <username>" somewhere at the top of the page, where <username> is the actual username of the authenticated user.
      2. Present a button with id attribute logout that upon pressing will log the user out and re-display the index page.

    In either case (whether the client is authenticated or not):
      1. Present a table with id attribute logentries.
      2. Each row of the table shall display an activity log entry, as follow:
        a. For account creation events, display the phrase "<username>" created an account from "<ip>", where <username> is the username in question, and <ip> is the IP address from which the user issued the account creation request.
        b. For login events, display the phrase "<username> logged in from <ip>", where <username> is the username in question, and <ip> is the IP address from which the user issued the login request.
        c. For logout events, display the phrase "<username> logged out from <ip>", where <username> is the username in question, and <ip> is the IP address from which the user issued the login request.
      3. Activity log entries shall be displayed in reverse chronological order.
-->