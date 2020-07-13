<?php
$zone=$_GET['zone'];
$locx=$_GET['locx'];
$locy=$_GET['locy'];
$bssid=$_GET['bssid'];
$ssid=$_GET['ssid'];
$strength=$_GET['strength'];
$flag=mysqli_connect('localhost','root','123456','wifilocate');
$conn = "insert into ap(zone,locx,locy,bssid,ssid,strength) values('{$zone}','{$locx}','{$locy}','{$bssid}','{$ssid}','{$strength}')";
mysqli_query($flag,$conn);
echo "Success";
?>
