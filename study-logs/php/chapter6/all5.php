<?php require '../header.php'; ?>
<!-- borderはCSS時に削除 -->
<table border="1">
    <tr>
        <th>商品番号</th>
        <th>商品名</th>
        <th>価格</th>
    </tr>
    <?php
    $pdo=new PDO('mysql:host=localhost;dbname=shop;charset=utf8', 'staff', 'password');
    function h($html) {
        return htmlspecialchars($html);
    }
    foreach ($pdo->query('select * from product') as $row) {
        echo '<tr>';
            echo '<td>', h($row['id']), '</td>';
            echo '<td>', h($row['name']), '</td>';
            echo '<td>', h($row['price']), '</td>';
        echo '</tr>';
        echo "\n";
    }
    ?>
</table>
<?php require '../footer.php'; ?>