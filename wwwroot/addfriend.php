<?php
$uuid = $_GET['uuid'];
$user = $_GET['user'];
$friend = $_GET['friend'];
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
if ($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from sessions where uuid='{$uuid}'";

$result = $conn->query($sql);
if ($result->num_rows > 0) {
   $sql = "select * from users where user='{$friend}'";
   $r2 = $conn->query($sql);
   if($r2->num_rows > 0) {
       $sql = "insert into friends(user,friend) values('{$user}','{$friend}')";
       $conn->query($sql);
       echo "Success";
   }
   else {
       echo "No such person";
   }
} else {
    echo "uuid is invalid";
}
$conn->close();

