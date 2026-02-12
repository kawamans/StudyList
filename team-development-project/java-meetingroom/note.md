## トータル Gitlog集計用コード
git log --numstat --pretty="format:AUTHOR:%aN" -- . ":(exclude).settings" ":(exclude).classpath" ":(exclude)Docs" ":(exclude)WEB-INF" ":(exclude)README.md" ":(exclude).mailmap" ":(exclude)note.md" ":(exclude).gitignore" | awk '
/^AUTHOR:/ {
    name = substr($0, 8);
    commits[name]++;
    next;
}
NF==3 {
    plus[name] += $1;
    minus[name] += $2;
}
END {
    for (name in commits) {
        printf "%-15s %-10d %-10d %-10d %-10d\n", name, commits[name], plus[name], minus[name], plus[name]-minus[name];
    }
}' | sort -k5 -nr | awk 'BEGIN {printf "%-15s %-10s %-10s %-10s %-10s\n", "User", "Commit", "Add", "Del", "Total"; print "-------------------------------------------------------------"} {print}'

## 個別 Gitlog集計用コード
git log --author="ユーザー名" --numstat --pretty="%H" -- . ":(exclude).settings" ":(exclude).classpath" ":(exclude)Docs" ":(exclude)WEB-INF" ":(exclude)README.md" ":(exclude).mailmap" ":(exclude)note.md" ":(exclude).gitignore" | awk -v user="$name" 'NF==1{c++} NF==3{a+=$1; d+=$2} END {printf "User: %s | Commit:%d | Add:%d | Del:%d | Total:%d\n", user, c, a, d, a-d}'

## Gitlog 関数化コード
function stats() {
    name=$1
    git log --author="$name" --numstat --pretty="%H" -- . ":(exclude).settings" ":(exclude).classpath" ":(exclude)Docs" ":(exclude)WEB-INF" ":(exclude)README.md" ":(exclude).mailmap" ":(exclude)note.md" ":(exclude).gitignore" | awk -v user="$name" 'NF==1{c++} NF==3{a+=$1; d+=$2} END {printf "User: %s | Commit:%d | Add:%d | Del:%d | Total:%d\n", user, c, a, d, a-d}'
}
### 使い方
 - 集計 stats ユーザー名
 - 変更 上書き
 - 定義内容の確認 type stats
 - 関数の削除 unset -f stats
 - notepad ~/.bashrc 関数固定

## TotalGitlog関数
function team_stats() {
    git log --numstat --pretty="format:AUTHOR:%aN" -- . \
        ":(exclude).settings" \
        ":(exclude).classpath" \
        ":(exclude)Docs" \
        ":(exclude)WEB-INF" \
        ":(exclude)README.md" \
        ":(exclude).mailmap" \
        ":(exclude)note.md" \
        ":(exclude).gitignore" | \
    awk '
    /^AUTHOR:/ {
        name = substr($0, 8);
        commits[name]++;
        next;
    }
    NF==3 {
        plus[name] += $1;
        minus[name] += $2;
    }
    END {
        for (name in commits) {
            printf "%-15s %-10d %-10d %-10d %-10d\n", name, commits[name], plus[name], minus[name], plus[name]-minus[name];
        }
    }' | sort -k5 -nr | awk 'BEGIN {printf "%-15s %-10s %-10s %-10s %-10s\n", "User", "Commit", "Add", "Del", "Total"; print "-------------------------------------------------------------" } {print}'
}

