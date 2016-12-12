###mysql


###oracle
####约束
```
select constraint_name,constraint_type,table_name from user_constraints where table_name = 'RES_TEST';
alter table res_test disable constraint fk_test2;
alter table res_test enable constraint fk_test2;
```
####主键约束
```
select uc.table_name,uc.constraint_name,uc.constraint_type,ucc.column_name from user_constraints uc
left join user_cons_columns ucc on uc.constraint_name = ucc.constraint_name where uc.constraint_name = 'SYS_C0040037' and uc.constraint_type='P'
```
####外键约束
```
select uc.table_name,uc.constraint_name,uc.constraint_type,ucc.column_name,ui.table_name,uic.column_name from user_constraints uc
left join user_cons_columns ucc on uc.constraint_name = ucc.constraint_name
left join user_indexes ui on uc.r_constraint_name = ui.index_name
left join user_ind_columns uic on ui.index_name = uic.index_name
where uc.constraint_name = 'FK_TEST2' and uc.constraint_type='R'
```
####其他约束
```
select uc.table_name,uc.constraint_name,uc.constraint_type,ucc.column_name from user_constraints uc
left join user_cons_columns ucc on uc.constraint_name = ucc.constraint_name
where 1=1 and uc.constraint_type in ('C','V','O')
```
