DROP TABLE creates;
DROP TABLE releases;
DROP TABLE plays;
DROP TABLE listens_to;
DROP TABLE contains;
DROP TABLE has;

DROP TABLE members;
DROP TABLE artist;
DROP TABLE podcast;
DROP TABLE playlist;
DROP TABLE song;
DROP TABLE album;

CREATE TABLE members ( 
    User_id NUMBER PRIMARY KEY,
    Username VARCHAR2(20),
    Country VARCHAR2(30),
    Email VARCHAR2(30),
    Full_name VARCHAR(25),
    Birthday DATE
   );
   
CREATE TABLE artist (
    Artist_id NUMBER PRIMARY KEY,
    Artist_name VARCHAR2(20) NOT NULL,
    Country VARCHAR2(30),
    Album_num NUMBER
   );
   
CREATE TABLE podcast (
    Podcast_id NUMBER PRIMARY KEY,
    Title VARCHAR2(35),
    Podcast_date DATE,
    Podcast_length VARCHAR2(5),
    Categories VARCHAR2(25),
    Episodes VARCHAR2(50)
    );
    
CREATE TABLE playlist (
    Playlist_id NUMBER PRIMARY KEY,
    Playlist_name VARCHAR2(25),
    Total_songs NUMBER
    );
    
CREATE TABLE song (
    Song_id NUMBER PRIMARY KEY,
    Song_length VARCHAR2(5),
    Genre VARCHAR2(15),
    Title VARCHAR2(35)
    );

CREATE TABLE album (
    Album_id NUMBER PRIMARY KEY,
    Album_name VARCHAR2(40) NOT NULL,
    Album_year DATE,
    Song_number NUMBER
    );
    
INSERT INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES (1232, 'abc_def', 'Indonesia', 'abcdef@gmail.com', 'Abc Def', to_date('1999-09-08', 'yyyy-mm-dd'));
INSERT INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES (2344, 'ghi_jkl', 'India', 'ghi_jkl@gmail.com', 'Ghi Jkl', to_date('1999-11-28', 'yyyy-mm-dd'));
INSERT INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES (3459, 'mno_pqr', 'Canada', 'mno.pqr@gmail.com', 'Mno Pqr', to_date('1999-07-19', 'yyyy-mm-dd'));
INSERT INTO members (User_id, Username, Country, Email, Full_name, Birthday) VALUES (6923, 'army_1306', 'Canada', 'bts_ftw13@gmail.com', 'Bangtan Bangtan', to_date('2013-06-13', 'yyyy-mm-dd'));

INSERT INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (7852, 'Ariana Grande', 'America', 2);
INSERT INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (8916, 'BTS', 'Korea', 2);
INSERT INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (3404, 'Halsey', 'America', 2);
INSERT INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (0734, 'Shawn Mendes', 'Canada', 1);
INSERT INTO artist (Artist_id, Artist_name, Country, Album_num) VALUES (7488, 'Troye Sivan', 'Australia', 1);

INSERT INTO podcast (Podcast_id, Title, Podcast_date, Podcast_length, Categories, Episodes) VALUES (3025, 'TED Talks Daily',  to_date('2019-09-13', 'yyyy-mm-dd'), '13:49', 'Environment', 'Can Seaweed Help Global Warming?');
INSERT INTO podcast (Podcast_id, Title, Podcast_date, Podcast_length, Categories, Episodes) VALUES (8934, 'MISFITS', to_date('2019-08-15', 'yyyy-mm-dd'), '53:38', 'Comedy', 'The Poland Story');
INSERT INTO podcast (Podcast_id, Title, Podcast_date, Podcast_length, Categories, Episodes) VALUES (2436, 'Uncover', to_date('2019-05-28', 'yyyy-mm-dd'), '29:45', 'True Crime', 'Behind Bars');

INSERT INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (7892, 'Party Mode', 8);
INSERT INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (5409, 'Everyday Favs', 8);
INSERT INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (8943, 'Chill Vibes', 8);
INSERT INTO playlist (Playlist_id, Playlist_name, Total_Songs) VALUES (6781, 'All Time BTS', 6);

INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (4523, '2:59', 'RnB', '7 Rings');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (1459, '3.27', 'Pop', 'thank u, next');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (1431, '3:32', 'RnB', 'Imagine');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (9304, '3:17', 'Pop', 'One Last Time');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (7584, '3:19', 'RnB', 'Bang Bang');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (3542, '3:35', 'Pop', 'Break Free');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (0833, '3:50', 'Kpop', 'Boy With Luv');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (3894, '3:44', 'Kpop', 'Mikrokosmos');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (8905, '3:47', 'Kpop', 'Jamais Vu');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (6554, '3:57', 'Kpop', 'RUN');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (3854, '3:59', 'Kpop', 'Butterfly');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (0983, '4:17', 'Kpop', 'Ma City');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (8123, '4:09', 'Electro Pop', 'Colors');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (2894, '3:04', 'Indie', 'New Americana');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (3409, '4:38', 'Electro Pop', 'Castle');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (7895, '3:52', 'Metal', 'Nightmare');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (3098, '3:22', 'Pop', 'Without Me');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (8767, '3:02', 'Indie', 'Graveyard');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (4909, '3:08', 'Pop', 'Treat You Better');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (6877, '3:29', 'Pop', 'Mercy');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (7659, '3:02', 'Indie', 'Youth');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (8978, '3:54', 'Indie', 'Suburbia');
INSERT INTO song (Song_id, Song_length, Genre, Title) VALUES (9847, '3:57', 'Indie', 'Talk Me Down');

INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (9760, 'thank u, next', to_date('2019-02-08', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (9786, 'My Everything', to_date('2014-08-25', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (4562, 'Map of The Soul: Persona', to_date('2019-04-12', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (2386, 'The Most Beautiful Moment in Life Pt.2', to_date('2015-11-30', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (0927, 'BADLANDS', to_date('2015-08-28', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (0789, 'Single', to_date('2019-09-13', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (9867, 'Illuminate', to_date('2016-09-23', 'yyyy-mm-dd'), 3);
INSERT INTO album (Album_id, Album_name, Album_year, Song_number) VALUES (0892, 'Blue Neighbourhood', to_date('2015-12-04', 'yyyy-mm-dd'), 3);

CREATE TABLE creates (
    User_id NUMBER REFERENCES members(User_id),
    Playlist_id NUMBER REFERENCES playlist(Playlist_id),
    PRIMARY KEY (User_id, Playlist_id)
    );
CREATE TABLE releases (
    Artist_id NUMBER REFERENCES artist(Artist_id),
    Album_id NUMBER REFERENCES album(Album_id),
    PRIMARY KEY (Artist_id, Album_id)
    );
    
CREATE TABLE plays (
    User_id NUMBER REFERENCES members(User_id),
    Song_id NUMBER REFERENCES song(Song_id),
    PRIMARY KEY (User_id, Song_id)
    ); 
CREATE TABLE listens_to (
    User_id NUMBER REFERENCES members(User_id),
    Podcast_id NUMBER REFERENCES podcast(Podcast_id),
    PRIMARY KEY (User_id, Podcast_id)
    );
CREATE TABLE contains (
    Album_id NUMBER REFERENCES album(Album_id),
    Song_id NUMBER REFERENCES song(Song_id),
    PRIMARY KEY (Album_id, Song_id)
    ); 
CREATE TABLE has (
    Playlist_id NUMBER REFERENCES playlist(Playlist_id),
    Song_id NUMBER REFERENCES song(Song_id),
    PRIMARY KEY (Playlist_id, Song_id)
    );
    
INSERT INTO creates (User_id, Playlist_id) VALUES (1232, 7892);
INSERT INTO creates (User_id, Playlist_id) VALUES (2344, 5409);
INSERT INTO creates (User_id, Playlist_id) VALUES (3459, 8943);
INSERT INTO creates (User_id, Playlist_id) VALUES (6923, 6781);

INSERT INTO releases (Artist_id, Album_id) VALUES (7852, 9760);
INSERT INTO releases (Artist_id, Album_id) VALUES (7852, 9786);
INSERT INTO releases (Artist_id, Album_id) VALUES (8916, 4562);
INSERT INTO releases (Artist_id, Album_id) VALUES (8916, 2386);
INSERT INTO releases (Artist_id, Album_id) VALUES (3404, 0927);
INSERT INTO releases (Artist_id, Album_id) VALUES (3404, 0789);
INSERT INTO releases (Artist_id, Album_id) VALUES (0734, 9867);
INSERT INTO releases (Artist_id, Album_id) VALUES (7488, 0892);

INSERT INTO plays (User_id, Song_id) VALUES (1232, 4523);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 3542);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 3894);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 6554);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 0983);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 8123);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 8767);
INSERT INTO plays (User_id, Song_id) VALUES (1232, 4909);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 1431);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 3542);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 0833);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 8905);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 3854);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 2894);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 6877);
INSERT INTO plays (User_id, Song_id) VALUES (2344, 8978);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 1459);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 9304);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 3409);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 7895);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 3098);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 7659);
INSERT INTO plays (User_id, Song_id) VALUES (3459, 9847);
INSERT INTO plays (User_id, Song_id) VALUES (6923, 0833);
INSERT INTO plays (User_id, Song_id) VALUES (6923, 3894);
INSERT INTO plays (User_id, Song_id) VALUES (6923, 8905);
INSERT INTO plays (User_id, Song_id) VALUES (6923, 6554);
INSERT INTO plays (User_id, Song_id) VALUES (6923, 3854);
INSERT INTO plays (User_id, Song_id) VALUES (6923, 0983);

INSERT INTO listens_to(User_id, Podcast_id) VALUES(1232, 3025);
INSERT INTO listens_to(User_id, Podcast_id) VALUES(2344, 8934);
INSERT INTO listens_to(User_id, Podcast_id) VALUES(2344, 3025);
INSERT INTO listens_to(User_id, Podcast_id) VALUES(3459, 2436);
    
