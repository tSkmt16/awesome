# Tomcatを使う
FROM tomcat:9-jdk17

# 作業ディレクトリを設定
WORKDIR /usr/local/tomcat/webapps

# ソースコードをコピー (プロジェクトのWEB-INFを含む必要があります)
COPY . .

# コンパイル（必要ならばコンパイル用にJavaのコードをビルド）
RUN javac /usr/local/tomcat/webapps/WEB-INF/classes/Main.java

# Tomcatのポート8080を開放
EXPOSE 8080

# Tomcatを起動
CMD ["catalina.sh", "run"]
