# Sử dụng image Java chính thức
FROM openjdk:17-jdk-slim

# Tạo thư mục chứa ứng dụng
WORKDIR /app

# Copy file JAR vào container
COPY target/3tshop-0.0.1-SNAPSHOT.jar app.jar

# Cấu hình lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
