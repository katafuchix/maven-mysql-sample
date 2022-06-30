package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {

	    public static void main(String[] args) {
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            // データベース接続
	            conn = DriverManager.getConnection(
	                    // ホスト名、データベース名
	                    "jdbc:mysql://localhost:3306/bbs_development",
	                    // ユーザー名
	                    "root",
	                    // パスワード
	                    "");

	            // SQL文をセット
	            stmt = conn.prepareStatement("SELECT * FROM users");
	            // SQL文を実行
	            rs = stmt.executeQuery();

	            // ループして1レコードずつ取得
	            while (rs.next()) {
	                String id      = rs.getString("id");
	                String name    = rs.getString("name");

	                System.out.println(id + "、" + name );
	            }

	        } catch (SQLException e) {
	            System.out.println("データベース接続エラー。");

	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                System.out.println("データベース接続エラー。");
	            }
	        }
	    }
}
