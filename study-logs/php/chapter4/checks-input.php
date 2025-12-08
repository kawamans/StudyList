<?php require '../header.php'; ?>
<p>ご興味のある商品ジャンルを全て選んでください。</p>
<form action="checks-output.php" method="get">
<?php
    $ganre = ['カメラ', 'パソコン', '時計', '家電', '書籍', '文房具', '食品'];
    foreach ($ganre as $item) {
        echo '<p>';
        echo '<input type="checkbox" name="genre[]" value="', $item, '">';
        echo $item;
        echo '</p>';
    }
?>
<p><input type="submit" value="確定"></p>
<?php
    $num = [2,3,4,5,6,7,8,9,11,14,35,78];
    for ($i = 0; $i < count($num); $i++) {
        echo '値を',$i,'取り出す<br>';
    }
?>
</form>
<?php require '../footer.php'; ?>
