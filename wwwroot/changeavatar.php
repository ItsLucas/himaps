<?php
$path = "./avatars/";
$user = $_POST['user'];
$uuid = $_POST['uuid'];
$server_name = $path.$user.".png";
if($_FILES['photo']['error']>0) {
    die("Unexpected error".$_FILES['photo']['error']);
}
$sql = "select * from sessions where uuid='{$uuid}' and user = '{$user}'";
$conn = new mysqli('localhost', 'root', '123456', 'wifilocate');
$result = $conn->query($sql);
if($result->num_rows>0) {
    if (move_uploaded_file($_FILES['photo']['tmp_name'], $server_name)) {
        echo "Success";
        $sql = "delete from avatars where user = '{$user}'";
        $conn->query($sql);
        $sql = "insert into avatars(user,imgpath) values('{$user}','{$server_name}')";
        $conn->query($sql);
    } else {
        echo "Upload failed";
    }
}
else {
    echo "Unauthorized";
}
?>
