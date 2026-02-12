<?php require '../header.php'; ?>
<?php
    $muscle = ['腕'=>1, '胸'=>2, '背中'=>3, '腹'=>4, '脚'=>5];
    $randmus = array_rand($muscle);
    echo '今日の筋トレ部位は', $randmus, 'です';
?>
<?php
    $muscle = ['腕', '胸', '背中', '腹', '脚'];
    echo '<p>今日の筋トレ部位は', $muscle[rand(0,4)], 'です</p>';
?>
<?php require '../footer.php'; ?>