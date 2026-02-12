<?php session_start(); ?>
<?php
echo 'ようこそ、', $_SESSION['customer']['name'], 'さん。';
echo '<br />';
echo '顧客番号は「', $_SESSION['customer']['id'], '」になります。';
?>