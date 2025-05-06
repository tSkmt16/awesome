# Tomcat 9 と JDK 17の公式イメージを使用
FROM tomcat:9-jdk17

# 作業ディレクトリを設定
WORKDIR /usr/local/tomcat/webapps

# ソースコード（.java ファイル）をコピー
COPY . .

# ソースコードをコンパイル
# -d オプションでコンパイル結果を classes フォルダに出力
RUN javac -d /usr/local/tomcat/webapps/WEB-INF/classes /src/main/java/servlet/*.java

# Tomcat のポート 8080 を開放
EXPOSE 8080

# Tomcat を起動
CMD ["catalina.sh", "run"]
