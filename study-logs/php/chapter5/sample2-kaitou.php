<?php require '../header.php'; ?>
<!-- 練習問題
・オリジナル関数を定義してください
・配列numsを関数に引数で渡し、関数内で引数で渡されて中身の偶数のみ画面に表示
・奇数は表示しない -->
<?php
    $nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
    function num($n) {
        foreach ($n as $na) {
            if ($na % 2 == 0) {
                echo '<p>「', $na, '」</p>';
            }
        }
        return ;
    }
    num($nums);
?>
<?php require '../footer.php'; ?>