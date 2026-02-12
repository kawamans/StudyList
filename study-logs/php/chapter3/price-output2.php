<?php require '../header.php'; ?>
<?php
    if (isset($_REQUEST['price'], $_REQUEST['count'])){
        $price = htmlspecialchars($_REQUEST['price']);
        $count = htmlspecialchars($_REQUEST['count']);
        define("TAX",1.1);
        echo $price, '円×';
        echo $count, '個＝';
        echo $price * $count * TAX, '円(税込)';
    }
?>
<?php require '../footer.php'; ?>