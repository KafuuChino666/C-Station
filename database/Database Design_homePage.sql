#预留首页信息表
CREATE TABLE hp_message(
	hp_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT UNIQUE NOT NULL,
	zone_id INT UNIQUE NOT NULL,
	video_id INT UNIQUE NOT NULL,
	black_room_id INT UNIQUE NOT NULL,
	column_id INT UNIQUE NOT NULL,
	live_id INT UNIQUE NOT NULL,
	classroom_id INT UNIQUE NOT NULL,
	musicplus_id INT UNIQUE NOT NULL,
	play_center_id INT UNIQUE NOT NULL,
	customer_server_id INT UNIQUE NOT NULL,
	bangumi_id INT UNIQUE NOT NULL,
	cartoon_id INT UNIQUE NOT NULL,
	FOREIGN KEY()
)
	