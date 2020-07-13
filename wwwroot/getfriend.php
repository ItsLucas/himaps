<?php
include "friend.php";
$user = $_GET['user'];
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
if ($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from friends where user='{$user}'";

$result = $conn->query($sql);
if($result->num_rows > 0) {
    $friends = array();
    $friend = null;
    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
        $name = $row['friend'];
        $sql2 = "select * from users where user='{$name}'";
        $r2 = $conn->query($sql2);
        $row2=$r2->fetch_array(MYSQLI_ASSOC);
        $friend = new friend($name,$row2['phone']);
        array_push($friends,$friend);
    }
    $data = array('data' => $friends);
    echo json_encode($data);
}
