<?php
$zoneid = $_GET['zoneid'];
$conn = new mysqli("localhost","root","123456","wifilocate");
$sql="select * from zones where zoneid='{$zoneid}'";
$result = $conn->query($sql);
if($result->num_rows > 0) {
    $row = $result->fetch_array(MYSQLI_ASSOC);
    $vzoneid = $row['vzoneid'];
    $sql = "select * from rooms where vzoneid = '{$vzoneid}'";
    $r2 = $conn->query($sql);
    if($r2->num_rows > 0) {
        $row2 = $r2->fetch_array(MYSQLI_ASSOC);
        echo $row2['roomid'];
    }
    else {
        echo "No such room!";
    }
}else {
    echo "No such zone!";
}