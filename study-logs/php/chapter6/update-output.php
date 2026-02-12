<?php require '../header.php'; ?>
<?php
    $pdo=new PDO('mysql:host=localhost;dbname=shop;charset=utf8', 'staff', 'password');
    $sql=$pdo->prepare('update product set name=?, price=? where id=?');
    if (empty($_REQUEST['name'])) {
        echo '商品名を入力してください。';
        echo '<p>商品番号【', $_REQUEST['id'], '】<br>商品名「', $_REQUEST['name'], '」<br>価格　￥', $_REQUEST['price'], '</p>';
    } else if (!preg_match('/^[0-9]+$/', $_REQUEST['price'])) {
        echo '価格を整数で入力してください。';
        echo '<p>商品番号【', $_REQUEST['id'], '】<br>商品名「', $_REQUEST['name'], '」<br>価格　￥', $_REQUEST['price'], '</p>';
    } else 
    if ($sql->execute([htmlspecialchars($_REQUEST['name']), $_REQUEST['price'], $_REQUEST['id']])) {
        echo '更新に成功しました。';
        echo '<p>商品番号【', $_REQUEST['id'], '】<br>商品名「', $_REQUEST['name'], '」<br>価格　￥', $_REQUEST['price'], '</p>';
    } else {
        echo '更新に失敗しました。';
        echo '<p>商品番号【', $_REQUEST['id'], '】<br>商品名「', $_REQUEST['name'], '」<br>価格　￥', $_REQUEST['price'], '</p>';
    }
?>
<?php require '../footer.php'; ?>