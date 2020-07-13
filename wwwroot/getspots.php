<?php
include "spot.php";
include "ap.php";
$zone = $_GET['zone'];
$conn = new mysqli("localhost","root","123456","wifilocate");
$sql="select * from ap where zone='{$zone}'";
$result = $conn->query($sql);
if($result->num_rows > 0) {
    $nx = 999999;
    $ny = 999999;
    $spots = array();
    $spot = null;
    while($row = $result->fetch_array(MYSQLI_ASSOC)) {
        //echo var_dump($row);
        if($nx!=$row['locx']||$ny!=$row['locy']) {
            $nx=intval($row['locx']);
            $ny=intval($row['locy']);
            //echo var_dump($nx);
            if($spot!=null) array_push($spots,$spot);
            $spot=new spot(array(),$nx,$ny);
        }
        $ap = new ap($row['bssid'],$row['ssid'],$row['strength']);
        array_push($spot->ap,$ap);
    }
    if($spot!=null) array_push($spots,$spot);
    $data = array('data' => $spots);
    echo json_encode($data);
}

?>
