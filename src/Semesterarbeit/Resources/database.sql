drop table if exists poi_category;
drop table if exists poi;

create table poi_category (
	 id			varchar(20) PRIMARY KEY
	,created 	timestamp
	,altered 	timestamp
	,name 		varchar(250)
);

create table poi (
	 id			varchar(20) PRIMARY KEY
	,created 	timestamp
	,altered 	timestamp
	,longitude  varchar(20)
	,latitude   varchar(20)
	,category   varchar(20)
	,name 		varchar(250)
);

select * from poi;
select * from poi where id = '2';