<?php
$user = $_GET['user'];
$x = $_GET['x'];
$y = $_GET['y'];
$vzone = $_GET['vzone'];
$vanish = $_GET['vanish'];
$uuid = $_GET['uuid'];
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
if ($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from sessions where uuid='{$uuid}'";

$result = $conn->query($sql);
if ($result->num_rows > 0) {
    $sql = "select * from locations where user='{$user}'";
    $result = $conn->query($sql);
    if($result->num_rows > 0) {
        $sql = "update locations set locx='{$x}',locy='{$y}',vzoneid='{$vzone}',vanish='{$vanish}' where locations.user='{$user}'";
        $conn->query($sql);
        echo "Success";
    }
    else {
        $sql = "insert into locations(user,locx,locy,vzoneid,vanish) values('{$user}','{$x}','{$y}','{$vzone}','{$vanish}')";
        $conn->query($sql);
        echo "Success";
    }
} else {
    echo "uuid is invalid";
}
$conn->close();

