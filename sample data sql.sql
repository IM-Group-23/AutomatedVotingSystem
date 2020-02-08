insert into province values(1,"Western"), (2,"Central");
insert into electoral_district values(1,"Colombo",1), (2,"Gampaha",1), (3,"Kalutara",1);
insert into polling_division values(1,"Moratumulla",1), (2,"Katubedda",1),(3,"Walana",3),(4,"Keselwatte",3);


insert into party values('UNP','United Nations Party');
insert into party values('UPFA','United Peoples Freedom Alliance');

insert into contestant values(1,'Rinil Wijesinghe','UNP',1);
insert into contestant values(2,'Mehinda Rajawickrama','UPFA',1);
insert into contestant values(3,'Akela Sooriyabandara','UNP',1);
insert into contestant values(4,'Mithri Siripala','UNP',1);

insert into election values(1,'2015-01-03','5:00','8:00','p');
insert into election values(2,'2018-11-17','5:00','8:00','Presidential Election');

insert into election_commissioner values('elemaco1','asda','sff','sf','adf','af');

insert into election_contestant values(1,1,1);

insert into grama_niladari values('grnamal','asda','zdfs','sf','adf','af','sdf',1);

insert into voter values('977430119v','asda','zdfs','sf','Miss.','af','2019-01-21','12121','grnamal',1);
insert into voter values('573521218v','asda','zdfs','sf','adf','af','2019-01-21','12121','grnamal',1);
insert into voter values('598380279v','asda','zdfs','sf','adf','af','2019-01-21','+94713140591','grnamal',1);

insert into vote values(1,'2015-01-03',1,1,1,'977430119v');

