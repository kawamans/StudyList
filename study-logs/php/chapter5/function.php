<?php
function sum(){//()内に引数
    //ここに処理
    return;// 戻り値
}
?>

<?php
function name() {
    echo 'おはようございます。<br>';
}
name();
?>

<?php
function name2($name) {
    echo 'おはようございます';
    echo $name;
    echo 'さん。<br>';
}
name2('アンパンマン');
?>

<?php
function name3($num1, $num2) {
    $ans = $num1 * $num2;
    return $ans;
}
echo name3(5,5);
?>

<?php
function rd($num3) {
    $ran = rand(1,100);
    return $num3 * $ran;
}
echo rd(1);
?>