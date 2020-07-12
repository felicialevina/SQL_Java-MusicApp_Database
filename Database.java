
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Database extends JFrame implements ActionListener{
	
	private JTextArea txtOutput;
	private JButton btnConnect, btnCreate, btnInsert, btnDrop, btnQuery, btnQuit;
	private Connection con;
	private JPanel btnPanel;
	private Statement stmt;
	private ResultSet rs;
	private String  SQL_INSERT1, SQL_INSERT2, SQL_INSERT3, SQL_INSERT4, SQL_INSERT5, SQL_INSERT6, SQL_INSERT7, 
					SQL_INSERT8, SQL_INSERT9, SQL_INSERT10, SQL_INSERT11, SQL_INSERT12;
	private String output = "";
			
	private static final String SQL_CREATE1 = "CREATE TABLE members (" + 
			"    User_id NUMBER PRIMARY KEY," + 
			"    Username VARCHAR2(20)," + 
			"    Country VARCHAR2(30)," + 
			"    Email VARCHAR2(30)," + 
			"    Full_name VARCHAR(25)," + 
			"    Birthday DATE" + 
			")";
	
	private static final String SQL_CREATE2 = "CREATE TABLE artist (" + 
			"    Artist_id NUMBER PRIMARY KEY," + 
			"    Artist_name VARCHAR2(20) NOT NULL," + 
			"    Country VARCHAR2(30)," + 
			"    Album_num NUMBER" + 
			")";
	
	private static final String SQL_CREATE3 = "CREATE TABLE podcast (" + 
			"    Podcast_id NUMBER PRIMARY KEY," + 
			"    Title VARCHAR2(35)," + 
			"    Podcast_date DATE," + 
			"    Podcast_length VARCHAR2(5)," + 
			"    Categories VARCHAR2(25)," + 
			"    Episodes VARCHAR2(50)" + 
			")";
	
	private static final String SQL_CREATE4 = "CREATE TABLE playlist (" + 
			"    Playlist_id NUMBER PRIMARY KEY," + 
			"    Playlist_name VARCHAR2(25)," + 
			"    Total_songs NUMBER" + 
			"    )";
	
	private static final String SQL_CREATE5 = "CREATE TABLE song (" + 
			"    Song_id NUMBER PRIMARY KEY," + 
			"    Song_length VARCHAR2(5)," + 
			"    Genre VARCHAR2(15)," + 
			"    Title VARCHAR2(35)" + 
			"    )";
	
	private static final String SQL_CREATE6 = "CREATE TABLE album (" + 
			"    Album_id NUMBER PRIMARY KEY," + 
			"    Album_name VARCHAR2(40) NOT NULL," + 
			"    Album_year DATE," + 
			"    Song_number NUMBER" + 
			"    )";
	
	private static final String SQL_CREATE7 = "CREATE TABLE creates (" + 
			"    User_id NUMBER REFERENCES members(User_id)," + 
			"    Playlist_id NUMBER REFERENCES playlist(Playlist_id)," + 
			"    PRIMARY KEY (User_id, Playlist_id)" +
			"    )";
	
	private static final String SQL_CREATE8 = "CREATE TABLE releases (" + 
			"    Artist_id NUMBER REFERENCES artist(Artist_id)," + 
			"    Album_id NUMBER REFERENCES album(Album_id)," + 
			"    PRIMARY KEY (Artist_id, Album_id)" + 
			"    )";
	
	private static final String SQL_CREATE9 = "CREATE TABLE plays (" + 
			"    User_id NUMBER REFERENCES members(User_id)," + 
			"    Song_id NUMBER REFERENCES song(Song_id)," + 
			"    PRIMARY KEY (User_id, Song_id)" + 
			"    )";
	
	private static final String SQL_CREATE10 = "CREATE TABLE listens_to (" + 
			"    User_id NUMBER REFERENCES members(User_id)," + 
			"    Podcast_id NUMBER REFERENCES podcast(Podcast_id)," + 
			"    PRIMARY KEY (User_id, Podcast_id)" + 
			"    )";
	
	private static final String SQL_CREATE11 = "CREATE TABLE contains (" + 
			"    Album_id NUMBER REFERENCES album(Album_id)," + 
			"    Song_id NUMBER REFERENCES song(Song_id)," + 
			"    PRIMARY KEY (Album_id, Song_id)" + 
			"    )"; 
	
	private static final String SQL_CREATE12 = "CREATE TABLE has (" + 
			"    Playlist_id NUMBER REFERENCES playlist(Playlist_id)," + 
			"    Song_id NUMBER REFERENCES song(Song_id)," + 
			"    PRIMARY KEY (Playlist_id, Song_id)" + 
			"    )"; 
	
public static void main(String args[]){
	
		new Database();
}
public Database() {
	try{

		SQL_INSERT1 = "INSERT ALL" +
								" INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES(1232, 'abc_def', 'Indonesia', 'abcdef@gmail.com', 'Abc Def', to_date('1999-09-08', 'yyyy-mm-dd'))" + 
								" INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES(2344, 'ghi_jkl', 'India', 'ghi_jkl@gmail.com', 'Ghi Jkl', to_date('1999-11-28', 'yyyy-mm-dd'))" + 
								" INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES (3459, 'mno_pqr', 'Canada', 'mno.pqr@gmail.com', 'Mno Pqr', to_date('1999-07-19', 'yyyy-mm-dd'))" + 
								" INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES (6923, 'army_1306', 'Canada', 'bts_ftw13@gmail.com', 'Bangtan Bangtan', to_date('2013-06-13', 'yyyy-mm-dd'))" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT2 = "INSERT ALL" + 
								" INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (7852, 'Ariana Grande', 'America', 2)" + 
								" INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (8916, 'BTS', 'Korea', 2)" + 
								" INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (3404, 'Halsey', 'America', 2)" + 
								" INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (0734, 'Shawn Mendes', 'Canada', 1)" + 
								" INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (7488, 'Troye Sivan', 'Australia', 1)" +
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT3 = "INSERT ALL" +
								" INTO podcast (Podcast_id, Title, Podcast_date, Podcast_length, Categories, Episodes) VALUES (3025, 'TED Talks Daily',  to_date('2019-09-13', 'yyyy-mm-dd'), '13:49', 'Environment', 'Can Seaweed Help Global Warming?')" + 
								" INTO podcast (Podcast_id, Title, Podcast_date, Podcast_length, Categories, Episodes) VALUES (8934, 'MISFITS', to_date('2019-08-15', 'yyyy-mm-dd'), '53:38', 'Comedy', 'The Poland Story')" + 
								" INTO podcast (Podcast_id, Title, Podcast_date, Podcast_length, Categories, Episodes) VALUES (2436, 'Uncover', to_date('2019-05-28', 'yyyy-mm-dd'), '29:45', 'True Crime', 'Behind Bars')"+
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT4 = "INSERT ALL" +
								" INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (7892, 'Party Mode', 8)" + 
								" INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (5409, 'Everyday Favs', 8)" + 
								" INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (8943, 'Chill Vibes', 8)" + 
								" INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (6781, 'All Time BTS', 6)" +
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT5 = "INSERT ALL" +
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (4523, '2:59', 'RnB', '7 Rings')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (1459, '3.27', 'Pop', 'thank u, next')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (1431, '3:32', 'RnB', 'Imagine')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (9304, '3:17', 'Pop', 'One Last Time')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (7584, '3:19', 'RnB', 'Bang Bang')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (3542, '3:35', 'Pop', 'Break Free')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (0833, '3:50', 'Kpop', 'Boy With Luv')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (3894, '3:44', 'Kpop', 'Mikrokosmos')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (8905, '3:47', 'Kpop', 'Jamais Vu')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (6554, '3:57', 'Kpop', 'RUN   ')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (3854, '3:59', 'Kpop', 'Butterfly')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (0983, '4:17', 'Kpop', 'Ma City')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (8123, '4:09', 'Electro Pop', 'Colors')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (2894, '3:04', 'Indie', 'New Americana')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (3409, '4:38', 'Electro Pop', 'Castle')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (7895, '3:52', 'Metal', 'Nightmare')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (3098, '3:22', 'Pop', 'Without Me')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (8767, '3:02', 'Indie', 'Graveyard')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (4909, '3:08', 'Pop', 'Treat You Better')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (6877, '3:29', 'Pop', 'Mercy')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (7659, '3:02', 'Indie', 'Youth   ')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (8978, '3:54', 'Indie', 'Suburbia')" + 
								" INTO song (Song_id, Song_length, Genre, Title) VALUES (9847, '3:57', 'Indie', 'Talk Me Down')" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT6 = "INSERT ALL" +
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (9760, 'thank u, next', to_date('2019-02-08', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (9786, 'My Everything', to_date('2014-08-25', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (4562, 'Map of The Soul: Persona', to_date('2019-04-12', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (2386, 'The Most Beautiful Moment in Life Pt.2', to_date('2015-11-30', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (0927, 'BADLANDS', to_date('2015-08-28', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (0789, 'Single', to_date('2019-09-13', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (9867, 'Illuminate', to_date('2016-09-23', 'yyyy-mm-dd'), 3)" + 
								" INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (0892, 'Blue Neighbourhood', to_date('2015-12-04', 'yyyy-mm-dd'), 3)" +
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT7 = "INSERT ALL" +
								" INTO creates (User_id, Playlist_id) VALUES (1232, 7892)" + 
								" INTO creates (User_id, Playlist_id) VALUES (2344, 5409)" + 
								" INTO creates (User_id, Playlist_id) VALUES (3459, 8943)" + 
								" INTO creates (User_id, Playlist_id) VALUES (6923, 6781)" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT8 = "INSERT All" +
								" INTO releases (Artist_id, Album_id) VALUES (7852, 9760)" + 
								" INTO releases (Artist_id, Album_id) VALUES (7852, 9786)" + 
								" INTO releases (Artist_id, Album_id) VALUES (8916, 4562)" + 
								" INTO releases (Artist_id, Album_id) VALUES (8916, 2386)" + 
								" INTO releases (Artist_id, Album_id) VALUES (3404, 0927)" + 
								" INTO releases (Artist_id, Album_id) VALUES (3404, 0789)" + 
								" INTO releases (Artist_id, Album_id) VALUES (0734, 9867)" + 
								" INTO releases (Artist_id, Album_id) VALUES (7488, 0892)" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT9 = "INSERT ALL" +
								" INTO plays (User_id, Song_id) VALUES (1232, 4523)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 3542)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 3894)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 6554)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 0983)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 8123)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 8767)" + 
								" INTO plays (User_id, Song_id) VALUES (1232, 4909)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 1431)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 3542)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 0833)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 8905)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 3854)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 2894)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 6877)" + 
								" INTO plays (User_id, Song_id) VALUES (2344, 8978)" + 
								" INTO plays (User_id, Song_id) VALUES (3459, 1459)" + 
								" INTO plays (User_id, Song_id) VALUES (3459, 9304)" + 
								" INTO plays (User_id, Song_id) VALUES (3459, 3409)" + 
								" INTO plays (User_id, Song_id) VALUES (3459, 7895)" + 
								" INTO plays (User_id, Song_id) VALUES (3459, 3098)" +  
								" INTO plays (User_id, Song_id) VALUES (3459, 7659)" + 
								" INTO plays (User_id, Song_id) VALUES (3459, 9847)" + 
								" INTO plays (User_id, Song_id) VALUES (6923, 0833)" + 
								" INTO plays (User_id, Song_id) VALUES (6923, 3894)" + 
								" INTO plays (User_id, Song_id) VALUES (6923, 8905)" + 
								" INTO plays (User_id, Song_id) VALUES (6923, 6554)" + 
								" INTO plays (User_id, Song_id) VALUES (6923, 3854)" + 
								" INTO plays (User_id, Song_id) VALUES (6923, 0983)" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT10 = "INSERT ALL" +
								" INTO listens_to(User_id, Podcast_id) VALUES(1232, 3025)" + 
								" INTO listens_to(User_id, Podcast_id) VALUES(2344, 8934)" + 
								" INTO listens_to(User_id, Podcast_id) VALUES(2344, 3025)" + 
								" INTO listens_to(User_id, Podcast_id) VALUES(3459, 2436)" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT11 = "INSERT ALL" +
								" INTO contains (Album_id, Song_id) VALUES (9760, 4523)" + 
								" INTO contains (Album_id, Song_id) VALUES (9760, 1459)" + 
								" INTO contains (Album_id, Song_id) VALUES (9760, 1431)" + 
								" INTO contains (Album_id, Song_id) VALUES (9786, 9304)" + 
								" INTO contains (Album_id, Song_id) VALUES (9786, 7584)" + 
								" INTO contains (Album_id, Song_id) VALUES (9786, 3542)" + 
								" INTO contains (Album_id, Song_id) VALUES (4562, 0833)" + 
								" INTO contains (Album_id, Song_id) VALUES (4562, 3894)" + 
								" INTO contains (Album_id, Song_id) VALUES (4562, 8905)" + 
								" INTO contains (Album_id, Song_id) VALUES (2386, 6554)" + 
								" INTO contains (Album_id, Song_id) VALUES (2386, 3854)" + 
								" INTO contains (Album_id, Song_id) VALUES (2386, 0983)" + 
								" INTO contains (Album_id, Song_id) VALUES (0927, 8123)" + 
								" INTO contains (Album_id, Song_id) VALUES (0927, 2894)" + 
								" INTO contains (Album_id, Song_id) VALUES (0927, 3409)" + 
								" INTO contains (Album_id, Song_id) VALUES (0789, 7895)" + 
								" INTO contains (Album_id, Song_id) VALUES (0789, 3098)" + 
								" INTO contains (Album_id, Song_id) VALUES (0789, 8767)" + 
								" INTO contains (Album_id, Song_id) VALUES (9867, 4909)" + 
								" INTO contains (Album_id, Song_id) VALUES (9867, 6877)" + 
								" INTO contains (Album_id, Song_id) VALUES (0892, 7659)" + 
								" INTO contains (Album_id, Song_id) VALUES (0892, 8978)" + 
								" INTO contains (Album_id, Song_id) VALUES (0892, 9847)" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		SQL_INSERT12 = "INSERT ALL" +
								" INTO has (Playlist_id, Song_id) VALUES (7892, 4523)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 3542)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 3894)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 6554)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 0983)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 8123)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 8767)" + 
								" INTO has (Playlist_id, Song_id) VALUES (7892, 4909)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 1431)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 3542)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 0833)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 8905)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 3854)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 2894)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 6877)" + 
								" INTO has (Playlist_id, Song_id) VALUES (5409, 8978)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 1459)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 9304)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 3409)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 7895)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 3098)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 7659)" + 
								" INTO has (Playlist_id, Song_id) VALUES (8943, 9847)" + 
								" INTO has (Playlist_id, Song_id) VALUES (6781, 0833)" + 
								" INTO has (Playlist_id, Song_id) VALUES (6781, 3894)" + 
								" INTO has (Playlist_id, Song_id) VALUES (6781, 8905)" + 
								" INTO has (Playlist_id, Song_id) VALUES (6781, 6554)" + 
								" INTO has (Playlist_id, Song_id) VALUES (6781, 3854)" + 
								" INTO has (Playlist_id, Song_id) VALUES (6781, 0983)" + 
								" SELECT * FROM DUAL" +
								" COMMIT"; 

		
		btnConnect = new JButton("Check Connection");
		btnConnect.setBounds(90, 20, 130, 30);
    	btnConnect.setToolTipText("Connect");
    	btnConnect.setFont(new Font("Britannic", Font.BOLD, 20));
    	btnConnect.setMnemonic(KeyEvent.VK_C);
    	
    	btnCreate = new JButton("Create Tables");
    	btnCreate.setBounds(90, 70, 130, 30);
    	btnCreate.setToolTipText("Create");
    	btnCreate.setFont(new Font("Britannic", Font.BOLD, 20));
    	btnCreate.setMnemonic(KeyEvent.VK_C);
    	
    	btnInsert = new JButton("Populate Tables");
    	btnInsert.setBounds(260, 70, 130, 30);
    	btnInsert.setToolTipText("Populate");
    	btnInsert.setFont(new Font("Britannic", Font.BOLD, 20));
    	btnInsert.setMnemonic(KeyEvent.VK_C);
    	
    	btnDrop = new JButton("Drop Tables");
    	btnDrop.setBounds(90, 120, 130, 30);
    	btnDrop.setToolTipText("Drop");
    	btnDrop.setFont(new Font("Britannic", Font.BOLD, 20));
    	btnDrop.setMnemonic(KeyEvent.VK_C);
		
    	btnQuery = new JButton("Queries");
    	btnQuery.setBounds(260, 120, 130, 30);
    	btnQuery.setToolTipText("Queries");
    	btnQuery.setFont(new Font("Britannic", Font.BOLD, 20));
    	btnQuery.setMnemonic(KeyEvent.VK_C);
    	
    	btnQuit = new JButton("Quit");
    	btnQuit.setPreferredSize(new Dimension(130, 30));
    	btnQuit.setToolTipText("Quit");
    	btnQuit.setFont(new Font("Britannic", Font.BOLD, 20));
    	btnQuery.setMnemonic(KeyEvent.VK_C);
    	
		txtOutput = new JTextArea(28, 80);
		txtOutput.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtOutput.setBounds(0, 170, 500, 200);
		
		JPanel btnPanel = new JPanel(new GridLayout(3, 1));
		btnPanel.add(btnConnect);
		btnPanel.add(btnQuit);
		btnPanel.add(btnCreate);
		btnPanel.add(btnInsert);
		btnPanel.add(btnDrop);
		btnPanel.add(btnQuery);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 15));
		panel.add(btnPanel);
		panel.add(new JScrollPane(txtOutput, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		
		setContentPane(panel);
		//setSize(500,420);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setTitle("Spotify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btnConnect.addActionListener(this);
		btnCreate.addActionListener(this);
		btnInsert.addActionListener(this);
		btnDrop.addActionListener(this);
		btnQuery.addActionListener(this);
		btnQuit.addActionListener(this);
		
		//con.close();

		}catch(Exception e){ System.out.println(e);}
}

public void actionPerformed(ActionEvent e){
	
	if(e.getSource() == btnConnect)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl","a2arya","12271752");
					stmt=con.createStatement();
					output+="Connected Successfully.\n";
					txtOutput.setText(output);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
	if(e.getSource() == btnCreate)
	{
		try {
			stmt.executeUpdate(SQL_CREATE1);		
			stmt.executeUpdate(SQL_CREATE2);
			stmt.executeUpdate(SQL_CREATE3);
			stmt.executeUpdate(SQL_CREATE4);
			stmt.executeUpdate(SQL_CREATE5);
			stmt.executeUpdate(SQL_CREATE6);
			stmt.executeUpdate(SQL_CREATE7);
			stmt.executeUpdate(SQL_CREATE8);
			stmt.executeUpdate(SQL_CREATE9);
			stmt.executeUpdate(SQL_CREATE10);
			stmt.executeUpdate(SQL_CREATE11);
			stmt.executeUpdate(SQL_CREATE12);
			System.out.println("Tables Created");
			output+="Tables created successfully.\n";
			txtOutput.setText(output);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch(Exception e2){ System.out.println(e2);}
		
	}
	
	if(e.getSource() == btnInsert)
	{
		try {
			stmt.executeUpdate(SQL_INSERT1);
			stmt.executeUpdate(SQL_INSERT2);
			stmt.executeUpdate(SQL_INSERT3);
			stmt.executeUpdate(SQL_INSERT4);
			stmt.executeUpdate(SQL_INSERT5);
			stmt.executeUpdate(SQL_INSERT6);
			stmt.executeUpdate(SQL_INSERT7);
			stmt.executeUpdate(SQL_INSERT8);
			stmt.executeUpdate(SQL_INSERT9);
			stmt.executeUpdate(SQL_INSERT10);
			stmt.executeUpdate(SQL_INSERT11);
			stmt.executeUpdate(SQL_INSERT12);
			stmt.executeQuery("CREATE VIEW sub_playlist AS (SELECT * FROM album WHERE Album_name LIKE 'M%')");
			stmt.executeQuery("CREATE VIEW kpop_songs AS (SELECT * FROM song WHERE Genre = 'Kpop')");
			System.out.println("Tables Populated");
			output+="Tables populated successfully.\n";
			txtOutput.setText(output);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if(e.getSource() == btnDrop)
	{
		try {
			stmt.executeUpdate("DROP TABLE creates");
			stmt.executeUpdate("DROP TABLE releases");
			stmt.executeUpdate("DROP TABLE plays");
			stmt.executeUpdate("DROP TABLE listens_to");
			stmt.executeUpdate("DROP TABLE contains");
			stmt.executeUpdate("DROP TABLE has");
			stmt.executeUpdate("DROP TABLE members");
			stmt.executeUpdate("DROP TABLE artist");
			stmt.executeUpdate("DROP TABLE podcast");
			stmt.executeUpdate("DROP TABLE playlist");
			stmt.executeUpdate("DROP TABLE song");
			stmt.executeUpdate("DROP TABLE album");
			stmt.executeUpdate("DROP VIEW sub_playlist");
			stmt.executeUpdate("DROP VIEW kpop_songs");
			System.out.println("Tables Dropped");
			output+="Tables dropped successfully.\n";
			txtOutput.setText(output);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
		
	if(e.getSource() == btnQuery)
	{
		try {
			
			rs = stmt.executeQuery("SELECT Title AS Indie_Songs, Song_length FROM song WHERE Genre = 'Indie'");
			output+="\nINDIE_SONGS			    SONG_LENGTH\n";
			while(rs.next()) {
				output+=rs.getString(1)+"  				"+rs.getString(2)+"\n";
				txtOutput.setText(output);
				}
			
			rs = stmt.executeQuery("SELECT Playlist_name ,Total_songs AS Number_of_Songs_in_Playlist FROM playlist WHERE Total_songs = 8");
			output+="\n\nPLAYLIST_NAME		   NUMBER_OF_SONGS_IN_PLAYLIST\n";
			while(rs.next()) {
				output+=rs.getString(1)+"  				"+rs.getInt(2)+"\n";
				txtOutput.setText(output);
				}
			
			rs = stmt.executeQuery("SELECT Title, 'in Playlist:', Playlist_name FROM song s, has h, playlist p WHERE s.Song_id = h.Song_id AND h.Playlist_id = p.Playlist_id AND Playlist_name = 'Chill Vibes'");
			output+="\n\nTITLE					INPLAYLIST:				PLAYLIST_NAME\n";
			while(rs.next()) {
				output+=rs.getString(1)+"  				"+rs.getString(2)+"  				"+rs.getString(3)+"\n";
				txtOutput.setText(output);
				}
			
			rs = stmt.executeQuery("SELECT Title, 'is by' , Artist_name FROM song s, album a, artist b, releases r, contains c WHERE s.Song_id = c.Song_id AND c.Album_id = a.Album_id AND a.Album_id = r.Album_id AND r.Artist_id = b.Artist_id AND Artist_name = 'BTS'");
			output+="\n\nTITLE					ISBY:				ARTIST_NAME\n";
			while(rs.next()) {
				output+=rs.getString(1)+"  				"+rs.getString(2)+"  				"+rs.getString(3)+"\n";
				txtOutput.setText(output);
				}
			
			rs = stmt.executeQuery("SELECT Playlist_name, COUNT(Song_id) AS Total_Songs_in_Playlist FROM playlist p, has h WHERE p.Playlist_id = h.Playlist_id GROUP BY Playlist_name");
			output+="\n\nPLAYLIST_NAME		      TOTAL_SONGS_IN_PLAYLIST\n";
			while(rs.next()) {
				output+=rs.getString(1)+"  				"+rs.getInt(2)+"\n";
				txtOutput.setText(output);
				}
			
			rs = stmt.executeQuery("(SELECT * FROM song) MINUS (SELECT s.* FROM song s, playlist p, has h WHERE p.Playlist_name = 'Party Mode' AND p.Playlist_id = h.Playlist_id AND h.Song_id = s.Song_id)");
			output+="\n\nSONG_ID		    SONG_LENGTH				GENRE				TITLE\n";
			while(rs.next()) {
				output+=rs.getInt(1)+"  			"+rs.getString(2)+"  				"+rs.getString(3)+"  				"+rs.getString(4)+"\n";
				txtOutput.setText(output);
				}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	if(e.getSource() == btnQuit)
	{ 
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION)
		{
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}	
	
}

}