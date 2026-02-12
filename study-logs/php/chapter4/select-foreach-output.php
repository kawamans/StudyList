<?php require '../header.php'; ?>
<?php
    $color = $_REQUEST['color'];
    $count = $_REQUEST['count'];
    if (($count > 0)) {
        echo "<p>商品の色は「{$color}」で、数は「{$count}個」です。</p>";
    } 
?>
<?php require '../footer.php'; ?>