package com.microsilver.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * @ 功能描述：读取一个XML文件并将其读取的相关数据插入到数据库中<br>
 * @ author：zhengtao @ version: 1.0
 */
@SuppressWarnings("unused")
public class Test {
	public Connection conn = null;
	public Statement st = null;

	@SuppressWarnings("unchecked")
	public void readXml() throws SQLException {
		// ***************************建立数据库连接***************************
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://192.168.4.106:3306/weiyin?useUnicode=true&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(url,"root","root");
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception sqlexception) {
			System.out.println("数据库连接发生异常！");
		}

		try {
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build("src/test/java/com/microsilver/test/AreaNew.xml");
			Element root = doc.getRootElement();
			List provinces = root.getChildren("province");
			for (Object province : provinces) {
				Element p = (Element) province;
				int code =p.getAttribute("code").getIntValue();
				String name = p.getAttribute("name").getValue();
				String sql = "insert into ims_sys_area(code,name,level)values("+code+",'"+name+"',1)";
				st.executeUpdate(sql);
				List cities = p.getChildren("city");
				for (Object city : cities) {
					Element c = (Element) city;
					int code1 = c.getAttribute("code").getIntValue();
					String name1 = c.getAttribute("name").getValue();
					sql = "insert into ims_sys_area(code,parent_code,name,level)values("+code1+","+code+",'"+name1+"',2)";
					st.executeUpdate(sql);
					List countries = c.getChildren("county");
					for (Object country : countries) {
						Element e = (Element) country;
						int code2 = e.getAttribute("code").getIntValue();
						String name2 = e.getAttribute("name").getValue();
						sql = "insert into ims_sys_area(code,parent_code,name,level)values("+code2+","+code1+",'"+name2+"',3)";
						st.executeUpdate(sql);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			st.close();
			conn.close();			
		}
	}

	public static void main(String[] args) throws SQLException {
		Test rx = new Test();
		rx.readXml();
	}

}
