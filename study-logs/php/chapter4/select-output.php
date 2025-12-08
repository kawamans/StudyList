<?php require '../header.php'; ?>
<?php
    switch ($_REQUEST['seat']) {
        case '指定席':
            echo '追加料金は1,200円です。';
            break;
        case 'グリーン席':
            echo '追加料金は2,500円です。';
            break;
        default:
            echo '追加料金はありません。';
            break;
    }
?>
<?php require '../footer.php'; ?>