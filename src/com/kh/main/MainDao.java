package com.kh.main;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.board.model.vo.Board;
import com.kh.member.model.dao.MemberDao;
import com.kh.notification.model.vo.Notification;

public class MainDao {

   private Properties prop = new Properties();
   
   public MainDao() {
      
      String fileName = MemberDao.class.getResource("/com/kh/sql/main-query.properties").getPath();
      fileName=fileName.replace("WEB-INF/classes/", "");
      try {
         prop.load(new FileReader(fileName));
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }

   public ArrayList<Notification> select5Notification(Connection conn) {
      ArrayList<Notification> list=new ArrayList<>();
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql=prop.getProperty("select5Notification");
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()) {
            list.add(new Notification(
                  rs.getInt(1),
                  rs.getInt(2),
                  rs.getString(3),
                  rs.getDate(4)+" "+rs.getTime(4),
                  rs.getDate(5)+" "+rs.getTime(5),
                  rs.getString(6),
                  rs.getInt(7),
                  rs.getString(8),
                  rs.getString(9),
                  rs.getString(10),
                  rs.getString(11),
                  rs.getInt(12),
                  rs.getString(13),
                  rs.getString(14),
                  rs.getString(15)));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(ps);
      }
      
      return list;
   }

   public ArrayList<Notification> select5NotificationEnd(Connection conn) {
      ArrayList<Notification> list=new ArrayList<>();
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql=prop.getProperty("select5NotificationEnd");
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()) {
            list.add(new Notification(
                  rs.getInt(1),
                  rs.getInt(2),
                  rs.getString(3),
                  rs.getDate(4)+" "+rs.getTime(4),
                  rs.getDate(5)+" "+rs.getTime(5),
                  rs.getString(6),
                  rs.getInt(7),
                  rs.getString(8),
                  rs.getString(9),
                  rs.getString(10),
                  rs.getString(11),
                  rs.getInt(12),
                  rs.getString(13),
                  rs.getString(14),
                  rs.getString(15)));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(ps);
      }
      
      return list;
   }

   public ArrayList<Board> select5Project(Connection conn) {
      ArrayList<Board> list=new ArrayList<>();
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql=prop.getProperty("select5Project");
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()) {
            list.add(new Board(
                  rs.getInt("b_no"),
                  rs.getInt("m_no"),
                  rs.getString("nickname"),
                  rs.getString("head"),
                  rs.getString("title"),
                  rs.getString("contents"),
                  rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"),
                  rs.getDate("update_date")+" "+rs.getTime("update_date"),
                  rs.getString("FILE_ORINAME"),
                  rs.getString("time"),
                  rs.getInt("count"),
                  rs.getString("status"),
                  rs.getInt("d_count"),
                  rs.getString("editFile"),
                  rs.getString("path"),
                  rs.getInt("down_count")));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(ps);
      }
      return list;
   }

   public ArrayList<Board> select5Study(Connection conn) {
      ArrayList<Board> list=new ArrayList<>();
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql=prop.getProperty("select5Study");
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()) {
            list.add(new Board(
                  rs.getInt("b_no"),
                  rs.getInt("m_no"),
                  rs.getString("nickname"),
                  rs.getString("head"),
                  rs.getString("title"),
                  rs.getString("contents"),
                  rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"),
                  rs.getDate("update_date")+" "+rs.getTime("update_date"),
                  rs.getString("FILE_ORINAME"),
                  rs.getString("time"),
                  rs.getInt("count"),
                  rs.getString("status"),
                  rs.getInt("d_count"),
                  rs.getString("editFile"),
                  rs.getString("path"),
                  rs.getInt("down_count")));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(ps);
      }
      return list;
   }

   public ArrayList<Board> select5Notice(Connection conn) {
      ArrayList<Board> list=new ArrayList<>();
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql=prop.getProperty("select5Notice");
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()) {
            list.add(new Board(
                  rs.getInt("b_no"),
                  rs.getInt("m_no"),
                  rs.getString("nickname"),
                  rs.getString("head"),
                  rs.getString("title"),
                  rs.getString("contents"),
                  rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"),
                  rs.getDate("update_date")+" "+rs.getTime("update_date"),
                  rs.getString("FILE_ORINAME"),
                  rs.getString("time"),
                  rs.getInt("count"),
                  rs.getString("status"),
                  rs.getInt("d_count"),
                  rs.getString("editFile"),
                  rs.getString("path"),
                  rs.getInt("down_count")));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(ps);
      }
      return list;
   }

   public ArrayList<Board> select5Free(Connection conn) {
      ArrayList<Board> list=new ArrayList<>();
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql=prop.getProperty("select5Free");
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()) {
            list.add(new Board(
                  rs.getInt("b_no"),
                  rs.getInt("m_no"),
                  rs.getString("nickname"),
                  rs.getString("head"),
                  rs.getString("title"),
                  rs.getString("contents"),
                  rs.getDate("enroll_date")+" "+rs.getTime("enroll_date"),
                  rs.getDate("update_date")+" "+rs.getTime("update_date"),
                  rs.getString("FILE_ORINAME"),
                  rs.getString("time"),
                  rs.getInt("count"),
                  rs.getString("status"),
                  rs.getInt("d_count"),
                  rs.getString("editFile"),
                  rs.getString("path"),
                  rs.getInt("down_count")));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(rs);
         close(ps);
      }
      return list;
   }

   public int visit(Connection conn) {
      int result=0;
      PreparedStatement ps=null;
      
      String sql="insert into visit values(sysdate)";
      try {
         ps=conn.prepareStatement(sql);
         result=ps.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(ps);
      }
      return result;
   }

   public int getTotal(Connection conn) {
      int result=0;
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql="select count(*) from visit";
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery(sql);
         if(rs.next()) {
            result=rs.getInt(1);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rs);
      }
      return result;
   }

   public int getToday(Connection conn) {
      int result=0;
      PreparedStatement ps=null;
      ResultSet rs=null;
      
      String sql="SELECT count(*) FROM visit WHERE to_char(vdate,'yyyy-mm-dd')=to_char(SYSDATE,'yyyy-mm-dd')";   
      try {
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery(sql);
         if(rs.next()) {
            result=rs.getInt(1);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rs);
      }
      return result;
   }
}