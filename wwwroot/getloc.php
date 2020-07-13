<?php
include "userloc.php";
$vzone = $_GET['vzone'];
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
if ($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from locations where vzoneid='{$vzone}'";

$result = $conn->query($sql);
if($result->num_rows > 0) {
    $nx = 999999;
    $ny = 999999;
    $users = array();
    $user = null;
    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
        if(boolval($row['vanish'])!=true) {
            $user = new userloc($row['user'], floatval($row['locx']), floatval($row['locy']));
            array_push($users, $user);
        }
        else {
            $user = new userloc($row['user'], 0, 0);
            array_push($users, $user);
        }
    }
    $data = array('data' => $users);
    echo json_encode($data);
}
