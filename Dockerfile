# JDK 17の公式イメージ
FROM eclipse-temurin:17-jdk

# 作業ディレクトリを設定
WORKDIR /app

# ソースコードをすべてコピー
COPY . .

# Javaファイルのコンパイル
RUN javac Main.java

# ポート8080を開放
EXPOSE 8080

# アプリケーションの起動
CMD ["java", "WelcomeServlet"]