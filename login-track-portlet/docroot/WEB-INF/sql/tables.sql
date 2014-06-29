create table LR_APP_LoginData (
	userId LONG not null,
	loginDate DATE not null,
	primary key (userId, loginDate)
);