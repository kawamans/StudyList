<?php require '../header.php'; ?>
<?php
    date_default_timezone_set('japan');
    echo '<p>', date('Y/m/d H:i:s'), '</p>';
    echo '<p>', date('Y年m月d日 H時i分s秒'), '</p>';
?>
<?php
    $fruits = ["lemon", "orange", "banana", "apple"];
    sort($fruits);
    foreach ($fruits as $key => $val) {
        echo "<p>fruits[", $key, "] = ", $val, "</p>";
    }
?>
<?php
    $fruit = ['レモン' => 100, 'オレンジ' => 200, 'バナナ' => 150,'りんご' => 120, '桃' => 300];
    ksort($fruit);
    foreach ($fruit as $frt => $price) {
        echo '<p>', $frt,'＝', $price, '円</p>';
        echo $sum = $sum + $price, $i++;
    }
    echo '<p>', $sum, $sum/$i, '</p>';
?>
<?php require '../footer.php'; ?>
