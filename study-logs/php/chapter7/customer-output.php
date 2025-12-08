<?php session_start(); ?>
<?php require '../header.php'; ?>
<?php require 'menu.php'; ?>
<?php
    $pdo=new PDO('mysql:host=localhost;dbname=shop;charset=utf8','staff', 'password');
    if (isset($_SESSION['customer'])) { //ログインしていればTRUE
        $id = $_SESSION['customer']['id'];
        //カラムloginのデータ属性はユニーク、ログインユーザーID以外でloginに被りが無いか確認
        $sql = $pdo->prepare('select * from customer where id!=? and login=?'); 
        $sql->execute([$id, $_REQUEST['login']]);
    } else { //ログインしていなければFALSE
        //カラムloginはユニーク属性、loginに被りが無いか確認
        $sql = $pdo->prepare('select * from customer where login=?');
        $sql->execute([$_REQUEST['login']]);
    }
    if (empty($sql->fetchAll())) { //fetchALLは$sql内のクエリ文の空を出力、emptyは空であればTRUE
        if (isset($_SESSION['customer'])) { //ログインしている既存ユーザーを処理
            $sql=$pdo->prepare('update customer set name=?, '.'address=?, login=?, password=? where id=?');
            $sql->execute([
                $_REQUEST['name'], $_REQUEST['address'],
                $_REQUEST['login'], $_REQUEST['password'], $id
            ]);
            $_SESSION['customer'] = [ //更新したユーザー情報をsessionに代入
                'id'=>$id, 'name'=>$_REQUEST['name'],
                'address'=>$_REQUEST['address'], 'login'=>$_REQUEST['login'],
                'password'=>$_REQUEST['password']
            ];
            echo 'お客様情報を更新しました。';
        } else { //ログインしていない新規ユーザーを処理
            $sql=$pdo->prepare('insert into customer values(null, ?, ?, ?, ?)');
            $sql->execute([$_REQUEST['name'], $_REQUEST['address'], $_REQUEST['login'], $_REQUEST['password']]);
            echo 'お客様情報を登録しました。';
        }
    } else { //$sql->fetchALLでloginの値に被りがあると処理
        echo 'ログイン名がすでに使用されていますので、変更してください。';
    }
?>
<?php require '../footer.php'; ?>