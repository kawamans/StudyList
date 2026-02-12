<?php require '../header.php'; ?>
商品を入力してください。
<form action="sql-injection-output.php" method="post">
    <input type="text" name="keyword">
    <input type="submit" value="検索">
</form>
<?php require '../footer.php'; ?>
<!-- sql injection code = 'or' '1'= '1 -->