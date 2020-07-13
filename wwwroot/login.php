<?php
$user=$_GET['user'];
$pass=$_GET['pass'];
$conn=new mysqli('localhost','root','123456','wifilocate');
if($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from users where user='{$user}' and pass='{$pass}'";
$result = $conn->query($sql);
if($result->num_rows > 0) {
    $chars = md5(uniqid(mt_rand(), true));  
    $uuid = substr ( $chars, 0, 8 ) . '-'
            . substr ( $chars, 8, 4 ) . '-' 
            . substr ( $chars, 12, 4 ) . '-'
            . substr ( $chars, 16, 4 ) . '-'
            . substr ( $chars, 20, 12 );  
    echo $uuid;  
    $sql="delete from sessions where user='{$user}'";
    $conn->query($sql);
    $sql="insert into sessions(user,uuid) values('{$user}','{$uuid}')";
    $conn->query($sql);
 } else {
    echo "Username or Password wrong";
}
$conn->close();
?>
