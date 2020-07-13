<?php
$uuid = $_GET['uuid'];
$user = $_GET['user'];
$pass = $_GET['pass'];
$phone = $_GET['phone'];
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
if ($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from sessions where uuid='{$uuid}'";

$result = $conn->query($sql);
if ($result->num_rows > 0) {
    $userarr = $result->fetch_array(MYSQLI_ASSOC);
    $olduser = $userarr['user'];
    $sql = "select * from users where user='{$user}'";
    $r2 = $conn->query($sql);
    if($r2->num_rows!=0) {
        $sql = "delete from sessions where uuid='{$uuid}'";
        $conn2 = new mysqli('localhost', 'root', '123456', 'wifilocate');
        $conn2->query($sql);
        $sql = "delete from users where user='{$olduser}'";
        $conn->query($sql);
        $sql = "insert into users(user,pass,phone) values('{$user}','{$pass}','{$phone}')";
        $conn->query($sql);
        echo "Success";
    }
    else {
        echo "Username exists!";
    }
} else {
    echo "uuid is invalid";
}
$conn->close();

