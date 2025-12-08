<?php require '../header.php'; ?>
<?php
function typ($i) {
    if ($i >= 150) {
        if ($i >= 200) {
            if ($i >= 250) {
                echo '「', $i, '」達人！';
            } else {
            echo '「', $i, '」絶好調！';
            }
        } else {
            echo '「', $i, '」良いね！';
        }
    } else {
        if ($i >= 100) {
            echo '「', $i, '」もっと頑張ろう！';
        } else {
            echo '「', $i, '」練習が足りない！';
        }
    }
    return ;
}
$typing = $_REQUEST['typing'];
typ($typing);
?>

<?php
function tp($j) {
    if ($j >= 150) {
        if ($j >= 200) {
            $price = 3;
        } else {
            $price = 2;
        }
    } else {
        if ($j >= 100) {
            $price = 1;
        } else {
            $price = 0;
        }
    }
    return $price;
}
$typing = $_REQUEST['typing'];
$hyouka = ['だめだめ', 'いまいち', '良いね', '絶好調'];
$p = tp($typing);
echo '<p>「', $typing, '」', $hyouka[$p], '</p>';

?>
<?php require '../footer.php'; ?>