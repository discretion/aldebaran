<?php ini_set('display_errors', 1); ?>
<!DOCTYPE html>
<html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="robots" content="noindex, nofollow">
      <meta name="author" content="Benjamin Hung">
      <title>Assignment 8, CIS33, Benjamin Hung</title>

      <!-- <link type='text/css' rel="stylesheet" href= -->
    </head>
    <body>
      <form action="#" method="POST">
        <input type="text" id="comment" name="comment" placeholder="Please type your precious words...">
        <input type="hidden" id="ip" name="ip" value="<?php echo $_SERVER["REMOTE_ADDR"]; ?>">
        <button type="submit">Post</button>
      </form>

      <?php
      $dbhost = 'localhost';
      $dbuser = 'bdhung';
      $dbpass = 'KASp10AtKjhRZ3Nd';
      $dbdatabase = 'bdhung';

      $db = new mysqli($dbhost, $dbuser, $dbpass, $dbdatabase);
      if (mysqli_connect_errno())
        exit('Connect failed: '. mysqli_connect_error());
      ?>
      
      <?php
        if (isset($_POST['comment'])) {
          $comment = $_POST['comment'];
          $ip = $_POST['ip'];
          $stmt = $db->prepare('INSERT INTO as8_Log (comment, IPaddress) VALUES (?, INET_ATON(?))');
          $stmt->bind_param('ss', $comment, $ip);
          $stmt->execute();
          $stmt->close();
        }
      ?>

      <!-- A list of all previous comments posted, in reverse chronological order. Based on Jeff's MovieReview example.-->
      <ul>
      <?php
        $result = $db->query('SELECT commentID, comment, INET_NTOA(IPaddress) AS IP, ts FROM as8_Log ORDER BY commentID DESC');
        while ($row = $result->fetch_array(MYSQLI_ASSOC)) {

      ?>
        <li><?=$row['commentID']?><p><?=strip_tags($row['comment'])?></p><?=$row['IP']?> &nbsp; <?=gethostbyaddr($row['IP'])?> &nbsp; <?=$row['ts']?></li>
      <?php
      }
      ?>
      </ul>

      <div>
      <a href="http://validator.w3.org/check?uri=referer">Valid HTML 5</a>
      </div>
    </body>
</html>

<!-- TODO: reverse chronological order (DESC). hostname gethostbyaddr($row['IP']). html injection strip_tags($row['comment']). -->
<!-- Table was created with this SQL command: CREATE TABLE as8_Log ( commentID INTEGER, comment varchar(256), IPaddress INT UNSIGNED, ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ); -->