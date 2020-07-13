<?php
$user=$_GET['user'];
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
if ($conn->connect_error) {
    die("Failed:" . $conn->connect_error);
}
$sql = "select * from avatars where user='{$user}'";
$file = null;
$result = $conn->query($sql);
if($result->num_rows>0) {
    $row = $result->fetch_array(MYSQLI_ASSOC);
    $file = $row['imgpath'];
}
if (file_exists($file)) {
    header('Content-Description: File Transfer');
    header('Content-Type: application/octet-stream');
    header('Content-Disposition: attachment; filename="'.basename($file).'"');
    header('Expires: 0');
    header('Cache-Control: must-revalidate');
    header('Pragma: public');
    header('Content-Length: ' . filesize($file));
    readfile($file);
    exit;
}
?>