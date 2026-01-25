### タスク進捗
| ﾒﾝﾊﾞｰ | jsp | 進捗率 | 処理1 | 進捗率 | 処理2 | 進捗率 | 特定作業 | 進捗率 |
| :--- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | 
| 川満 | user | 90% | extra(J) | 95% | user(S) | 90% | DAO(J) | 95% |
| 猪本 | roomDel | 95% | service(J) | 90% | roomAdd(S) | 90% | CSS(M) | 80% |
| 谷田 | roomAdd | 95% | DAO(J) | ―% | roomDel(S) | 90% | test | - |
| 飯田 | cancel | 95% | cancel(S) | 95% | roomDel(S) | 90% | test | - |
| 山崎 | login | 95% | login(S) | 95% | test | - | - | - |
| 石坂 | reserv | 95% | reserv(S) | 95% | roomAdd(S) | 90% | test | image |

``` diff
java-meetingroom/ ✅ 🟡 🔴
├── DB/                         # DB関連 ✅ 100% (谷田/川満)
│   ├── database.sql            # テーブル定義
│   └── testdsata.sql           # テスト用データ
└── src/main/
    ├── java/jp/co/seminar/
        ├── bean/               # [Model] ✅ 100% (川満/猪本)
+       │   ├── AppException.java
+       │   ├── MeetingRoom.java
+       │   ├── ExtraMR.java
+       │   ├── LoginUserBean.java
+       │   ├── UserBean.java
+       │   ├── RoomBean.java
+       │   └── ReservationBean.java
        ├── dao/                # [Model] ✅ 100% (川満)
+       │   ├── ReservationDao.java
+       │   ├── RoomDao.java
+       │   ├── UserDao.java
+       │   └── TestMain.java
        ├── filter/             # 共通処理 ✅ 100% (川満/猪本)
+       │   ├── EncodingFilter.java
+       │   ├── LoginUrlFilter.java
+       │   └── SessionFilter.java
        ├── servlet/main/       # [Controller] 🟡 90% (山崎)
+       │   ├── ChangeDateServlet.java  # 山﨑 $
+       │   ├── LoginServlet.java  # 山﨑 $
+       │   └── LogoutServlet.java  # 山﨑 $
        ├── servlet/meetingRoom/# [Controller] 🟡 90% (飯田/谷田)
+       │   ├── CreateAddMeetingRoom.java  # 山﨑 $
+       │   ├── CreateMeetingRoom.java  # 山﨑 $
+       │   ├── DeleteAddMeetingRoom.java  # 山﨑 $
+       │   └── DeleteMeetingRoom.java  # 山﨑 $
        ├── servlet/reservation/# [Controller] 🟡 95% (飯田/石坂)
+       │   ├── CancelCreateServlet.java  # 山﨑 $
+       │   ├── CancelServlet.java  # 山﨑 $
+       │   ├── ReserveCreateServlet.java  # 山﨑 $
+       │   └── ReserveServlet.java  # 山﨑 $
        ├── servlet/user/       # [Controller] 🟡 90% (川満)
+       │   ├── CreateAddUserServlet.java
+       │   ├── CreateUserServlet.java
+       │   ├── DeleteAddUserServlet.java
+       │   ├── DeleteUserServlet.java
+       │   ├── UpdateAddUserServlet.java
+       │   └── UpdateUserServlet.java
        └── util/               # 共通DB接続 ✅ 100% (川満)
+           ├── DatabaseConfig.java
+           └── DatabaseConnection.java
    └── webapp/
+       ├── css/style.css       # CSSデザイン 🟡 90% (猪本)
        └── jsp/                # [View] 画面表示
+           ├── login.jsp       # ログイン    🟡 95% (山崎)
+           ├── menu.jsp        # メニュー    🟡 95% (山崎)
            ├── cancel/         # 予約取消    🟡 95% (飯田)
+           │   ├── cancelConfirm.jsp
+           │   ├── cancelError.jsp
+           │   ├── cancelInput.jsp
+           │   └── canceled.jsp
            ├── includeFile/    # 共通部品 ✅ 100% (猪本/石坂)
+           │   └── includeUserName.jsp
            ├── meetingRoom/    # 会議室管理 🟡 90% (猪本/石坂)
+           │   ├── meetingRoomCompletion.jsp
+           │   ├── meetingRoomConfirm.jsp
+           │   ├── meetingRoomDelete.jsp
+           │   ├── meetingRoomError.jsp
+           │   └── meetingRoomInput.jsp
            ├── reservation/    # 予約登録    🟡 95% (石坂)
+           │   ├── reserveConfirm.jsp
+           │   ├── reserveError.jsp
+           │   ├── reserveInput.jsp
+           │   └── reserved.jsp
            └── userSituation/  # ユーザ管理  🟡 90% (川満)
+               ├── userCompletion.jsp
+               ├── userConfirm.jsp
+               ├── userCreate.jsp
+               ├── userDelete.jsp
+               ├── userError.jsp
+               └── userUpdate.jsp
```