INSERT INTO contains (Album_id, Song_id) VALUES (9760, 4523);
INSERT INTO contains (Album_id, Song_id) VALUES (9760, 1459);
INSERT INTO contains (Album_id, Song_id) VALUES (9760, 1431);
INSERT INTO contains (Album_id, Song_id) VALUES (9786, 9304);
INSERT INTO contains (Album_id, Song_id) VALUES (9786, 7584);
INSERT INTO contains (Album_id, Song_id) VALUES (9786, 3542);
INSERT INTO contains (Album_id, Song_id) VALUES (4562, 0833);
INSERT INTO contains (Album_id, Song_id) VALUES (4562, 3894);
INSERT INTO contains (Album_id, Song_id) VALUES (4562, 8905);
INSERT INTO contains (Album_id, Song_id) VALUES (2386, 6554);
INSERT INTO contains (Album_id, Song_id) VALUES (2386, 3854);
INSERT INTO contains (Album_id, Song_id) VALUES (2386, 0983);
INSERT INTO contains (Album_id, Song_id) VALUES (0927, 8123);
INSERT INTO contains (Album_id, Song_id) VALUES (0927, 2894);
INSERT INTO contains (Album_id, Song_id) VALUES (0927, 3409);
INSERT INTO contains (Album_id, Song_id) VALUES (0789, 7895);
INSERT INTO contains (Album_id, Song_id) VALUES (0789, 3098);
INSERT INTO contains (Album_id, Song_id) VALUES (0789, 8767);
INSERT INTO contains (Album_id, Song_id) VALUES (9867, 4909);
INSERT INTO contains (Album_id, Song_id) VALUES (9867, 6877);
INSERT INTO contains (Album_id, Song_id) VALUES (0892, 7659);
INSERT INTO contains (Album_id, Song_id) VALUES (0892, 8978);
INSERT INTO contains (Album_id, Song_id) VALUES (0892, 9847);

INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 4523);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 3542);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 3894);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 6554);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 0983);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 8123);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 8767);
INSERT INTO has (Playlist_id, Song_id) VALUES (7892, 4909);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 1431);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 3542);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 0833);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 8905);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 3854);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 2894);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 6877);
INSERT INTO has (Playlist_id, Song_id) VALUES (5409, 8978);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 1459);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 9304);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 3409);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 7895);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 3098);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 7659);
INSERT INTO has (Playlist_id, Song_id) VALUES (8943, 9847);
INSERT INTO has (Playlist_id, Song_id) VALUES (6781, 0833);
INSERT INTO has (Playlist_id, Song_id) VALUES (6781, 3894);
INSERT INTO has (Playlist_id, Song_id) VALUES (6781, 8905);
INSERT INTO has (Playlist_id, Song_id) VALUES (6781, 6554);
INSERT INTO has (Playlist_id, Song_id) VALUES (6781, 3854);
INSERT INTO has (Playlist_id, Song_id) VALUES (6781, 0983);




SELECT *
FROM members;

SELECT *
FROM artist
WHERE Album_num > 1;

SELECT Episodes AS New_Podcasts, Podcast_date
FROM podcast
WHERE Podcast_date > to_date('2019-06-01', 'yyyy-mm-dd');

SELECT Playlist_name ,Total_songs AS Number_of_Songs_in_Playlist
FROM playlist
WHERE Total_songs = 8;

SELECT Title AS Indie_Songs, Song_length
FROM song 
WHERE Genre = 'Indie';

SELECT Album_name AS Album_2015, Album_year
FROM album
WHERE Album_year > to_date('2015-01-01', 'yyyy-mm-dd') AND Album_year < to_date('2016-01-01', 'yyyy-mm-dd');

SELECT *
FROM podcast
WHERE Categories = 'True Crime' ;





SELECT Title, 'in Playlist:', Playlist_name
FROM song s, has h, playlist p
WHERE s.Song_id = h.Song_id
      AND h.Playlist_id = p.Playlist_id 
      AND Playlist_name = 'Chill Vibes';

SELECT Title, 'is by' , Artist_name
FROM song s, album a, artist b, releases r, contains c
WHERE s.Song_id = c.Song_id
      AND c.Album_id = a.Album_id
      AND a.Album_id = r.Album_id
      AND r.Artist_id = b.Artist_id 
      AND Artist_name = 'BTS' ;


CREATE VIEW sub_playlist AS
(SELECT *
FROM album
WHERE Album_name LIKE 'M%');

SELECT Album_name, Album_year
FROM sub_playlist
WHERE Album_id = 4562;

CREATE VIEW kpop_songs AS
(SELECT *
FROM song
WHERE Genre = 'Kpop');

SELECT *
FROM kpop_songs;

SELECT Playlist_name, COUNT(Song_id) AS Total_Songs_in_Playlist
FROM playlist p, has h
WHERE p.Playlist_id = h.Playlist_id
GROUP BY Playlist_name;

(SELECT *
FROM song)
MINUS
(SELECT s.*
FROM song s, playlist p, has h
WHERE p.Playlist_name = 'Party Mode'
    AND p.Playlist_id = h.Playlist_id
    AND h.Song_id = s.Song_id);
