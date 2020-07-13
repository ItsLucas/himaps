<?php
//$zone=$_GET['zone'];
//$locx=$_GET['locx'];
//$locy=$_GET['locy'];
//$bssid=$_GET['bssid'];
//$ssid=$_GET['ssid'];
//$strength=$_GET['strength'];
$user = $_GET['user'];
$pass = $_GET['pass'];
$phone = $_GET['phone'];
$flag = mysqli_connect('localhost', 'root', '123456', 'wifilocate');
$conn = "select * from users where user='{$user}';";
//echo $conn;
//$conn = "insert into ap(zone,locx,locy,bssid,ssid,strength) values('{$zone}','{$locx}','{$locy}','{$bssid}','{$ssid}','{$strength}')";
$result = mysqli_query($flag, $conn);
//echo $result->num_rows();
//echo $result->num_rows . "\n";
if ($result->num_rows > 0) {
    echo "User exists!";
} else {
    $conn = "insert into users(user,pass,phone) values('{$user}','{$pass}','{$phone}');";
    mysqli_query($flag, $conn);
//echo $conn;
    echo "Success";
}
//echo "Success";
?>