### 1. kawamitsu
| Date | Commit | 追加 | 削除 | 合計差分 | 増加数 |
| :--- | ---: | ---: | ---: | ---: | ---: |
| 1/15 | 29 | 1931 | 370 | 1561 | - |
| 1/16 | 32 | 2173 | 588 | 1585 | 24 |
| 1/17 | - | - | - | - | - |
| 1/18 | - | - | - | - | - |
| 1/19 | 38 | 2883 | 852 | 2031 | 446 |
| 1/20 | 42 | 3065 | 887 | 2178 | 147 |
| 1/21 | 51 | 3647 | 1294 | 2353 | 175 |
| 1/22 | 62 | 4285 | 1543 | 2742 | 389 |
| 1/23 | 66 | 4557 | 1704 | 2853 | 111 |
| 1/24 | - | - | - | - | - |
| 1/25 | 67 | 4803 | 1960 | 2843 | -10 |
| 1/26 | - | - | - | - | - |
| 1/27 | - | - | - | - | - |

### 2. inomoto
| Date | Commit | 追加 | 削除 | 合計差分 | 増加数 |
| :--- | ---: | ---: | ---: | ---: | ---: |
| 1/15 | 42 | 2076 | 531 | 1545 | - |
| 1/16 | 46 | 2359 | 675 | 1684 | 139 |
| 1/17 | - | - | - | - | - |
| 1/18 | - | - | - | - | - |
| 1/19 | 54 | 2571 | 823 | 1748 | 64 |
| 1/20 | 69 | 2925 | 1011 | 1914 | 166 |
| 1/21 | 78 | 3133 | 1128 | 2005 | 91 |
| 1/22 | 79 | 3243 | 1203 | 2040 | 35 |
| 1/23 | 79 | 3243 | 1203 | 2040 | 0 |
| 1/24 | - | - | - | - | - |
| 1/25 | - | - | - | - | - |
| 1/26 | - | - | - | - | - |
| 1/27 | - | - | - | - | - |

### 3. tanida
| Date | Commit | 追加 | 削除 | 合計差分 | 増加数 |
| :--- | ---: | ---: | ---: | ---: | ---: |
| 1/15 | 17 | 1045 | 631 | 414 | - |
| 1/16 | - | - | - | - | - |
| 1/17 | - | - | - | - | - |
| 1/18 | - | - | - | - | - |
| 1/19 | 20 | 1187 | 819 | 368 | 46 |
| 1/20 | 27 | 1508 | 992 | 516 | 148 |
| 1/21 | 38 | 1613 | 1099 | 514 | -2 |
| 1/22 | 44 | 1760 | 1233 | 527 | 13 |
| 1/23 | 47 | 1772 | 1260 | 512 | -15 |
| 1/24 | - | - | - | - | - |
| 1/25 | - | - | - | - | - |
| 1/26 | - | - | - | - | - |
| 1/27 | - | - | - | - | - |

### 4. ishizaka
| Date | Commit | 追加 | 削除 | 合計差分 | 増加数 |
| :--- | ---: | ---: | ---: | ---: | ---: |
| 1/15 | 23 | 800 | 417 | 383 | - |
| 1/16 | 28 | 978 | 549 | 429 | 46 |
| 1/17 | - | - | - | - | - |
| 1/18 | - | - | - | - | - |
| 1/19 | 31 | 1097 | 656 | 441 | 12 |
| 1/20 | 39 | 1195 | 730 | 465 | 24 |
| 1/21 | 43 | 1257 | 786 | 471 | 6 |
| 1/22 | 47 | 1281 | 801 | 480 | 9 |
| 1/23 | 48 | 1287 | 803 | 484 | 4 |
| 1/24 | - | - | - | - | - |
| 1/25 | - | - | - | - | - |
| 1/26 | - | - | - | - | - |
| 1/27 | - | - | - | - | - |

### 5. ida
| Date | Commit | 追加 | 削除 | 合計差分 | 増加数 |
| :--- | ---: | ---: | ---: | ---: | ---: |
| 1/15 | 25 | 703 | 341 | 362 | - |
| 1/16 | 29 | 785 | 403 | 382 | 20 |
| 1/17 | - | - | - | - | - |
| 1/18 | - | - | - | - | - |
| 1/19 | - | - | - | - | - |
| 1/20 | 35 | 870 | 458 | 412 | 30 |
| 1/21 | 40 | 944 | 521 | 423 | 11 |
| 1/22 | 45 | 962 | 529 | 433 | 10 |
| 1/23 | 47 | 970 | 562 | 408 | -25 |
| 1/24 | - | - | - | - | - |
| 1/25 | - | - | - | - | - |
| 1/26 | - | - | - | - | - |
| 1/27 | - | - | - | - | - |

### 6. yamazaki
| Date | Commit | 追加 | 削除 | 合計差分 | 増加数 |
| :--- | ---: | ---: | ---: | ---: | ---: |
| 1/15 | 21 | 483 | 212 | 271 | - |
| 1/16 | 23 | 785 | 224 | 291 | 20 |
| 1/17 | - | - | - | - | - |
| 1/18 | - | - | - | - | - |
| 1/19 | 25 | 587 | 268 | 319 | 28 |
| 1/20 | 30 | 691 | 313 | 378 | 59 |
| 1/21 | 34 | 737 | 363 | 374 | -4 |
| 1/22 | 51 | 743 | 381 | 362 | -12 |
| 1/23 | 58 | 767 | 421 | 346 | -16 |
| 1/24 | - | - | - | - | - |
| 1/25 | - | - | - | - | - |
| 1/26 | - | - | - | - | - |
| 1/27 | - | - | - | - | - |
