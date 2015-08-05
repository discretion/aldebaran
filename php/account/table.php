    <table id="logentries">
      <tr><th>Activity Log</th></tr>
      <?php
      $results = $db->query('SELECT UserID, DateTime, INET_NTOA(IPaddress) AS IP, EventType FROM AuthLogEntry ORDER BY DateTime desc');
      while ($row = $results->fetch_array(MYSQLI_ASSOC)) {
        $stmt = $db->prepare('SELECT Username FROM USER WHERE UserID=?');
        $stmt->bind_param('i', $userid2);
        $stmt->execute();
        $stmt->bind_result($username1);
        while ($stmt->fetch()) {
          $username2 = $username1;
        }
        if ($row['EventType'] == "create") {
      ?>
      <tr><td><?=$username2."created an account from".$row['IP']?></td></tr>
      <?php
        }
        elseif ($row['EventType'] == "login") {
      ?>
      <tr><td><?=$username2."logged in from".$row['IP']?></td></tr>
      <?php
        }
        elseif ($row['EventType'] == "logout") {
      ?>
      <tr><td><?=$username2."logged out from".$row['IP']?></td></tr>
      <?php
        }
      }
      ?>
    </table>