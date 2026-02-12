<?php require '../header.php'; ?>
<p>商品の色と個数を選択してください。</p>
<form action="select-foreach-output.php" method="post">
    <select name="color">
        <?php
            $color = ['ホワイト', 'ブルー', 'レッド', 'イエロー', 'ブラック', 'ピンク'];
            // []を使うのはarrayの短縮形
            // $color = array('ホワイト', 'ブルー', 'レッド', 'イエロー', 'ブラック');
            foreach ($color as $c) {
                echo '<option value="', $c ,'">', $c, '</option>';
            }
            ?>
    </select>
    <select name="count">
        <?php
            for ($i = 1; $i <= 10; $i++) {
                echo '<option value="', $i, '">', $i, '</option>';
            }
        ?>
    </select>
    <?php
        echo '個';
    ?>
    <p><input type="submit" value="確定"></p>
</form>
<?php require '../footer.php'; ?>