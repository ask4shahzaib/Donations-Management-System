create database donations

use donations

create table beneficiaryprojects(
project varchar(30),
beneficiary varchar(30))


create table project(
nam varchar(30) primary key,
descrip varchar(200),
manager varchar(30),
budget int
)


create table projectvolunteers(
project varchar(30),
volunteer varchar(30))



create table issuedonations(
project varchar(30),
beneficiary varchar(30),
amount int,
weight int)


create table donation(
project varchar(30),
donor varchar(30),
dontype varchar(5),
amount int)


create table volunteer(
nam varchar(30),
cnic varchar(30) primary key,
addr varchar (100),
phone varchar(20),
dob varchar(10),
avail bit)


create table donor(
nam varchar(30),
cnic varchar(30) primary key,
addr varchar (100),
phone varchar(20),
dob varchar(10))



create table Beneficiary(
nam varchar(30),
cnic varchar(30) primary key,
addr varchar (100),
phone varchar(20),
dob varchar(10))



create table team(
project varchar(30),
volunteer varchar(30))



select * from team
select * from Beneficiary
select * from donor
select * from volunteer
select * from donation
select * from issuedonations
select * from project
select * from beneficiaryprojects

select donor from donation where project like 'p'

use donations


delete from team
delete from Beneficiary
delete from donor
delete from volunteer
delete from donation
delete from issuedonations
delete from project
delete from beneficiaryprojects

select nam from volunteer where avail = 1 
except
select volunteer from team where project like 'project 1'


go 


go

insert into issuedonations values('project 1','d1',0,0)

go

CREATE PROCEDURE checkbalance (
    @project varchar(30),
    @amount INT OUTPUT,
	@weight INT OUTPUT
) AS
BEGIN
declare @x int,@x2 int
set @x =  (select sum(amount) from donation where project = @project and dontype = 'cash')
set @x2 = (select sum(amount) from issuedonations where project = @project)
select @amount =  @x-@x2
set @x = (select sum(amount) from donation where project = @project and dontype = 'wheat')
set @x2 = (select sum(weight) from issuedonations where project=@project)
select @weight = @x-@x2
END



go
create procedure addissuedonation
@project varchar(30),@beneficiary varchar(30),@amount int , @weight int
as
begin
insert into issuedonations values (@project,@beneficiary,@amount,@weight)
end

go
create procedure addProject
@nam varchar(30), @desc varchar(200), @manager varchar(30) , @budget int
as
begin
insert into project values(@nam,@desc,@manager,@budget)
insert into issuedonations values(@nam,'',0,0)
end
go

create procedure addbeneficiaryprojects
@project varchar(30), @beneficiary varchar(30)
as
begin
insert into beneficiaryprojects values(@project,@beneficiary)
end
go

create procedure addprojectvolunteers
@project varchar(30), @volunteer varchar(30)
as
begin
insert into team values(@project,@volunteer)
end

go
create procedure addDonation
@project varchar(30), @donor varchar(30), @type varchar(50) , @amount int
as
begin
insert into donation values(@project,@donor,@type,@amount)
end


go
create procedure addDonor
@nam varchar(30),@phone varchar(11), @address varchar(200), @cnic varchar(20),@dob varchar(10)
as
begin
insert into donor values(@nam,@cnic,@address,@phone,@dob)
end

go
create procedure addBeneficiary
@nam varchar(30),@phone varchar(11), @address varchar(200), @cnic varchar(20),@dob varchar(10)
as
begin
insert into Beneficiary values(@nam,@cnic,@address,@phone,@dob)
end

go
create procedure addVolunteer
@avail bit , @nam varchar(30), @cnic varchar(30), @address varchar(100) , @phone varchar(21) , @dob varchar(10)
as
begin
insert into volunteer values(@nam,@cnic,@address,@phone,@dob,@avail)
end

go
create procedure removevolunteer
@nam varchar(30),@project varchar(30)
as
begin
delete from team where volunteer like @nam and project like @project
end

go
create procedure replacevolunteer
@nam varchar(30),@name2 varchar(30),@project varchar(30)
as
begin
update team set volunteer = @name2 where volunteer like @nam and project like @project
end


go
create procedure replacemanager

@nam varchar(30),@project varchar(30)
as
begin
update volunteer set avail = 1 where nam = (select manager from project where nam like @project)
update project set manager = @nam where nam like @project
update volunteer set avail = 0 where nam = (select manager from project where nam like @project)
end