<?php
$user=$_GET['user'];
$pass=$_GET['pass'];
$newpass=$_GET['newpass'];
$conn=new mysqli('localhost','root','123456','wifilocate');
if($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from users where user='{$user}' and pass='{$pass}'";
$result = $conn->query($sql);
if($result->num_rows > 0) {
    $sql="delete from sessions where user='{$user}'";
    $conn2=new mysqli('localhost','root','123456','wifilocate');
    $conn2->query($sql);
    $sql="update users set pass='{$newpass}' where user='{$user}'";
    $conn->query($sql);
    echo "Success";
 } else {
    echo "Username or Password wrong";
}
$conn->close();
?>
